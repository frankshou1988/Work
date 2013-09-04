package com.tetrapak.action.ajax.cip;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.domain.cip.CIPSlaveLine;
import com.tetrapak.domain.cip.CIPTarget;
import com.tetrapak.domain.cip.CIPTrendTag;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.model.cip.CIPReportQueryActionModel;

public class CIPAjaxAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private List<CIPTarget> cipTargets;
    private Integer cipTargetGroupId;
    private List<CIPSlaveLine> cipSlaveLines;
    private List<CIPTrendTag> cipTrendTags;

    private Integer masterLineId;

    @JSON(name = "cipSlaveLines")
    public List<CIPSlaveLine> getCipSlaveLines() {
	return cipSlaveLines;
    }

    public void setCipSlaveLines(List<CIPSlaveLine> cipSlaveLines) {
	this.cipSlaveLines = cipSlaveLines;
    }

    @JSON(name = "cipTrendTags")
    public List<CIPTrendTag> getCipTrendTags() {
	return cipTrendTags;
    }

    public void setCipTrendTags(List<CIPTrendTag> cipTrendTags) {
	this.cipTrendTags = cipTrendTags;
    }

    @JSON(serialize = false)
    public Integer getMasterLineId() {
	return masterLineId;
    }

    public void setMasterLineId(Integer masterLineId) {
	this.masterLineId = masterLineId;
    }

    @JSON(name = "cipTargets")
    public List<CIPTarget> getCipTargets() {
	return cipTargets;
    }

    public void setCipTargets(List<CIPTarget> cipTargets) {
	this.cipTargets = cipTargets;
    }

    @JSON(serialize = false)
    public Integer getCipTargetGroupId() {
	return cipTargetGroupId;
    }

    public void setCipTargetGroupId(Integer cipTargetGroupId) {
	this.cipTargetGroupId = cipTargetGroupId;
    }

    public String getSlaveLineOfMasterLine() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    setCipSlaveLines(CIPReportQueryActionModel.getCIPSlaveLineListOfMasterLine(masterLineId));
	    result = SUCCESS;
	}
	return result;
    }

    public String getCIPTrendTagOfMasterLine() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    setCipTrendTags(CIPReportQueryActionModel.getCIPTrendTagListOfMasterLine(masterLineId));
	    result = SUCCESS;
	}
	return result;
    }

    public String getCIPTargetOfTargetGroup() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    setCipTargets(CIPReportQueryActionModel.getCIPTargetListOfTargetGroup(cipTargetGroupId));
	    result = SUCCESS;
	}
	return result;
    }
}
