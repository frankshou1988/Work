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
@Table(name = "bpu_report_result", schema = "dbo")
public class BPUReportResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "bpu_report_result_unique_id")
    private String bpuReportResultUniqueId;
    @Column(name = "bpu_machine_id")
    private Integer bpuMachineId;
    @Column(name = "bpu_machine_name")
    private String bpuMachineName;
    @Column(name = "bpu_machine_desc")
    private String bpuMachineDesc;
    @Column(name = "bpu_machine_serial_number")
    private String bpuMachineSerialNumber;
    @Column(name = "bpu_prod_start_date_time")
    private Date bpuProdStartDateTime;
    @Column(name = "bpu_prod_end_date_time")
    private Date bpuProdEndDateTime;
    @Column(name = "bpu_prod_last_time")
    private String bpuProdLastTime;

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

    public Date getBpuProdStartDateTime() {
	return bpuProdStartDateTime;
    }

    public void setBpuProdStartDateTime(Date bpuProdStartDateTime) {
	this.bpuProdStartDateTime = bpuProdStartDateTime;
    }

    public Date getBpuProdEndDateTime() {
	return bpuProdEndDateTime;
    }

    public void setBpuProdEndDateTime(Date bpuProdEndDateTime) {
	this.bpuProdEndDateTime = bpuProdEndDateTime;
    }

    public String getBpuProdLastTime() {
	return bpuProdLastTime;
    }

    public void setBpuProdLastTime(String bpuProdLastTime) {
	this.bpuProdLastTime = bpuProdLastTime;
    }

}
