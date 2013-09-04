package com.tetrapak.action.systemsettings.cip;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.model.systemsettings.cip.CIPResultSettingActionModel;

public class CIPResultSettingAction extends ActionSupport implements Action {
    private static final long serialVersionUID = 3868965939182601514L;

    private Integer cipResultId;
    private Long cipResultPLCIdValue;
    private String cipResultDesc;
    private String plcStructureType;

    public Integer getCipResultId() {
	return cipResultId;
    }

    public void setCipResultId(Integer cipResultId) {
	this.cipResultId = cipResultId;
    }

    public Long getCipResultPLCIdValue() {
	return cipResultPLCIdValue;
    }

    public void setCipResultPLCIdValue(Long cipResultPLCIdValue) {
	this.cipResultPLCIdValue = cipResultPLCIdValue;
    }

    public String getCipResultDesc() {
	return cipResultDesc;
    }

    public void setCipResultDesc(String cipResultDesc) {
	this.cipResultDesc = cipResultDesc;
    }

    public String getPlcStructureType() {
	return plcStructureType;
    }

    public void setPlcStructureType(String plcStructureType) {
	this.plcStructureType = plcStructureType;
    }

    public String save() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = CIPResultSettingActionModel.save(cipResultPLCIdValue, cipResultDesc, plcStructureType);
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
	    boolean dr = CIPResultSettingActionModel.delete(cipResultId);
	    if (dr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

}
