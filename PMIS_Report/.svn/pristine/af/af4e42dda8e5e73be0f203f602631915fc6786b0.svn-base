package com.tetrapak.action.systemsettings.cip;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.domain.cip.CIPMasterLine;
import com.tetrapak.model.systemsettings.cip.CIPMasterLineTagSettingActionModel;

public class CIPMasterLineTagSettingAction extends ActionSupport implements Action {
    private static final long serialVersionUID = -8807946471719603837L;
    private Integer masterLineId;
    private String masterLineOperTag;

    private String masterLineRoutePhaseIDTag;
    private String masterLineCIPProgramIDTag;
    private String masterLineOperatedByIDTag;
    private String masterLineCIPResultIDTag;

    private String masterLineStepsTag;

    private String masterLineFlowOutTag;
    private String masterLineTemperatureOutTag;
    private String masterLineConductivityBackTag;
    private String masterLineTemperatureBackTag;

    private String masterLineStepTimerTag;

    private CIPMasterLine cipMasterLine;

    /**
     * The following property is for TPM6 based cip program only
     * */
    private String phaseActivityIDTag;
    private String preRinseStepNTag;
    private String preRinseStepTimerHoldTag;
    private String intRinseStepNTag;
    private String intRinseStepTimerHoldTag;
    private String lyeStepNTag;
    private String lyeStepTimerHoldTag;
    private String acidStepNTag;
    private String acidStepTimerHoldTag;
    private String hotWatStepNTag;
    private String hotWatStepTimerHoldTag;
    private String chemDisStepNTag;
    private String chemDisStepTimerHoldTag;
    private String finalRinseStepNTag;
    private String finalRinseStepTimerHoldTag;

    public Integer getMasterLineId() {
	return masterLineId;
    }

    public void setMasterLineId(Integer masterLineId) {
	this.masterLineId = masterLineId;
    }

    public String getMasterLineOperTag() {
	return masterLineOperTag;
    }

    public void setMasterLineOperTag(String masterLineOperTag) {
	this.masterLineOperTag = masterLineOperTag;
    }

    public String getMasterLineRoutePhaseIDTag() {
	return masterLineRoutePhaseIDTag;
    }

    public void setMasterLineRoutePhaseIDTag(String masterLineRoutePhaseIDTag) {
	this.masterLineRoutePhaseIDTag = masterLineRoutePhaseIDTag;
    }

    public String getMasterLineCIPProgramIDTag() {
	return masterLineCIPProgramIDTag;
    }

    public void setMasterLineCIPProgramIDTag(String masterLineCIPProgramIDTag) {
	this.masterLineCIPProgramIDTag = masterLineCIPProgramIDTag;
    }

    public String getMasterLineOperatedByIDTag() {
	return masterLineOperatedByIDTag;
    }

    public void setMasterLineOperatedByIDTag(String masterLineOperatedByIDTag) {
	this.masterLineOperatedByIDTag = masterLineOperatedByIDTag;
    }

    public String getMasterLineCIPResultIDTag() {
	return masterLineCIPResultIDTag;
    }

    public void setMasterLineCIPResultIDTag(String masterLineCIPResultIDTag) {
	this.masterLineCIPResultIDTag = masterLineCIPResultIDTag;
    }

    public String getMasterLineStepsTag() {
	return masterLineStepsTag;
    }

    public void setMasterLineStepsTag(String masterLineStepsTag) {
	this.masterLineStepsTag = masterLineStepsTag;
    }

    public String getMasterLineFlowOutTag() {
	return masterLineFlowOutTag;
    }

    public void setMasterLineFlowOutTag(String masterLineFlowOutTag) {
	this.masterLineFlowOutTag = masterLineFlowOutTag;
    }

    public String getMasterLineTemperatureOutTag() {
	return masterLineTemperatureOutTag;
    }

    public void setMasterLineTemperatureOutTag(String masterLineTemperatureOutTag) {
	this.masterLineTemperatureOutTag = masterLineTemperatureOutTag;
    }

    public String getMasterLineConductivityBackTag() {
	return masterLineConductivityBackTag;
    }

    public void setMasterLineConductivityBackTag(String masterLineConductivityBackTag) {
	this.masterLineConductivityBackTag = masterLineConductivityBackTag;
    }

    public String getMasterLineTemperatureBackTag() {
	return masterLineTemperatureBackTag;
    }

    public void setMasterLineTemperatureBackTag(String masterLineTemperatureBackTag) {
	this.masterLineTemperatureBackTag = masterLineTemperatureBackTag;
    }

    public CIPMasterLine getCipMasterLine() {
	return cipMasterLine;
    }

    public void setCipMasterLine(CIPMasterLine cipMasterLine) {
	this.cipMasterLine = cipMasterLine;
    }

    public String getMasterLineStepTimerTag() {
	return masterLineStepTimerTag;
    }

    public void setMasterLineStepTimerTag(String masterLineStepTimerTag) {
	this.masterLineStepTimerTag = masterLineStepTimerTag;
    }

