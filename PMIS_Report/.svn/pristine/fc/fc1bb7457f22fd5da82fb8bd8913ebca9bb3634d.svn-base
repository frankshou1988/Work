package com.tetrapak.action.systemsettings.bpu;

import org.apache.struts2.ServletActionContext;

import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.util.bpu.BPUAlarmTagUtil;

public class BPUAlarmTagSettingAction extends AbstractBPUSettingAction {

    private static final long serialVersionUID = 1L;
    private Integer bpuMachineId;
    private Integer alarmTagId;
    private String alarmTagName;
    /**
     * This name must be unique, check it.
     * */
    private String alarmInsqlTagName;
    private String alarmTagDesc;

    public Integer getBpuMachineId() {
	return bpuMachineId;
    }

    public void setBpuMachineId(Integer bpuMachineId) {
	this.bpuMachineId = bpuMachineId;
    }

    public Integer getAlarmTagId() {
	return alarmTagId;
    }

    public void setAlarmTagId(Integer alarmTagId) {
	this.alarmTagId = alarmTagId;
    }

    public String getAlarmTagName() {
	return alarmTagName;
    }

    public void setAlarmTagName(String alarmTagName) {
	this.alarmTagName = alarmTagName;
    }

    public String getAlarmInsqlTagName() {
	return alarmInsqlTagName;
    }

    public void setAlarmInsqlTagName(String alarmInsqlTagName) {
	this.alarmInsqlTagName = alarmInsqlTagName;
    }

    public String getAlarmTagDesc() {
	return alarmTagDesc;
    }

    public void setAlarmTagDesc(String alarmTagDesc) {
	this.alarmTagDesc = alarmTagDesc;
    }

    @Override
    public String add() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = BPUAlarmTagUtil.addAlarmTag(bpuMachineId, alarmTagName, alarmInsqlTagName, alarmTagDesc);
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
	    boolean sr = BPUAlarmTagUtil.editAlarmTag(bpuMachineId, alarmTagId, alarmTagName, alarmInsqlTagName,
		    alarmTagDesc);
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
	    boolean sr = BPUAlarmTagUtil.deleteAlarmTag(alarmTagId);
	    if (sr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

}
