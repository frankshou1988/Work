package com.tetrapak.domain.cip;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cip_report_result", schema = "dbo")
public class CIPReportResult implements Serializable {

    private static final long serialVersionUID = 6244831579513418117L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * CIP General Information
     * */
    @Column(name = "cip_master_line_id")
    private Integer cipMasterLineId;
    @Column(name = "cip_master_line_name")
    private String cipMasterLineName;
    @Column(name = "cip_slave_line_id")
    private Integer cipSlaveLineId;
    @Column(name = "cip_slave_line_name")
    private String cipSlaveLineName;
    @Column(name = "cip_target_name")
    private String cipTargetName;
    @Column(name = "cip_target_desc")
    private String cipTargetDesc;
    @Column(name = "cip_start_date_time")
    private Date cipStartDateTime;
    @Column(name = "cip_end_date_time")
    private Date cipEndDateTime;
    @Column(name = "cip_last_time")
    private String cipLastTime;
    @Column(name = "cip_type")
    private String cipType;
    @Column(name = "cip_type_plc_id")
    private Long cipTypePLCId;
    @Column(name = "cip_result_plc_id")
    private Long cipResultPLCId;
    @Column(name = "cip_result")
    private String cipResult;

    /**
     * Pre Rinse Information
     * */
    @Column(name = "cip_pre_rinse_start_date_time")
    private Date cipPreRinseStartDateTime;
    @Column(name = "cip_pre_rinse_end_date_time")
    private Date cipPreRinseEndDateTime;
    @Column(name = "cip_pre_rinse_last_time")
    private String cipPreRinseLastTime;
    @Column(name = "cip_pre_rinse_temperature_out")
    private String cipPreRinseTemperatureOut;
    @Column(name = "cip_pre_rinse_flow_out")
    private String cipPreRinseFlowOut;
    @Column(name = "cip_pre_rinse_temperature_back")
    private String cipPreRinseTemperatureBack;

    /**
     * Lye Information
     * */

    @Column(name = "cip_lye_cycle_start_date_time")
    private Date cipLyeCycleStartDateTime;
    @Column(name = "cip_lye_cycle_end_date_time")
    private Date cipLyeCycleEndDateTime;
    @Column(name = "cip_lye_cycle_last_time")
    private String cipLyeCycleLastTime;
    @Column(name = "cip_lye_cycle_temperature_out")
    private String cipLyeCycleTemperatureOut;
    @Column(name = "cip_lye_cycle_flow_out")
    private String cipLyeCycleFlowOut;
    @Column(name = "cip_lye_cycle_conductivity_back")
    private String cipLyeCycleConductivityBack;
    @Column(name = "cip_lye_cycle_temperature_back")
    private String cipLyeCycleTemperatureBack;

    /**
     * Inter Rinse information
     * */
    @Column(name = "cip_inter_rinse_start_date_time")
    private Date cipInterRinseStartDateTime;
    @Column(name = "cip_inter_rinse_end_date_time")
    private Date cipInterRinseEndDateTime;
    @Column(name = "cip_inter_rinse_last_time")
    private String cipInterRinseLastTime;
    @Column(name = "cip_inter_rinse_temperature_out")
    private String cipInterRinseTemperatureOut;
    @Column(name = "cip_inter_rinse_flow_out")
    private String cipInterRinseFlowOut;
    @Column(name = "cip_inter_rinse_temperature_back")
    private String cipInterRinseTemperatureBack;

    /**
     * Acid Information
     * */

    @Column(name = "cip_acid_cycle_start_date_time")
    private Date cipAcidCycleStartDateTime;
    @Column(name = "cip_acid_cycle_end_date_time")
    private Date cipAcidCycleEndDateTime;
    @Column(name = "cip_acid_cycle_last_time")
    private String cipAcidCycleLastTime;
    @Column(name = "cip_acid_cycle_temperature_out")
    private String cipAcidCycleTemperatureOut;
    @Column(name = "cip_acid_cycle_flow_out")
    private String cipAcidCycleFlowOut;
    @Column(name = "cip_acid_cycle_conductivity_back")
    private String cipAcidCycleConductivityBack;
    @Column(name = "cip_acid_cycle_temperature_back")
    private String cipAcidCycleTemperatureBack;

