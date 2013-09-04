package com.tetrapak.model.systemsettings.cip;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPResult;

public class CIPResultSettingActionModel {
    /**
     * Save or update the cip result
     * */
    public static boolean save(Long cipResultPlcId, String cipResultDesc, String plcStructureType) throws Exception {
	boolean result = false;
	CIPResult cr = (CIPResult) CommonDao.getObjByColumns(CIPResult.class, new String[] { "cipResultPLCId",
		"plcStructureType" }, new Object[] { cipResultPlcId, plcStructureType });
	if (cr == null) {
	    cr = new CIPResult();
	}
	cr.setCipResultPLCId(cipResultPlcId);
	cr.setCipResultDesc(cipResultDesc);
	cr.setPlcStructureType(plcStructureType);
	result = CommonDao.saveOrUpdate(cr);
	return result;
    }

    public static boolean delete(Integer cipResultId) throws Exception {
	boolean result = false;
	CIPResult cr = new CIPResult();
	cr.setId(cipResultId);
	result = CommonDao.delete(cr);
	return result;
    }
}
