package com.tetrapak.util.cip;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.domain.cip.CIPPhase;
import com.tetrapak.hibernate.HU;

public class CIPPhaseUtil {

    public static boolean isPhaseExist(String phaseName, Long phaseID) throws Exception {
	boolean result = false;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    @SuppressWarnings("unchecked")
	    List<Object> objList = s.createCriteria(CIPPhase.class)
		    .add(Restrictions.or(Restrictions.eq("phaseName", phaseName), Restrictions.eq("phaseID", phaseID)))
		    .list();
	    t.commit();
	    if (objList.size() > 0) {
		result = true;
	    }
	} catch (Exception e) {
	    t.rollback();
	    throw e;
	} finally {
	    s.close();
	}
	return result;
    }

    public static List<CIPPhase> getCIPPhaseList() throws Exception {
	List<CIPPhase> cipPhaseList = new ArrayList<CIPPhase>();
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    @SuppressWarnings("unchecked")
	    List<Object> objList = s.createCriteria(CIPPhase.class).addOrder(Order.asc("phaseName")).list();
	    t.commit();
	    for (Object obj : objList) {
		cipPhaseList.add((CIPPhase) obj);
	    }
	} catch (Exception e) {
	    t.rollback();
	    throw e;
	} finally {
	    s.close();
	}
	return cipPhaseList;
    }
}
