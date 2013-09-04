package com.tetrapak.util.cip;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tetrapak.domain.cip.CIPMasterLine;
import com.tetrapak.domain.cip.CIPReportResult;
import com.tetrapak.insql.InSQLDaoUtil;
import com.tetrapak.util.common.Tools;

public class CIPReportAnalyserUtil {
    public static long getCIPProgramID(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws ClassNotFoundException, SQLException, IOException {
	return InSQLDaoUtil.getInSQLLongValue(tagName, edgeLeadingTime, edgeTrailingTime);
    }

    public static long getCIPPhaseID(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws ClassNotFoundException, SQLException, IOException {
	return InSQLDaoUtil.getInSQLLongValue(tagName, edgeLeadingTime, edgeTrailingTime);
    }

    public static long getCIPResultID(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws ClassNotFoundException, SQLException, IOException {
	return InSQLDaoUtil.getInSQLLongValue(tagName, edgeLeadingTime, edgeTrailingTime);
    }

    public static long getOperatedByID(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws ClassNotFoundException, SQLException, IOException {
	return InSQLDaoUtil.getInSQLLongValue(tagName, edgeLeadingTime, edgeTrailingTime);
    }

    public static Map<String, Integer> getCIPSteps(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws ClassNotFoundException, SQLException, IOException {
	return InSQLDaoUtil.getSteps(tagName, edgeLeadingTime, edgeTrailingTime);
    }

    public static Map<String, Integer> getPhaseActivityIDs(String tagName, String edgeLeadingTime,
	    String edgeTrailingTime) throws ClassNotFoundException, SQLException, IOException {
	return InSQLDaoUtil.getIntValueMap(tagName, edgeLeadingTime, edgeTrailingTime);
    }

    public static Map<String, Integer> getPhaseActivitySteps(String tagName, String edgeLeadingTime,
	    String edgeTrailingTime) throws ClassNotFoundException, SQLException, IOException {
	return InSQLDaoUtil.getIntValueMap(tagName, edgeLeadingTime, edgeTrailingTime);
    }

    public static List<Integer> getPhaseIDList(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws SQLException, ClassNotFoundException, IOException {
	return InSQLDaoUtil.getIntValueList(tagName, edgeLeadingTime, edgeTrailingTime);
    }

    public static List<Long> getPhaseIDListOfTPM6(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws SQLException, ClassNotFoundException, IOException {
	List<Long> phaseIdList = InSQLDaoUtil.getLongValueList(tagName, edgeLeadingTime, edgeTrailingTime);
	List<Long> retPhaseIdList = new ArrayList<Long>();
	/**
	 * Bug fix, in TPM6 we can not judge from a list of steps of the queued
	 * jobs.
	 * */
	for (Long phaseId : phaseIdList) {
	    if (phaseId != 0) {
		retPhaseIdList.add(phaseId);
	    }
	}
	return retPhaseIdList;
    }

    public static void setCIPPreRinse(CIPMasterLine ml, CIPReportResult cipReportResult, String preRinseStartDateTime,
	    String preRinseEndDateTime) throws ClassNotFoundException, SQLException, IOException, ParseException {
	// pre rinse
	if (preRinseStartDateTime != null && preRinseEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatusNoTimer(ml.getCipMasterLineFlowOutTag(),
		    preRinseStartDateTime, preRinseEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatusNoTimer(ml.getCipMasterLineTemperatureOutTag(),
		    preRinseStartDateTime, preRinseEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatusNoTimer(ml.getCipMasterLineTemperatureBackTag(),
		    preRinseStartDateTime, preRinseEndDateTime);
	    cipReportResult.setCipPreRinseStartDateTime(Tools.toDate(preRinseStartDateTime).getTime());
	    cipReportResult.setCipPreRinseEndDateTime(Tools.toDate(preRinseEndDateTime).getTime());
	    cipReportResult.setCipPreRinseLastTime(Tools.dateDiffMinutes(preRinseStartDateTime, preRinseEndDateTime)
		    .getHumanTime());
	    cipReportResult.setCipPreRinseFlowOut(flowOut);
	    cipReportResult.setCipPreRinseTemperatureOut(ttOut);
	    cipReportResult.setCipPreRinseTemperatureBack(ttBack);
	}
    }

    public static void setCIPInterRinse(CIPMasterLine ml, CIPReportResult cipReportResult,
	    String interRinseStartDateTime, String interRinseEndDateTime) throws ClassNotFoundException, SQLException,
	    IOException, ParseException {
	// inter rinse
	if (interRinseStartDateTime != null && interRinseEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatusNoTimer(ml.getCipMasterLineFlowOutTag(),
		    interRinseStartDateTime, interRinseEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatusNoTimer(ml.getCipMasterLineTemperatureOutTag(),
		    interRinseStartDateTime, interRinseEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatusNoTimer(ml.getCipMasterLineTemperatureBackTag(),
		    interRinseStartDateTime, interRinseEndDateTime);
	    cipReportResult.setCipInterRinseStartDateTime(Tools.toDate(interRinseStartDateTime).getTime());
	    cipReportResult.setCipInterRinseEndDateTime(Tools.toDate(interRinseEndDateTime).getTime());
	    cipReportResult.setCipInterRinseLastTime(Tools.dateDiffMinutes(interRinseStartDateTime,
		    interRinseEndDateTime).getHumanTime());
	    cipReportResult.setCipInterRinseFlowOut(flowOut);
	    cipReportResult.setCipInterRinseTemperatureOut(ttOut);
	    cipReportResult.setCipInterRinseTemperatureBack(ttBack);
	}
    }

    public static void setCIPFinalRinse(CIPMasterLine ml, CIPReportResult cipReportResult,
	    String finalRinseStartDateTime, String finalRinseEndDateTime) throws ClassNotFoundException, SQLException,
	    IOException, ParseException {
	// final rinse
	if (finalRinseStartDateTime != null && finalRinseEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatusNoTimer(ml.getCipMasterLineFlowOutTag(),
		    finalRinseStartDateTime, finalRinseEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatusNoTimer(ml.getCipMasterLineTemperatureOutTag(),
		    finalRinseStartDateTime, finalRinseEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatusNoTimer(ml.getCipMasterLineTemperatureBackTag(),
		    finalRinseStartDateTime, finalRinseEndDateTime);
	    cipReportResult.setCipFinalRinseStartDateTime(Tools.toDate(finalRinseStartDateTime).getTime());
	    cipReportResult.setCipFinalRinseEndDateTime(Tools.toDate(finalRinseEndDateTime).getTime());
	    cipReportResult.setCipFinalRinseLastTime(Tools.dateDiffMinutes(finalRinseStartDateTime,
		    finalRinseEndDateTime).getHumanTime());
	    cipReportResult.setCipFinalRinseFlowOut(flowOut);
	    cipReportResult.setCipFinalRinseTemperatureOut(ttOut);
	    cipReportResult.setCipFinalRinseTemperatureBack(ttBack);
	}
    }

    public static void setCIPSterilize(CIPMasterLine ml, CIPReportResult cipReportResult, String sterStartDateTime,
	    String sterEndDateTime) throws ClassNotFoundException, SQLException, IOException, ParseException {
	// ster
	if (sterStartDateTime != null && sterEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatus(ml.getCipMasterLineStepTimerTag(),
		    ml.getCipMasterLineFlowOutTag(), sterStartDateTime, sterEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatus(ml.getCipMasterLineStepTimerTag(),
		    ml.getCipMasterLineTemperatureOutTag(), sterStartDateTime, sterEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatus(ml.getCipMasterLineStepTimerTag(),
		    ml.getCipMasterLineTemperatureBackTag(), sterStartDateTime, sterEndDateTime);

	    cipReportResult.setCipSterStartDateTime(Tools.toDate(sterStartDateTime).getTime());
	    cipReportResult.setCipSterEndDateTime(Tools.toDate(sterEndDateTime).getTime());
	    cipReportResult.setCipSterilizeLastTime(Tools.dateDiffMinutes(sterStartDateTime, sterEndDateTime)
		    .getHumanTime());
	    cipReportResult.setCipSterilizeFlowOut(flowOut);
	    cipReportResult.setCipSterilizeTemperatureOut(ttOut);
	    cipReportResult.setCipSterilizeTemperatureBack(ttBack);
	}
    }

    public static void setCIPLyeCycle(CIPMasterLine ml, CIPReportResult cipReportResult, String lyeCycleStartDateTime,
	    String lyeCycleEndDateTime) throws ClassNotFoundException, SQLException, IOException, ParseException {
	// lye cycle
	if (lyeCycleStartDateTime != null && lyeCycleEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatus(ml.getCipMasterLineStepTimerTag(),
		    ml.getCipMasterLineFlowOutTag(), lyeCycleStartDateTime, lyeCycleEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatus(ml.getCipMasterLineStepTimerTag(),
		    ml.getCipMasterLineTemperatureOutTag(), lyeCycleStartDateTime, lyeCycleEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatus(ml.getCipMasterLineStepTimerTag(),
		    ml.getCipMasterLineTemperatureBackTag(), lyeCycleStartDateTime, lyeCycleEndDateTime);
	    String ctBack = InSQLDaoUtil.getDeviceStatus(ml.getCipMasterLineStepTimerTag(),
		    ml.getCipMasterLineConductivityBackTag(), lyeCycleStartDateTime, lyeCycleEndDateTime);

	    cipReportResult.setCipLyeCycleLastTime(Tools.dateDiffMinutes(lyeCycleStartDateTime, lyeCycleEndDateTime)
		    .getHumanTime());
	    cipReportResult.setCipLyeCycleStartDateTime(Tools.toDate(lyeCycleStartDateTime).getTime());
	    cipReportResult.setCipLyeCycleEndDateTime(Tools.toDate(lyeCycleEndDateTime).getTime());
	    cipReportResult.setCipLyeCycleFlowOut(flowOut);
	    cipReportResult.setCipLyeCycleTemperatureOut(ttOut);
	    cipReportResult.setCipLyeCycleTemperatureBack(ttBack);
	    cipReportResult.setCipLyeCycleConductivityBack(ctBack);
	}
    }

    public static void setCIPAcidCycle(CIPMasterLine ml, CIPReportResult cipReportResult,
	    String acidCycleStartDateTime, String acidCycleEndDateTime) throws ClassNotFoundException, SQLException,
	    IOException, ParseException {
	// acid cycle
	if (acidCycleStartDateTime != null && acidCycleEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatus(ml.getCipMasterLineStepTimerTag(),
		    ml.getCipMasterLineFlowOutTag(), acidCycleStartDateTime, acidCycleEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatus(ml.getCipMasterLineStepTimerTag(),
		    ml.getCipMasterLineTemperatureOutTag(), acidCycleStartDateTime, acidCycleEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatus(ml.getCipMasterLineStepTimerTag(),
		    ml.getCipMasterLineTemperatureBackTag(), acidCycleStartDateTime, acidCycleEndDateTime);
	    String ctBack = InSQLDaoUtil.getDeviceStatus(ml.getCipMasterLineStepTimerTag(),
		    ml.getCipMasterLineConductivityBackTag(), acidCycleStartDateTime, acidCycleEndDateTime);

	    cipReportResult.setCipAcidCycleLastTime(Tools.dateDiffMinutes(acidCycleStartDateTime, acidCycleEndDateTime)
		    .getHumanTime());
	    cipReportResult.setCipAcidCycleStartDateTime(Tools.toDate(acidCycleStartDateTime).getTime());
	    cipReportResult.setCipAcidCycleEndDateTime(Tools.toDate(acidCycleEndDateTime).getTime());
	    cipReportResult.setCipAcidCycleFlowOut(flowOut);
	    cipReportResult.setCipAcidCycleTemperatureOut(ttOut);
	    cipReportResult.setCipAcidCycleTemperatureBack(ttBack);
	    cipReportResult.setCipAcidCycleConductivityBack(ctBack);
	}
    }

    /**
     * The following methods are only for TPM6 based CIP program
     * */
    public static void setCIPPreRinseOfTPM6(CIPMasterLine ml, CIPReportResult cipReportResult,
	    String preRinseStartDateTime, String preRinseEndDateTime) throws ClassNotFoundException, SQLException,
	    IOException, ParseException {
	// pre rinse
	if (preRinseStartDateTime != null && preRinseEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getPreRinseStepTimerHoldTag(),
		    ml.getCipMasterLineFlowOutTag(), preRinseStartDateTime, preRinseEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getPreRinseStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureOutTag(), preRinseStartDateTime, preRinseEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getPreRinseStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureBackTag(), preRinseStartDateTime, preRinseEndDateTime);
	    cipReportResult.setCipPreRinseStartDateTime(Tools.toDate(preRinseStartDateTime).getTime());
	    cipReportResult.setCipPreRinseEndDateTime(Tools.toDate(preRinseEndDateTime).getTime());
	    cipReportResult.setCipPreRinseLastTime(Tools.dateDiffMinutes(preRinseStartDateTime, preRinseEndDateTime)
		    .getHumanTime());
	    cipReportResult.setCipPreRinseFlowOut(flowOut);
	    cipReportResult.setCipPreRinseTemperatureOut(ttOut);
	    cipReportResult.setCipPreRinseTemperatureBack(ttBack);
	}
    }

    public static void setCIPInterRinseOfTPM6(CIPMasterLine ml, CIPReportResult cipReportResult,
	    String interRinseStartDateTime, String interRinseEndDateTime) throws ClassNotFoundException, SQLException,
	    IOException, ParseException {
	// inter rinse
	if (interRinseStartDateTime != null && interRinseEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getIntRinseStepTimerHoldTag(),
		    ml.getCipMasterLineFlowOutTag(), interRinseStartDateTime, interRinseEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getIntRinseStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureOutTag(), interRinseStartDateTime, interRinseEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getIntRinseStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureBackTag(), interRinseStartDateTime, interRinseEndDateTime);
	    cipReportResult.setCipInterRinseStartDateTime(Tools.toDate(interRinseStartDateTime).getTime());
	    cipReportResult.setCipInterRinseEndDateTime(Tools.toDate(interRinseEndDateTime).getTime());
	    cipReportResult.setCipInterRinseLastTime(Tools.dateDiffMinutes(interRinseStartDateTime,
		    interRinseEndDateTime).getHumanTime());
	    cipReportResult.setCipInterRinseFlowOut(flowOut);
	    cipReportResult.setCipInterRinseTemperatureOut(ttOut);
	    cipReportResult.setCipInterRinseTemperatureBack(ttBack);
	}
    }

    public static void setCIPFinalRinseOfTPM6(CIPMasterLine ml, CIPReportResult cipReportResult,
	    String finalRinseStartDateTime, String finalRinseEndDateTime) throws ClassNotFoundException, SQLException,
	    IOException, ParseException {
	// final rinse
	if (finalRinseStartDateTime != null && finalRinseEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getFinalRinseStepTimerHoldTag(),
		    ml.getCipMasterLineFlowOutTag(), finalRinseStartDateTime, finalRinseEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getFinalRinseStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureOutTag(), finalRinseStartDateTime, finalRinseEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getFinalRinseStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureBackTag(), finalRinseStartDateTime, finalRinseEndDateTime);
	    cipReportResult.setCipFinalRinseStartDateTime(Tools.toDate(finalRinseStartDateTime).getTime());
	    cipReportResult.setCipFinalRinseEndDateTime(Tools.toDate(finalRinseEndDateTime).getTime());
	    cipReportResult.setCipFinalRinseLastTime(Tools.dateDiffMinutes(finalRinseStartDateTime,
		    finalRinseEndDateTime).getHumanTime());
	    cipReportResult.setCipFinalRinseFlowOut(flowOut);
	    cipReportResult.setCipFinalRinseTemperatureOut(ttOut);
	    cipReportResult.setCipFinalRinseTemperatureBack(ttBack);
	}
    }

    public static void setCIPSterilizeOfTPM6(CIPMasterLine ml, CIPReportResult cipReportResult,
	    String sterStartDateTime, String sterEndDateTime) throws ClassNotFoundException, SQLException, IOException,
	    ParseException {
	// ster
	if (sterStartDateTime != null && sterEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getHotWatStepTimerHoldTag(),
		    ml.getCipMasterLineFlowOutTag(), sterStartDateTime, sterEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getHotWatStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureOutTag(), sterStartDateTime, sterEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getHotWatStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureBackTag(), sterStartDateTime, sterEndDateTime);

	    cipReportResult.setCipSterStartDateTime(Tools.toDate(sterStartDateTime).getTime());
	    cipReportResult.setCipSterEndDateTime(Tools.toDate(sterEndDateTime).getTime());
	    cipReportResult.setCipSterilizeLastTime(Tools.dateDiffMinutes(sterStartDateTime, sterEndDateTime)
		    .getHumanTime());
	    cipReportResult.setCipSterilizeFlowOut(flowOut);
	    cipReportResult.setCipSterilizeTemperatureOut(ttOut);
	    cipReportResult.setCipSterilizeTemperatureBack(ttBack);
	}
    }

    public static void setCIPChemDisOfTPM6(CIPMasterLine ml, CIPReportResult cipReportResult, String sterStartDateTime,
	    String sterEndDateTime) throws ClassNotFoundException, SQLException, IOException, ParseException {
	// chem dis
	if (sterStartDateTime != null && sterEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getChemDisStepTimerHoldTag(),
		    ml.getCipMasterLineFlowOutTag(), sterStartDateTime, sterEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getChemDisStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureOutTag(), sterStartDateTime, sterEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getChemDisStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureBackTag(), sterStartDateTime, sterEndDateTime);

	    cipReportResult.setCipSterStartDateTime(Tools.toDate(sterStartDateTime).getTime());
	    cipReportResult.setCipSterEndDateTime(Tools.toDate(sterEndDateTime).getTime());
	    cipReportResult.setCipSterilizeLastTime(Tools.dateDiffMinutes(sterStartDateTime, sterEndDateTime)
		    .getHumanTime());
	    cipReportResult.setCipSterilizeFlowOut(flowOut);
	    cipReportResult.setCipSterilizeTemperatureOut(ttOut);
	    cipReportResult.setCipSterilizeTemperatureBack(ttBack);
	}
    }

    public static void setCIPLyeCycleOfTPM6(CIPMasterLine ml, CIPReportResult cipReportResult,
	    String lyeCycleStartDateTime, String lyeCycleEndDateTime) throws ClassNotFoundException, SQLException,
	    IOException, ParseException {
	// lye cycle
	if (lyeCycleStartDateTime != null && lyeCycleEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getLyeStepTimerHoldTag(),
		    ml.getCipMasterLineFlowOutTag(), lyeCycleStartDateTime, lyeCycleEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getLyeStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureOutTag(), lyeCycleStartDateTime, lyeCycleEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getLyeStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureBackTag(), lyeCycleStartDateTime, lyeCycleEndDateTime);
	    String ctBack = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getLyeStepTimerHoldTag(),
		    ml.getCipMasterLineConductivityBackTag(), lyeCycleStartDateTime, lyeCycleEndDateTime);

	    cipReportResult.setCipLyeCycleLastTime(Tools.dateDiffMinutes(lyeCycleStartDateTime, lyeCycleEndDateTime)
		    .getHumanTime());
	    cipReportResult.setCipLyeCycleStartDateTime(Tools.toDate(lyeCycleStartDateTime).getTime());
	    cipReportResult.setCipLyeCycleEndDateTime(Tools.toDate(lyeCycleEndDateTime).getTime());
	    cipReportResult.setCipLyeCycleFlowOut(flowOut);
	    cipReportResult.setCipLyeCycleTemperatureOut(ttOut);
	    cipReportResult.setCipLyeCycleTemperatureBack(ttBack);
	    cipReportResult.setCipLyeCycleConductivityBack(ctBack);
	}
    }

    public static void setCIPAcidCycleOfTPM6(CIPMasterLine ml, CIPReportResult cipReportResult,
	    String acidCycleStartDateTime, String acidCycleEndDateTime) throws ClassNotFoundException, SQLException,
	    IOException, ParseException {
	// acid cycle
	if (acidCycleStartDateTime != null && acidCycleEndDateTime != null) {
	    String flowOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getLyeStepTimerHoldTag(),
		    ml.getCipMasterLineFlowOutTag(), acidCycleStartDateTime, acidCycleEndDateTime);
	    String ttOut = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getLyeStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureOutTag(), acidCycleStartDateTime, acidCycleEndDateTime);
	    String ttBack = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getLyeStepTimerHoldTag(),
		    ml.getCipMasterLineTemperatureBackTag(), acidCycleStartDateTime, acidCycleEndDateTime);
	    String ctBack = InSQLDaoUtil.getDeviceStatusOfTPM6(ml.getLyeStepTimerHoldTag(),
		    ml.getCipMasterLineConductivityBackTag(), acidCycleStartDateTime, acidCycleEndDateTime);

	    cipReportResult.setCipAcidCycleLastTime(Tools.dateDiffMinutes(acidCycleStartDateTime, acidCycleEndDateTime)
		    .getHumanTime());
	    cipReportResult.setCipAcidCycleStartDateTime(Tools.toDate(acidCycleStartDateTime).getTime());
	    cipReportResult.setCipAcidCycleEndDateTime(Tools.toDate(acidCycleEndDateTime).getTime());
	    cipReportResult.setCipAcidCycleFlowOut(flowOut);
	    cipReportResult.setCipAcidCycleTemperatureOut(ttOut);
	    cipReportResult.setCipAcidCycleTemperatureBack(ttBack);
	    cipReportResult.setCipAcidCycleConductivityBack(ctBack);
	}
    }

}
