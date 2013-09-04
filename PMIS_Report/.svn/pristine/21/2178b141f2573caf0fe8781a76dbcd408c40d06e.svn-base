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
import com.tetrapak.metaclass.EdgeSection;
import com.tetrapak.metaclass.PLCStructureTypes;
import com.tetrapak.metaclass.TPM6PhaseActivityID;
import com.tetrapak.metaclass.TPM6PhaseActivityStep;
import com.tetrapak.util.common.HMIOperatorUtil;
import com.tetrapak.util.common.Tools;

public class TPM6CIPReportAnalyser extends CIPReportAnalyserUtil {
    private static Logger log = LoggerFactory.getLogger(TPM6CIPReportAnalyser.class);

    public static void cipReportAnalyse() throws Exception {
	String queryEndDate = Tools.toDateStr(new Date());
	// This code only for the tetrapak structure cip based on TPM6
	List<CIPMasterLine> cipMasterLineList = CIPLineUtil.getCIPMasterLineOfTPM6();

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

		List<Long> phaseIDList = getPhaseIDListOfTPM6(ml.getCipMasterLineRoutePhaseIDTag(),
			Tools.toDateStr(Tools.addUpdateInterval(Tools.toDate(cipEdgeLeadingTime)).getTime()),
			cipEdgeTrailingTime);

		List<EdgeSection> queuedES = new ArrayList<EdgeSection>();
		// if there are more than one phase ids,then there are queued
		// jobs.
		if (phaseIDList.size() > 1) {
		    for (Long phaseID : phaseIDList) {
			String pStartDateTime = InSQLDaoUtil.getMinTimestampOfTagValue(
				ml.getCipMasterLineRoutePhaseIDTag(), phaseID, cipEdgeLeadingTime, cipEdgeTrailingTime);
			String pEndDateTime = InSQLDaoUtil.getMaxTimestampOfTagValue(
				ml.getCipMasterLineRoutePhaseIDTag(), phaseID, cipEdgeLeadingTime, cipEdgeTrailingTime);
			if (pStartDateTime != null && pEndDateTime != null) {
			    EdgeSection edgeSection = new EdgeSection();
			    edgeSection.setEdgeStartDateTime(pStartDateTime);
			    edgeSection.setEdgeEndDateTime(pEndDateTime);
			    queuedES.add(edgeSection);
			} else {
			    if (log.isErrorEnabled())
				log.error("Error when get the queued cip edge section of " + ml.getCipMasterLineName()
					+ "\t" + cipEdgeLeadingTime + "\t" + cipEdgeTrailingTime + "\t" + phaseID);
			}
		    }
		} else {
		    EdgeSection edgeSection = new EdgeSection();
		    edgeSection.setEdgeStartDateTime(cipEdgeLeadingTime);
		    edgeSection.setEdgeEndDateTime(cipEdgeTrailingTime);
		    queuedES.add(edgeSection);
		}

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

		    CIPType cipType = CIPReportUtil.getCIPTypeByProgramIDOfTPM6(programID);
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

		    CIPResult cipResult = CIPReportUtil.getCIPResultByResultIDOfTPM6(cipResultID);
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
			    PLCStructureTypes.TPM6);

		    CIPSlaveLine slaveLine = cipPhase.getCipSlaveLine();
		    CIPTarget cipTarget = cipPhase.getCipTarget();

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

