package com.tetrapak.metaclass;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tetrapak.domain.cip.CIPMasterLine;

public class CIPPerformAnalyseResult {
    private List<CIPMasterLine> cipMasterLineList;
    private Date queryStartDateTime;
    private Date queryEndDateTime;
    private PeriodLastTime cipTotalLastTime;
    private Map<String, PeriodLastTime> cipTotalLastTimeOfCIPType;
    private int cipTotalCount;
    private Map<String, Integer> cipTotalCountOfCIPType;

    public List<CIPMasterLine> getCipMasterLineList() {
	return cipMasterLineList;
    }

    public void setCipMasterLineList(List<CIPMasterLine> cipMasterLineList) {
	this.cipMasterLineList = cipMasterLineList;
    }

    public Date getQueryStartDateTime() {
	return queryStartDateTime;
    }

    public void setQueryStartDateTime(Date queryStartDateTime) {
	this.queryStartDateTime = queryStartDateTime;
    }

    public Date getQueryEndDateTime() {
	return queryEndDateTime;
    }

    public void setQueryEndDateTime(Date queryEndDateTime) {
	this.queryEndDateTime = queryEndDateTime;
    }

    public PeriodLastTime getCipTotalLastTime() {
	return cipTotalLastTime;
    }

    public void setCipTotalLastTime(PeriodLastTime cipTotalLastTime) {
	this.cipTotalLastTime = cipTotalLastTime;
    }

    public Map<String, PeriodLastTime> getCipTotalLastTimeOfCIPType() {
	return cipTotalLastTimeOfCIPType;
    }

    public void setCipTotalLastTimeOfCIPType(Map<String, PeriodLastTime> cipTotalLastTimeOfCIPType) {
	this.cipTotalLastTimeOfCIPType = cipTotalLastTimeOfCIPType;
    }

    public int getCipTotalCount() {
	return cipTotalCount;
    }

    public void setCipTotalCount(int cipTotalCount) {
	this.cipTotalCount = cipTotalCount;
    }

    public Map<String, Integer> getCipTotalCountOfCIPType() {
	return cipTotalCountOfCIPType;
    }

    public void setCipTotalCountOfCIPType(Map<String, Integer> cipTotalCountOfCIPType) {
	this.cipTotalCountOfCIPType = cipTotalCountOfCIPType;
    }

    public PeriodLastTime getCipLyeLastTime() {
	return cipTotalLastTimeOfCIPType.get(CIPTypes.LYE);
    }

    public PeriodLastTime getCipAcidLastTime() {
	return cipTotalLastTimeOfCIPType.get(CIPTypes.ACID);
    }

    public PeriodLastTime getCipLyeAcidLastTime() {
	return cipTotalLastTimeOfCIPType.get(CIPTypes.LYE_ACID);
    }

    public PeriodLastTime getCipRinseLastTime() {
	return cipTotalLastTimeOfCIPType.get(CIPTypes.RINSE);
    }

    public PeriodLastTime getCipSterilizeLastTime() {
	return cipTotalLastTimeOfCIPType.get(CIPTypes.STER_OR_CHEM_DIS);
    }

    public int getCipLyeCount() {
	return cipTotalCountOfCIPType.get(CIPTypes.LYE);
    }

    public int getCipAcidCount() {
	return cipTotalCountOfCIPType.get(CIPTypes.ACID);
    }

    public int getCipLyeAcidCount() {
	return cipTotalCountOfCIPType.get(CIPTypes.LYE_ACID);
    }

    public int getCipRinseCount() {
	return cipTotalCountOfCIPType.get(CIPTypes.RINSE);
    }

    public int getCipSterilizeCount() {
	return cipTotalCountOfCIPType.get(CIPTypes.STER_OR_CHEM_DIS);
    }

}
