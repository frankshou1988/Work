package com.tetrapak.action.admin;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.bpu.BPUAnalogTag;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.util.bpu.BPUAnalogTagUtil;

public class BPUStandardParamSettingAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Integer bpuMachineId;
	private Integer analogTagId;
	private BPUAnalogTag selectedAnalogTag;
	private Double bpuStandardParamMinValue;
	private Double bpuStandardParamMaxValue;

	public Integer getBpuMachineId() {
		return bpuMachineId;
	}

	public void setBpuMachineId(Integer bpuMachineId) {
		this.bpuMachineId = bpuMachineId;
	}

	public Integer getAnalogTagId() {
		return analogTagId;
	}

	public void setAnalogTagId(Integer analogTagId) {
		this.analogTagId = analogTagId;
	}

	public BPUAnalogTag getSelectedAnalogTag() {
		return selectedAnalogTag;
	}

	public void setSelectedAnalogTag(BPUAnalogTag selectedAnalogTag) {
		this.selectedAnalogTag = selectedAnalogTag;
	}

	public Double getBpuStandardParamMinValue() {
		return bpuStandardParamMinValue;
	}

	public void setBpuStandardParamMinValue(Double bpuStandardParamMinValue) {
		this.bpuStandardParamMinValue = bpuStandardParamMinValue;
	}

	public Double getBpuStandardParamMaxValue() {
		return bpuStandardParamMaxValue;
	}

	public void setBpuStandardParamMaxValue(Double bpuStandardParamMaxValue) {
		this.bpuStandardParamMaxValue = bpuStandardParamMaxValue;
	}

	/**
	 * BPU standard parameter setting page
	 * 
	 * @throws Exception
	 * */
	public String bpuStandardParamSettingPage() throws Exception {
		if (analogTagId != null) {
			selectedAnalogTag = (BPUAnalogTag) CommonDao.getObjById(BPUAnalogTag.class, analogTagId);
		}
		return SUCCESS;
	}

	public String bpuStandardParamSave() throws Exception {
		String result = INPUT;
		String reqMethod = ServletActionContext.getRequest().getMethod();
		if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
			throw new HttpMethodNotSupportedForActionException();
		} else {
			boolean sr = BPUAnalogTagUtil.saveBPUStandardParam(analogTagId, bpuStandardParamMinValue,
					bpuStandardParamMaxValue);
			if (sr) {
				result = SUCCESS;
			}
		}
		return result;
	}
}
