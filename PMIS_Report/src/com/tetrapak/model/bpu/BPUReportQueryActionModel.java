package com.tetrapak.model.bpu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.config.Constants;
import com.tetrapak.config.PMISConfig;
import com.tetrapak.domain.bpu.BPUReportResult;
import com.tetrapak.domain.bpu.BPUReportStepResult;
import com.tetrapak.hibernate.HU;
import com.tetrapak.metaclass.BPUReportPhaseSummary;
import com.tetrapak.util.common.Tools;

public class BPUReportQueryActionModel {
    @SuppressWarnings("unchecked")
    public static List<BPUReportResult> queryBPUReportResult(String bpuMachineName, String queryStartDate,
	    String queryEndDate, String orderType) throws Exception {
	List<BPUReportResult> bpuReportResultList = new ArrayList<BPUReportResult>();
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    List<Object> objList = null;
	    Criteria c = s.createCriteria(BPUReportResult.class);
	    createBPUReportResultCriteria(c, bpuMachineName, queryStartDate, queryEndDate, orderType);
	    objList = c.list();
	    t.commit();
	    for (Object obj : objList) {
		BPUReportResult bpuReportResult = (BPUReportResult) obj;
		bpuReportResultList.add(bpuReportResult);
	    }
	} catch (Exception e) {
	    if (t != null && t.isActive()) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    s.close();
	}
	return bpuReportResultList;
    }

    public static long queryBPUReportResultCount(String bpuMachineName, String queryStartDate, String queryEndDate)
	    throws Exception {
	Long rowCount = 0L;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(BPUReportResult.class);
	    if (!bpuMachineName.equals(Constants.BPU_REPORT_QUERY_ALL)) {
		c.add(Restrictions.eq("bpuMachineName", bpuMachineName));
	    }
	    c.add(Restrictions.between("bpuProdStartDateTime", Tools.toDate(queryStartDate).getTime(),
		    Tools.toDate(queryEndDate).getTime()));
	    @SuppressWarnings("rawtypes")
	    List result = c.setProjection(Projections.rowCount()).list();
	    if (result.size() > 0) {
		rowCount = (Long) result.get(0);
	    }
	    t.commit();

	} catch (Exception e) {
	    if (t != null && t.isActive()) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    s.close();
	}
	int pageCount = (int) (rowCount / PMISConfig.getBpuReportPageCount());
	if (rowCount % PMISConfig.getBpuReportPageCount() != 0) {
	    pageCount += 1;
	}
	return pageCount;
    }

    @SuppressWarnings("unchecked")
    public static List<BPUReportResult> queryBPUReportResult(String bpuMachineName, String queryStartDate,
	    String queryEndDate, String orderType, int page) throws Exception {
	List<BPUReportResult> bpuReportResultList = new ArrayList<BPUReportResult>();
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    List<Object> objList = null;
	    Criteria c = s.createCriteria(BPUReportResult.class);
	    createBPUReportResultCriteria(c, bpuMachineName, queryStartDate, queryEndDate, orderType);
	    c.setFirstResult((page - 1) * PMISConfig.getBpuReportPageCount());
	    c.setMaxResults(PMISConfig.getBpuReportPageCount());
	    objList = c.list();
	    t.commit();
	    for (Object obj : objList) {
		BPUReportResult bpuReportResult = (BPUReportResult) obj;
		bpuReportResultList.add(bpuReportResult);
	    }
	} catch (Exception e) {
	    if (t != null && t.isActive()) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    s.close();
	}
	return bpuReportResultList;
    }

    private static void createBPUReportResultCriteria(Criteria c, String bpuMachineName, String queryStartDate,
	    String queryEndDate, String orderType) throws ParseException {
	if (!bpuMachineName.equals(Constants.BPU_REPORT_QUERY_ALL)) {
	    c.add(Restrictions.eq("bpuMachineName", bpuMachineName));
	}
	c.add(Restrictions.between("bpuProdStartDateTime", Tools.toDate(queryStartDate).getTime(),
		Tools.toDate(queryEndDate).getTime()));
	if (orderType.equals(Constants.ORDER_BY_DATE_TIME_ASC)) {
	    c.addOrder(Order.asc("bpuProdStartDateTime"));
	} else if (orderType.equals(Constants.ORDER_BY_DATE_TIME_DESC)) {
	    c.addOrder(Order.desc("bpuProdStartDateTime"));
	}
    }

    public static BPUReportResult getBPUReportResult(String uid) throws Exception {
	BPUReportResult bpuReportResult = null;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    @SuppressWarnings("unchecked")
	    List<Object> objList = (List<Object>) s.createCriteria(BPUReportResult.class)
		    .add(Restrictions.eq("bpuReportResultUniqueId", uid)).setMaxResults(1).list();
	    t.commit();
	    if (objList.size() > 0) {
		bpuReportResult = (BPUReportResult) objList.get(0);
	    }
	} catch (Exception e) {
	    if (t != null && t.isActive()) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    s.close();
	}
	return bpuReportResult;
    }

    public static List<BPUReportPhaseSummary> createBPUReportPhaseSummary(
	    List<BPUReportStepResult> bpuReportStepResultList) {
	List<BPUReportPhaseSummary> summaryList = new ArrayList<BPUReportPhaseSummary>();
	int size = bpuReportStepResultList.size();
	if (size > 0) {
	    int i = 0;
	    while (i < size) {
		BPUReportStepResult stepResult = bpuReportStepResultList.get(i);
		Date phaseStartDateTime = stepResult.getStepStartDateTime();
		Date phaseEndDateTime = stepResult.getStepEndDateTime();
		String phaseDesc = stepResult.getStepPhaseStatDesc();
		Integer phaseN = stepResult.getStepPhaseStatN();
		while (i + 1 < size) {
		    BPUReportStepResult currentStepResult = bpuReportStepResultList.get(i);
		    BPUReportStepResult nextStepResult = bpuReportStepResultList.get(i + 1);
		    if (currentStepResult.getStepPhaseStatN().equals(nextStepResult.getStepPhaseStatN())) {
			phaseEndDateTime = nextStepResult.getStepEndDateTime();
			i++;
		    } else {
			phaseEndDateTime = currentStepResult.getStepEndDateTime();
			break;
		    }
		}

		// create summary
		BPUReportPhaseSummary summary = new BPUReportPhaseSummary();
		summary.setPhaseDesc(phaseDesc);
		summary.setPhaseN(phaseN);
		summary.setPhaseStartDateTime(phaseStartDateTime);
		summary.setPhaseEndDateTime(phaseEndDateTime);
		summary.setPhaseLastTime(Tools.dateDiffMinutes(phaseStartDateTime, phaseEndDateTime).getHumanTime());
		summaryList.add(summary);
		i++;
	    }
	}
	return summaryList;
    }
}
