package com.tetrapak.action.systemsettings.cip;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.model.systemsettings.cip.CIPLineSettingModel;

/**
 * CIP Master Line Management Action
 * */
public class CIPMasterLineSettingAction extends ActionSupport implements Action {
    private static final long serialVersionUID = 1L;
    private Integer masterLineId;
    private String masterLineName;
    private String masterLineDesc;
    private String plcStructureType;
    private String workshopType;

    @Override
    public String execute() throws Exception {
	throw new HttpMethodNotSupportedForActionException();
    }

    public Integer getMasterLineId() {
	return masterLineId;
    }

    public void setMasterLineId(Integer masterLineId) {
	this.masterLineId = masterLineId;
    }

    public String getMasterLineName() {
	return masterLineName;
    }

    public void setMasterLineName(String masterLineName) {
	this.masterLineName = masterLineName;
    }

    public String getMasterLineDesc() {
	return masterLineDesc;
    }

    public void setMasterLineDesc(String masterLineDesc) {
	this.masterLineDesc = masterLineDesc;
    }

    public String getPlcStructureType() {
	return plcStructureType;
    }

    public void setPlcStructureType(String plcStructureType) {
	this.plcStructureType = plcStructureType;
    }

    public String getWorkshopType() {
	return workshopType;
    }

    public void setWorkshopType(String workshopType) {
	this.workshopType = workshopType;
    }

    public String add() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = CIPLineSettingModel.addCIPMasterLine(masterLineName, masterLineDesc, plcStructureType,
		    workshopType);
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
	    boolean sr = CIPLineSettingModel.editCIPMasterLine(masterLineId, masterLineName, masterLineDesc,
		    plcStructureType, workshopType);
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
	    boolean dr = CIPLineSettingModel.deleteCIPMasterLine(masterLineId);
	    if (dr) {
		result = SUCCESS;
	    }
	}
	return result;
    }
}
