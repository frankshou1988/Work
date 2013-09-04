package com.tetrapak.domain.cip;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The CIPMasterLine class which stands for the CIP Master Line definition,you
 * should give it a name and an optional description. This CIP Master Line has
 * some tags, which holds the data during the CIP process.
 * */
@Entity
@Table(name = "cip_master_line", schema = "dbo")
public class CIPMasterLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cip_master_line_name")
    private String cipMasterLineName;
    @Column(name = "cip_master_line_desc")
    private String cipMasterLineDesc;

    @Column(name = "plc_structure_type")
    private String plcStructureType;
    @Column(name = "workshop_type")
    private String workshopType;
    /**
     * CIP Master Line Tags
     * */
    @Column(name = "cip_master_line_oper_tag")
    private String cipMasterLineOperTag;

    @Column(name = "cip_master_line_route_phase_id_tag")
    private String cipMasterLineRoutePhaseIDTag;
    @Column(name = "cip_master_line_cip_program_id_tag")
    private String cipMasterLineCIPProgramIDTag;
    @Column(name = "cip_master_line_operated_by_id_tag")
    private String cipMasterLineOperatedByIDTag;
    @Column(name = "cip_master_line_cip_result_id_tag")
    private String cipMasterLineCIPResultIDTag;

    @Column(name = "cip_master_line_steps_tag")
    private String cipMasterLineStepsTag;

    @Column(name = "cip_master_line_flow_out_tag")
    private String cipMasterLineFlowOutTag;
    @Column(name = "cip_master_line_temperature_out_tag")
    private String cipMasterLineTemperatureOutTag;
    @Column(name = "cip_master_line_conductivity_back_tag")
    private String cipMasterLineConductivityBackTag;
    @Column(name = "cip_master_line_temperature_back_tag")
    private String cipMasterLineTemperatureBackTag;

    @Column(name = "cip_master_line_step_timer_tag")
    private String cipMasterLineStepTimerTag;

    /**
     * The following property are for TPM6 based PLC program only.
     * */
    @Column(name = "phase_activity_id_tag")
    private String phaseActivityIDTag;
    @Column(name = "pre_rinse_step_n_tag")
    private String preRinseStepNTag;
    @Column(name = "pre_rinse_step_timer_hold_tag")
    private String preRinseStepTimerHoldTag;
    @Column(name = "int_rinse_step_n_tag")
    private String intRinseStepNTag;
    @Column(name = "int_rinse_step_timer_hold_tag")
    private String intRinseStepTimerHoldTag;
    @Column(name = "lye_step_n_tag")
    private String lyeStepNTag;
    @Column(name = "lye_step_timer_hold_tag")
    private String lyeStepTimerHoldTag;
    @Column(name = "acid_step_n_tag")
    private String acidStepNTag;
    @Column(name = "acid_step_timer_hold_tag")
    private String acidStepTimerHoldTag;
    @Column(name = "hot_wat_step_n_tag")
    private String hotWatStepNTag;
    @Column(name = "hot_wat_step_timer_hold_tag")
    private String hotWatStepTimerHoldTag;
    @Column(name = "chem_dis_step_n_tag")
    private String chemDisStepNTag;
    @Column(name = "chem_dis_step_timer_hold_tag")
    private String chemDisStepTimerHoldTag;
    @Column(name = "final_rinse_step_n_tag")
    private String finalRinseStepNTag;
    @Column(name = "final_rinse_step_timer_hold_tag")
    private String finalRinseStepTimerHoldTag;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getCipMasterLineName() {
	return cipMasterLineName;
    }

    public void setCipMasterLineName(String cipMasterLineName) {
	this.cipMasterLineName = cipMasterLineName;
    }

    public String getCipMasterLineDesc() {
	return cipMasterLineDesc;
    }

    public void setCipMasterLineDesc(String cipMasterLineDesc) {
	this.cipMasterLineDesc = cipMasterLineDesc;
    }

    public String getPlcStructureType() {
	return plcStructureType;
    }

    public void setPlcStructureType(String plcStructureType) {
	this.plcStructureType = plcStructureType;
    }

    public String getWorkshopType() {
	return workshopType;
    }

    public void setWorkshopType(String workshopType) {
	this.workshopType = workshopType;
    }

    public String getCipMasterLineOperTag() {
	return cipMasterLineOperTag;
    }

    public void setCipMasterLineOperTag(String cipMasterLineOperTag) {
	this.cipMasterLineOperTag = cipMasterLineOperTag;
    }

    public String getCipMasterLineRoutePhaseIDTag() {
	return cipMasterLineRoutePhaseIDTag;
    }

    public void setCipMasterLineRoutePhaseIDTag(String cipMasterLineRoutePhaseIDTag) {
	this.cipMasterLineRoutePhaseIDTag = cipMasterLineRoutePhaseIDTag;
    }

    public String getCipMasterLineCIPProgramIDTag() {
	return cipMasterLineCIPProgramIDTag;
    }

    public void setCipMasterLineCIPProgramIDTag(String cipMasterLineCIPProgramIDTag) {
	this.cipMasterLineCIPProgramIDTag = cipMasterLineCIPProgramIDTag;
    }

    public String getCipMasterLineOperatedByIDTag() {
	return cipMasterLineOperatedByIDTag;
    }

    public void setCipMasterLineOperatedByIDTag(String cipMasterLineOperatedByIDTag) {
	this.cipMasterLineOperatedByIDTag = cipMasterLineOperatedByIDTag;
    }

    public String getCipMasterLineCIPResultIDTag() {
	return cipMasterLineCIPResultIDTag;
    }

    public void setCipMasterLineCIPResultIDTag(String cipMasterLineCIPResultIDTag) {
	this.cipMasterLineCIPResultIDTag = cipMasterLineCIPResultIDTag;
    }

    public String getCipMasterLineStepsTag() {
	return cipMasterLineStepsTag;
    }

    public void setCipMasterLineStepsTag(String cipMasterLineStepsTag) {
	this.cipMasterLineStepsTag = cipMasterLineStepsTag;
    }

    public String getCipMasterLineFlowOutTag() {
	return cipMasterLineFlowOutTag;
    }

    public void setCipMasterLineFlowOutTag(String cipMasterLineFlowOutTag) {
	this.cipMasterLineFlowOutTag = cipMasterLineFlowOutTag;
    }

    public String getCipMasterLineTemperatureOutTag() {
	return cipMasterLineTemperatureOutTag;
    }

    public void setCipMasterLineTemperatureOutTag(String cipMasterLineTemperatureOutTag) {
	this.cipMasterLineTemperatureOutTag = cipMasterLineTemperatureOutTag;
    }

    public String getCipMasterLineConductivityBackTag() {
	return cipMasterLineConductivityBackTag;
    }

    public void setCipMasterLineConductivityBackTag(String cipMasterLineConductivityBackTag) {
	this.cipMasterLineConductivityBackTag = cipMasterLineConductivityBackTag;
    }

    public String getCipMasterLineTemperatureBackTag() {
	return cipMasterLineTemperatureBackTag;
    }

    public void setCipMasterLineTemperatureBackTag(String cipMasterLineTemperatureBackTag) {
	this.cipMasterLineTemperatureBackTag = cipMasterLineTemperatureBackTag;
    }

    public String getCipMasterLineStepTimerTag() {
	return cipMasterLineStepTimerTag;
    }

    public void setCipMasterLineStepTimerTag(String cipMasterLineStepTimerTag) {
	this.cipMasterLineStepTimerTag = cipMasterLineStepTimerTag;
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

}
