package com.tetrapak.model.cip;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPMasterLine;
import com.tetrapak.domain.cip.CIPReportResult;
import com.tetrapak.domain.cip.CIPTargetGroup;
import com.tetrapak.metaclass.CIPPerformAnalyseResult;
import com.tetrapak.metaclass.PLCStructureTypes;
import com.tetrapak.metaclass.PeriodLastTime;
import com.tetrapak.util.cip.CIPLineUtil;
import com.tetrapak.util.cip.CIPPerformAnalyser;
import com.tetrapak.util.common.Tools;

public class CIPPerformAnalysisActionModel {
    public static CIPPerformAnalyseResult getCIPPerformAnalyseResult(List<Integer> cipMasterLineIdList,
	    String queryStartDateTimeStr, String queryEndDateTimeStr) throws Exception {
	CIPPerformAnalyseResult pResult = new CIPPerformAnalyseResult();
	List<CIPMasterLine> cipMasterLineList = CIPLineUtil.getCIPMasterLineList(cipMasterLineIdList);
	List<CIPMasterLine> tpm6CIPMasterLineList = new ArrayList<CIPMasterLine>();
	List<CIPMasterLine> tpm5CIPMasterLineList = new ArrayList<CIPMasterLine>();
	List<CIPMasterLine> tpm4CIPMasterLineList = new ArrayList<CIPMasterLine>();
	for (CIPMasterLine ml : cipMasterLineList) {
	    if (ml.getPlcStructureType().equalsIgnoreCase(PLCStructureTypes.TPM6)) {
		tpm6CIPMasterLineList.add(ml);
	    } else if (ml.getPlcStructureType().equalsIgnoreCase(PLCStructureTypes.TPM5)) {
		tpm5CIPMasterLineList.add(ml);
	    } else if (ml.getPlcStructureType().equalsIgnoreCase(PLCStructureTypes.TPM4)) {
		tpm4CIPMasterLineList.add(ml);
	    }
	}
	Date queryStartDateTime = Tools.toDate(queryStartDateTimeStr).getTime();
	Date queryEndDateTime = Tools.toDate(queryEndDateTimeStr).getTime();
	// TPM6
	List<CIPReportResult> tpm6cipReportResultList = CIPPerformAnalyser.getCIPReportResult(tpm6CIPMasterLineList,
		queryStartDateTime, queryEndDateTime);
	// get total last time of cip of TPM6
	PeriodLastTime cipTotalLastTimeOfTPM6 = CIPPerformAnalyser.getTotalCIPLastTime(tpm6cipReportResultList);
	// get total last time of different cip types of TPM6
	Map<String, PeriodLastTime> cipTotalLastTimeOfCIPTypeOfTPM6 = CIPPerformAnalyser
		.getTotalCIPLastTimeOfCIPTypeOfTPM6(tpm6cipReportResultList);
	// get total count of cip of TPM6
	int cipTotalCountOfTPM6 = CIPPerformAnalyser.getCIPTotalCount(tpm6cipReportResultList);
	// get total count of different cip types of TPM6
	Map<String, Integer> cipTotalCountOfCIPTypeOfTPM6 = CIPPerformAnalyser
		.getCIPTotalCountOfCIPTypeOfTPM6(tpm6cipReportResultList);

	// TPM5
	List<CIPReportResult> tpm5cipReportResultList = CIPPerformAnalyser.getCIPReportResult(tpm5CIPMasterLineList,
		queryStartDateTime, queryEndDateTime);
	// get total last time of cip of TPM5
	PeriodLastTime cipTotalLastTimeOfTPM5 = CIPPerformAnalyser.getTotalCIPLastTime(tpm5cipReportResultList);
	// get total last time of different cip types of TPM5
	Map<String, PeriodLastTime> cipTotalLastTimeOfCIPTypeOfTPM5 = CIPPerformAnalyser
		.getTotalCIPLastTimeOfCIPTypeOfTPM5(tpm5cipReportResultList);
	// get total count of cip of TPM5
	int cipTotalCountOfTPM5 = CIPPerformAnalyser.getCIPTotalCount(tpm5cipReportResultList);
	// get total count of different cip types of TPM5
	Map<String, Integer> cipTotalCountOfCIPTypeOfTPM5 = CIPPerformAnalyser
		.getCIPTotalCountOfCIPTypeOfTPM5(tpm5cipReportResultList);

	// TPM4
	List<CIPReportResult> tpm4CipReportResultList = CIPPerformAnalyser.getCIPReportResult(tpm4CIPMasterLineList,
		queryStartDateTime, queryEndDateTime);
	// get total last time of cip of TPM4
	PeriodLastTime cipTotalLastTimeOfTPM4 = CIPPerformAnalyser.getTotalCIPLastTime(tpm4CipReportResultList);
	// get total last time of different cip types of TPM4
	Map<String, PeriodLastTime> cipTotalLastTimeOfCIPTypeOfTPM4 = CIPPerformAnalyser
		.getTotalCIPLastTimeOfCIPTypeOfTPM4(tpm4CipReportResultList);
	// get total count of cip of TPM4
	int cipTotalCountOfTPM4 = CIPPerformAnalyser.getCIPTotalCount(tpm4CipReportResultList);
	// get total count of different cip types of TPM4
	Map<String, Integer> cipTotalCountOfCIPTypeOfTPM4 = CIPPerformAnalyser
		.getCIPTotalCountOfCIPTypeOfTPM4(tpm4CipReportResultList);

	// add them all
	// total cip last time
	cipTotalLastTimeOfTPM6.add(cipTotalLastTimeOfTPM5);
	cipTotalLastTimeOfTPM6.add(cipTotalLastTimeOfTPM4);
	PeriodLastTime cipTotalLastTime = cipTotalLastTimeOfTPM6;
	// total cip count
	int cipTotalCount = cipTotalCountOfTPM6 + cipTotalCountOfTPM5 + cipTotalCountOfTPM4;

	Map<String, PeriodLastTime> cipTotalLastTimeOfCIPType = new HashMap<String, PeriodLastTime>();
	Set<Entry<String, PeriodLastTime>> iterTimeSet = cipTotalLastTimeOfCIPTypeOfTPM6.entrySet();

	for (Entry<String, PeriodLastTime> entry : iterTimeSet) {
	    String cipType = entry.getKey();
	    PeriodLastTime lastTimeTPM6 = entry.getValue();
	    PeriodLastTime lastTimeTPM5 = cipTotalLastTimeOfCIPTypeOfTPM5.get(cipType);
	    PeriodLastTime lastTimeTPM4 = cipTotalLastTimeOfCIPTypeOfTPM4.get(cipType);
	    lastTimeTPM6.add(lastTimeTPM5);
	    lastTimeTPM6.add(lastTimeTPM4);
	    PeriodLastTime lastTime = lastTimeTPM6;
	    cipTotalLastTimeOfCIPType.put(cipType, lastTime);
	}

	Map<String, Integer> cipTotalCountOfCIPType = new HashMap<String, Integer>();
	Set<Entry<String, Integer>> iterCountSet = cipTotalCountOfCIPTypeOfTPM6.entrySet();
	for (Entry<String, Integer> entry : iterCountSet) {
	    String cipType = entry.getKey();
	    int countTPM6 = entry.getValue();
	    int countTPM5 = cipTotalCountOfCIPTypeOfTPM5.get(cipType);
	    int countTPM4 = cipTotalCountOfCIPTypeOfTPM4.get(cipType);
	    int count = countTPM6 + countTPM5 + countTPM4;
	    cipTotalCountOfCIPType.put(cipType, count);
	}

	pResult.setQueryStartDateTime(queryStartDateTime);
	pResult.setQueryEndDateTime(queryEndDateTime);
	pResult.setCipMasterLineList(cipMasterLineList);
	pResult.setCipTotalLastTime(cipTotalLastTime);
	pResult.setCipTotalLastTimeOfCIPType(cipTotalLastTimeOfCIPType);
	pResult.setCipTotalCount(cipTotalCount);
	pResult.setCipTotalCountOfCIPType(cipTotalCountOfCIPType);
	return pResult;
    }

