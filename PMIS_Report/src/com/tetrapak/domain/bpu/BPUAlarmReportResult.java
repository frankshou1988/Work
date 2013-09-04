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
@Table(name = "bpu_alarm_report_result", schema = "dbo")
public class BPUAlarmReportResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "bpu_machine_id")
    private Integer bpuMachineId;
    @Column(name = "bpu_machine_name")
    private String bpuMachineName;
    @Column(name = "bpu_machine_desc")
    private String bpuMachineDesc;
    @Column(name = "bpu_machine_serial_number")
    private String bpuMachineSerialNumber;
    @Column(name = "alarm_tag_id")
    private Integer alarmTagId;
    @Column(name = "alarm_bit")
    private Integer alarmBit;
    @Column(name = "alarm_msg")
    private String alarmMsg;
    @Column(name = "alarm_start_date_time")
    private Date alarmStartDateTime;
    @Column(name = "alarm_end_date_time")
    private Date alarmEndDateTime;
    @Column(name = "alarm_last_time")
    private String alarmLastTime;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
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

    public String getBpuMachineDesc() {
	return bpuMachineDesc;
    }

    public void setBpuMachineDesc(String bpuMachineDesc) {
	this.bpuMachineDesc = bpuMachineDesc;
    }

    public String getBpuMachineSerialNumber() {
	return bpuMachineSerialNumber;
    }

    public void setBpuMachineSerialNumber(String bpuMachineSerialNumber) {
	this.bpuMachineSerialNumber = bpuMachineSerialNumber;
    }

    public Integer getAlarmTagId() {
	return alarmTagId;
    }

    public void setAlarmTagId(Integer alarmTagId) {
	this.alarmTagId = alarmTagId;
    }

    public Integer getAlarmBit() {
	return alarmBit;
    }

    public void setAlarmBit(Integer alarmBit) {
	this.alarmBit = alarmBit;
    }

    public String getAlarmMsg() {
	return alarmMsg;
    }

    public void setAlarmMsg(String alarmMsg) {
	this.alarmMsg = alarmMsg;
    }

    public Date getAlarmStartDateTime() {
	return alarmStartDateTime;
    }

    public void setAlarmStartDateTime(Date alarmStartDateTime) {
	this.alarmStartDateTime = alarmStartDateTime;
    }

    public Date getAlarmEndDateTime() {
	return alarmEndDateTime;
    }

    public void setAlarmEndDateTime(Date alarmEndDateTime) {
	this.alarmEndDateTime = alarmEndDateTime;
    }

    public String getAlarmLastTime() {
	return alarmLastTime;
    }

    public void setAlarmLastTime(String alarmLastTime) {
	this.alarmLastTime = alarmLastTime;
    }

}
