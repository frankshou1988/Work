package com.tetrapak.util.bpu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.bpu.BPUReportAnalysePoint;
import com.tetrapak.domain.bpu.BPUReportResult;
import com.tetrapak.domain.bpu.BPUReportStepResult;
import com.tetrapak.hibernate.HU;
import com.tetrapak.insql.InSQLDao;
import com.tetrapak.metaclass.TagQueryUtil;

public class BPUReportAnalyseUtil {
    /**
     * Get the datetime of those steps=0
     * */
    public static List<String> getBPUSectionList(String bpuStepNTag, String queryStartDateTime, String queryEndDateTime)
	    throws Exception {
	List<String> sectionList = new ArrayList<String>();
	String query = TagQueryUtil.createDeltaQuery(bpuStepNTag, queryStartDateTime, queryEndDateTime, 0);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	while (rs.next()) {
	    String timestamp = TagQueryUtil.formatDate(rs.getString("DateTime"));
	    sectionList.add(timestamp);
	}
	con.close();
	return sectionList;
    }

    /**
     * Get latest bpu report analyse point
     * */
    public static BPUReportAnalysePoint getBPUReportAnalysePointOfBPUMachine(String bpuMachineName) throws Exception {
	BPUReportAnalysePoint analysePoint = null;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    @SuppressWarnings("unchecked")
	    List<Object> objList = s.createCriteria(BPUReportAnalysePoint.class).createCriteria("bpuMachine")
		    .add(Restrictions.eq("machineName", bpuMachineName)).setMaxResults(1).list();
	    t.commit();
	    if (objList.size() > 0) {
		analysePoint = (BPUReportAnalysePoint) objList.get(0);
	    }
	} catch (Exception e) {
	    if (t != null && t.isActive()) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    s.close();
	}
	return analysePoint;
    }

    /**
     * Update the bpu report latest analyse time
     * */
    public static void updateBPUReportAnalysePoint(Integer pointId, String latestEndTime) throws Exception {
	BPUReportAnalysePoint point = (BPUReportAnalysePoint) CommonDao
		.getObjById(BPUReportAnalysePoint.class, pointId);
	if (point != null) {
	    point.setBpuReportLatestAnalyseDateTime(latestEndTime);
	    CommonDao.update(point);
	}
    }

    public static boolean saveBPUReportResult(BPUReportResult bpuReportResult) throws Exception {
	boolean result = false;
	List<?> objList = CommonDao.checkObjDuplicate(BPUReportResult.class, "bpuMachineId",
		bpuReportResult.getBpuMachineId(), "bpuProdStartDateTime", bpuReportResult.getBpuProdStartDateTime(),
		"bpuProdEndDateTime", bpuReportResult.getBpuProdEndDateTime());
	if (objList.size() == 0) {
	    // create new alarm and save here
	    result = CommonDao.save(bpuReportResult);
	}
	return result;
    }

    public static boolean saveBPUReportStepResult(BPUReportStepResult bpuReportStepResult) throws Exception {
	boolean result = false;
	List<?> objList = CommonDao.checkObjDuplicate(BPUReportStepResult.class, "bpuReportResultUniqueId",
		bpuReportStepResult.getBpuReportResultUniqueId(), "stepN", bpuReportStepResult.getStepN(),
		"stepStartDateTime", bpuReportStepResult.getStepStartDateTime(), "stepEndDateTime",
		bpuReportStepResult.getStepEndDateTime());
	if (objList.size() == 0) {
	    // create new alarm and save here
	    result = CommonDao.save(bpuReportStepResult);
	}
	return result;
    }
}
