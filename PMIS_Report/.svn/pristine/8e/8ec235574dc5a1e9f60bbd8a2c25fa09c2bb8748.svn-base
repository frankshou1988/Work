package com.tetrapak.model.bpu;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.bpu.BPUReportStepResult;
import com.tetrapak.hibernate.HU;
import com.tetrapak.util.common.Tools;

public class BPUReportStepQueryActionModel {
    public static List<BPUReportStepResult> getBPUReportStepResult(String uid) throws Exception {
	List<BPUReportStepResult> bpuReportStepResultList = new ArrayList<BPUReportStepResult>();
	List<?> objList = CommonDao.getAllObjByColumns(BPUReportStepResult.class,
		new String[] { "bpuReportResultUniqueId" }, new Object[] { uid }, "stepStartDateTime", true);
	for (Object obj : objList) {
	    bpuReportStepResultList.add((BPUReportStepResult) obj);
	}
	return bpuReportStepResultList;
    }

    public static List<BPUReportStepResult> queryBPUReportStepResult(String bpuMachineName, String queryStartDate,
	    String queryEndDate, int phaseID) throws Exception {
	List<BPUReportStepResult> bpuReportStepResultList = new ArrayList<BPUReportStepResult>();
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    @SuppressWarnings("unchecked")
	    List<Object> objList = (List<Object>) s
		    .createCriteria(BPUReportStepResult.class)
		    .add(Restrictions.eq("bpuMachineName", bpuMachineName))
		    .add(Restrictions.eq("stepPhaseStatN", phaseID))
		    .add(Restrictions.between("stepStartDateTime", Tools.toDate(queryStartDate).getTime(), Tools
			    .toDate(queryEndDate).getTime())).list();
	    t.commit();
	    for (Object obj : objList) {
		bpuReportStepResultList.add((BPUReportStepResult) obj);
	    }
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
	return bpuReportStepResultList;
    }
}