    /**
     * Final Rinse Information
     * */
    @Column(name = "cip_final_rinse_start_date_time")
    private Date cipFinalRinseStartDateTime;
    @Column(name = "cip_final_rinse_end_date_time")
    private Date cipFinalRinseEndDateTime;
    @Column(name = "cip_final_rinse_last_time")
    private String cipFinalRinseLastTime;
    @Column(name = "cip_final_rinse_temperature_out")
    private String cipFinalRinseTemperatureOut;
    @Column(name = "cip_final_rinse_flow_out")
    private String cipFinalRinseFlowOut;
    @Column(name = "cip_final_rinse_temperature_back")
    private String cipFinalRinseTemperatureBack;

    /**
     * Sterilization Information
     * */
    @Column(name = "cip_ster_start_date_time")
    private Date cipSterStartDateTime;
    @Column(name = "cip_ster_end_date_time")
    private Date cipSterEndDateTime;
    @Column(name = "cip_ster_last_time")
    private String cipSterilizeLastTime;
    @Column(name = "cip_ster_temperature_out")
    private String cipSterilizeTemperatureOut;
    @Column(name = "cip_ster_flow_out")
    private String cipSterilizeFlowOut;
    @Column(name = "cip_ster_temperature_back")
    private String cipSterilizeTemperatureBack;

    @Column(name = "cip_operated_by_id")
    private Long cipOperatedByID;
    @Column(name = "cip_operated_by_name")
    private String cipOperatedByName;

    @Column(name = "plc_structure_type")
    private String plcStructureType;

    @Column(name = "workshop_type")
    private String workshopType;

    @Column(name = "time_since_last_operation")
    private String timeSinceLastOperation;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getCipMasterLineId() {
	return cipMasterLineId;
    }

    public void setCipMasterLineId(Integer cipMasterLineId) {
	this.cipMasterLineId = cipMasterLineId;
    }

    public String getCipMasterLineName() {
	return cipMasterLineName;
    }

    public void setCipMasterLineName(String cipMasterLineName) {
	this.cipMasterLineName = cipMasterLineName;
    }

    public Integer getCipSlaveLineId() {
	return cipSlaveLineId;
    }

    public void setCipSlaveLineId(Integer cipSlaveLineId) {
	this.cipSlaveLineId = cipSlaveLineId;
    }

    public String getCipSlaveLineName() {
	return cipSlaveLineName;
    }

    public void setCipSlaveLineName(String cipSlaveLineName) {
	this.cipSlaveLineName = cipSlaveLineName;
    }

    public String getCipTargetName() {
	return cipTargetName;
    }

    public void setCipTargetName(String cipTargetName) {
	this.cipTargetName = cipTargetName;
    }

    public String getCipTargetDesc() {
	return cipTargetDesc;
    }

    public void setCipTargetDesc(String cipTargetDesc) {
	this.cipTargetDesc = cipTargetDesc;
    }

    public Date getCipStartDateTime() {
	return cipStartDateTime;
    }

    public void setCipStartDateTime(Date cipStartDateTime) {
	this.cipStartDateTime = cipStartDateTime;
    }

    public Date getCipEndDateTime() {
	return cipEndDateTime;
    }

    public void setCipEndDateTime(Date cipEndDateTime) {
	this.cipEndDateTime = cipEndDateTime;
    }

    public String getCipLastTime() {
	return cipLastTime;
    }

    public void setCipLastTime(String cipLastTime) {
	this.cipLastTime = cipLastTime;
    }

    public String getCipType() {
	return cipType;
    }

    public void setCipType(String cipType) {
	this.cipType = cipType;
    }

    public Long getCipTypePLCId() {
	return cipTypePLCId;
    }

