package com.tetrapak.util.cip;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPMasterLine;
import com.tetrapak.domain.cip.CIPSlaveLine;
import com.tetrapak.hibernate.HU;
import com.tetrapak.metaclass.PLCStructureTypes;

public class CIPLineUtil {

    public static List<CIPMasterLine> getCIPMasterLineList() throws Exception {
	List<?> objAllList = CommonDao.getAllObj(CIPMasterLine.class, "cipMasterLineName", true);
	List<CIPMasterLine> cipMasterLineList = new ArrayList<CIPMasterLine>();
	for (Object obj : objAllList) {
	    cipMasterLineList.add((CIPMasterLine) obj);
	}
	return cipMasterLineList;
    }

    public static List<CIPMasterLine> getCIPMasterLineListOfWorkshop(String workshopTypeName) throws Exception {
	List<?> objAllList = CommonDao.getAllObjByColumns(CIPMasterLine.class, new String[] { "workshopType" },
		new Object[] { workshopTypeName }, "cipMasterLineName", true);
	List<CIPMasterLine> cipMasterLineList = new ArrayList<CIPMasterLine>();
	for (Object obj : objAllList) {
	    cipMasterLineList.add((CIPMasterLine) obj);
	}
	return cipMasterLineList;
    }

    public static List<CIPMasterLine> getCIPMasterLineOfTPM6() throws Exception {
	List<?> objAllList = CommonDao.getAllObjByColumns(CIPMasterLine.class, new String[] { "plcStructureType" },
		new Object[] { PLCStructureTypes.TPM6 }, "cipMasterLineName", true);
	List<CIPMasterLine> cipMasterLineList = new ArrayList<CIPMasterLine>();
	for (Object obj : objAllList) {
	    cipMasterLineList.add((CIPMasterLine) obj);
	}
	return cipMasterLineList;
    }

    public static List<CIPMasterLine> getCIPMasterLineOfTPM5() throws Exception {
	List<?> objAllList = CommonDao.getAllObjByColumns(CIPMasterLine.class, new String[] { "plcStructureType" },
		new Object[] { PLCStructureTypes.TPM5 }, "cipMasterLineName", true);
	List<CIPMasterLine> cipMasterLineList = new ArrayList<CIPMasterLine>();
	for (Object obj : objAllList) {
	    cipMasterLineList.add((CIPMasterLine) obj);
	}
	return cipMasterLineList;
    }

    public static List<CIPMasterLine> getCIPMasterLineOfTPM4() throws Exception {
	List<?> objAllList = CommonDao.getAllObjByColumns(CIPMasterLine.class, new String[] { "plcStructureType" },
		new Object[] { PLCStructureTypes.TPM4 }, "cipMasterLineName", true);
	List<CIPMasterLine> cipMasterLineList = new ArrayList<CIPMasterLine>();
	for (Object obj : objAllList) {
	    cipMasterLineList.add((CIPMasterLine) obj);
	}
	return cipMasterLineList;
    }

    public static List<CIPSlaveLine> getCIPSlaveLineListByMasterLineId(Integer masterLineId) throws Exception {
	List<?> objList = CommonDao.getAllObjByColumnsAndRef(CIPSlaveLine.class, new String[] {}, new Object[] {},
		"cipMasterLine", "id", masterLineId, "cipSlaveLineName", true);
	List<CIPSlaveLine> cipSlaveLineList = new ArrayList<CIPSlaveLine>();
	for (Object obj : objList) {
	    cipSlaveLineList.add((CIPSlaveLine) obj);
	}
	return cipSlaveLineList;
    }

    public static List<CIPMasterLine> getCIPMasterLineList(List<Integer> cipMasterLineIdList) throws Exception {
	List<CIPMasterLine> cipMasterLineList = new ArrayList<CIPMasterLine>();
	if (!cipMasterLineIdList.isEmpty()) {
	    SessionFactory sf = HU.getSessionFactory();
	    Session s = sf.openSession();
	    Transaction t = null;
	    try {
		t = s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Object> objList = s.createCriteria(CIPMasterLine.class)
			.add(Restrictions.in("id", cipMasterLineIdList)).addOrder(Order.asc("cipMasterLineName"))
			.list();
		t.commit();
		for (Object obj : objList) {
		    cipMasterLineList.add((CIPMasterLine) obj);
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
	}
	return cipMasterLineList;
    }

}
