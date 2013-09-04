package com.tetrapak.util.cip;

import java.util.ArrayList;
import java.util.Collection;
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
import com.tetrapak.metaclass.CIPResults;
import com.tetrapak.metaclass.CIPStepN;
import com.tetrapak.metaclass.EdgeSection;
import com.tetrapak.metaclass.PLCStructureTypes;
import com.tetrapak.metaclass.TPM4CIPType;
import com.tetrapak.metaclass.TimePeriod;
import com.tetrapak.util.common.HMIOperatorUtil;
import com.tetrapak.util.common.Tools;

/**
 * This class used to analyze the TPM4-based structure CIP Program
 * */
public class TPM4CIPReportAnalyser extends CIPReportAnalyserUtil {
    private static Logger log = LoggerFactory.getLogger(TPM4CIPReportAnalyser.class);

    public static void cipReportAnalyse() throws Exception {
	String queryEndDate = Tools.toDateStr(new Date());
	// This code only for the TPM4 based structure cip
	List<CIPMasterLine> cipMasterLineList = CIPLineUtil.getCIPMasterLineOfTPM4();

	// execute the query
	for (CIPMasterLine ml : cipMasterLineList) {
	    String latestCIPEndTime = "";
	    // get the latest cip analyse time
	    CIPReportAnalysePoint point = CIPReportUtil.getCIPLastestAnalyseDateTime(ml.getCipMasterLineName());
	    String queryStartDate = point.getCipLatestAnalyseDateTime();

	    List<EdgeSection> edgeSectionList = InSQLDaoUtil.getEdgeSectionList(ml.getCipMasterLineOperTag(),
		    queryStartDate, queryEndDate);
	    for (EdgeSection edgeSection : edgeSectionList) {
		CIPReportResult cipReportResult = new CIPReportResult();
		String cipEdgeLeadingTime = edgeSection.getEdgeStartDateTime();
		String cipEdgeTrailingTime = edgeSection.getEdgeEndDateTime();
		Map<String, Integer> cipSteps = getCIPSteps(ml.getCipMasterLineStepsTag(), cipEdgeLeadingTime,
			cipEdgeTrailingTime);
		long programID = getCIPProgramID(ml.getCipMasterLineCIPProgramIDTag(), cipEdgeLeadingTime,
			cipEdgeTrailingTime);
		long phaseID = getCIPPhaseID(ml.getCipMasterLineRoutePhaseIDTag(), cipEdgeLeadingTime,
			cipEdgeTrailingTime);

		if (phaseID == 0) {
		    if (log.isErrorEnabled())
			log.error("Unable to find the phaseID [" + phaseID + "] for " + ml.getCipMasterLineName()
				+ "\t[" + cipEdgeLeadingTime + ":" + cipEdgeTrailingTime + "]");
		    continue;
		}

		CIPPhase cipPhase = CIPReportUtil.getCIPPhaseByPhaseID(phaseID);
		if (cipPhase == null) {
		    if (log.isErrorEnabled())
			log.error("Unable to find cip phase for phase id: " + phaseID + "\t"
				+ ml.getCipMasterLineName() + "\t[" + cipEdgeLeadingTime + ":" + cipEdgeTrailingTime
				+ "]");
		    continue;
		}

		long cipResultID = CIPResults.NOT_CLEAN;
		Collection<Integer> values = cipSteps.values();
		List<Integer> steps = new ArrayList<Integer>();
		for (Integer value : values) {
		    steps.add(value);
		}
		int size = steps.size();
		int lastStep = steps.get(size - 1);
		if (lastStep == 0) {
		    if (size - 2 >= 0) {
			lastStep = steps.get(size - 2);
		    }
		}
		if (lastStep == CIPStepN.TPM4_STEP_38 || lastStep == CIPStepN.TPM4_STEP_49
			|| lastStep == CIPStepN.TPM4_STEP_94) {
		    if (programID == TPM4CIPType.LYE || programID == TPM4CIPType.LYE_ACID
			    || programID == TPM4CIPType.ACID) {
			cipResultID = CIPResults.CLEANED;
		    } else if (programID == TPM4CIPType.RINSE) {
			cipResultID = CIPResults.RINSED;
		    } else if (programID == TPM4CIPType.STERILIZE) {
			cipResultID = CIPResults.CLEANED_STERILIZED;
		    }
		}

		CIPResult cipResult = CIPReportUtil.getCIPResultByResultIDOfTPM4(cipResultID);
		// Attention: Get TPM4 CIP Types
		CIPType cipType = CIPReportUtil.getCIPTypeByProgramIDOfTPM4(programID);
		if (cipType == null) {
		    if (log.isErrorEnabled())
			log.error("[TPM4 CIP] Unable to find cip type for type id: " + programID + "\t"
				+ ml.getCipMasterLineName() + "\t[" + cipEdgeLeadingTime + ":" + cipEdgeTrailingTime
				+ "]");
		    // Error tolerant
		    cipType = new CIPType();
		    cipType.setCipTypePLCId(programID);
		    cipType.setCipTypeDesc("N/A");
		}

		HMIOperator operator = HMIOperatorUtil.getHMIOperatorByPLCId(0, PLCStructureTypes.TPM4);
		CIPSlaveLine slaveLine = cipPhase.getCipSlaveLine();
		CIPTarget cipTarget = cipPhase.getCipTarget();

		// set the general information for cip report result
		cipReportResult.setCipMasterLineId(ml.getId());
		cipReportResult.setCipMasterLineName(ml.getCipMasterLineDesc());
		cipReportResult.setCipSlaveLineId(slaveLine.getId());
		cipReportResult.setCipSlaveLineName(slaveLine.getCipSlaveLineDesc());
		cipReportResult.setCipStartDateTime(Tools.toDate(cipEdgeLeadingTime).getTime());
		cipReportResult.setCipEndDateTime(Tools.toDate(cipEdgeTrailingTime).getTime());
		cipReportResult.setCipLastTime(Tools.dateDiffMinutes(cipEdgeLeadingTime, cipEdgeTrailingTime)
			.getHumanTime());
		cipReportResult.setCipTargetDesc(cipTarget.getCipTargetDesc());
		cipReportResult.setCipTargetName(cipTarget.getCipTargetName());
		cipReportResult.setCipType(cipType.getCipTypeDesc());
		cipReportResult.setCipTypePLCId(cipType.getCipTypePLCId());
		cipReportResult.setCipResultPLCId(cipResultID);
		cipReportResult.setCipResult(cipResult.getCipResultDesc());
		cipReportResult.setCipOperatedByID(10L);
		cipReportResult.setCipOperatedByName(operator.getOperatorName());
		cipReportResult.setPlcStructureType(ml.getPlcStructureType());
		cipReportResult.setWorkshopType(ml.getWorkshopType());
		Set<Entry<String, Integer>> entrySet = cipSteps.entrySet();
		if (programID == TPM4CIPType.LYE) {
		    String preRinseStartDateTime = null;
		    String preRinseEndDateTime = null;
		    String lyeCycleStartDateTime = null;
		    String lyeCycleEndDateTime = null;
		    String finalRinseStartDateTime = null;
		    String finalRinseEndDateTime = null;
		    for (Entry<String, Integer> each : entrySet) {
			Integer stepN = each.getValue();
			if (stepN.equals(CIPStepN.TPM4_STEP_5)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_5, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    preRinseStartDateTime = tp.getStartDateTime();
			    preRinseEndDateTime = tp.getEndDateTime();
			} else if (stepN.equals(CIPStepN.TPM4_STEP_10)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_10, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    lyeCycleStartDateTime = tp.getStartDateTime();
			    lyeCycleEndDateTime = tp.getEndDateTime();
			} else if (stepN.equals(CIPStepN.TPM4_STEP_29)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_29, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    finalRinseStartDateTime = tp.getStartDateTime();
			    finalRinseEndDateTime = tp.getEndDateTime();
			}
		    }
		    // pre rinse
		    setCIPPreRinse(ml, cipReportResult, preRinseStartDateTime, preRinseEndDateTime);
		    // lye cycle
		    setCIPLyeCycle(ml, cipReportResult, lyeCycleStartDateTime, lyeCycleEndDateTime);
		    // final rinse
		    setCIPFinalRinse(ml, cipReportResult, finalRinseStartDateTime, finalRinseEndDateTime);
		} else if (programID == TPM4CIPType.ACID) {
		    String preRinseStartDateTime = null;
		    String preRinseEndDateTime = null;
		    String acidCycleStartDateTime = null;
		    String acidCycleEndDateTime = null;
		    String finalRinseStartDateTime = null;
		    String finalRinseEndDateTime = null;
		    for (Entry<String, Integer> each : entrySet) {
			Integer stepN = each.getValue();
			if (stepN.equals(CIPStepN.TPM4_STEP_5)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_5, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    preRinseStartDateTime = tp.getStartDateTime();
			    preRinseEndDateTime = tp.getEndDateTime();
			} else if (stepN.equals(CIPStepN.TPM4_STEP_20)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_20, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    acidCycleStartDateTime = tp.getStartDateTime();
			    acidCycleEndDateTime = tp.getEndDateTime();
			} else if (stepN.equals(CIPStepN.TPM4_STEP_29)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_29, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    finalRinseStartDateTime = tp.getStartDateTime();
			    finalRinseEndDateTime = tp.getEndDateTime();
			}
		    }
		    // pre rinse
		    setCIPPreRinse(ml, cipReportResult, preRinseStartDateTime, preRinseEndDateTime);
		    // acid cycle
		    setCIPAcidCycle(ml, cipReportResult, acidCycleStartDateTime, acidCycleEndDateTime);
		    // final rinse
		    setCIPFinalRinse(ml, cipReportResult, finalRinseStartDateTime, finalRinseEndDateTime);
		} else if (programID == TPM4CIPType.LYE_ACID) {
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
			Integer stepN = each.getValue();
			if (stepN.equals(CIPStepN.TPM4_STEP_5)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_5, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    preRinseStartDateTime = tp.getStartDateTime();
			    preRinseEndDateTime = tp.getEndDateTime();
			} else if (stepN.equals(CIPStepN.TPM4_STEP_10)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_10, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    lyeCycleStartDateTime = tp.getStartDateTime();
			    lyeCycleEndDateTime = tp.getEndDateTime();
			} else if (stepN.equals(CIPStepN.TPM4_STEP_15)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_15, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    interRinseStartDateTime = tp.getStartDateTime();
			    interRinseEndDateTime = tp.getEndDateTime();
			} else if (stepN.equals(CIPStepN.TPM4_STEP_20)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_20, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    acidCycleStartDateTime = tp.getStartDateTime();
			    acidCycleEndDateTime = tp.getEndDateTime();
			} else if (stepN.equals(CIPStepN.TPM4_STEP_29)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_29, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    finalRinseStartDateTime = tp.getStartDateTime();
			    finalRinseEndDateTime = tp.getEndDateTime();
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
		} else if (programID == TPM4CIPType.RINSE) {
		    String finalRinseStartDateTime = null;
		    String finalRinseEndDateTime = null;
		    for (Entry<String, Integer> each : entrySet) {
			Integer stepN = each.getValue();
			if (stepN.equals(CIPStepN.TPM4_STEP_32)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_32, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    finalRinseStartDateTime = tp.getStartDateTime();
			    finalRinseEndDateTime = tp.getEndDateTime();
			}
		    }

		    setCIPFinalRinse(ml, cipReportResult, finalRinseStartDateTime, finalRinseEndDateTime);
		} else if (programID == TPM4CIPType.STERILIZE) {
		    String sterStartDateTime = null;
		    String sterEndDateTime = null;
		    for (Entry<String, Integer> each : entrySet) {
			Integer stepN = each.getValue();
			if (stepN.equals(CIPStepN.TPM4_STEP_35)) {
			    TimePeriod tp = InSQLDaoUtil.getTimePeriodOfTagValue(ml.getCipMasterLineStepsTag(),
				    CIPStepN.TPM4_STEP_35, cipEdgeLeadingTime, cipEdgeTrailingTime);
			    sterStartDateTime = tp.getStartDateTime();
			    sterEndDateTime = tp.getEndDateTime();
			}
		    }
		    setCIPSterilize(ml, cipReportResult, sterStartDateTime, sterEndDateTime);
		}
		// get the last time operation
		CIPReportResult lastCIPReportResult = CIPReportUtil.getLastCIPOperation(cipTarget.getCipTargetName());
		if (lastCIPReportResult != null) {
		    Date lastCIPOperationEndTime = lastCIPReportResult.getCipEndDateTime();
		    cipReportResult.setTimeSinceLastOperation(Tools.dateDiffMinutes(lastCIPOperationEndTime,
			    cipReportResult.getCipEndDateTime()).getHumanTime());
		}
		// save cip result to database
		CIPReportUtil.saveCIPReportResult(cipReportResult);
		// compare the cip end time with the cipendtime
		if (cipEdgeTrailingTime.compareTo(latestCIPEndTime) >= 0) {
		    latestCIPEndTime = cipEdgeTrailingTime;
		}
		// save or update cip end time
		if (!latestCIPEndTime.isEmpty()) {
		    point.setCipLatestAnalyseDateTime(latestCIPEndTime);
		    CommonDao.update(point);
		}
	    }

	}
    }

}