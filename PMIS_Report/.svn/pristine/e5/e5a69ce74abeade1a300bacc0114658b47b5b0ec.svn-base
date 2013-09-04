package com.tetrapak.model.systemsettings.cip;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPTarget;
import com.tetrapak.domain.cip.CIPTargetGroup;
import com.tetrapak.hibernate.HU;

public class CIPTargetSettingModel {
    public static boolean isCIPTargetGroupDuplicate(Integer id, String cipTargetGroupName) throws Exception {
	boolean duplicate = false;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria q = s.createCriteria(CIPTargetGroup.class).add(
		    Restrictions.eq("cipTargetGroupName", cipTargetGroupName));
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

    public static boolean addCIPTargetGroup(String targetGroupName, String targetGroupDesc, String workshopType)
	    throws Exception {
	boolean result = false;
	if (!isCIPTargetGroupDuplicate(null, targetGroupName)) {
	    CIPTargetGroup cml = new CIPTargetGroup();
	    cml.setCipTargetGroupName(targetGroupName);
	    cml.setCipTargetGroupDesc(targetGroupDesc);
	    cml.setWorkshopType(workshopType);
	    result = CommonDao.save(cml);
	}
	return result;
    }

    public static boolean editCIPTargetGroup(Integer id, String targetGroupName, String targetGroupDesc,
	    String workshopType) throws Exception {
	boolean result = false;
	if (!isCIPTargetGroupDuplicate(id, targetGroupName)) {
	    CIPTargetGroup cml = (CIPTargetGroup) CommonDao.getObjById(CIPTargetGroup.class, id);
	    if (cml != null) {
		cml.setCipTargetGroupName(targetGroupName);
		cml.setCipTargetGroupDesc(targetGroupDesc);
		cml.setWorkshopType(workshopType);
		result = CommonDao.update(cml);
	    }
	}
	return result;
    }

    public static boolean deleteCIPTargetGroup(Integer targetGroupId) throws Exception {
	boolean result = false;
	CIPTargetGroup tg = new CIPTargetGroup();
	tg.setId(targetGroupId);
	result = CommonDao.delete(tg);
	return result;
    }

    public static boolean isCIPTargetDuplicate(Integer id, String cipTargetName) throws Exception {
	boolean duplicate = false;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria q = s.createCriteria(CIPTarget.class).add(Restrictions.eq("cipTargetName", cipTargetName));
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

    public static boolean deleteCIPTarget(Integer targetId) throws Exception {
	boolean result = false;
	CIPTarget target = new CIPTarget();
	target.setId(targetId);
	result = CommonDao.delete(target);
	return result;
    }

    public static boolean addCIPTarget(String cipTargetName, String cipTargetDesc, Integer cipTargetGroupId)
	    throws Exception {
	boolean result = false;
	if (!isCIPTargetDuplicate(null, cipTargetName)) {
	    CIPTarget e = new CIPTarget();
	    e.setCipTargetName(cipTargetName);
	    e.setCipTargetDesc(cipTargetDesc);
	    CIPTargetGroup g = (CIPTargetGroup) CommonDao.getObjById(CIPTargetGroup.class, cipTargetGroupId);
	    if (g != null) {
		e.setCipTargetGroup(g);
		result = CommonDao.save(e);
	    }
	}
	return result;
    }

    public static boolean editCIPTarget(Integer id, String cipTargetName, String cipTargetDesc, Integer cipTargetGroupId)
	    throws Exception {
	boolean result = false;
	if (!isCIPTargetDuplicate(id, cipTargetName)) {
	    CIPTarget e = (CIPTarget) CommonDao.getObjById(CIPTarget.class, id);
	    if (e != null) {
		e.setCipTargetName(cipTargetName);
		e.setCipTargetDesc(cipTargetDesc);
		CIPTargetGroup g = (CIPTargetGroup) CommonDao.getObjById(CIPTargetGroup.class, cipTargetGroupId);
		if (g != null) {
		    e.setCipTargetGroup(g);
		    result = CommonDao.update(e);
		}
	    }
	}
	return result;
    }

}
