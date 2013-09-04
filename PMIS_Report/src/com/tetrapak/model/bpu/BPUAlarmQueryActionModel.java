package com.tetrapak.model.bpu;

import java.text.ParseException;
import java.util.ArrayList;
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
import com.tetrapak.domain.bpu.BPUAlarmReportResult;
import com.tetrapak.hibernate.HU;
import com.tetrapak.util.common.Tools;

public class BPUAlarmQueryActionModel {
    @SuppressWarnings("unchecked")
    public static List<BPUAlarmReportResult> queryBPUAlarmReportResult(Integer bpuMachineId, String queryStartDate,
	    String queryEndDate, String orderType) throws Exception {
	List<BPUAlarmReportResult> bpuAlarmReportResultList = new ArrayList<BPUAlarmReportResult>();
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    List<Object> objList = null;
	    Criteria c = s.createCriteria(BPUAlarmReportResult.class);
	    createBPUAlarmReportResultCriteria(c, bpuMachineId, queryStartDate, queryEndDate, orderType);
	    objList = c.list();
	    t.commit();
	    for (Object obj : objList) {
		BPUAlarmReportResult bpuAlarmReportResult = (BPUAlarmReportResult) obj;
		bpuAlarmReportResultList.add(bpuAlarmReportResult);
	    }
	} catch (Exception e) {
	    if (t != null && t.isActive()) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    s.close();
	}
	return bpuAlarmReportResultList;
    }

    public static long queryBPUAlarmReportResultCount(Integer bpuMachineId, String queryStartDate, String queryEndDate)
	    throws Exception {
	Long rowCount = 0L;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(BPUAlarmReportResult.class);
	    if (!bpuMachineId.equals(Constants.BPU_ALARM_REPORT_QUERY_ALL)) {
		c.add(Restrictions.eq("bpuMachineId", bpuMachineId));
	    }
	    c.add(Restrictions.between("alarmStartDateTime", Tools.toDate(queryStartDate).getTime(),
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
	int pageCount = (int) (rowCount / PMISConfig.getBpuAlarmReportPageCount());
	if (rowCount % PMISConfig.getBpuAlarmReportPageCount() != 0) {
	    pageCount += 1;
	}
	return pageCount;
    }

    @SuppressWarnings("unchecked")
    public static List<BPUAlarmReportResult> queryBPUAlarmReportResult(Integer bpuMachineId, String queryStartDate,
	    String queryEndDate, String orderType, int page) throws Exception {
	List<BPUAlarmReportResult> bpuAlarmReportResultList = new ArrayList<BPUAlarmReportResult>();
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    List<Object> objList = null;
	    Criteria c = s.createCriteria(BPUAlarmReportResult.class);
	    createBPUAlarmReportResultCriteria(c, bpuMachineId, queryStartDate, queryEndDate, orderType);
	    c.setFirstResult((page - 1) * PMISConfig.getBpuAlarmReportPageCount());
	    c.setMaxResults(PMISConfig.getBpuAlarmReportPageCount());
	    objList = c.list();
	    t.commit();
	    for (Object obj : objList) {
		BPUAlarmReportResult bpuAlarmReportResult = (BPUAlarmReportResult) obj;
		bpuAlarmReportResultList.add(bpuAlarmReportResult);
	    }
	} catch (Exception e) {
	    if (t != null && t.isActive()) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    s.close();
	}
	return bpuAlarmReportResultList;
    }

    private static void createBPUAlarmReportResultCriteria(Criteria c, Integer bpuMachineId, String queryStartDate,
	    String queryEndDate, String orderType) throws ParseException {
	if (!bpuMachineId.equals(Constants.BPU_ALARM_REPORT_QUERY_ALL)) {
	    c.add(Restrictions.eq("bpuMachineId", bpuMachineId));
	}
	c.add(Restrictions.between("alarmStartDateTime", Tools.toDate(queryStartDate).getTime(),
		Tools.toDate(queryEndDate).getTime()));
	if (orderType.equals(Constants.ORDER_BY_DATE_TIME_ASC)) {
	    c.addOrder(Order.asc("alarmStartDateTime"));
	} else if (orderType.equals(Constants.ORDER_BY_DATE_TIME_DESC)) {
	    c.addOrder(Order.desc("alarmStartDateTime"));
	}
    }

}
