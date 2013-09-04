package com.tetrapak.domain.bpu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bpu_analog_tag", schema = "dbo")
public class BPUAnalogTag implements Serializable, Comparable<BPUAnalogTag> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "analog_tag_name")
    private String analogTagName;
    @Column(name = "analog_insql_tag_name")
    private String analogInsqlTagName;
    @Column(name = "analog_tag_desc")
    private String analogTagDesc;
    @Column(name = "analog_tag_unit")
    private String analogTagUnit;
    @Column(name = "analog_tag_value_divided_by")
    private Double analogTagValueDividedBy;
    @Column(name = "analog_tag_value_type")
    private String analogTagValueType;
    @Column(name = "analog_standard_min_value")
    private Double analogStandardMinValue;
    @Column(name = "analog_standard_max_value")
    private Double analogStandardMaxValue;
    @ManyToOne
    @JoinColumn(name = "bpu_machine", referencedColumnName = "id")
    private BPUMachine bpuMachine;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getAnalogTagName() {
	return analogTagName;
    }

    public void setAnalogTagName(String analogTagName) {
	this.analogTagName = analogTagName;
    }

    public String getAnalogInsqlTagName() {
	return analogInsqlTagName;
    }

    public void setAnalogInsqlTagName(String analogInsqlTagName) {
	this.analogInsqlTagName = analogInsqlTagName;
    }

    public String getAnalogTagDesc() {
	return analogTagDesc;
    }

    public void setAnalogTagDesc(String analogTagDesc) {
	this.analogTagDesc = analogTagDesc;
    }

    public String getAnalogTagUnit() {
	return analogTagUnit;
    }

    public void setAnalogTagUnit(String analogTagUnit) {
	this.analogTagUnit = analogTagUnit;
    }

    public Double getAnalogTagValueDividedBy() {
	return analogTagValueDividedBy;
    }

    public void setAnalogTagValueDividedBy(Double analogTagValueDividedBy) {
	this.analogTagValueDividedBy = analogTagValueDividedBy;
    }

    public BPUMachine getBpuMachine() {
	return bpuMachine;
    }

    public void setBpuMachine(BPUMachine bpuMachine) {
	this.bpuMachine = bpuMachine;
    }

    public String getAnalogTagValueType() {
	return analogTagValueType;
    }

    public void setAnalogTagValueType(String analogTagValueType) {
	this.analogTagValueType = analogTagValueType;
    }

    public Double getAnalogStandardMinValue() {
	return analogStandardMinValue;
    }

    public void setAnalogStandardMinValue(Double analogStandardMinValue) {
	this.analogStandardMinValue = analogStandardMinValue;
    }

    public Double getAnalogStandardMaxValue() {
	return analogStandardMaxValue;
    }

    public void setAnalogStandardMaxValue(Double analogStandardMaxValue) {
	this.analogStandardMaxValue = analogStandardMaxValue;
    }

    @Override
    public int compareTo(BPUAnalogTag tag) {
	return this.analogTagName.compareTo(tag.getAnalogTagName());
    }

}