    public void setCipTypePLCId(Long cipTypePLCId) {
	this.cipTypePLCId = cipTypePLCId;
    }

    public Long getCipResultPLCId() {
	return cipResultPLCId;
    }

    public void setCipResultPLCId(Long cipResultPLCId) {
	this.cipResultPLCId = cipResultPLCId;
    }

    public String getCipResult() {
	return cipResult;
    }

    public void setCipResult(String cipResult) {
	this.cipResult = cipResult;
    }

    public Date getCipPreRinseStartDateTime() {
	return cipPreRinseStartDateTime;
    }

    public void setCipPreRinseStartDateTime(Date cipPreRinseStartDateTime) {
	this.cipPreRinseStartDateTime = cipPreRinseStartDateTime;
    }

    public Date getCipPreRinseEndDateTime() {
	return cipPreRinseEndDateTime;
    }

    public void setCipPreRinseEndDateTime(Date cipPreRinseEndDateTime) {
	this.cipPreRinseEndDateTime = cipPreRinseEndDateTime;
    }

    public String getCipPreRinseLastTime() {
	return cipPreRinseLastTime;
    }

    public void setCipPreRinseLastTime(String cipPreRinseLastTime) {
	this.cipPreRinseLastTime = cipPreRinseLastTime;
    }

    public String getCipPreRinseTemperatureOut() {
	return cipPreRinseTemperatureOut;
    }

    public void setCipPreRinseTemperatureOut(String cipPreRinseTemperatureOut) {
	this.cipPreRinseTemperatureOut = cipPreRinseTemperatureOut;
    }

    public String getCipPreRinseFlowOut() {
	return cipPreRinseFlowOut;
    }

    public void setCipPreRinseFlowOut(String cipPreRinseFlowOut) {
	this.cipPreRinseFlowOut = cipPreRinseFlowOut;
    }

    public String getCipPreRinseTemperatureBack() {
	return cipPreRinseTemperatureBack;
    }

    public void setCipPreRinseTemperatureBack(String cipPreRinseTemperatureBack) {
	this.cipPreRinseTemperatureBack = cipPreRinseTemperatureBack;
    }

    public Date getCipLyeCycleStartDateTime() {
	return cipLyeCycleStartDateTime;
    }

    public void setCipLyeCycleStartDateTime(Date cipLyeCycleStartDateTime) {
	this.cipLyeCycleStartDateTime = cipLyeCycleStartDateTime;
    }

    public Date getCipLyeCycleEndDateTime() {
	return cipLyeCycleEndDateTime;
    }

    public void setCipLyeCycleEndDateTime(Date cipLyeCycleEndDateTime) {
	this.cipLyeCycleEndDateTime = cipLyeCycleEndDateTime;
    }

    public String getCipLyeCycleLastTime() {
	return cipLyeCycleLastTime;
    }

    public void setCipLyeCycleLastTime(String cipLyeCycleLastTime) {
	this.cipLyeCycleLastTime = cipLyeCycleLastTime;
    }

    public String getCipLyeCycleTemperatureOut() {
	return cipLyeCycleTemperatureOut;
    }

    public void setCipLyeCycleTemperatureOut(String cipLyeCycleTemperatureOut) {
	this.cipLyeCycleTemperatureOut = cipLyeCycleTemperatureOut;
    }

    public String getCipLyeCycleFlowOut() {
	return cipLyeCycleFlowOut;
    }

    public void setCipLyeCycleFlowOut(String cipLyeCycleFlowOut) {
	this.cipLyeCycleFlowOut = cipLyeCycleFlowOut;
    }

    public String getCipLyeCycleConductivityBack() {
	return cipLyeCycleConductivityBack;
    }

    public void setCipLyeCycleConductivityBack(String cipLyeCycleConductivityBack) {
	this.cipLyeCycleConductivityBack = cipLyeCycleConductivityBack;
    }

    public String getCipLyeCycleTemperatureBack() {
	return cipLyeCycleTemperatureBack;
    }

