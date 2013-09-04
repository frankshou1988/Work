package com.tetrapak.util.cip;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.domain.cip.CIPMasterLine;
import com.tetrapak.domain.cip.CIPReportResult;
import com.tetrapak.hibernate.HU;
import com.tetrapak.metaclass.PeriodLastTime;
import com.tetrapak.metaclass.CIPTypes;
import com.tetrapak.metaclass.TPM4CIPType;
import com.tetrapak.metaclass.TPM5CIPType;
import com.tetrapak.metaclass.TPM6CIPType;

/**
 * Analyse the cip report result and prepare for the cip efficiency report
 * */
public class CIPPerformAnalyser {
    public static List<CIPReportResult> getCIPReportResult(List<CIPMasterLine> cipMasterLineList,
	    Date queryStartDateTime, Date queryEndDateTime) throws Exception {
	List<CIPReportResult> result = new ArrayList<CIPReportResult>();
	List<Integer> masterLineIdList = new ArrayList<Integer>();
	for (CIPMasterLine ml : cipMasterLineList) {
	    masterLineIdList.add(ml.getId());
	}
	if (!masterLineIdList.isEmpty()) {
	    SessionFactory sf = HU.getSessionFactory();
	    Session s = sf.openSession();
	    Transaction t = null;
	    try {
		t = s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Object> objList = s.createCriteria(CIPReportResult.class)
			.add(Restrictions.in("cipMasterLineId", masterLineIdList))
			.add(Restrictions.between("cipStartDateTime", queryStartDateTime, queryEndDateTime)).list();
		t.commit();
		for (Object obj : objList) {
		    result.add((CIPReportResult) obj);
		}
	    } catch (Exception e) {
		t.rollback();
		throw e;
	    } finally {
		s.close();
	    }
	}
	return result;
    }

