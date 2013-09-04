package com.tetrapak.model.systemsettings.cip;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPType;

/**
 * Save or update cip type
 * */
public class CIPTypeSettingActionModel {
    public static boolean save(Long cipTypePlcId, String cipTypeDesc, String plcStructureType) throws Exception {
	boolean result = false;
	CIPType ct = null;
	ct = (CIPType) CommonDao.getObjByColumns(CIPType.class, new String[] { "cipTypePLCId", "plcStructureType" },
		new Object[] { cipTypePlcId, plcStructureType });
	if (ct == null) {
	    ct = new CIPType();
	}
	ct.setCipTypePLCId(cipTypePlcId);
	ct.setCipTypeDesc(cipTypeDesc);
	ct.setPlcStructureType(plcStructureType);
	result = CommonDao.saveOrUpdate(ct);
	return result;
    }

    public static boolean delete(Integer cipTypeId) throws Exception {
	boolean result = false;
	CIPType cr = new CIPType();
	cr.setId(cipTypeId);
	result = CommonDao.delete(cr);
	return result;
    }

}
