package com.tetrapak.util.cip;

import java.util.ArrayList;
import java.util.List;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPPhase;

public class CIPPhaseSettingUtil {
    public static List<CIPPhase> getCIPPhaseList() throws Exception {
	List<CIPPhase> phaseList = new ArrayList<CIPPhase>();
	List<?> objList = CommonDao.getAllObj(CIPPhase.class, "phaseName", true);
	for (Object obj : objList) {
	    phaseList.add((CIPPhase) obj);
	}
	return phaseList;
    }
}