    public void setCipLyeCycleTemperatureBack(String cipLyeCycleTemperatureBack) {
	this.cipLyeCycleTemperatureBack = cipLyeCycleTemperatureBack;
    }

    public Date getCipInterRinseStartDateTime() {
	return cipInterRinseStartDateTime;
    }

    public void setCipInterRinseStartDateTime(Date cipInterRinseStartDateTime) {
	this.cipInterRinseStartDateTime = cipInterRinseStartDateTime;
    }

    public Date getCipInterRinseEndDateTime() {
	return cipInterRinseEndDateTime;
    }

    public void setCipInterRinseEndDateTime(Date cipInterRinseEndDateTime) {
	this.cipInterRinseEndDateTime = cipInterRinseEndDateTime;
    }

    public String getCipInterRinseLastTime() {
	return cipInterRinseLastTime;
    }

    public void setCipInterRinseLastTime(String cipInterRinseLastTime) {
	this.cipInterRinseLastTime = cipInterRinseLastTime;
    }

    public String getCipInterRinseTemperatureOut() {
	return cipInterRinseTemperatureOut;
    }

    public void setCipInterRinseTemperatureOut(String cipInterRinseTemperatureOut) {
	this.cipInterRinseTemperatureOut = cipInterRinseTemperatureOut;
    }

    public String getCipInterRinseFlowOut() {
	return cipInterRinseFlowOut;
    }

    public void setCipInterRinseFlowOut(String cipInterRinseFlowOut) {
	this.cipInterRinseFlowOut = cipInterRinseFlowOut;
    }

    public String getCipInterRinseTemperatureBack() {
	return cipInterRinseTemperatureBack;
    }

    public void setCipInterRinseTemperatureBack(String cipInterRinseTemperatureBack) {
	this.cipInterRinseTemperatureBack = cipInterRinseTemperatureBack;
    }

    public Date getCipAcidCycleStartDateTime() {
	return cipAcidCycleStartDateTime;
    }

    public void setCipAcidCycleStartDateTime(Date cipAcidCycleStartDateTime) {
	this.cipAcidCycleStartDateTime = cipAcidCycleStartDateTime;
    }

    public Date getCipAcidCycleEndDateTime() {
	return cipAcidCycleEndDateTime;
    }

    public void setCipAcidCycleEndDateTime(Date cipAcidCycleEndDateTime) {
	this.cipAcidCycleEndDateTime = cipAcidCycleEndDateTime;
    }

    public String getCipAcidCycleLastTime() {
	return cipAcidCycleLastTime;
    }

    public void setCipAcidCycleLastTime(String cipAcidCycleLastTime) {
	this.cipAcidCycleLastTime = cipAcidCycleLastTime;
    }

    public String getCipAcidCycleTemperatureOut() {
	return cipAcidCycleTemperatureOut;
    }

    public void setCipAcidCycleTemperatureOut(String cipAcidCycleTemperatureOut) {
	this.cipAcidCycleTemperatureOut = cipAcidCycleTemperatureOut;
    }

    public String getCipAcidCycleFlowOut() {
	return cipAcidCycleFlowOut;
    }

    public void setCipAcidCycleFlowOut(String cipAcidCycleFlowOut) {
	this.cipAcidCycleFlowOut = cipAcidCycleFlowOut;
    }

    public String getCipAcidCycleConductivityBack() {
	return cipAcidCycleConductivityBack;
    }

    public void setCipAcidCycleConductivityBack(String cipAcidCycleConductivityBack) {
	this.cipAcidCycleConductivityBack = cipAcidCycleConductivityBack;
    }

    public String getCipAcidCycleTemperatureBack() {
	return cipAcidCycleTemperatureBack;
    }

    public void setCipAcidCycleTemperatureBack(String cipAcidCycleTemperatureBack) {
	this.cipAcidCycleTemperatureBack = cipAcidCycleTemperatureBack;
    }

