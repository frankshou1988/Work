package com.tetrapak.action.systemsettings.bpu;

import org.apache.struts2.ServletActionContext;

import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.util.bpu.BPUAnalogTagUtil;

public class BPUAnalogTagSettingAction extends AbstractBPUSettingAction {

    private static final long serialVersionUID = 1L;
    private Integer bpuMachineId;
    private Integer analogTagId;
    private String analogTagName;
    /**
     * This name must be unique, check it.
     * */
    private String analogInsqlTagName;
    private String analogTagDesc;
    private String analogTagUnit;
    private String analogTagValueType;
    private Double analogTagValueDividedBy;
    private String analogStandardMinValue;
    private String analogStandardMaxValue;

    public Integer getBpuMachineId() {
	return bpuMachineId;
    }

    public void setBpuMachineId(Integer bpuMachineId) {
	this.bpuMachineId = bpuMachineId;
    }

    public Integer getAnalogTagId() {
	return analogTagId;
    }

    public void setAnalogTagId(Integer analogTagId) {
	this.analogTagId = analogTagId;
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

    public String getAnalogTagValueType() {
	return analogTagValueType;
    }

    public void setAnalogTagValueType(String analogTagValueType) {
	this.analogTagValueType = analogTagValueType;
    }

    public Double getAnalogTagValueDividedBy() {
	return analogTagValueDividedBy;
    }

    public void setAnalogTagValueDividedBy(Double analogTagValueDividedBy) {
	this.analogTagValueDividedBy = analogTagValueDividedBy;
    }

    public String getAnalogStandardMinValue() {
	return analogStandardMinValue;
    }

    public void setAnalogStandardMinValue(String analogStandardMinValue) {
	this.analogStandardMinValue = analogStandardMinValue;
    }

    public String getAnalogStandardMaxValue() {
	return analogStandardMaxValue;
    }

    public void setAnalogStandardMaxValue(String analogStandardMaxValue) {
	this.analogStandardMaxValue = analogStandardMaxValue;
    }

    @Override
    public String add() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = BPUAnalogTagUtil.addAnalogTag(bpuMachineId, analogTagName, analogInsqlTagName, analogTagDesc,
		    analogTagUnit, analogTagValueType, analogTagValueDividedBy);
	    if (sr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

    @Override
    public String edit() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = BPUAnalogTagUtil.editAnalogTag(bpuMachineId, analogTagId, analogTagName, analogInsqlTagName,
		    analogTagDesc, analogTagUnit, analogTagValueType, analogTagValueDividedBy);
	    if (sr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

    @Override
    public String delete() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = BPUAnalogTagUtil.deleteAnalogTag(analogTagId);
	    if (sr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

}
