package com.tetrapak.domain.bpu;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bpu_report_step_result", schema = "dbo")
public class BPUReportStepResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "bpu_report_result_unique_id")
    private String bpuReportResultUniqueId;
    @Column(name = "step_start_date_time")
    private Date stepStartDateTime;
    @Column(name = "step_end_date_time")
    private Date stepEndDateTime;
    @Column(name = "step_last_time")
    private String stepLastTime;
    @Column(name = "step_n")
    private Integer stepN;
    @Column(name = "step_n_desc")
    private String stepNDesc;
    @Column(name = "step_phase_stat_n")
    private Integer stepPhaseStatN;
    @Column(name = "step_phase_stat_desc")
    private String stepPhaseStatDesc;
    @Column(name = "bpu_machine_id")
    private Integer bpuMachineId;
    @Column(name = "bpu_machine_name")
    private String bpuMachineName;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getBpuReportResultUniqueId() {
	return bpuReportResultUniqueId;
    }

    public void setBpuReportResultUniqueId(String bpuReportResultUniqueId) {
	this.bpuReportResultUniqueId = bpuReportResultUniqueId;
    }

    public Date getStepStartDateTime() {
	return stepStartDateTime;
    }

    public void setStepStartDateTime(Date stepStartDateTime) {
	this.stepStartDateTime = stepStartDateTime;
    }

    public Date getStepEndDateTime() {
	return stepEndDateTime;
    }

    public void setStepEndDateTime(Date stepEndDateTime) {
	this.stepEndDateTime = stepEndDateTime;
    }

    public String getStepLastTime() {
	return stepLastTime;
    }

    public void setStepLastTime(String stepLastTime) {
	this.stepLastTime = stepLastTime;
    }

    public Integer getStepN() {
	return stepN;
    }

    public void setStepN(Integer stepN) {
	this.stepN = stepN;
    }

    public String getStepNDesc() {
	return stepNDesc;
    }

    public void setStepNDesc(String stepNDesc) {
	this.stepNDesc = stepNDesc;
    }

    public Integer getStepPhaseStatN() {
	return stepPhaseStatN;
    }

    public void setStepPhaseStatN(Integer stepPhaseStatN) {
	this.stepPhaseStatN = stepPhaseStatN;
    }

    public String getStepPhaseStatDesc() {
	return stepPhaseStatDesc;
    }

    public void setStepPhaseStatDesc(String stepPhaseStatDesc) {
	this.stepPhaseStatDesc = stepPhaseStatDesc;
    }

    public Integer getBpuMachineId() {
	return bpuMachineId;
    }

    public void setBpuMachineId(Integer bpuMachineId) {
	this.bpuMachineId = bpuMachineId;
    }

    public String getBpuMachineName() {
	return bpuMachineName;
    }

    public void setBpuMachineName(String bpuMachineName) {
	this.bpuMachineName = bpuMachineName;
    }

}
