package com.tetrapak.util.cip;

import java.util.ArrayList;
import java.util.List;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPResult;
import com.tetrapak.metaclass.PLCStructureTypes;

public class CIPResultUtil {
    public static List<CIPResult> getCIPResultList() throws Exception {
	List<CIPResult> cipTypeList = new ArrayList<CIPResult>();
	List<?> objList = CommonDao.getAllObj(CIPResult.class, "cipResultPLCId", true);
	for (Object obj : objList) {
	    cipTypeList.add((CIPResult) obj);
	}
	return cipTypeList;
    }

    public static List<CIPResult> getCIPResultListOfTPM4() throws Exception {
	List<CIPResult> cipResultList = new ArrayList<CIPResult>();
	List<?> objList = CommonDao.getAllObjByColumns(CIPResult.class, new String[] { "plcStructureType" },
		new Object[] { PLCStructureTypes.TPM4 }, "cipResultPLCId", true);
	for (Object obj : objList) {
	    cipResultList.add((CIPResult) obj);
	}
	return cipResultList;
    }

    public static List<CIPResult> getCIPResultListOfTPM5() throws Exception {
	List<CIPResult> cipResultList = new ArrayList<CIPResult>();
	List<?> objList = CommonDao.getAllObjByColumns(CIPResult.class, new String[] { "plcStructureType" },
		new Object[] { PLCStructureTypes.TPM5 }, "cipResultPLCId", true);
	for (Object obj : objList) {
	    cipResultList.add((CIPResult) obj);
	}
	return cipResultList;
    }

    public static List<CIPResult> getCIPResultListOfTPM6() throws Exception {
	List<CIPResult> cipResultList = new ArrayList<CIPResult>();
	List<?> objList = CommonDao.getAllObjByColumns(CIPResult.class, new String[] { "plcStructureType" },
		new Object[] { PLCStructureTypes.TPM6 }, "cipResultPLCId", true);
	for (Object obj : objList) {
	    cipResultList.add((CIPResult) obj);
	}
	return cipResultList;
    }
}
