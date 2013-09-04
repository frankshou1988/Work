package com.tetrapak.action.admin;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.model.admin.HMIOperatorManageActionModel;

public class HMIOperatorManageAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Integer operatorId;
    private Long plcId;
    private String operatorName;
    private String plcStructureType;

    public Integer getOperatorId() {
	return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
	this.operatorId = operatorId;
    }

    public Long getPlcId() {
	return plcId;
    }

    public void setPlcId(Long plcId) {
	this.plcId = plcId;
    }

    public String getOperatorName() {
	return operatorName;
    }

    public void setOperatorName(String operatorName) {
	this.operatorName = operatorName;
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
	    boolean sr = HMIOperatorManageActionModel.save(plcId, operatorName, plcStructureType);
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
	    boolean dr = HMIOperatorManageActionModel.delete(operatorId);
	    if (dr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

}
