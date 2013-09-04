package com.tetrapak.model.systemsettings.cip;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPPhase;
import com.tetrapak.domain.cip.CIPSlaveLine;
import com.tetrapak.domain.cip.CIPTarget;
import com.tetrapak.util.cip.CIPPhaseUtil;

public class CIPPhaseSettingActionModel {

    public static boolean saveCIPPhase(Integer id, String cipPhaseName, Long cipPhaseID, Integer cipPhaseSlaveLineId,
	    Integer cipPhaseTargetId) throws Exception {
	boolean result = false;
	CIPSlaveLine cipSlaveLine = (CIPSlaveLine) CommonDao.getObjById(CIPSlaveLine.class, cipPhaseSlaveLineId);
	CIPTarget cipTarget = (CIPTarget) CommonDao.getObjById(CIPTarget.class, cipPhaseTargetId);
	CIPPhase cipPhase = null;
	if (id != null) {
	    cipPhase = (CIPPhase) CommonDao.getObjById(CIPPhase.class, id);
	    if (cipPhase != null && cipSlaveLine != null && cipTarget != null) {
		cipPhase.setPhaseName(cipPhaseName);
		cipPhase.setPhaseID(cipPhaseID);
		cipPhase.setCipSlaveLine(cipSlaveLine);
		cipPhase.setCipTarget(cipTarget);
		CommonDao.update(cipPhase);
	    }
	} else {
	    if (!CIPPhaseUtil.isPhaseExist(cipPhaseName, cipPhaseID)) {
		if (cipSlaveLine != null && cipTarget != null) {
		    cipPhase = new CIPPhase();
		    cipPhase.setPhaseID(cipPhaseID);
		    cipPhase.setPhaseName(cipPhaseName);
		    cipPhase.setCipSlaveLine(cipSlaveLine);
		    cipPhase.setCipTarget(cipTarget);
		    result = CommonDao.save(cipPhase);
		}
	    }
	}

	return result;
    }

    public static boolean deleteCIPPhase(Integer id) throws Exception {
	boolean result = false;
	CIPPhase p = new CIPPhase();
	p.setId(id);
	result = CommonDao.delete(p);
	return result;
    }

}
