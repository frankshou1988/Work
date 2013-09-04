package com.tetrapak.util.bpu;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.bpu.BPUStepN;

public class BPUStepNUtil {
    public static BPUStepN getBPUStepNByStep(Integer step, String machineType) throws Exception {
	BPUStepN bpuStepN = null;
	Object obj = CommonDao.getObjByColumns(BPUStepN.class, new String[] { "bpuStepN", "machineType" },
		new Object[] { step, machineType });
	if (obj != null) {
	    bpuStepN = (BPUStepN) obj;
	}
	return bpuStepN;

    }
}
