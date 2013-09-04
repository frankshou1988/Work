package com.tetrapak.util.bpu;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.bpu.BPUAlarmMsg;
import com.tetrapak.domain.bpu.BPUAlarmReportAnalysePoint;
import com.tetrapak.domain.bpu.BPUAlarmReportResult;
import com.tetrapak.domain.bpu.BPUAlarmTag;
import com.tetrapak.hibernate.HU;
import com.tetrapak.util.common.Tools;

public class BPUAlarmReportAnalyseUtil {
    private static org.slf4j.Logger log = LoggerFactory.getLogger(BPUAlarmReportAnalyseUtil.class);

    public static BPUAlarmReportAnalysePoint getBPUAlarmReportAnalysePointOfAlarmTag(String alarmTagName)
	    throws Exception {
	BPUAlarmReportAnalysePoint analysePoint = null;
	Object obj = CommonDao.getObjByColumnsAndRef(BPUAlarmReportAnalysePoint.class, new String[] {},
		new Object[] {}, "bpuAlarmTag", "alarmTagName", alarmTagName);
	if (obj != null) {
	    analysePoint = (BPUAlarmReportAnalysePoint) obj;
	}
	return analysePoint;
    }

    public static void updateBPUAlarmAnalysePoint(Integer pointId, String latestEndTime) throws Exception {
	BPUAlarmReportAnalysePoint point = (BPUAlarmReportAnalysePoint) CommonDao.getObjById(
		BPUAlarmReportAnalysePoint.class, pointId);
	if (point != null) {
	    point.setBpuAlarmLatestAnalyseDateTime(latestEndTime);
	    CommonDao.update(point);
	}
    }

    public static boolean saveBPUAlarmStartInfo(BPUAlarmTag alarmTag, Integer alarmBit, String alarmStartDateTime)
	    throws Exception {
	boolean result = false;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    @SuppressWarnings("unchecked")
	    List<Object> objList = s
		    .createCriteria(BPUAlarmReportResult.class)
		    .add(Restrictions.eq("alarmTagId", alarmTag.getId()))
		    .add(Restrictions.eq("alarmBit", alarmBit))
		    .add(Restrictions.or(
			    Restrictions.eq("alarmStartDateTime", Tools.toDate(alarmStartDateTime).getTime()),
			    Restrictions.and(Restrictions.isNull("alarmEndDateTime"),
				    Restrictions.isNotNull("alarmStartDateTime"))))
		    .addOrder(Order.desc("alarmStartDateTime")).setMaxResults(1).list();
	    t.commit();
	    if (objList.size() == 0) {
		// create new alarm and save here
		BPUAlarmReportResult bpuAlarmReportResult = new BPUAlarmReportResult();
		bpuAlarmReportResult.setBpuMachineId(alarmTag.getBpuMachine().getId());
		bpuAlarmReportResult.setBpuMachineName(alarmTag.getBpuMachine().getMachineName());
		bpuAlarmReportResult.setBpuMachineDesc(alarmTag.getBpuMachine().getMachineDesc());
		bpuAlarmReportResult.setBpuMachineSerialNumber(alarmTag.getBpuMachine().getMachineSerialNumber());
		bpuAlarmReportResult.setAlarmTagId(alarmTag.getId());
		bpuAlarmReportResult.setAlarmStartDateTime(Tools.toDate(alarmStartDateTime).getTime());
		bpuAlarmReportResult.setAlarmBit(alarmBit);
		BPUAlarmMsg alarmMsg = BPUAlarmMsgUtil.getBPUAlarmMsgByAlarmTagAndAlarmBit(alarmTag.getId(), alarmBit);
		if (alarmMsg != null) {
		    bpuAlarmReportResult.setAlarmMsg(alarmMsg.getAlarmMsgInfo());
		} else {
		    if (log.isErrorEnabled())
			log.error("Alarm Msg NULL for bit " + alarmBit + ", alarmTagId " + alarmTag.getId());
		}
		result = CommonDao.save(bpuAlarmReportResult);
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
	return result;
    }

    public static boolean updateBPUAlarmEndInfo(BPUAlarmTag alarmTag, Integer alarmBit, String alarmEndDateTime)
	    throws Exception {
	boolean result = false;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    @SuppressWarnings("unchecked")
	    List<Object> objList = s.createCriteria(BPUAlarmReportResult.class)
		    .add(Restrictions.eq("alarmTagId", alarmTag.getId())).add(Restrictions.eq("alarmBit", alarmBit))
		    .add(Restrictions.isNotNull("alarmStartDateTime")).add(Restrictions.isNull("alarmEndDateTime"))
		    .addOrder(Order.desc("alarmStartDateTime")).setMaxResults(1).list();
	    t.commit();
	    if (objList.size() > 0) {
		BPUAlarmReportResult bpuAlarmReportResult = (BPUAlarmReportResult) objList.get(0);
		bpuAlarmReportResult.setAlarmEndDateTime(Tools.toDate(alarmEndDateTime).getTime());
		bpuAlarmReportResult.setAlarmLastTime(Tools.dateDiffMinutes(
			Tools.toDateStr(bpuAlarmReportResult.getAlarmStartDateTime()), alarmEndDateTime, true)
			.getHumanTime());
		result = CommonDao.update(bpuAlarmReportResult);
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
	return result;
    }
}
