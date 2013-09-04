package com.tetrapak.action.systemsettings.cip;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.model.systemsettings.cip.CIPTargetSettingModel;

public class CIPTargetGroupSettingAction extends ActionSupport implements Action {
    private static final long serialVersionUID = -4851069365124738063L;
    private Integer cipTargetGroupId;
    private String cipTargetGroupName;
    private String cipTargetGroupDesc;
    private String workshopType;

    public Integer getCipTargetGroupId() {
	return cipTargetGroupId;
    }

    public void setCipTargetGroupId(Integer cipTargetGroupId) {
	this.cipTargetGroupId = cipTargetGroupId;
    }

    public String getCipTargetGroupName() {
	return cipTargetGroupName;
    }

    public void setCipTargetGroupName(String cipTargetGroupName) {
	this.cipTargetGroupName = cipTargetGroupName;
    }

    public String getCipTargetGroupDesc() {
	return cipTargetGroupDesc;
    }

    public void setCipTargetGroupDesc(String cipTargetGroupDesc) {
	this.cipTargetGroupDesc = cipTargetGroupDesc;
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
	    boolean sr = CIPTargetSettingModel.addCIPTargetGroup(cipTargetGroupName, cipTargetGroupDesc, workshopType);
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
	    boolean sr = CIPTargetSettingModel.editCIPTargetGroup(cipTargetGroupId, cipTargetGroupName,
		    cipTargetGroupDesc, workshopType);
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
	    boolean dr = CIPTargetSettingModel.deleteCIPTargetGroup(cipTargetGroupId);
	    if (dr) {
		result = SUCCESS;
	    }
	}
	return result;
    }
}