    public static CIPPerformAnalyseResult getCIPPerformAnalyseResultOfTarget(CIPTargetGroup cipTargetGroup,
	    String cipTargetName, String queryStartDateTimeStr, String queryEndDateTimeStr) throws Exception {
	CIPPerformAnalyseResult pResult = new CIPPerformAnalyseResult();
	PeriodLastTime cipTotalLastTime = null;
	Map<String, PeriodLastTime> cipTotalLastTimeOfCIPType = null;
	int cipTotalCount = 0;
	Map<String, Integer> cipTotalCountOfCIPType = null;
	Date queryStartDateTime = Tools.toDate(queryStartDateTimeStr).getTime();
	Date queryEndDateTime = Tools.toDate(queryEndDateTimeStr).getTime();
	List<CIPReportResult> cipReportResultList = CIPPerformAnalyser.getCIPReportResultOfTarget(cipTargetName,
		queryStartDateTime, queryEndDateTime);
	CIPMasterLine ml = null;
	if (cipReportResultList.size() > 0) {
	    CIPReportResult cipReportResult = cipReportResultList.get(0);
	    int masterLineId = cipReportResult.getCipMasterLineId();
	    ml = (CIPMasterLine) CommonDao.getObjById(CIPMasterLine.class, masterLineId);

	}
	if (ml != null) {
	    cipTotalLastTime = CIPPerformAnalyser.getTotalCIPLastTime(cipReportResultList);
	    if (ml.getPlcStructureType().equalsIgnoreCase(PLCStructureTypes.TPM6)) {
		cipTotalLastTimeOfCIPType = CIPPerformAnalyser.getTotalCIPLastTimeOfCIPTypeOfTPM6(cipReportResultList);
	    } else if (ml.getPlcStructureType().equalsIgnoreCase(PLCStructureTypes.TPM5)) {
		cipTotalLastTimeOfCIPType = CIPPerformAnalyser.getTotalCIPLastTimeOfCIPTypeOfTPM5(cipReportResultList);
	    } else if (ml.getPlcStructureType().equalsIgnoreCase(PLCStructureTypes.TPM4)) {
		cipTotalLastTimeOfCIPType = CIPPerformAnalyser.getTotalCIPLastTimeOfCIPTypeOfTPM4(cipReportResultList);
	    }
	    cipTotalCount = CIPPerformAnalyser.getCIPTotalCount(cipReportResultList);
	    if (ml.getPlcStructureType().equalsIgnoreCase(PLCStructureTypes.TPM6)) {
		cipTotalCountOfCIPType = CIPPerformAnalyser.getCIPTotalCountOfCIPTypeOfTPM6(cipReportResultList);
	    } else if (ml.getPlcStructureType().equalsIgnoreCase(PLCStructureTypes.TPM5)) {
		cipTotalCountOfCIPType = CIPPerformAnalyser.getCIPTotalCountOfCIPTypeOfTPM5(cipReportResultList);
	    } else if (ml.getPlcStructureType().equalsIgnoreCase(PLCStructureTypes.TPM4)) {
		cipTotalCountOfCIPType = CIPPerformAnalyser.getCIPTotalCountOfCIPTypeOfTPM4(cipReportResultList);
	    }
	}

	pResult.setQueryStartDateTime(queryStartDateTime);
	pResult.setQueryEndDateTime(queryEndDateTime);
	pResult.setCipTotalLastTime(cipTotalLastTime);
	pResult.setCipTotalLastTimeOfCIPType(cipTotalLastTimeOfCIPType);
	pResult.setCipTotalCount(cipTotalCount);
	pResult.setCipTotalCountOfCIPType(cipTotalCountOfCIPType);
	return pResult;
    }
}
