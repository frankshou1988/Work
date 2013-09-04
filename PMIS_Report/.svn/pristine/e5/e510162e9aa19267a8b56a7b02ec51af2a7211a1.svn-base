package com.tetrapak.domain.bpu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bpu_step_number", schema = "dbo")
public class BPUStepN implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "bpu_step_n")
    private Integer bpuStepN;
    @Column(name = "bpu_step_n_desc")
    private String bpuStepNDesc;
    @Column(name = "machine_type")
    private String machineType;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getBpuStepN() {
	return bpuStepN;
    }

    public void setBpuStepN(Integer bpuStepN) {
	this.bpuStepN = bpuStepN;
    }

    public String getBpuStepNDesc() {
	return bpuStepNDesc;
    }

    public void setBpuStepNDesc(String bpuStepNDesc) {
	this.bpuStepNDesc = bpuStepNDesc;
    }

    public String getMachineType() {
	return machineType;
    }

    public void setMachineType(String machineType) {
	this.machineType = machineType;
    }

}