    public static List<CIPReportResult> getCIPReportResultOfTarget(String cipTargetName, Date queryStartDateTime,
	    Date queryEndDateTime) throws Exception {
	List<CIPReportResult> result = new ArrayList<CIPReportResult>();
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    @SuppressWarnings("unchecked")
	    List<Object> objList = s.createCriteria(CIPReportResult.class)
		    .add(Restrictions.eq("cipTargetName", cipTargetName))
		    .add(Restrictions.between("cipStartDateTime", queryStartDateTime, queryEndDateTime)).list();
	    t.commit();
	    for (Object obj : objList) {
		result.add((CIPReportResult) obj);
	    }
	} catch (Exception e) {
	    t.rollback();
	    throw e;
	} finally {
	    s.close();
	}
	return result;
    }

    public static PeriodLastTime getTotalCIPLastTime(List<CIPReportResult> cipReportResultList) {
	PeriodLastTime cipTotalLastTime = new PeriodLastTime();
	for (CIPReportResult result : cipReportResultList) {
	    String cipLastTimeStr = result.getCipLastTime();
	    PeriodLastTime cipLastTimeEach = new PeriodLastTime();
	    cipLastTimeEach.parsePeriodLastTime(cipLastTimeStr);
	    cipTotalLastTime.add(cipLastTimeEach);
	}
	return cipTotalLastTime;
    }

    public static Map<String, PeriodLastTime> getTotalCIPLastTimeOfCIPTypeOfTPM5(
	    List<CIPReportResult> cipReportResultList) {
	Map<String, PeriodLastTime> cipTotalLastTimeMap = new HashMap<String, PeriodLastTime>();
	PeriodLastTime cipTotalLastTimeLye = new PeriodLastTime();
	PeriodLastTime cipTotalLastTimeAcid = new PeriodLastTime();
	PeriodLastTime cipTotalLastTimeLyeAcid = new PeriodLastTime();
	PeriodLastTime cipTotalLastTimeRinse = new PeriodLastTime();
	PeriodLastTime cipTotalLastTimeSterilize = new PeriodLastTime();
	for (CIPReportResult result : cipReportResultList) {
	    String cipLastTimeStr = result.getCipLastTime();
	    PeriodLastTime cipLastTimeEach = new PeriodLastTime();
	    cipLastTimeEach.parsePeriodLastTime(cipLastTimeStr);
	    long cipType = result.getCipTypePLCId();
	    if (cipType == TPM5CIPType.LYE) {
		cipTotalLastTimeLye.add(cipLastTimeEach);
	    } else if (cipType == TPM5CIPType.ACID) {
		cipTotalLastTimeAcid.add(cipLastTimeEach);
	    } else if (cipType == TPM5CIPType.LYE_ACID) {
		cipTotalLastTimeLyeAcid.add(cipLastTimeEach);
	    } else if (cipType == TPM5CIPType.RINSE) {
		cipTotalLastTimeRinse.add(cipLastTimeEach);
	    } else if (cipType == TPM5CIPType.STERILIZE || cipType == TPM5CIPType.CHEM_DIS) {
		cipTotalLastTimeSterilize.add(cipLastTimeEach);
	    }
	}
	cipTotalLastTimeMap.put(CIPTypes.LYE, cipTotalLastTimeLye);
	cipTotalLastTimeMap.put(CIPTypes.ACID, cipTotalLastTimeAcid);
	cipTotalLastTimeMap.put(CIPTypes.LYE_ACID, cipTotalLastTimeLyeAcid);
	cipTotalLastTimeMap.put(CIPTypes.RINSE, cipTotalLastTimeRinse);
	cipTotalLastTimeMap.put(CIPTypes.STER_OR_CHEM_DIS, cipTotalLastTimeSterilize);
	return cipTotalLastTimeMap;
    }

    public static Map<String, PeriodLastTime> getTotalCIPLastTimeOfCIPTypeOfTPM4(
	    List<CIPReportResult> cipReportResultList) {
	Map<String, PeriodLastTime> cipTotalLastTimeMap = new HashMap<String, PeriodLastTime>();
	PeriodLastTime cipTotalLastTimeLye = new PeriodLastTime();
	PeriodLastTime cipTotalLastTimeAcid = new PeriodLastTime();
	PeriodLastTime cipTotalLastTimeLyeAcid = new PeriodLastTime();
	PeriodLastTime cipTotalLastTimeRinse = new PeriodLastTime();
	PeriodLastTime cipTotalLastTimeSterilize = new PeriodLastTime();
	for (CIPReportResult result : cipReportResultList) {
	    String cipLastTimeStr = result.getCipLastTime();
	    PeriodLastTime cipLastTimeEach = new PeriodLastTime();
	    cipLastTimeEach.parsePeriodLastTime(cipLastTimeStr);
	    long cipType = result.getCipTypePLCId();
	    if (cipType == TPM4CIPType.LYE) {
		cipTotalLastTimeLye.add(cipLastTimeEach);
	    } else if (cipType == TPM4CIPType.ACID) {
		cipTotalLastTimeAcid.add(cipLastTimeEach);
	    } else if (cipType == TPM4CIPType.LYE_ACID) {
		cipTotalLastTimeLyeAcid.add(cipLastTimeEach);
	    } else if (cipType == TPM4CIPType.RINSE) {
		cipTotalLastTimeRinse.add(cipLastTimeEach);
	    } else if (cipType == TPM4CIPType.STERILIZE) {
		cipTotalLastTimeSterilize.add(cipLastTimeEach);
	    }
	}

	cipTotalLastTimeMap.put(CIPTypes.LYE, cipTotalLastTimeLye);
	cipTotalLastTimeMap.put(CIPTypes.ACID, cipTotalLastTimeAcid);
	cipTotalLastTimeMap.put(CIPTypes.LYE_ACID, cipTotalLastTimeLyeAcid);
	cipTotalLastTimeMap.put(CIPTypes.RINSE, cipTotalLastTimeRinse);
	cipTotalLastTimeMap.put(CIPTypes.STER_OR_CHEM_DIS, cipTotalLastTimeSterilize);
	return cipTotalLastTimeMap;
    }

    public static int getCIPTotalCount(List<CIPReportResult> cipReportResultList) {
	return cipReportResultList.size();
    }

    public static Map<String, Integer> getCIPTotalCountOfCIPTypeOfTPM5(List<CIPReportResult> cipReportResultList) {
	Map<String, Integer> cipTotalCountOfCIPTypeMap = new HashMap<String, Integer>();
	int lyeCount = 0;
	int acidCount = 0;
	int lyeAcidCount = 0;
	int rinseCount = 0;
	int sterilizeCount = 0;
	for (CIPReportResult result : cipReportResultList) {
	    long cipType = result.getCipTypePLCId();
	    if (cipType == TPM5CIPType.LYE) {
		lyeCount += 1;
	    } else if (cipType == TPM5CIPType.ACID) {
		acidCount += 1;
	    } else if (cipType == TPM5CIPType.LYE_ACID) {
		lyeAcidCount += 1;
	    } else if (cipType == TPM5CIPType.RINSE) {
		rinseCount += 1;
	    } else if (cipType == TPM5CIPType.STERILIZE || cipType == TPM5CIPType.CHEM_DIS) {
		sterilizeCount += 1;
	    }
	}
	cipTotalCountOfCIPTypeMap.put(CIPTypes.LYE, lyeCount);
	cipTotalCountOfCIPTypeMap.put(CIPTypes.ACID, acidCount);
	cipTotalCountOfCIPTypeMap.put(CIPTypes.LYE_ACID, lyeAcidCount);
	cipTotalCountOfCIPTypeMap.put(CIPTypes.RINSE, rinseCount);
	cipTotalCountOfCIPTypeMap.put(CIPTypes.STER_OR_CHEM_DIS, sterilizeCount);
	return cipTotalCountOfCIPTypeMap;
    }

    public static Map<String, Integer> getCIPTotalCountOfCIPTypeOfTPM4(List<CIPReportResult> cipReportResultList) {
	Map<String, Integer> cipTotalCountOfCIPTypeMap = new HashMap<String, Integer>();
	int lyeCount = 0;
	int acidCount = 0;
	int lyeAcidCount = 0;
	int rinseCount = 0;
	int sterilizeCount = 0;
	for (CIPReportResult result : cipReportResultList) {
	    long cipType = result.getCipTypePLCId();
	    if (cipType == TPM4CIPType.LYE) {
		lyeCount += 1;
	    } else if (cipType == TPM4CIPType.ACID) {
		acidCount += 1;
	    } else if (cipType == TPM4CIPType.LYE_ACID) {
		lyeAcidCount += 1;
	    } else if (cipType == TPM4CIPType.RINSE) {
		rinseCount += 1;
	    } else if (cipType == TPM4CIPType.STERILIZE) {
		sterilizeCount += 1;
	    }
	}

	cipTotalCountOfCIPTypeMap.put(CIPTypes.LYE, lyeCount);
	cipTotalCountOfCIPTypeMap.put(CIPTypes.ACID, acidCount);
	cipTotalCountOfCIPTypeMap.put(CIPTypes.LYE_ACID, lyeAcidCount);
	cipTotalCountOfCIPTypeMap.put(CIPTypes.RINSE, rinseCount);
	cipTotalCountOfCIPTypeMap.put(CIPTypes.STER_OR_CHEM_DIS, sterilizeCount);
	return cipTotalCountOfCIPTypeMap;
    }

    public static Map<String, PeriodLastTime> getTotalCIPLastTimeOfCIPTypeOfTPM6(
	    List<CIPReportResult> cipReportResultList) {
	Map<String, PeriodLastTime> cipTotalLastTimeMap = new HashMap<String, PeriodLastTime>();
	PeriodLastTime cipTotalLastTimeLye = new PeriodLastTime();
	PeriodLastTime cipTotalLastTimeAcid = new PeriodLastTime();
	PeriodLastTime cipTotalLastTimeLyeAcid = new PeriodLastTime();
	PeriodLastTime cipTotalLastTimeRinse = new PeriodLastTime();
	PeriodLastTime cipTotalLastTimeSterilize = new PeriodLastTime();
	for (CIPReportResult result : cipReportResultList) {
	    String cipLastTimeStr = result.getCipLastTime();
	    PeriodLastTime cipLastTimeEach = new PeriodLastTime();
	    cipLastTimeEach.parsePeriodLastTime(cipLastTimeStr);
	    long cipType = result.getCipTypePLCId();
	    if (cipType == TPM6CIPType.LYE || cipType == TPM6CIPType.LYE_HOT_WAT || cipType == TPM6CIPType.LYE_CHEM_DIS) {
		cipTotalLastTimeLye.add(cipLastTimeEach);
	    } else if (cipType == TPM6CIPType.ACID || cipType == TPM6CIPType.ACID_LYE_HOT_WAT) {
		cipTotalLastTimeAcid.add(cipLastTimeEach);
	    } else if (cipType == TPM6CIPType.LYE_ACID || cipType == TPM6CIPType.LYE_ACID_HOT_WAT
		    || cipType == TPM6CIPType.LYE_ACID_CHEM_DIS) {
		cipTotalLastTimeLyeAcid.add(cipLastTimeEach);
	    } else if (cipType == TPM6CIPType.RINSE) {
		cipTotalLastTimeRinse.add(cipLastTimeEach);
	    } else if (cipType == TPM6CIPType.HOT_WAT || cipType == TPM6CIPType.CHEM_DIS) {
		cipTotalLastTimeSterilize.add(cipLastTimeEach);
	    }
	}
	cipTotalLastTimeMap.put(CIPTypes.LYE, cipTotalLastTimeLye);
	cipTotalLastTimeMap.put(CIPTypes.ACID, cipTotalLastTimeAcid);
	cipTotalLastTimeMap.put(CIPTypes.LYE_ACID, cipTotalLastTimeLyeAcid);
	cipTotalLastTimeMap.put(CIPTypes.RINSE, cipTotalLastTimeRinse);
	cipTotalLastTimeMap.put(CIPTypes.STER_OR_CHEM_DIS, cipTotalLastTimeSterilize);
	return cipTotalLastTimeMap;
    }

    public static Map<String, Integer> getCIPTotalCountOfCIPTypeOfTPM6(List<CIPReportResult> cipReportResultList) {
	Map<String, Integer> cipTotalCountOfCIPTypeMap = new HashMap<String, Integer>();
	int lyeCount = 0;
	int acidCount = 0;
	int lyeAcidCount = 0;
	int rinseCount = 0;
	int sterilizeCount = 0;
	for (CIPReportResult result : cipReportResultList) {
	    long cipType = result.getCipTypePLCId();
	    if (cipType == TPM6CIPType.LYE || cipType == TPM6CIPType.LYE_HOT_WAT || cipType == TPM6CIPType.LYE_CHEM_DIS) {
		lyeCount += 1;
	    } else if (cipType == TPM6CIPType.ACID || cipType == TPM6CIPType.ACID_LYE_HOT_WAT) {
		acidCount += 1;
	    } else if (cipType == TPM6CIPType.LYE_ACID || cipType == TPM6CIPType.LYE_ACID_HOT_WAT
		    || cipType == TPM6CIPType.LYE_ACID_CHEM_DIS) {
		lyeAcidCount += 1;
	    } else if (cipType == TPM6CIPType.RINSE) {
		rinseCount += 1;
	    } else if (cipType == TPM6CIPType.HOT_WAT || cipType == TPM6CIPType.CHEM_DIS) {
		sterilizeCount += 1;
	    }
	}
	cipTotalCountOfCIPTypeMap.put(CIPTypes.LYE, lyeCount);
	cipTotalCountOfCIPTypeMap.put(CIPTypes.ACID, acidCount);
	cipTotalCountOfCIPTypeMap.put(CIPTypes.LYE_ACID, lyeAcidCount);
	cipTotalCountOfCIPTypeMap.put(CIPTypes.RINSE, rinseCount);
	cipTotalCountOfCIPTypeMap.put(CIPTypes.STER_OR_CHEM_DIS, sterilizeCount);
	return cipTotalCountOfCIPTypeMap;
    }

}
