package com.tetrapak.util.cip;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPMasterLine;
import com.tetrapak.domain.cip.CIPPhase;
import com.tetrapak.domain.cip.CIPReportAnalysePoint;
import com.tetrapak.domain.cip.CIPReportResult;
import com.tetrapak.domain.cip.CIPResult;
import com.tetrapak.domain.cip.CIPSlaveLine;
import com.tetrapak.domain.cip.CIPTarget;
import com.tetrapak.domain.cip.CIPType;
import com.tetrapak.domain.comm.HMIOperator;
import com.tetrapak.insql.InSQLDaoUtil;
import com.tetrapak.metaclass.CIPStepN;
import com.tetrapak.metaclass.EdgeSection;
import com.tetrapak.metaclass.PLCStructureTypes;
import com.tetrapak.metaclass.TPM5CIPType;
import com.tetrapak.util.common.HMIOperatorUtil;
import com.tetrapak.util.common.Tools;

public class TPM5CIPReportAnalyser extends CIPReportAnalyserUtil {
    private static Logger log = LoggerFactory.getLogger(TPM5CIPReportAnalyser.class);

    public static void cipReportAnalyse() throws Exception {
	String queryEndDate = Tools.toDateStr(new Date());
	// This code only for the tetrapak structure cip based on tpm5
	List<CIPMasterLine> cipMasterLineList = CIPLineUtil.getCIPMasterLineOfTPM5();

	// execute the query
	for (CIPMasterLine ml : cipMasterLineList) {
	    String latestCIPEndTime = "";
	    // get the latest cip analyse time
	    CIPReportAnalysePoint point = CIPReportUtil.getCIPLastestAnalyseDateTime(ml.getCipMasterLineName());
	    String queryStartDate = point.getCipLatestAnalyseDateTime();

	    // QUERY EDGE SECTION
	    List<EdgeSection> edgeSectionList = InSQLDaoUtil.getEdgeSectionList(ml.getCipMasterLineOperTag(),
		    queryStartDate, queryEndDate);
	    // BUG FIX - Consider the circumstance of queue, where the
	    // f**king Oper tag are not reset to 0
	    // Judge by the steps

	    for (EdgeSection oes : edgeSectionList) {
		String cipEdgeLeadingTime = oes.getEdgeStartDateTime();
		String cipEdgeTrailingTime = oes.getEdgeEndDateTime();
		Map<String, Integer> cipSteps = getCIPSteps(ml.getCipMasterLineStepsTag(), cipEdgeLeadingTime,
			cipEdgeTrailingTime);
		List<Integer> phaseIDList = getPhaseIDList(ml.getCipMasterLineRoutePhaseIDTag(),
			Tools.toDateStr(Tools.addUpdateInterval(Tools.toDate(cipEdgeLeadingTime)).getTime()),
			cipEdgeTrailingTime);
		// check whether it has queued jobs
		String startDateTime = cipEdgeLeadingTime;
		List<EdgeSection> queuedES = new ArrayList<EdgeSection>();
		// if there are more than one phase ids,then is has queued
		// jobs.
		if (phaseIDList.size() > 1) {
		    Set<Entry<String, Integer>> stepsEntrySet = cipSteps.entrySet();
		    List<Entry<String, Integer>> stepsEntryList = new ArrayList<Entry<String, Integer>>();
		    stepsEntryList.addAll(stepsEntrySet);
		    stepsEntrySet = null;
		    int vStep = 0;
		    int entryCount = stepsEntryList.size();
		    for (int i = 0; i < entryCount; i++) {
			Entry<String, Integer> stepEntry = stepsEntryList.get(i);
			String timestamp = stepEntry.getKey();
			Integer step = stepEntry.getValue();
			if (step >= vStep) {
			    vStep = step;
			} else {
			    vStep = step;
			    if ((i - 1 > 0) && step > 0) {
				Entry<String, Integer> endDateTimeEntry = stepsEntryList.get(i - 1);
				EdgeSection edgeSection = new EdgeSection();
				edgeSection.setEdgeStartDateTime(startDateTime);
				edgeSection.setEdgeEndDateTime(endDateTimeEntry.getKey());
				startDateTime = timestamp;
				queuedES.add(edgeSection);
			    }
			}
		    }
		}
		EdgeSection edgeSection = new EdgeSection();
		edgeSection.setEdgeStartDateTime(startDateTime);
		edgeSection.setEdgeEndDateTime(cipEdgeTrailingTime);
		queuedES.add(edgeSection);

		for (EdgeSection ies : queuedES) {
		    CIPReportResult cipReportResult = new CIPReportResult();
		    String icipEdgeLeadingTime = ies.getEdgeStartDateTime();
		    String icipEdgeTrailingTime = ies.getEdgeEndDateTime();
		    long programID = getCIPProgramID(ml.getCipMasterLineCIPProgramIDTag(), icipEdgeLeadingTime,
			    icipEdgeTrailingTime);
		    long phaseID = getCIPPhaseID(ml.getCipMasterLineRoutePhaseIDTag(), icipEdgeLeadingTime,
			    icipEdgeTrailingTime);

		    long cipResultID = getCIPResultID(ml.getCipMasterLineCIPResultIDTag(), icipEdgeLeadingTime,
			    icipEdgeTrailingTime);

		    long cipOperatedByID = getOperatedByID(ml.getCipMasterLineOperatedByIDTag(), icipEdgeLeadingTime,
			    icipEdgeTrailingTime);

		    if (phaseID == 0) {
			if (log.isErrorEnabled())
			    log.error("Unable to find the phaseID [" + phaseID + "] for " + ml.getCipMasterLineName()
				    + "\t[" + icipEdgeLeadingTime + ":" + icipEdgeTrailingTime + "]");
			continue;
		    }

		    CIPPhase cipPhase = CIPReportUtil.getCIPPhaseByPhaseID(phaseID);
		    if (cipPhase == null) {
			if (log.isErrorEnabled())
			    log.error("Unable to find cip phase for phase id: " + phaseID + "\t"
				    + ml.getCipMasterLineName() + "\t[" + icipEdgeLeadingTime + ":"
				    + icipEdgeTrailingTime + "]");
			continue;
		    }

		    CIPType cipType = CIPReportUtil.getCIPTypeByProgramIDOfTPM5(programID);
		    if (cipType == null) {
			if (log.isErrorEnabled())
			    log.error("Unable to find cip type for type id: " + programID + "\t"
				    + ml.getCipMasterLineName() + "\t[" + icipEdgeLeadingTime + ":"
				    + icipEdgeTrailingTime + "]");
			// Error tolerant
			cipType = new CIPType();
			cipType.setCipTypePLCId(programID);
			cipType.setCipTypeDesc("N/A");
		    }

		    CIPResult cipResult = CIPReportUtil.getCIPResultByResultIDOfTPM5(cipResultID);
		    if (cipResult == null) {
			if (log.isErrorEnabled())
			    log.error("Unable to find cip result for result id: " + cipResultID + "\t"
				    + ml.getCipMasterLineName() + "\t[" + icipEdgeLeadingTime + ":"
				    + icipEdgeTrailingTime + "]");
			// Error tolerant
			cipResult = new CIPResult();
			cipResult.setCipResultPLCId(cipResultID);
			cipResult.setCipResultDesc("N/A");
		    }

		    HMIOperator operator = HMIOperatorUtil.getHMIOperatorByPLCId(cipOperatedByID,
			    PLCStructureTypes.TPM5);

		    CIPSlaveLine slaveLine = cipPhase.getCipSlaveLine();
		    CIPTarget cipTarget = cipPhase.getCipTarget();
		    Map<String, Integer> icipSteps = getCIPSteps(ml.getCipMasterLineStepsTag(), icipEdgeLeadingTime,
			    icipEdgeTrailingTime);
		    // set the general information for cip report result
		    cipReportResult.setCipMasterLineId(ml.getId());
		    cipReportResult.setCipMasterLineName(ml.getCipMasterLineDesc());
		    cipReportResult.setCipSlaveLineId(slaveLine.getId());
		    cipReportResult.setCipSlaveLineName(slaveLine.getCipSlaveLineDesc());
		    cipReportResult.setCipStartDateTime(Tools.toDate(icipEdgeLeadingTime).getTime());
		    cipReportResult.setCipEndDateTime(Tools.toDate(icipEdgeTrailingTime).getTime());
		    cipReportResult.setCipTargetDesc(cipTarget.getCipTargetDesc());
		    cipReportResult.setCipTargetName(cipTarget.getCipTargetName());
		    cipReportResult.setCipType(cipType.getCipTypeDesc());
		    cipReportResult.setCipTypePLCId(cipType.getCipTypePLCId());
		    cipReportResult.setCipResultPLCId(cipResultID);
		    cipReportResult.setCipResult(cipResult.getCipResultDesc());
		    cipReportResult.setCipOperatedByID(cipOperatedByID);
		    cipReportResult.setCipOperatedByName(operator.getOperatorName());
		    cipReportResult.setPlcStructureType(ml.getPlcStructureType());
		    cipReportResult.setWorkshopType(ml.getWorkshopType());
		    cipReportResult.setCipLastTime(Tools.dateDiffMinutes(icipEdgeLeadingTime, icipEdgeTrailingTime)
			    .getHumanTime());
		    Set<Entry<String, Integer>> entrySet = icipSteps.entrySet();
		    if (cipType.getCipTypePLCId() == TPM5CIPType.LYE) {
			String preRinseStartDateTime = null;
			String preRinseEndDateTime = null;
			String lyeCycleStartDateTime = null;
			String lyeCycleEndDateTime = null;
			String finalRinseStartDateTime = null;
			String finalRinseEndDateTime = null;
			for (Entry<String, Integer> each : entrySet) {
			    String timestamp = each.getKey();
			    Integer stepN = each.getValue();
			    if (stepN.equals(CIPStepN.STEP_20)) {
				preRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_30)) {
				preRinseEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_35)) {
				if (preRinseEndDateTime == null) {
				    preRinseEndDateTime = timestamp;
				}
			    } else if (stepN.equals(CIPStepN.STEP_50)) {
				lyeCycleStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_150)) {
				lyeCycleEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_170)) {
				finalRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_210)) {
				finalRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_230)) {
				finalRinseEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_235)) {
				if (finalRinseEndDateTime == null) {
				    finalRinseEndDateTime = timestamp;
				}
			    }
			}
			// pre rinse
			setCIPPreRinse(ml, cipReportResult, preRinseStartDateTime, preRinseEndDateTime);
			// lye cycle
			setCIPLyeCycle(ml, cipReportResult, lyeCycleStartDateTime, lyeCycleEndDateTime);
			// final rinse
			setCIPFinalRinse(ml, cipReportResult, finalRinseStartDateTime, finalRinseEndDateTime);
		    } else if (cipType.getCipTypePLCId() == TPM5CIPType.ACID) {
			String preRinseStartDateTime = null;
			String preRinseEndDateTime = null;
			String acidCycleStartDateTime = null;
			String acidCycleEndDateTime = null;
			String finalRinseStartDateTime = null;
			String finalRinseEndDateTime = null;
			for (Entry<String, Integer> each : entrySet) {
			    String timestamp = each.getKey();
			    Integer stepN = each.getValue();
			    if (stepN.equals(CIPStepN.STEP_20)) {
				preRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_90)) {
				preRinseEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_95)) {
				if (preRinseEndDateTime == null) {
				    preRinseEndDateTime = timestamp;
				}
			    } else if (stepN.equals(CIPStepN.STEP_110)) {
				acidCycleStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_120)) {
				acidCycleEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_170)) {
				finalRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_210)) {
				finalRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_230)) {
				finalRinseEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_235)) {
				if (finalRinseEndDateTime == null) {
				    finalRinseEndDateTime = timestamp;
				}
			    }
			}
			// pre rinse
			setCIPPreRinse(ml, cipReportResult, preRinseStartDateTime, preRinseEndDateTime);
			// acid cycle
			setCIPAcidCycle(ml, cipReportResult, acidCycleStartDateTime, acidCycleEndDateTime);
			// final rinse
			setCIPFinalRinse(ml, cipReportResult, finalRinseStartDateTime, finalRinseEndDateTime);
		    } else if (cipType.getCipTypePLCId() == TPM5CIPType.LYE_ACID) {
			String preRinseStartDateTime = null;
			String preRinseEndDateTime = null;

			String lyeCycleStartDateTime = null;
			String lyeCycleEndDateTime = null;

			String interRinseStartDateTime = null;
			String interRinseEndDateTime = null;

			String acidCycleStartDateTime = null;
			String acidCycleEndDateTime = null;

			String finalRinseStartDateTime = null;
			String finalRinseEndDateTime = null;

			for (Entry<String, Integer> each : entrySet) {
			    String timestamp = each.getKey();
			    Integer stepN = each.getValue();
			    if (stepN.equals(CIPStepN.STEP_20)) {
				preRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_30)) {
				preRinseEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_35)) {
				if (preRinseEndDateTime == null) {
				    preRinseEndDateTime = timestamp;
				}
			    } else if (stepN.equals(CIPStepN.STEP_50)) {
				lyeCycleStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_60)) {
				lyeCycleEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_80)) {
				interRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_90)) {
				interRinseEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_95)) {
				interRinseEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_110)) {
				acidCycleStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_120)) {
				acidCycleEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_170)) {
				finalRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_210)) {
				finalRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_230)) {
				finalRinseEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_235)) {
				if (finalRinseEndDateTime == null) {
				    finalRinseEndDateTime = timestamp;
				}
			    }
			}

			// pre rinse
			setCIPPreRinse(ml, cipReportResult, preRinseStartDateTime, preRinseEndDateTime);

			// lye cycle
			setCIPLyeCycle(ml, cipReportResult, lyeCycleStartDateTime, lyeCycleEndDateTime);

			// inter rinse
			setCIPInterRinse(ml, cipReportResult, interRinseStartDateTime, interRinseEndDateTime);
			// acid cycle
			setCIPAcidCycle(ml, cipReportResult, acidCycleStartDateTime, acidCycleEndDateTime);

			// final rinse
			setCIPFinalRinse(ml, cipReportResult, finalRinseStartDateTime, finalRinseEndDateTime);
		    } else if (cipType.getCipTypePLCId() == TPM5CIPType.RINSE) {
			String finalRinseStartDateTime = null;
			String finalRinseEndDateTime = null;
			for (Entry<String, Integer> each : entrySet) {
			    String timestamp = each.getKey();
			    Integer stepN = each.getValue();
			    if (stepN.equals(CIPStepN.STEP_190)) {
				finalRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_230)) {
				finalRinseEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_235)) {
				if (finalRinseEndDateTime == null) {
				    finalRinseEndDateTime = timestamp;
				}
			    }
			}

			setCIPFinalRinse(ml, cipReportResult, finalRinseStartDateTime, finalRinseEndDateTime);
		    } else if (cipType.getCipTypePLCId() == TPM5CIPType.STERILIZE) {
			String sterStartDateTime = null;
			String sterEndDateTime = null;

			String finalRinseStartDateTime = null;
			String finalRinseEndDateTime = null;
			boolean isSterDone = false;
			for (Entry<String, Integer> each : entrySet) {
			    String timestamp = each.getKey();
			    Integer stepN = each.getValue();
			    if (stepN.equals(CIPStepN.STEP_220)) {
				sterStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_230) && !isSterDone) {
				sterEndDateTime = timestamp;
				isSterDone = true;
			    } else if (stepN.equals(CIPStepN.STEP_235) && !isSterDone) {
				if (sterEndDateTime == null) {
				    sterEndDateTime = timestamp;
				    isSterDone = true;
				}
			    } else if (stepN.equals(CIPStepN.STEP_170) && isSterDone) {
				finalRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_230) && isSterDone) {
				finalRinseEndDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_235) && isSterDone) {
				if (finalRinseEndDateTime == null) {
				    finalRinseEndDateTime = timestamp;
				}
			    }
			}
			setCIPFinalRinse(ml, cipReportResult, finalRinseStartDateTime, finalRinseEndDateTime);
			setCIPSterilize(ml, cipReportResult, sterStartDateTime, sterEndDateTime);
		    } else if (cipType.getCipTypePLCId() == TPM5CIPType.CHEM_DIS) {
			String sterStartDateTime = null;
			String sterEndDateTime = null;

			String finalRinseStartDateTime = null;
			String finalRinseEndDateTime = null;
			for (Entry<String, Integer> each : entrySet) {
			    String timestamp = each.getKey();
			    Integer stepN = each.getValue();
			    if (stepN.equals(CIPStepN.STEP_225)) {
				finalRinseStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_226)) {
				finalRinseEndDateTime = timestamp;
				sterStartDateTime = timestamp;
			    } else if (stepN.equals(CIPStepN.STEP_230) || stepN.equals(CIPStepN.STEP_235)) {
				sterEndDateTime = timestamp;
			    }
			}
			setCIPFinalRinse(ml, cipReportResult, finalRinseStartDateTime, finalRinseEndDateTime);
			setCIPSterilize(ml, cipReportResult, sterStartDateTime, sterEndDateTime);
		    }
		    // get the last time operation
		    CIPReportResult lastCIPReportResult = CIPReportUtil.getLastCIPOperation(cipTarget
			    .getCipTargetName());
		    if (lastCIPReportResult != null) {
			Date lastCIPOperationEndTime = lastCIPReportResult.getCipEndDateTime();
			cipReportResult.setTimeSinceLastOperation(Tools.dateDiffMinutes(lastCIPOperationEndTime,
				cipReportResult.getCipEndDateTime()).getHumanTime());
		    }
		    // save cip result to database
		    CIPReportUtil.saveCIPReportResult(cipReportResult);
		    // compare the cip end time with the cipendtime
		    if (icipEdgeTrailingTime.compareTo(latestCIPEndTime) >= 0) {
			latestCIPEndTime = icipEdgeTrailingTime;
		    }
		    // save or update cip end time
		    if (!latestCIPEndTime.isEmpty()) {
			point.setCipLatestAnalyseDateTime(latestCIPEndTime);
			CommonDao.saveOrUpdate(point);
		    }
		}
	    }
	}
    }

}
