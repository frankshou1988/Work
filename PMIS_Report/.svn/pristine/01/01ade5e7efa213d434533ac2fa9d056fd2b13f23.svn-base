package com.tetrapak.util.bpu;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.bpu.BPUAnalogTag;
import com.tetrapak.domain.bpu.BPUMachine;
import com.tetrapak.hibernate.HU;

public class BPUAnalogTagUtil {
    public static List<BPUAnalogTag> getBPUAnalogTagListOfBPUMachine(Integer bpuMachineId) throws Exception {
	List<BPUAnalogTag> bpuAnalogTagList = new ArrayList<BPUAnalogTag>();
	List<?> objList = CommonDao.getAllObjByColumnsAndRef(BPUAnalogTag.class, new String[] {}, new Object[] {},
		"bpuMachine", "id", bpuMachineId, "analogTagName", true);
	for (Object obj : objList) {
	    bpuAnalogTagList.add((BPUAnalogTag) obj);
	}
	return bpuAnalogTagList;
    }

    public static boolean isBPUAnalogTagDuplicate(Integer id, String bpuAnalogInsqlTagName) throws Exception {
	boolean duplicate = false;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria q = s.createCriteria(BPUAnalogTag.class).add(
		    Restrictions.eq("analogInsqlTagName", bpuAnalogInsqlTagName));
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
	    if (s != null) {
		s.close();
	    }
	}
	return duplicate;
    }

    public static boolean addAnalogTag(Integer bpuMachineId, String analogTagName, String analogInsqlTagName,
	    String analogTagDesc, String analogTagUnit, String analogTagValueType, Double analogTagValueDividedBy)
	    throws Exception {
	boolean result = false;
	if (!isBPUAnalogTagDuplicate(null, analogInsqlTagName)) {
	    BPUMachine bpuMachine = (BPUMachine) CommonDao.getObjById(BPUMachine.class, bpuMachineId);
	    if (bpuMachine != null) {
		BPUAnalogTag g = new BPUAnalogTag();
		g.setAnalogTagName(analogTagName);
		g.setAnalogInsqlTagName(analogInsqlTagName);
		g.setAnalogTagDesc(analogTagDesc);
		g.setAnalogTagUnit(analogTagUnit);
		g.setAnalogTagValueType(analogTagValueType);
		g.setAnalogTagValueDividedBy(analogTagValueDividedBy);
		g.setBpuMachine(bpuMachine);
		result = CommonDao.save(g);
	    }

	}
	return result;
    }

    public static boolean editAnalogTag(Integer bpuMachineId, Integer analogTagId, String analogTagName,
	    String analogInsqlTagName, String analogTagDesc, String analogTagUnit, String analogTagValueType,
	    Double analogTagValueDividedBy) throws Exception {
	boolean result = false;
	if (!isBPUAnalogTagDuplicate(analogTagId, analogInsqlTagName)) {
	    BPUAnalogTag g = (BPUAnalogTag) CommonDao.getObjById(BPUAnalogTag.class, analogTagId);
	    if (g != null) {
		BPUMachine bpuMachine = (BPUMachine) CommonDao.getObjById(BPUMachine.class, bpuMachineId);
		if (bpuMachine != null) {
		    g.setAnalogTagName(analogTagName);
		    g.setAnalogInsqlTagName(analogInsqlTagName);
		    g.setAnalogTagDesc(analogTagDesc);
		    g.setAnalogTagUnit(analogTagUnit);
		    g.setAnalogTagValueType(analogTagValueType);
		    g.setAnalogTagValueDividedBy(analogTagValueDividedBy);
		    g.setBpuMachine(bpuMachine);
		    result = CommonDao.update(g);
		}
	    }
	}
	return result;
    }

    public static boolean deleteAnalogTag(Integer analogTagId) throws Exception {
	boolean result = false;
	BPUAnalogTag g = new BPUAnalogTag();
	g.setId(analogTagId);
	result = CommonDao.delete(g);
	return result;
    }

    public static boolean saveBPUStandardParam(Integer analogTagId, Double bpuStandardParamMinValue,
	    Double bpuStandardParamMaxValue) throws Exception {
	boolean result = false;
	BPUAnalogTag g = (BPUAnalogTag) CommonDao.getObjById(BPUAnalogTag.class, analogTagId);
	if (g != null) {
	    g.setAnalogStandardMinValue(bpuStandardParamMinValue);
	    g.setAnalogStandardMaxValue(bpuStandardParamMaxValue);
	    result = CommonDao.update(g);
	}
	return result;
    }

}
