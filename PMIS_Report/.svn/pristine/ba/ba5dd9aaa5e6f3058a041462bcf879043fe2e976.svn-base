package com.tetrapak.action.systemsettings.bpu;

import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.bpu.BPUAlarmMsg;
import com.tetrapak.domain.bpu.BPUAlarmTag;
import com.tetrapak.domain.bpu.BPUAnalogTag;
import com.tetrapak.domain.bpu.BPUMachine;

public class BPUSettingPageAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Integer analogTagId;
    private BPUAnalogTag selectedAnalogTag;
    private Integer bpuMachineId;
    private BPUMachine selectedBPUMachine;
    private Integer alarmTagId;
    private BPUAlarmTag selectedAlarmTag;
    private Integer alarmMsgId;
    private BPUAlarmMsg selectedAlarmMsg;

    public Integer getAnalogTagId() {
	return analogTagId;
    }

    public void setAnalogTagId(Integer analogTagId) {
	this.analogTagId = analogTagId;
    }

    public BPUAnalogTag getSelectedAnalogTag() {
	return selectedAnalogTag;
    }

    public void setSelectedAnalogTag(BPUAnalogTag selectedAnalogTag) {
	this.selectedAnalogTag = selectedAnalogTag;
    }

    public Integer getBpuMachineId() {
	return bpuMachineId;
    }

    public void setBpuMachineId(Integer bpuMachineId) {
	this.bpuMachineId = bpuMachineId;
    }

    public BPUMachine getSelectedBPUMachine() {
	return selectedBPUMachine;
    }

    public void setSelectedBPUMachine(BPUMachine selectedBPUMachine) {
	this.selectedBPUMachine = selectedBPUMachine;
    }

    public Integer getAlarmTagId() {
	return alarmTagId;
    }

    public void setAlarmTagId(Integer alarmTagId) {
	this.alarmTagId = alarmTagId;
    }

    public BPUAlarmTag getSelectedAlarmTag() {
	return selectedAlarmTag;
    }

    public void setSelectedAlarmTag(BPUAlarmTag selectedAlarmTag) {
	this.selectedAlarmTag = selectedAlarmTag;
    }

    public Integer getAlarmMsgId() {
	return alarmMsgId;
    }

    public void setAlarmMsgId(Integer alarmMsgId) {
	this.alarmMsgId = alarmMsgId;
    }

    public BPUAlarmMsg getSelectedAlarmMsg() {
	return selectedAlarmMsg;
    }

    public void setSelectedAlarmMsg(BPUAlarmMsg selectedAlarmMsg) {
	this.selectedAlarmMsg = selectedAlarmMsg;
    }

    /**
     * BPU Setting Page
     * 
     * @throws Exception
     * */

    public String bpuSettingPage() throws Exception {
	return SUCCESS;
    }

    public String bpuMachineSettingPage() throws Exception {
	if (bpuMachineId != null) {
	    selectedBPUMachine = (BPUMachine) CommonDao.getObjById(BPUMachine.class, bpuMachineId);
	}
	return SUCCESS;
    }

    public String bpuAnalogTagSettingPage() throws Exception {
	if (analogTagId != null) {
	    selectedAnalogTag = (BPUAnalogTag) CommonDao.getObjById(BPUAnalogTag.class, analogTagId);
	}
	return SUCCESS;
    }

    public String bpuAlarmTagSettingPage() throws Exception {
	if (alarmTagId != null) {
	    selectedAlarmTag = (BPUAlarmTag) CommonDao.getObjById(BPUAlarmTag.class, alarmTagId);
	}
	return SUCCESS;
    }

    public String bpuAlarmMsgSettingPage() throws Exception {
	if (alarmMsgId != null) {
	    selectedAlarmMsg = (BPUAlarmMsg) CommonDao.getObjById(BPUAlarmMsg.class, alarmMsgId);
	}
	return SUCCESS;
    }
}
