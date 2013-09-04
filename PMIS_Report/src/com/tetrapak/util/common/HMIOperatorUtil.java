package com.tetrapak.util.common;

import java.util.ArrayList;
import java.util.List;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.comm.HMIOperator;

public class HMIOperatorUtil {
    public static HMIOperator getHMIOperatorByPLCId(long operatedByID, String plcStructureType) throws Exception {
	HMIOperator operator = null;
	Object obj = CommonDao.getObjByColumns(HMIOperator.class, new String[] { "plcId", "plcStructureType" },
		new Object[] { operatedByID, plcStructureType }, null, null);
	if (obj != null) {
	    operator = (HMIOperator) obj;
	} else {
	    operator = new HMIOperator();
	    operator.setOperatorName("Unknown:" + operatedByID);
	    operator.setPlcId(operatedByID);
	    operator.setPlcStructureType(plcStructureType);
	}
	return operator;
    }

    public static List<HMIOperator> getHMIOperatorList() throws Exception {
	List<HMIOperator> operatorList = new ArrayList<HMIOperator>();
	List<?> objList = CommonDao.getAllObj(HMIOperator.class, "plcId", true);
	for (Object obj : objList) {
	    operatorList.add((HMIOperator) obj);
	}
	return operatorList;
    }

}
