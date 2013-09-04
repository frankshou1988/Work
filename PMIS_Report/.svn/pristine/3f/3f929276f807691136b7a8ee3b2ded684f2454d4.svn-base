package com.tetrapak.action.systemsettings.cip;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPMasterLine;
import com.tetrapak.domain.cip.CIPPhase;
import com.tetrapak.domain.cip.CIPTrendTag;

/**
 * CIP Setting Pages Action
 * */
public class CIPSettingsPageAction extends ActionSupport implements Action {
    private static final long serialVersionUID = -7723551249187888624L;
    private Integer masterLineId;
    private CIPMasterLine cipMasterLine;
    private Integer cipPhaseId;
    private CIPPhase cipPhase;
    private Integer cipTrendTagId;
    private CIPTrendTag cipTrendTag;

    public Integer getMasterLineId() {
	return masterLineId;
    }

    public void setMasterLineId(Integer masterLineId) {
	this.masterLineId = masterLineId;
    }

    public CIPMasterLine getCipMasterLine() {
	return cipMasterLine;
    }

    public void setCipMasterLine(CIPMasterLine cipMasterLine) {
	this.cipMasterLine = cipMasterLine;
    }

    public Integer getCipPhaseId() {
	return cipPhaseId;
    }

    public void setCipPhaseId(Integer cipPhaseId) {
	this.cipPhaseId = cipPhaseId;
    }

    public CIPPhase getCipPhase() {
	return cipPhase;
    }

    public void setCipPhase(CIPPhase cipPhase) {
	this.cipPhase = cipPhase;
    }

    public Integer getCipTrendTagId() {
	return cipTrendTagId;
    }

    public void setCipTrendTagId(Integer cipTrendTagId) {
	this.cipTrendTagId = cipTrendTagId;
    }

    public CIPTrendTag getCipTrendTag() {
	return cipTrendTag;
    }

    public void setCipTrendTag(CIPTrendTag cipTrendTag) {
	this.cipTrendTag = cipTrendTag;
    }

    public String cipSettingPage() throws Exception {
	return SUCCESS;
    }

    /**
     * CIP Master Line Setting and Slave Line Setting Page
     * */
    public String cipLineSettingPage() throws Exception {
	return SUCCESS;
    }

    /**
     * CIP Target Group Setting and Target Setting Page
     * */
    public String cipTargetSettingPage() throws Exception {
	return SUCCESS;
    }

    /**
     * CIP Phase Setting Page
     * */
    public String cipPhaseSettingPage() throws Exception {
	if (cipPhaseId != null) {
	    setCipPhase((CIPPhase) CommonDao.getObjById(CIPPhase.class, cipPhaseId));
	}
	return SUCCESS;
    }

    /**
     * CIP Type Setting and CIP Result Setting Page
     * */
    public String cipTypeResultSettingPage() throws Exception {
	return SUCCESS;
    }

    /**
     * CIP Trend Tag Setting Page
     * */
    public String cipTrendTagSettingPage() throws Exception {
	if (this.cipTrendTagId != null) {
	    this.setCipTrendTag((CIPTrendTag) CommonDao.getObjById(CIPTrendTag.class, cipTrendTagId));
	}
	return SUCCESS;
    }

    /**
     * CIP Master Line Tags Setting Page
     * */
    public String cipMasterLineTagsSettingPage() throws Exception {
	if (masterLineId != null) {
	    setCipMasterLine((CIPMasterLine) CommonDao.getObjById(CIPMasterLine.class, masterLineId));
	}
	return SUCCESS;
    }

}
