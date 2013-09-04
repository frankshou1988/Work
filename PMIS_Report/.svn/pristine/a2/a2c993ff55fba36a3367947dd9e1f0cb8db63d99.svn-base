package com.tetrapak.action.cip;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPTarget;
import com.tetrapak.domain.cip.CIPTargetGroup;
import com.tetrapak.metaclass.CIPPerformAnalyseResult;
import com.tetrapak.model.cip.CIPPerformAnalysisActionModel;

public class CIPPerformAnalysisAction extends ActionSupport implements Action {
    private static final long serialVersionUID = 1L;
    private List<Integer> cipMasterLineIdList;
    private Integer cipTargetGroupId;
    private Integer cipTargetId;
    private String queryStartDate;
    private String queryEndDate;
    private CIPTargetGroup cipTargetGroup;
    private CIPTarget cipTarget;
    private CIPPerformAnalyseResult cipPerformAnalyseResult;

    public String getQueryStartDate() {
	return queryStartDate;
    }

    public void setQueryStartDate(String queryStartDate) {
	this.queryStartDate = queryStartDate;
    }

    public String getQueryEndDate() {
	return queryEndDate;
    }

    public void setQueryEndDate(String queryEndDate) {
	this.queryEndDate = queryEndDate;
    }

    public List<Integer> getCipMasterLineIdList() {
	return cipMasterLineIdList;
    }

    public void setCipMasterLineIdList(List<Integer> cipMasterLineIdList) {
	this.cipMasterLineIdList = cipMasterLineIdList;
    }

    public CIPPerformAnalyseResult getCipPerformAnalyseResult() {
	return cipPerformAnalyseResult;
    }

    public void setCipPerformAnalyseResult(CIPPerformAnalyseResult cipPerformAnalyseResult) {
	this.cipPerformAnalyseResult = cipPerformAnalyseResult;
    }

    public Integer getCipTargetGroupId() {
	return cipTargetGroupId;
    }

    public void setCipTargetGroupId(Integer cipTargetGroupId) {
	this.cipTargetGroupId = cipTargetGroupId;
    }

    public Integer getCipTargetId() {
	return cipTargetId;
    }

    public void setCipTargetId(Integer cipTargetId) {
	this.cipTargetId = cipTargetId;
    }

    public CIPTargetGroup getCipTargetGroup() {
	return cipTargetGroup;
    }

    public void setCipTargetGroup(CIPTargetGroup cipTargetGroup) {
	this.cipTargetGroup = cipTargetGroup;
    }

    public CIPTarget getCipTarget() {
	return cipTarget;
    }

    public void setCipTarget(CIPTarget cipTarget) {
	this.cipTarget = cipTarget;
    }

    public String cipPerformAnalysisMasterLineQuery() throws Exception {
	String result = SUCCESS;
	setCipPerformAnalyseResult(CIPPerformAnalysisActionModel.getCIPPerformAnalyseResult(cipMasterLineIdList,
		queryStartDate, queryEndDate));
	return result;
    }

    public String cipPerformAnalysisTargetQuery() throws Exception {
	String result = SUCCESS;
	CIPTargetGroup targetGroup = (CIPTargetGroup) CommonDao.getObjById(CIPTargetGroup.class, cipTargetGroupId);
	if (targetGroup != null) {
	    setCipTargetGroup(targetGroup);
	    CIPTarget target = (CIPTarget) CommonDao.getObjById(CIPTarget.class, cipTargetId);
	    if (target != null) {
		setCipTarget(target);
		setCipPerformAnalyseResult(CIPPerformAnalysisActionModel.getCIPPerformAnalyseResultOfTarget(
			cipTargetGroup, cipTarget.getCipTargetName(), queryStartDate, queryEndDate));
	    }
	}
	return result;
    }
}
