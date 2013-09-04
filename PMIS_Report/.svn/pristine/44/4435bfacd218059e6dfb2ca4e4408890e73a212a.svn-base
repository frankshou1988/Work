package com.tetrapak.action.systemsettings.cip;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.model.systemsettings.cip.CIPLineSettingModel;

/**
 * CIP Slave Line Management Action
 * */
public class CIPSlaveLineSettingAction extends ActionSupport implements Action {

    private static final long serialVersionUID = 1L;
    private Integer slaveLineId;
    private String slaveLineName;
    private String slaveLineDesc;
    private Integer masterLineId;

    @Override
    public String execute() throws Exception {
	throw new HttpMethodNotSupportedForActionException();
    }

    public Integer getSlaveLineId() {
	return slaveLineId;
    }

    public void setSlaveLineId(Integer slaveLineId) {
	this.slaveLineId = slaveLineId;
    }

    public String getSlaveLineName() {
	return slaveLineName;
    }

    public void setSlaveLineName(String slaveLineName) {
	this.slaveLineName = slaveLineName;
    }

    public String getSlaveLineDesc() {
	return slaveLineDesc;
    }

    public void setSlaveLineDesc(String slaveLineDesc) {
	this.slaveLineDesc = slaveLineDesc;
    }

    public Integer getMasterLineId() {
	return masterLineId;
    }

    public void setMasterLineId(Integer masterLineId) {
	this.masterLineId = masterLineId;
    }

    public String add() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = CIPLineSettingModel.addCIPSlaveLine(slaveLineName, slaveLineDesc, masterLineId);
	    if (sr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

    public String edit() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = CIPLineSettingModel.editCIPSlaveLine(slaveLineId, slaveLineName, slaveLineDesc, masterLineId);
	    if (sr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

    public String delete() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean dr = CIPLineSettingModel.deleteCIPSlaveLine(slaveLineId);
	    if (dr) {
		result = SUCCESS;
	    }
	}
	return result;
    }
}
