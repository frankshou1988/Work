package com.tetrapak.util.bpu;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.bpu.BPUMachine;
import com.tetrapak.hibernate.HU;

public class BPUMachineUtil {
    public static List<BPUMachine> getBPUMachineList() throws Exception {
	List<BPUMachine> bpuMachineList = new ArrayList<BPUMachine>();
	List<?> objList = CommonDao.getAllObj(BPUMachine.class, "machineName", true);
	for (Object obj : objList) {
	    bpuMachineList.add((BPUMachine) obj);
	}
	return bpuMachineList;
    }

    public static BPUMachine getBPUMachineByName(String bpuMachineName) throws Exception {
	BPUMachine bpuMachine = null;
	Object obj = CommonDao.getObjByUniqueColumn(BPUMachine.class, "machineName", bpuMachineName);
	if (obj != null) {
	    bpuMachine = (BPUMachine) obj;
	}
	return bpuMachine;
    }

    public static boolean isBPUMachineDuplicate(Integer id, String bpuMachineName) throws Exception {
	boolean duplicate = false;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria q = s.createCriteria(BPUMachine.class).add(Restrictions.eq("machineName", bpuMachineName));
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

    public static boolean addBPUMachine(String bpuMachineName, String bpuMachineDesc, String bpuMachineSerialNumber,
	    String machineType) throws Exception {
	boolean result = false;
	if (!isBPUMachineDuplicate(null, bpuMachineName)) {
	    BPUMachine g = new BPUMachine();
	    g.setMachineName(bpuMachineName);
	    g.setMachineDesc(bpuMachineDesc);
	    g.setMachineSerialNumber(bpuMachineSerialNumber);
	    g.setMachineType(machineType);
	    result = CommonDao.save(g);
	}
	return result;
    }

    public static boolean editBPUMachine(Integer bpuMachineId, String bpuMachineName, String bpuMachineDesc,
	    String bpuMachineSerialNumber, String machineType) throws Exception {
	boolean result = false;
	if (!isBPUMachineDuplicate(bpuMachineId, bpuMachineName)) {
	    BPUMachine g = (BPUMachine) CommonDao.getObjById(BPUMachine.class, bpuMachineId);
	    if (g != null) {
		g.setMachineName(bpuMachineName);
		g.setMachineDesc(bpuMachineDesc);
		g.setMachineSerialNumber(bpuMachineSerialNumber);
		g.setMachineType(machineType);
		result = CommonDao.update(g);
	    }
	}
	return result;
    }

    public static boolean deleteBPUMachine(Integer bpuMachineId) throws Exception {
	boolean result = false;
	BPUMachine g = new BPUMachine();
	g.setId(bpuMachineId);
	result = CommonDao.delete(g);
	return result;
    }

    public static boolean saveBPUMachineTag(Integer bpuMachineId, String stepNumberInSQLTag, String phaseStatusInSQLTag)
	    throws Exception {
	boolean result = false;
	BPUMachine g = (BPUMachine) CommonDao.getObjById(BPUMachine.class, bpuMachineId);
	if (g != null) {
	    g.setStepNumberInSQLTag(stepNumberInSQLTag);
	    g.setPhaseStatusInSQLTag(phaseStatusInSQLTag);
	    result = CommonDao.update(g);
	}
	return result;
    }
}
