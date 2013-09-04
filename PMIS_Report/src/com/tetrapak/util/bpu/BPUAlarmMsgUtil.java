package com.tetrapak.util.bpu;

import java.util.ArrayList;
import java.util.List;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.bpu.BPUAlarmMsg;
import com.tetrapak.domain.bpu.BPUAlarmTag;

public class BPUAlarmMsgUtil {
    public static List<BPUAlarmMsg> getAlarmMsgOfAlarmTag(Integer alarmTagId) throws Exception {
	List<BPUAlarmMsg> bpuAlarmTagList = new ArrayList<BPUAlarmMsg>();
	List<?> objList = CommonDao.getAllObjByColumnsAndRef(BPUAlarmMsg.class, new String[] {}, new Object[] {},
		"bpuAlarmTag", "id", alarmTagId, "alarmMsgBit", true);
	for (Object obj : objList) {
	    bpuAlarmTagList.add((BPUAlarmMsg) obj);
	}
	return bpuAlarmTagList;

    }

    public static boolean addAlarmMsg(Integer alarmTagId, Integer alarmMsgBit, String alarmMsgInfo) throws Exception {
	boolean result = false;
	BPUAlarmTag bpuAlarmTag = (BPUAlarmTag) CommonDao.getObjById(BPUAlarmTag.class, alarmTagId);
	if (bpuAlarmTag != null) {
	    BPUAlarmMsg g = new BPUAlarmMsg();
	    g.setAlarmMsgBit(alarmMsgBit);
	    g.setAlarmMsgInfo(alarmMsgInfo);
	    g.setBpuAlarmTag(bpuAlarmTag);
	    result = CommonDao.save(g);
	}
	return result;

    }

    public static boolean editAlarmMsg(Integer alarmMsgId, Integer alarmTagId, Integer alarmMsgBit, String alarmMsgInfo)
	    throws Exception {
	boolean result = false;
	BPUAlarmMsg g = (BPUAlarmMsg) CommonDao.getObjById(BPUAlarmMsg.class, alarmMsgId);
	if (g != null) {
	    BPUAlarmTag bpuAlarmTag = (BPUAlarmTag) CommonDao.getObjById(BPUAlarmTag.class, alarmTagId);
	    if (bpuAlarmTag != null) {
		g.setAlarmMsgBit(alarmMsgBit);
		g.setAlarmMsgInfo(alarmMsgInfo);
		g.setBpuAlarmTag(bpuAlarmTag);
		result = CommonDao.update(g);
	    }
	}
	return result;
    }

    public static boolean deleteAlarmMsg(Integer alarmMsgId) throws Exception {
	boolean result = false;
	BPUAlarmMsg g = new BPUAlarmMsg();
	g.setId(alarmMsgId);
	result = CommonDao.delete(g);
	return result;
    }

    public static BPUAlarmMsg getBPUAlarmMsgByAlarmTagAndAlarmBit(Integer alarmTagId, Integer alarmBit)
	    throws Exception {
	BPUAlarmMsg alarmMsg = null;
	Object obj = CommonDao.getObjByColumnsAndRef(BPUAlarmMsg.class, new String[] { "alarmMsgBit" },
		new Object[] { alarmBit }, "bpuAlarmTag", "id", alarmTagId);
	if (obj != null) {
	    alarmMsg = (BPUAlarmMsg) obj;
	}
	return alarmMsg;
    }
}
