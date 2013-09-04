package com.tetrapak.action.systemsettings.cip;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.model.systemsettings.cip.CIPTargetSettingModel;

public class CIPTargetSettingAction extends ActionSupport implements Action {
    private static final long serialVersionUID = 2919180935341846317L;
    private Integer cipTargetId;
    private String cipTargetName;
    private String cipTargetDesc;
    private Integer cipTargetGroupId;

    public Integer getCipTargetId() {
	return cipTargetId;
    }

    public void setCipTargetId(Integer cipTargetId) {
	this.cipTargetId = cipTargetId;
    }

    public String getCipTargetName() {
	return cipTargetName;
    }

    public void setCipTargetName(String cipTargetName) {
	this.cipTargetName = cipTargetName;
    }

    public String getCipTargetDesc() {
	return cipTargetDesc;
    }

    public void setCipTargetDesc(String cipTargetDesc) {
	this.cipTargetDesc = cipTargetDesc;
    }

    public Integer getCipTargetGroupId() {
	return cipTargetGroupId;
    }

    public void setCipTargetGroupId(Integer cipTargetGroupId) {
	this.cipTargetGroupId = cipTargetGroupId;
    }

    public String add() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = CIPTargetSettingModel.addCIPTarget(cipTargetName, cipTargetDesc, cipTargetGroupId);
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
	    boolean sr = CIPTargetSettingModel.editCIPTarget(cipTargetId, cipTargetName, cipTargetDesc,
		    cipTargetGroupId);
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
	    boolean dr = CIPTargetSettingModel.deleteCIPTarget(cipTargetId);
	    if (dr) {
		result = SUCCESS;
	    }
	}
	return result;
    }
}
