package com.tetrapak.action.bpu;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.domain.bpu.BPUAlarmTag;
import com.tetrapak.domain.bpu.BPUAnalogTag;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.util.bpu.BPUAlarmTagUtil;
import com.tetrapak.util.bpu.BPUAnalogTagUtil;

public class BPUJSONAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Integer bpuMachineId;
    private List<BPUAlarmTag> bpuAlarmTagList;
    private List<BPUAnalogTag> bpuAnalogTagList;

    @JSON(serialize = false)
    public Integer getBpuMachineId() {
	return bpuMachineId;
    }

    public void setBpuMachineId(Integer bpuMachineId) {
	this.bpuMachineId = bpuMachineId;
    }

    @JSON(name = "bpuAlarmTagList")
    public List<BPUAlarmTag> getBpuAlarmTagList() {
	return bpuAlarmTagList;
    }

    @JSON(name = "bpuAnalogTagList")
    public List<BPUAnalogTag> getBpuAnalogTagList() {
	return bpuAnalogTagList;
    }

    public void setBpuAnalogTagList(List<BPUAnalogTag> bpuAnalogTagList) {
	this.bpuAnalogTagList = bpuAnalogTagList;
    }

    public void setBpuAlarmTagList(List<BPUAlarmTag> bpuAlarmTagList) {
	this.bpuAlarmTagList = bpuAlarmTagList;
    }

    public String getBPUAlarmTagListOfBPUMachine() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    setBpuAlarmTagList(BPUAlarmTagUtil.getBPUAlarmTagListOfBPUMachine(bpuMachineId));
	    result = SUCCESS;
	}
	return result;
    }

    public String getBPUAnalogListOfBPUMachine() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    setBpuAnalogTagList(BPUAnalogTagUtil.getBPUAnalogTagListOfBPUMachine(bpuMachineId));
	    result = SUCCESS;
	}
	return result;
    }
}