    public Date getCipFinalRinseStartDateTime() {
	return cipFinalRinseStartDateTime;
    }

    public void setCipFinalRinseStartDateTime(Date cipFinalRinseStartDateTime) {
	this.cipFinalRinseStartDateTime = cipFinalRinseStartDateTime;
    }

    public Date getCipFinalRinseEndDateTime() {
	return cipFinalRinseEndDateTime;
    }

    public void setCipFinalRinseEndDateTime(Date cipFinalRinseEndDateTime) {
	this.cipFinalRinseEndDateTime = cipFinalRinseEndDateTime;
    }

    public String getCipFinalRinseLastTime() {
	return cipFinalRinseLastTime;
    }

    public void setCipFinalRinseLastTime(String cipFinalRinseLastTime) {
	this.cipFinalRinseLastTime = cipFinalRinseLastTime;
    }

    public String getCipFinalRinseTemperatureOut() {
	return cipFinalRinseTemperatureOut;
    }

    public void setCipFinalRinseTemperatureOut(String cipFinalRinseTemperatureOut) {
	this.cipFinalRinseTemperatureOut = cipFinalRinseTemperatureOut;
    }

    public String getCipFinalRinseFlowOut() {
	return cipFinalRinseFlowOut;
    }

    public void setCipFinalRinseFlowOut(String cipFinalRinseFlowOut) {
	this.cipFinalRinseFlowOut = cipFinalRinseFlowOut;
    }

    public String getCipFinalRinseTemperatureBack() {
	return cipFinalRinseTemperatureBack;
    }

    public void setCipFinalRinseTemperatureBack(String cipFinalRinseTemperatureBack) {
	this.cipFinalRinseTemperatureBack = cipFinalRinseTemperatureBack;
    }

    public Date getCipSterStartDateTime() {
	return cipSterStartDateTime;
    }

    public void setCipSterStartDateTime(Date cipSterStartDateTime) {
	this.cipSterStartDateTime = cipSterStartDateTime;
    }

    public Date getCipSterEndDateTime() {
	return cipSterEndDateTime;
    }

    public void setCipSterEndDateTime(Date cipSterEndDateTime) {
	this.cipSterEndDateTime = cipSterEndDateTime;
    }

    public String getCipSterilizeLastTime() {
	return cipSterilizeLastTime;
    }

    public void setCipSterilizeLastTime(String cipSterilizeLastTime) {
	this.cipSterilizeLastTime = cipSterilizeLastTime;
    }

    public String getCipSterilizeTemperatureOut() {
	return cipSterilizeTemperatureOut;
    }

    public void setCipSterilizeTemperatureOut(String cipSterilizeTemperatureOut) {
	this.cipSterilizeTemperatureOut = cipSterilizeTemperatureOut;
    }

    public String getCipSterilizeFlowOut() {
	return cipSterilizeFlowOut;
    }

    public void setCipSterilizeFlowOut(String cipSterilizeFlowOut) {
	this.cipSterilizeFlowOut = cipSterilizeFlowOut;
    }

    public String getCipSterilizeTemperatureBack() {
	return cipSterilizeTemperatureBack;
    }

    public void setCipSterilizeTemperatureBack(String cipSterilizeTemperatureBack) {
	this.cipSterilizeTemperatureBack = cipSterilizeTemperatureBack;
    }

    public Long getCipOperatedByID() {
	return cipOperatedByID;
    }

    public void setCipOperatedByID(Long cipOperatedByID) {
	this.cipOperatedByID = cipOperatedByID;
    }

    public String getCipOperatedByName() {
	return cipOperatedByName;
    }

    public void setCipOperatedByName(String cipOperatedByName) {
	this.cipOperatedByName = cipOperatedByName;
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

    public String getTimeSinceLastOperation() {
	return timeSinceLastOperation;
    }

    public void setTimeSinceLastOperation(String timeSinceLastOperation) {
	this.timeSinceLastOperation = timeSinceLastOperation;
    }

}
