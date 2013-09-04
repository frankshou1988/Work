package com.tetrapak.domain.bpu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bpu_phase_stat", schema = "dbo")
public class BPUPhaseStat implements Serializable, Comparable<BPUPhaseStat> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "bpu_phase_stat_n")
    private Integer bpuPhaseStatN;
    @Column(name = "bpu_phase_stat_n_desc")
    private String bpuPhaseStatNDesc;
    @Column(name = "machine_type")
    private String machineType;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getBpuPhaseStatN() {
	return bpuPhaseStatN;
    }

    public void setBpuPhaseStatN(Integer bpuPhaseStatN) {
	this.bpuPhaseStatN = bpuPhaseStatN;
    }

    public String getBpuPhaseStatNDesc() {
	return bpuPhaseStatNDesc;
    }

    public void setBpuPhaseStatNDesc(String bpuPhaseStatNDesc) {
	this.bpuPhaseStatNDesc = bpuPhaseStatNDesc;
    }

    public String getMachineType() {
	return machineType;
    }

    public void setMachineType(String machineType) {
	this.machineType = machineType;
    }

    @Override
    public int compareTo(BPUPhaseStat o) {
	return this.getBpuPhaseStatN().compareTo(o.getBpuPhaseStatN());
    }

}
