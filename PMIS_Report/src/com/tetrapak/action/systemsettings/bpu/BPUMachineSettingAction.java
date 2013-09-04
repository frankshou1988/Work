package com.tetrapak.action.systemsettings.bpu;

import org.apache.struts2.ServletActionContext;

import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.util.bpu.BPUMachineUtil;

public class BPUMachineSettingAction extends AbstractBPUSettingAction {
    private static final long serialVersionUID = 1L;
    private Integer bpuMachineId;
    private String bpuMachineName;
    private String bpuMachineDesc;
    private String bpuMachineSerialNumber;
    private String bpuMachineType;
    private String stepNumberInSQLTag;
    private String phaseStatusInSQLTag;

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

    public String getBpuMachineType() {
	return bpuMachineType;
    }

    public void setBpuMachineType(String bpuMachineType) {
	this.bpuMachineType = bpuMachineType;
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

    @Override
    public String add() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = BPUMachineUtil.addBPUMachine(bpuMachineName, bpuMachineDesc, bpuMachineSerialNumber,
		    bpuMachineType);
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
	    boolean sr = BPUMachineUtil.editBPUMachine(bpuMachineId, bpuMachineName, bpuMachineDesc,
		    bpuMachineSerialNumber, bpuMachineType);
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
	    boolean sr = BPUMachineUtil.deleteBPUMachine(bpuMachineId);
	    if (sr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

    public String saveBPUMachineTag() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = BPUMachineUtil.saveBPUMachineTag(bpuMachineId, stepNumberInSQLTag, phaseStatusInSQLTag);
	    if (sr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

}
