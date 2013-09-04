package com.tetrapak.util.cip;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPTarget;
import com.tetrapak.domain.cip.CIPTargetGroup;
import com.tetrapak.hibernate.HU;

public class CIPTargetUtil {
    public static List<CIPTargetGroup> getCIPTargetGroupList() throws Exception {
	List<CIPTargetGroup> targetGroupList = new ArrayList<CIPTargetGroup>();
	List<?> objList = CommonDao.getAllObj(CIPTargetGroup.class, "cipTargetGroupName", true);
	for (Object obj : objList) {
	    targetGroupList.add((CIPTargetGroup) obj);
	}
	return targetGroupList;
    }

    public static List<CIPTarget> getCIPTargetList() throws Exception {
	List<CIPTarget> targetList = new ArrayList<CIPTarget>();
	List<?> objList = CommonDao.getAllObj(CIPTarget.class, "cipTargetName", true);
	for (Object obj : objList) {
	    targetList.add((CIPTarget) obj);
	}
	return targetList;
    }

    public static List<CIPTarget> getCIPTargetListOfWorkshop(String workshopTypeName) throws Exception {
	List<CIPTarget> cipTargetList = new ArrayList<CIPTarget>();
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(CIPTarget.class).createCriteria("cipTargetGroup")
		    .add(Restrictions.eq("workshopType", workshopTypeName));
	    List<?> objList = c.list();
	    t.commit();
	    for (Object obj : objList) {
		cipTargetList.add((CIPTarget) obj);
	    }

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
	return cipTargetList;
    }

    public static List<CIPTarget> getTargetListByGroupId(Integer targetGroupId) throws Exception {
	List<CIPTarget> targetList = new ArrayList<CIPTarget>();
	List<?> objList = CommonDao.getAllObjByColumnsAndRef(CIPTarget.class, new String[] {}, new Object[] {},
		"cipTargetGroup", "id", targetGroupId, "cipTargetName", true);
	for (Object obj : objList) {
	    targetList.add((CIPTarget) obj);
	}
	return targetList;
    }
}
