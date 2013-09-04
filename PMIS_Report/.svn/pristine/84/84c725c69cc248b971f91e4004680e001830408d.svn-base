package com.tetrapak.action.systemsettings.bpu;

import org.apache.struts2.ServletActionContext;

import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.util.bpu.BPUAlarmMsgUtil;

public class BPUAlarmMsgSettingAction extends AbstractBPUSettingAction {

    private static final long serialVersionUID = 1L;
    private Integer alarmMsgId;
    private Integer bpuMachineId;
    private Integer alarmTagId;
    private Integer alarmMsgBit;
    private String alarmMsgInfo;

    public Integer getAlarmMsgId() {
	return alarmMsgId;
    }

    public void setAlarmMsgId(Integer alarmMsgId) {
	this.alarmMsgId = alarmMsgId;
    }

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

    public Integer getAlarmMsgBit() {
	return alarmMsgBit;
    }

    public void setAlarmMsgBit(Integer alarmMsgBit) {
	this.alarmMsgBit = alarmMsgBit;
    }

    public String getAlarmMsgInfo() {
	return alarmMsgInfo;
    }

    public void setAlarmMsgInfo(String alarmMsgInfo) {
	this.alarmMsgInfo = alarmMsgInfo;
    }

    @Override
    public String add() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = BPUAlarmMsgUtil.addAlarmMsg(alarmTagId, alarmMsgBit, alarmMsgInfo);
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
	    boolean sr = BPUAlarmMsgUtil.editAlarmMsg(alarmMsgId, alarmTagId, alarmMsgBit, alarmMsgInfo);
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
	    boolean sr = BPUAlarmMsgUtil.deleteAlarmMsg(alarmMsgId);
	    if (sr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

}
