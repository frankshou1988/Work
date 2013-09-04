package com.tetrapak.model.admin;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.comm.HMIOperator;

public class HMIOperatorManageActionModel {
    public static boolean save(Long operatedByID, String operatorName, String plcStructureType) throws Exception {
	boolean result = false;
	HMIOperator operator = null;
	operator = (HMIOperator) CommonDao.getObjByColumns(HMIOperator.class, new String[] { "plcId",
		"plcStructureType" }, new Object[] { operatedByID, plcStructureType });
	if (operator == null) {
	    operator = new HMIOperator();
	}
	operator.setPlcId(operatedByID);
	operator.setOperatorName(operatorName);
	operator.setPlcStructureType(plcStructureType);
	result = CommonDao.saveOrUpdate(operator);
	return result;
    }

    public static boolean delete(Integer id) throws Exception {
	boolean result = false;
	HMIOperator operator = new HMIOperator();
	operator.setId(id);
	result = CommonDao.delete(operator);
	return result;
    }
}
