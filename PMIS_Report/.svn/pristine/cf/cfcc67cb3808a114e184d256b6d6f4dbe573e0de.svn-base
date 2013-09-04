package com.tetrapak.util.cip;

import java.util.ArrayList;
import java.util.List;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPType;
import com.tetrapak.metaclass.PLCStructureTypes;

public class CIPTypeUtil {

    public static List<CIPType> getCIPTypeList() throws Exception {
	List<CIPType> cipTypeList = new ArrayList<CIPType>();
	List<?> objList = CommonDao.getAllObj(CIPType.class, "cipTypePLCId", true);
	for (Object obj : objList) {
	    cipTypeList.add((CIPType) obj);
	}
	return cipTypeList;
    }

    public static List<CIPType> getCIPTypeListOfTPM6() throws Exception {
	List<CIPType> cipTypeList = new ArrayList<CIPType>();
	List<?> objList = CommonDao.getAllObjByColumns(CIPType.class, new String[] { "plcStructureType" },
		new Object[] { PLCStructureTypes.TPM6 }, "cipTypePLCId", true);
	for (Object obj : objList) {
	    cipTypeList.add((CIPType) obj);
	}
	return cipTypeList;
    }

    public static List<CIPType> getCIPTypeListOfTPM5() throws Exception {
	List<CIPType> cipTypeList = new ArrayList<CIPType>();
	List<?> objList = CommonDao.getAllObjByColumns(CIPType.class, new String[] { "plcStructureType" },
		new Object[] { PLCStructureTypes.TPM5 }, "cipTypePLCId", true);
	for (Object obj : objList) {
	    cipTypeList.add((CIPType) obj);
	}
	return cipTypeList;
    }

    public static List<CIPType> getCIPTypeListOfTPM4() throws Exception {
	List<CIPType> cipTypeList = new ArrayList<CIPType>();
	List<?> objList = CommonDao.getAllObjByColumns(CIPType.class, new String[] { "plcStructureType" },
		new Object[] { PLCStructureTypes.TPM4 }, "cipTypePLCId", true);
	for (Object obj : objList) {
	    cipTypeList.add((CIPType) obj);
	}
	return cipTypeList;
    }
}
