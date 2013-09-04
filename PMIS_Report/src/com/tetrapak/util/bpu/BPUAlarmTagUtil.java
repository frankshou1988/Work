package com.tetrapak.util.bpu;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.bpu.BPUAlarmTag;
import com.tetrapak.domain.bpu.BPUMachine;
import com.tetrapak.hibernate.HU;

public class BPUAlarmTagUtil {
    public static List<BPUAlarmTag> getBPUAlarmTagList() throws Exception {
	List<BPUAlarmTag> bpuAlarmTagList = new ArrayList<BPUAlarmTag>();
	List<?> objList = CommonDao.getAllObj(BPUAlarmTag.class, "alarmTagName", true);
	for (Object obj : objList) {
	    bpuAlarmTagList.add((BPUAlarmTag) obj);
	}
	return bpuAlarmTagList;
    }

    public static List<BPUAlarmTag> getBPUAlarmTagListOfBPUMachine(Integer bpuMachineId) throws Exception {
	List<BPUAlarmTag> bpuAlarmTagList = new ArrayList<BPUAlarmTag>();
	List<?> objList = CommonDao.getAllObjByColumnsAndRef(BPUAlarmTag.class, new String[] {}, new Object[] {},
		"bpuMachine", "id", bpuMachineId, "alarmTagName", true);
	for (Object obj : objList) {
	    bpuAlarmTagList.add((BPUAlarmTag) obj);
	}
	return bpuAlarmTagList;
    }

    public static boolean isBPUAlarmTagDuplicate(Integer id, String bpuAlarmInsqlTagName) throws Exception {
	boolean duplicate = false;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria q = s.createCriteria(BPUAlarmTag.class).add(
		    Restrictions.eq("alarmInsqlTagName", bpuAlarmInsqlTagName));
	    if (id != null) {
		q.add(Restrictions.ne("id", id));
	    }
	    q.setMaxResults(1);
	    @SuppressWarnings({ "unchecked" })
	    List<Object> objList = q.list();
	    t.commit();
	    duplicate = (objList.size() > 0);
	} catch (Exception e) {
	    if (t != null && t.isActive()) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null && s.isOpen()) {
		s.close();
	    }
	}
	return duplicate;
    }

    public static boolean addAlarmTag(Integer bpuMachineId, String alarmTagName, String alarmInsqlTagName,
	    String alarmTagDesc) throws Exception {
	boolean result = false;
	if (!isBPUAlarmTagDuplicate(null, alarmInsqlTagName)) {
	    BPUMachine bpuMachine = (BPUMachine) CommonDao.getObjById(BPUMachine.class, bpuMachineId);
	    if (bpuMachine != null) {
		BPUAlarmTag g = new BPUAlarmTag();
		g.setAlarmTagName(alarmTagName);
		g.setAlarmInsqlTagName(alarmInsqlTagName);
		g.setAlarmTagDesc(alarmTagDesc);
		g.setBpuMachine(bpuMachine);
		result = CommonDao.save(g);
	    }

	}
	return result;
    }

    public static boolean editAlarmTag(Integer bpuMachineId, Integer alarmTagId, String alarmTagName,
	    String alarmInsqlTagName, String alarmTagDesc) throws Exception {
	boolean result = false;
	if (!isBPUAlarmTagDuplicate(alarmTagId, alarmInsqlTagName)) {
	    BPUAlarmTag g = (BPUAlarmTag) CommonDao.getObjById(BPUAlarmTag.class, alarmTagId);
	    if (g != null) {
		BPUMachine bpuMachine = (BPUMachine) CommonDao.getObjById(BPUMachine.class, bpuMachineId);
		if (bpuMachine != null) {
		    g.setAlarmTagName(alarmTagName);
		    g.setAlarmInsqlTagName(alarmInsqlTagName);
		    g.setAlarmTagDesc(alarmTagDesc);
		    g.setBpuMachine(bpuMachine);
		    result = CommonDao.update(g);
		}
	    }
	}
	return result;
    }

    public static boolean deleteAlarmTag(Integer alarmTagId) throws Exception {
	boolean result = false;
	BPUAlarmTag g = new BPUAlarmTag();
	g.setId(alarmTagId);
	result = CommonDao.delete(g);
	return result;
    }

}
