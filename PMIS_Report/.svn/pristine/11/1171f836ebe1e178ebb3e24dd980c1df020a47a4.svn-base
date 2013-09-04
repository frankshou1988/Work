package com.tetrapak.model.systemsettings.cip;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPMasterLine;

/**
 * Save the CIP Master Line related tags
 * */
public class CIPMasterLineTagSettingActionModel {

    public static boolean saveMasterLineTags(Integer masterLineId, String masterLineOperTag,
	    String masterLineRoutePhaseIDTag, String masterLineCIPProgramIDTag, String masterLineOperatedByIDTag,
	    String masterLineCIPResultID, String masterLineStepsTag, String masterLineFlowOutTag,
	    String masterLineTemperatureOutTag, String masterLineConductivityBackTag,
	    String masterLineTemperatureBackTag, String masterLineStepTimerTag, String phaseActivityIDTag,
	    String preRinseStepNTag, String preRinseStepTimerHoldTag, String intRinseStepNTag,
	    String intRinseStepTimerHoldTag, String lyeStepNTag, String lyeStepTimerHoldTag, String acidStepNTag,
	    String acidStepTimerHoldTag, String hotWatStepNTag, String hotWatStepTimerHoldTag, String chemDisStepNTag,
	    String chemDisStepTimerHoldTag, String finalRinseStepNTag, String finalRinseStepTimerHoldTag)
	    throws Exception {
	boolean result = false;
	CIPMasterLine ml = (CIPMasterLine) CommonDao.getObjById(CIPMasterLine.class, masterLineId);
	if (ml != null) {
	    ml.setCipMasterLineOperTag(masterLineOperTag);

	    ml.setCipMasterLineRoutePhaseIDTag(masterLineRoutePhaseIDTag);
	    ml.setCipMasterLineCIPProgramIDTag(masterLineCIPProgramIDTag);
	    ml.setCipMasterLineOperatedByIDTag(masterLineOperatedByIDTag);
	    ml.setCipMasterLineCIPResultIDTag(masterLineCIPResultID);

	    ml.setCipMasterLineStepsTag(masterLineStepsTag);

	    ml.setCipMasterLineFlowOutTag(masterLineFlowOutTag);
	    ml.setCipMasterLineTemperatureOutTag(masterLineTemperatureOutTag);
	    ml.setCipMasterLineConductivityBackTag(masterLineConductivityBackTag);
	    ml.setCipMasterLineTemperatureBackTag(masterLineTemperatureBackTag);

	    ml.setCipMasterLineStepTimerTag(masterLineStepTimerTag);

	    /**
	     * The following property is only for TPM6 based CIP program
	     * */
	    ml.setPhaseActivityIDTag(phaseActivityIDTag);
	    ml.setPreRinseStepNTag(preRinseStepNTag);
	    ml.setPreRinseStepTimerHoldTag(preRinseStepTimerHoldTag);
	    ml.setIntRinseStepNTag(intRinseStepNTag);
	    ml.setIntRinseStepTimerHoldTag(intRinseStepTimerHoldTag);
	    ml.setLyeStepNTag(lyeStepNTag);
	    ml.setLyeStepTimerHoldTag(lyeStepTimerHoldTag);
	    ml.setAcidStepNTag(acidStepNTag);
	    ml.setAcidStepTimerHoldTag(acidStepTimerHoldTag);
	    ml.setHotWatStepNTag(hotWatStepNTag);
	    ml.setHotWatStepTimerHoldTag(hotWatStepTimerHoldTag);
	    ml.setChemDisStepNTag(chemDisStepNTag);
	    ml.setChemDisStepTimerHoldTag(chemDisStepTimerHoldTag);
	    ml.setFinalRinseStepNTag(finalRinseStepNTag);
	    ml.setFinalRinseStepTimerHoldTag(finalRinseStepTimerHoldTag);
	    CommonDao.update(ml);
	    result = true;
	}
	return result;
    }

}
