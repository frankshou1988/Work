package com.tetrapak.util.cip;

import java.util.List;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPPhase;
import com.tetrapak.domain.cip.CIPReportAnalysePoint;
import com.tetrapak.domain.cip.CIPReportResult;
import com.tetrapak.domain.cip.CIPResult;
import com.tetrapak.domain.cip.CIPType;
import com.tetrapak.metaclass.PLCStructureTypes;

public class CIPReportUtil {
    public static CIPType getCIPTypeByProgramIDOfTPM6(long programID) throws Exception {
	CIPType cipType = null;
	cipType = (CIPType) CommonDao
		.getObjByColumns(CIPType.class, new String[] { "cipTypePLCId", "plcStructureType" }, new Object[] {
			programID, PLCStructureTypes.TPM6 });
	return cipType;
    }

    public static CIPType getCIPTypeByProgramIDOfTPM5(long programID) throws Exception {
	CIPType cipType = null;
	cipType = (CIPType) CommonDao
		.getObjByColumns(CIPType.class, new String[] { "cipTypePLCId", "plcStructureType" }, new Object[] {
			programID, PLCStructureTypes.TPM5 });
	return cipType;
    }

    public static CIPType getCIPTypeByProgramIDOfTPM4(long programID) throws Exception {
	CIPType cipType = null;
	cipType = (CIPType) CommonDao
		.getObjByColumns(CIPType.class, new String[] { "cipTypePLCId", "plcStructureType" }, new Object[] {
			programID, PLCStructureTypes.TPM4 });
	return cipType;
    }

    public static CIPResult getCIPResultByResultIDOfTPM6(long resultID) throws Exception {
	CIPResult cipResult = null;
	cipResult = (CIPResult) CommonDao.getObjByColumns(CIPResult.class, new String[] { "cipResultPLCId",
		"plcStructureType" }, new Object[] { resultID, PLCStructureTypes.TPM6 });
	return cipResult;
    }

    public static CIPResult getCIPResultByResultIDOfTPM5(long resultID) throws Exception {
	CIPResult cipResult = null;
	cipResult = (CIPResult) CommonDao.getObjByColumns(CIPResult.class, new String[] { "cipResultPLCId",
		"plcStructureType" }, new Object[] { resultID, PLCStructureTypes.TPM5 });
	return cipResult;
    }

    public static CIPResult getCIPResultByResultIDOfTPM4(long resultID) throws Exception {
	CIPResult cipResult = null;
	cipResult = (CIPResult) CommonDao.getObjByColumns(CIPResult.class, new String[] { "cipResultPLCId",
		"plcStructureType" }, new Object[] { resultID, PLCStructureTypes.TPM4 });
	return cipResult;
    }

    public static CIPReportAnalysePoint getCIPLastestAnalyseDateTime(String cipMasterLineName) throws Exception {
	CIPReportAnalysePoint lastestDateTime = null;
	lastestDateTime = (CIPReportAnalysePoint) CommonDao.getObjByColumnsAndRef(CIPReportAnalysePoint.class,
		new String[] {}, new Object[] {}, "cipMasterLine", "cipMasterLineName", cipMasterLineName);
	return lastestDateTime;
    }

    public static void saveCIPReportResult(CIPReportResult cipReportResult) throws Exception {
	List<?> objList = CommonDao.checkObjDuplicate(CIPReportResult.class, "cipSlaveLineId",
		cipReportResult.getCipSlaveLineId(), "cipStartDateTime", cipReportResult.getCipStartDateTime(),
		"cipEndDateTime", cipReportResult.getCipEndDateTime());
	if (objList.size() == 0) {
	    CommonDao.save(cipReportResult);
	}
    }

    public static CIPPhase getCIPPhaseByPhaseID(long phaseID) throws Exception {
	CIPPhase cipPhase = null;
	cipPhase = (CIPPhase) CommonDao.getObjByUniqueColumn(CIPPhase.class, "phaseID", phaseID);
	return cipPhase;
    }

    public static CIPReportResult getLastCIPOperation(String cipTargetName) throws Exception {
	CIPReportResult cipReportResult = null;
	Object obj = CommonDao.getObjByColumns(CIPReportResult.class, new String[] { "cipTargetName" },
		new Object[] { cipTargetName }, "cipEndDateTime", false);
	if (obj != null) {
	    cipReportResult = (CIPReportResult) obj;
	}
	return cipReportResult;
    }
}
