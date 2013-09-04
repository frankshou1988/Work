package com.tetrapak.action.systemsettings.cip;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.model.systemsettings.cip.CIPTrendTagSettingModel;

public class CIPTrendTagSettingAction extends ActionSupport implements Action {

    private static final long serialVersionUID = 8271378884055294079L;
    private String cipTrendTagName;
    private String cipTrendTagDesc;
    private String cipTrendTagUnit;
    private Boolean cipTrendTagType;
    private Integer cipTrendTagMasterLineId;
    private Integer cipTrendTagId;
    private Integer cipTrendTagValueDividedBy;

    public String getCipTrendTagName() {
	return cipTrendTagName;
    }

    public void setCipTrendTagName(String cipTrendTagName) {
	this.cipTrendTagName = cipTrendTagName;
    }

    public String getCipTrendTagDesc() {
	return cipTrendTagDesc;
    }

    public void setCipTrendTagDesc(String cipTrendTagDesc) {
	this.cipTrendTagDesc = cipTrendTagDesc;
    }

    public String getCipTrendTagUnit() {
	return cipTrendTagUnit;
    }

    public void setCipTrendTagUnit(String cipTrendTagUnit) {
	this.cipTrendTagUnit = cipTrendTagUnit;
    }

    public Boolean getCipTrendTagType() {
	return cipTrendTagType;
    }

    public void setCipTrendTagType(Boolean cipTrendTagType) {
	this.cipTrendTagType = cipTrendTagType;
    }

    public Integer getCipTrendTagMasterLineId() {
	return cipTrendTagMasterLineId;
    }

    public void setCipTrendTagMasterLineId(Integer cipTrendTagMasterLineId) {
	this.cipTrendTagMasterLineId = cipTrendTagMasterLineId;
    }

    public Integer getCipTrendTagId() {
	return cipTrendTagId;
    }

    public void setCipTrendTagId(Integer cipTrendTagId) {
	this.cipTrendTagId = cipTrendTagId;
    }

    public Integer getCipTrendTagValueDividedBy() {
	return cipTrendTagValueDividedBy;
    }

    public void setCipTrendTagValueDividedBy(Integer cipTrendTagValueDividedBy) {
	this.cipTrendTagValueDividedBy = cipTrendTagValueDividedBy;
    }

    public String save() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean sr = CIPTrendTagSettingModel.saveCIPTrendTag(cipTrendTagName, cipTrendTagDesc, cipTrendTagUnit,
		    cipTrendTagValueDividedBy, cipTrendTagType, cipTrendTagMasterLineId);
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
	    boolean dr = CIPTrendTagSettingModel.deleteCIPTrendTagById(cipTrendTagId);
	    if (dr) {
		result = SUCCESS;
	    }
	}
	return result;
    }
}