		    // get the phase activity ids
		    final Map<String, Integer> phaseActivityIDs = getPhaseActivityIDs(ml.getPhaseActivityIDTag(),
			    icipEdgeLeadingTime, icipEdgeTrailingTime);
		    Set<Entry<String, Integer>> entrySet = phaseActivityIDs.entrySet();
		    List<String> activityStartTimeList = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;
			{
			    this.addAll(phaseActivityIDs.keySet());
			}
		    };

		    int activityStartTimeIndex = 0;
		    int activityStartTimeSize = activityStartTimeList.size();
		    for (Entry<String, Integer> entry : entrySet) {
			Integer activityID = entry.getValue();
			String activityStartTime = entry.getKey();
			String activityEndTime = null;

			if (activityStartTimeIndex < activityStartTimeSize - 1) {
			    activityEndTime = activityStartTimeList.get(activityStartTimeIndex + 1);
			} else {
			    activityEndTime = icipEdgeTrailingTime;
			}

			Map<String, Integer> activitySteps = null;
			switch (activityID) {
			case TPM6PhaseActivityID.PRE_RINSE:
			    activitySteps = getPhaseActivitySteps(ml.getPreRinseStepNTag(), activityStartTime,
				    activityEndTime);
			    break;
			case TPM6PhaseActivityID.LYE:
			    activitySteps = getPhaseActivitySteps(ml.getLyeStepNTag(), activityStartTime,
				    activityEndTime);
			    break;
			case TPM6PhaseActivityID.INT_RINSE:
			    activitySteps = getPhaseActivitySteps(ml.getIntRinseStepNTag(), activityStartTime,
				    activityEndTime);
			    break;
			case TPM6PhaseActivityID.ACID:
			    activitySteps = getPhaseActivitySteps(ml.getAcidStepNTag(), activityStartTime,
				    activityEndTime);
			    break;
			case TPM6PhaseActivityID.HOT_WAT:
			    activitySteps = getPhaseActivitySteps(ml.getHotWatStepNTag(), activityStartTime,
				    activityEndTime);
			    break;
			case TPM6PhaseActivityID.CHEM_DIS:
			    activitySteps = getPhaseActivitySteps(ml.getChemDisStepNTag(), activityStartTime,
				    activityEndTime);
			    break;
			case TPM6PhaseActivityID.FINAL_RINSE:
			    activitySteps = getPhaseActivitySteps(ml.getFinalRinseStepNTag(), activityStartTime,
				    activityEndTime);
			    break;
			}
			if (activitySteps != null) {
			    Set<Entry<String, Integer>> activityStepsEntrySet = activitySteps.entrySet();
			    for (Entry<String, Integer> activityStepEntry : activityStepsEntrySet) {
				String activityStepStartTime = activityStepEntry.getKey();
				Integer activityStepN = activityStepEntry.getValue();
				String activityStepEndTime = null;
				if (activityStepN == TPM6PhaseActivityStep.ACTIVITY_CIRCULATION_STEP) {
				    switch (activityID) {
				    case TPM6PhaseActivityID.PRE_RINSE:
					activityStepEndTime = InSQLDaoUtil.getMaxTimestampOfTagValue(
						ml.getPreRinseStepNTag(), activityStepN, activityStepStartTime,
						activityEndTime);
					// set pre rinse cip result
					setCIPPreRinseOfTPM6(ml, cipReportResult, activityStepStartTime,
						activityStepEndTime);
					break;
				    case TPM6PhaseActivityID.LYE:
					activityStepEndTime = InSQLDaoUtil.getMaxTimestampOfTagValue(
						ml.getLyeStepNTag(), activityStepN, activityStepStartTime,
						activityEndTime);
					// set lye circulation cip result
					setCIPLyeCycleOfTPM6(ml, cipReportResult, activityStepStartTime,
						activityStepEndTime);
					break;
				    case TPM6PhaseActivityID.INT_RINSE:
					activityStepEndTime = InSQLDaoUtil.getMaxTimestampOfTagValue(
						ml.getIntRinseStepNTag(), activityStepN, activityStepStartTime,
						activityEndTime);
					// set inter rinse cip result
					setCIPInterRinseOfTPM6(ml, cipReportResult, activityStepStartTime,
						activityStepEndTime);
					break;
				    case TPM6PhaseActivityID.ACID:
					activityStepEndTime = InSQLDaoUtil.getMaxTimestampOfTagValue(
						ml.getAcidStepNTag(), activityStepN, activityStepStartTime,
						activityEndTime);
					// set acid circulation cip result
					setCIPAcidCycleOfTPM6(ml, cipReportResult, activityStepStartTime,
						activityStepEndTime);
					break;
				    case TPM6PhaseActivityID.HOT_WAT:
					activityStepEndTime = InSQLDaoUtil.getMaxTimestampOfTagValue(
						ml.getHotWatStepNTag(), activityStepN, activityStepStartTime,
						activityEndTime);
					// set hot water cip result
					setCIPSterilizeOfTPM6(ml, cipReportResult, activityStepStartTime,
						activityStepEndTime);
					break;
				    case TPM6PhaseActivityID.CHEM_DIS:
					activityStepEndTime = InSQLDaoUtil.getMaxTimestampOfTagValue(
						ml.getChemDisStepNTag(), activityStepN, activityStepStartTime,
						activityEndTime);
					// set chem dis cip result
					setCIPChemDisOfTPM6(ml, cipReportResult, activityStepStartTime,
						activityStepEndTime);
					break;
				    case TPM6PhaseActivityID.FINAL_RINSE:
					activityStepEndTime = InSQLDaoUtil.getMaxTimestampOfTagValue(
						ml.getFinalRinseStepNTag(), activityStepN, activityStepStartTime,
						activityEndTime);
					// set final rinse cip result
					setCIPFinalRinseOfTPM6(ml, cipReportResult, activityStepStartTime,
						activityStepEndTime);
					break;
				    }

				}
			    }
			}

			activityStartTimeIndex++;
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
