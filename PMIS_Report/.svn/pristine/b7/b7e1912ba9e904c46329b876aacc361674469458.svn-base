package com.tetrapak.model.systemsettings.cip;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPMasterLine;
import com.tetrapak.domain.cip.CIPSlaveLine;
import com.tetrapak.hibernate.HU;

public class CIPLineSettingModel {
    public static boolean isCIPMasterLineDuplicate(Integer id, String cipMasterLineName) throws Exception {
	boolean duplicate = false;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria q = s.createCriteria(CIPMasterLine.class).add(
		    Restrictions.eq("cipMasterLineName", cipMasterLineName));
	    if (id != null) {
		q.add(Restrictions.ne("id", id));
	    }
	    q.setMaxResults(1);
	    @SuppressWarnings({ "unchecked" })
	    List<Object> objList = q.list();
	    t.commit();
	    duplicate = (objList.size() > 0);
	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return duplicate;
    }

    public static boolean addCIPMasterLine(String masterLineName, String masterLineDesc, String plcStructureType,
	    String workshopType) throws Exception {
	boolean result = false;
	if (!isCIPMasterLineDuplicate(null, masterLineName)) {
	    CIPMasterLine cml = new CIPMasterLine();
	    cml.setCipMasterLineName(masterLineName);
	    cml.setCipMasterLineDesc(masterLineDesc);
	    cml.setPlcStructureType(plcStructureType);
	    cml.setWorkshopType(workshopType);
	    result = CommonDao.save(cml);
	}
	return result;
    }

    public static boolean editCIPMasterLine(Integer id, String masterLineName, String masterLineDesc,
	    String plcStructureType, String workshopType) throws Exception {
	boolean result = false;
	if (!isCIPMasterLineDuplicate(id, masterLineName)) {
	    CIPMasterLine cml = (CIPMasterLine) CommonDao.getObjById(CIPMasterLine.class, id);
	    if (cml != null) {
		cml.setCipMasterLineName(masterLineName);
		cml.setCipMasterLineDesc(masterLineDesc);
		cml.setPlcStructureType(plcStructureType);
		cml.setWorkshopType(workshopType);
		result = CommonDao.update(cml);
	    }
	}
	return result;
    }

    public static boolean deleteCIPMasterLine(Integer masterLineId) throws Exception {
	boolean result = false;
	CIPMasterLine ml = new CIPMasterLine();
	ml.setId(masterLineId);
	result = CommonDao.delete(ml);
	return result;
    }

    public static boolean isCIPSlaveLineDuplicate(Integer id, String cipSlaveLineName) throws Exception {
	boolean duplicate = false;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria q = s.createCriteria(CIPSlaveLine.class)
		    .add(Restrictions.eq("cipSlaveLineName", cipSlaveLineName));
	    if (id != null) {
		q.add(Restrictions.ne("id", id));
	    }
	    q.setMaxResults(1);
	    @SuppressWarnings({ "unchecked" })
	    List<Object> objList = q.list();
	    t.commit();
	    duplicate = (objList.size() > 0);
	} catch (Exception e) {
	    t.rollback();
	    throw e;
	} finally {
	    s.close();
	}
	return duplicate;
    }

    public static boolean addCIPSlaveLine(String slaveLineName, String slaveLineDesc, Integer masterLineId)
	    throws Exception {
	boolean result = false;
	if (!isCIPSlaveLineDuplicate(null, slaveLineName)) {
	    CIPSlaveLine e = new CIPSlaveLine();
	    e.setCipSlaveLineName(slaveLineName);
	    e.setCipSlaveLineDesc(slaveLineDesc);
	    CIPMasterLine g = (CIPMasterLine) CommonDao.getObjById(CIPMasterLine.class, masterLineId);
	    if (g != null) {
		e.setCipMasterLine(g);
		result = CommonDao.save(e);
	    }
	}
	return result;
    }

    public static boolean editCIPSlaveLine(Integer id, String slaveLineName, String slaveLineDesc, Integer masterLineId)
	    throws Exception {
	boolean result = false;
	if (!isCIPSlaveLineDuplicate(id, slaveLineName)) {
	    CIPSlaveLine e = (CIPSlaveLine) CommonDao.getObjById(CIPSlaveLine.class, id);
	    if (e != null) {
		e.setCipSlaveLineName(slaveLineName);
		e.setCipSlaveLineDesc(slaveLineDesc);
		CIPMasterLine g = (CIPMasterLine) CommonDao.getObjById(CIPMasterLine.class, masterLineId);
		if (g != null) {
		    e.setCipMasterLine(g);
		    result = CommonDao.update(e);
		}
	    }

	}
	return result;
    }

    public static boolean deleteCIPSlaveLine(Integer slaveLineId) throws Exception {
	boolean result = false;
	CIPSlaveLine sl = new CIPSlaveLine();
	sl.setId(slaveLineId);
	result = CommonDao.delete(sl);
	return result;
    }
}