    public String getPhaseActivityIDTag() {
	return phaseActivityIDTag;
    }

    public void setPhaseActivityIDTag(String phaseActivityIDTag) {
	this.phaseActivityIDTag = phaseActivityIDTag;
    }

    public String getPreRinseStepNTag() {
	return preRinseStepNTag;
    }

    public void setPreRinseStepNTag(String preRinseStepNTag) {
	this.preRinseStepNTag = preRinseStepNTag;
    }

    public String getPreRinseStepTimerHoldTag() {
	return preRinseStepTimerHoldTag;
    }

    public void setPreRinseStepTimerHoldTag(String preRinseStepTimerHoldTag) {
	this.preRinseStepTimerHoldTag = preRinseStepTimerHoldTag;
    }

    public String getIntRinseStepNTag() {
	return intRinseStepNTag;
    }

    public void setIntRinseStepNTag(String intRinseStepNTag) {
	this.intRinseStepNTag = intRinseStepNTag;
    }

    public String getIntRinseStepTimerHoldTag() {
	return intRinseStepTimerHoldTag;
    }

    public void setIntRinseStepTimerHoldTag(String intRinseStepTimerHoldTag) {
	this.intRinseStepTimerHoldTag = intRinseStepTimerHoldTag;
    }

    public String getLyeStepNTag() {
	return lyeStepNTag;
    }

    public void setLyeStepNTag(String lyeStepNTag) {
	this.lyeStepNTag = lyeStepNTag;
    }

    public String getLyeStepTimerHoldTag() {
	return lyeStepTimerHoldTag;
    }

    public void setLyeStepTimerHoldTag(String lyeStepTimerHoldTag) {
	this.lyeStepTimerHoldTag = lyeStepTimerHoldTag;
    }

    public String getAcidStepNTag() {
	return acidStepNTag;
    }

    public void setAcidStepNTag(String acidStepNTag) {
	this.acidStepNTag = acidStepNTag;
    }

    public String getAcidStepTimerHoldTag() {
	return acidStepTimerHoldTag;
    }

    public void setAcidStepTimerHoldTag(String acidStepTimerHoldTag) {
	this.acidStepTimerHoldTag = acidStepTimerHoldTag;
    }

    public String getHotWatStepNTag() {
	return hotWatStepNTag;
    }

    public void setHotWatStepNTag(String hotWatStepNTag) {
	this.hotWatStepNTag = hotWatStepNTag;
    }

    public String getHotWatStepTimerHoldTag() {
	return hotWatStepTimerHoldTag;
    }

    public void setHotWatStepTimerHoldTag(String hotWatStepTimerHoldTag) {
	this.hotWatStepTimerHoldTag = hotWatStepTimerHoldTag;
    }

    public String getChemDisStepNTag() {
	return chemDisStepNTag;
    }

    public void setChemDisStepNTag(String chemDisStepNTag) {
	this.chemDisStepNTag = chemDisStepNTag;
    }

    public String getChemDisStepTimerHoldTag() {
	return chemDisStepTimerHoldTag;
    }

    public void setChemDisStepTimerHoldTag(String chemDisStepTimerHoldTag) {
	this.chemDisStepTimerHoldTag = chemDisStepTimerHoldTag;
    }

    public String getFinalRinseStepNTag() {
	return finalRinseStepNTag;
    }

    public void setFinalRinseStepNTag(String finalRinseStepNTag) {
	this.finalRinseStepNTag = finalRinseStepNTag;
    }

    public String getFinalRinseStepTimerHoldTag() {
	return finalRinseStepTimerHoldTag;
    }

    public void setFinalRinseStepTimerHoldTag(String finalRinseStepTimerHoldTag) {
	this.finalRinseStepTimerHoldTag = finalRinseStepTimerHoldTag;
    }

    public String save() throws Exception {
	String result = INPUT;
	boolean rs = CIPMasterLineTagSettingActionModel.saveMasterLineTags(masterLineId, masterLineOperTag,
		masterLineRoutePhaseIDTag, masterLineCIPProgramIDTag, masterLineOperatedByIDTag,
		masterLineCIPResultIDTag, masterLineStepsTag, masterLineFlowOutTag, masterLineTemperatureOutTag,
		masterLineConductivityBackTag, masterLineTemperatureBackTag, masterLineStepTimerTag,
		phaseActivityIDTag, preRinseStepNTag, preRinseStepTimerHoldTag, intRinseStepNTag,
		intRinseStepTimerHoldTag, lyeStepNTag, lyeStepTimerHoldTag, acidStepNTag, acidStepTimerHoldTag,
		hotWatStepNTag, hotWatStepTimerHoldTag, chemDisStepNTag, chemDisStepTimerHoldTag, finalRinseStepNTag,
		finalRinseStepTimerHoldTag);
	if (rs) {
	    result = SUCCESS;
	}
	return result;
    }

}
