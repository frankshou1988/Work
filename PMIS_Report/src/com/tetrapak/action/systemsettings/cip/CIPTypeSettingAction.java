package com.tetrapak.action.systemsettings.cip;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.model.systemsettings.cip.CIPTypeSettingActionModel;

public class CIPTypeSettingAction extends ActionSupport {
    private static final long serialVersionUID = 3868965939182601514L;
    private Integer cipTypeId;
    private Long cipTypePLCIdValue;
    private String cipTypeDesc;
    private String plcStructureType;

    public Integer getCipTypeId() {
	return cipTypeId;
    }

    public void setCipTypeId(Integer cipTypeId) {
	this.cipTypeId = cipTypeId;
    }

    public Long getCipTypePLCIdValue() {
	return cipTypePLCIdValue;
    }

    public void setCipTypePLCIdValue(Long cipTypePLCIdValue) {
	this.cipTypePLCIdValue = cipTypePLCIdValue;
    }

    public String getCipTypeDesc() {
	return cipTypeDesc;
    }

    public void setCipTypeDesc(String cipTypeDesc) {
	this.cipTypeDesc = cipTypeDesc;
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
	    boolean sr = CIPTypeSettingActionModel.save(cipTypePLCIdValue, cipTypeDesc, plcStructureType);
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
	    boolean dr = CIPTypeSettingActionModel.delete(cipTypeId);
	    if (dr) {
		result = SUCCESS;
	    }
	}
	return result;
    }

}
