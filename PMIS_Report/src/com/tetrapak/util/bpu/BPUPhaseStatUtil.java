package com.tetrapak.util.bpu;

import java.util.ArrayList;
import java.util.List;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.bpu.BPUPhaseStat;

public class BPUPhaseStatUtil {
    public static BPUPhaseStat getBPUPhaseStatByPhaseNumber(Integer phaseNumber, String machineType) throws Exception {
	BPUPhaseStat bpuPhaseStat = null;
	Object obj = CommonDao.getObjByColumns(BPUPhaseStat.class, new String[] { "bpuPhaseStatN", "machineType" },
		new Object[] { phaseNumber, machineType }, null, null);
	if (obj != null) {
	    bpuPhaseStat = (BPUPhaseStat) obj;
	}
	return bpuPhaseStat;
    }

    public static List<BPUPhaseStat> getBPUPhaseStatList() throws Exception {
	List<BPUPhaseStat> bpuPhaseStatList = new ArrayList<BPUPhaseStat>();
	List<?> objList = CommonDao.getAllObj(BPUPhaseStat.class, null, null);
	for (Object obj : objList) {
	    bpuPhaseStatList.add((BPUPhaseStat) obj);
	}
	return bpuPhaseStatList;
    }

    public static List<BPUPhaseStat> getBPUPhaseStatOfMachine(String machineType) throws Exception {
	List<BPUPhaseStat> bpuPhaseStatList = new ArrayList<BPUPhaseStat>();
	List<?> objList = CommonDao.getAllObjByColumns(BPUPhaseStat.class, new String[] { "machineType" },
		new Object[] { machineType }, "bpuPhaseStatN", true);
	for (Object obj : objList) {
	    bpuPhaseStatList.add((BPUPhaseStat) obj);
	}
	return bpuPhaseStatList;
    }
}
