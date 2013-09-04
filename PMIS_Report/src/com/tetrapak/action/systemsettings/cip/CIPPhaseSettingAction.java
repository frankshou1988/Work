package com.tetrapak.action.systemsettings.cip;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.model.systemsettings.cip.CIPPhaseSettingActionModel;

public class CIPPhaseSettingAction extends ActionSupport implements Action {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String cipPhaseName;
    private Long cipPhaseID;
    private Integer cipPhaseSlaveLineId;
    private Integer cipPhaseTargetId;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getCipPhaseName() {
	return cipPhaseName;
    }

    public void setCipPhaseName(String cipPhaseName) {
	this.cipPhaseName = cipPhaseName;
    }

    public Long getCipPhaseID() {
	return cipPhaseID;
    }

    public void setCipPhaseID(Long cipPhaseID) {
	this.cipPhaseID = cipPhaseID;
    }

    public Integer getCipPhaseSlaveLineId() {
	return cipPhaseSlaveLineId;
    }

    public void setCipPhaseSlaveLineId(Integer cipPhaseSlaveLineId) {
	this.cipPhaseSlaveLineId = cipPhaseSlaveLineId;
    }

    public Integer getCipPhaseTargetId() {
	return cipPhaseTargetId;
    }

    public void setCipPhaseTargetId(Integer cipPhaseTargetId) {
	this.cipPhaseTargetId = cipPhaseTargetId;
    }

    public String save() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = CIPPhaseSettingActionModel.saveCIPPhase(id, cipPhaseName, cipPhaseID, cipPhaseSlaveLineId,
		    cipPhaseTargetId);
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
	    boolean dr = CIPPhaseSettingActionModel.deleteCIPPhase(id);
	    if (dr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

}
