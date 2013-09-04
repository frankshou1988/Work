package com.tetrapak.domain.bpu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bpu_machine", schema = "dbo")
public class BPUMachine implements Serializable, Comparable<BPUMachine> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "machine_name")
    private String machineName;
    @Column(name = "machine_desc")
    private String machineDesc;
    @Column(name = "machine_serial_number")
    private String machineSerialNumber;
    @Column(name = "step_number_insql_tag")
    private String stepNumberInSQLTag;
    @Column(name = "phase_status_insql_tag")
    private String phaseStatusInSQLTag;
    @Column(name = "machine_type")
    private String machineType;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getMachineName() {
	return machineName;
    }

    public void setMachineName(String machineName) {
	this.machineName = machineName;
    }

    public String getMachineDesc() {
	return machineDesc;
    }

    public void setMachineDesc(String machineDesc) {
	this.machineDesc = machineDesc;
    }

    public String getMachineSerialNumber() {
	return machineSerialNumber;
    }

    public void setMachineSerialNumber(String machineSerialNumber) {
	this.machineSerialNumber = machineSerialNumber;
    }

    public String getStepNumberInSQLTag() {
	return stepNumberInSQLTag;
    }

    public void setStepNumberInSQLTag(String stepNumberInSQLTag) {
	this.stepNumberInSQLTag = stepNumberInSQLTag;
    }

    public String getPhaseStatusInSQLTag() {
	return phaseStatusInSQLTag;
    }

    public void setPhaseStatusInSQLTag(String phaseStatusInSQLTag) {
	this.phaseStatusInSQLTag = phaseStatusInSQLTag;
    }

    public String getMachineType() {
	return machineType;
    }

    public void setMachineType(String machineType) {
	this.machineType = machineType;
    }

    @Override
    public int compareTo(BPUMachine o) {
	return this.getMachineName().compareTo(o.getMachineName());
    }

}
