package com.tetrapak.util.bpu;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.tetrapak.config.Constants;
import com.tetrapak.domain.bpu.BPUAlarmReportAnalysePoint;
import com.tetrapak.domain.bpu.BPUAlarmTag;
import com.tetrapak.insql.InSQLDaoUtil;
import com.tetrapak.util.common.Tools;

public class BPUAlarmReportAnalyser {
    public static void bpuAlarmReportAnalyse() throws Exception {
	String queryEndDate = Tools.toDateStr(new Date());
	List<BPUAlarmTag> bpuAlarmTagList = BPUAlarmTagUtil.getBPUAlarmTagList();
	for (BPUAlarmTag alarmTag : bpuAlarmTagList) {
	    String latestAlarmEndTime = "";
	    BPUAlarmReportAnalysePoint point = BPUAlarmReportAnalyseUtil
		    .getBPUAlarmReportAnalysePointOfAlarmTag(alarmTag.getAlarmTagName());
	    String queryStartDate = point.getBpuAlarmLatestAnalyseDateTime();
	    Map<String, Long> alarmValueMap = InSQLDaoUtil.getLongValueMap(alarmTag.getAlarmInsqlTagName(),
		    queryStartDate, queryEndDate);
	    Set<Entry<String, Long>> entrySet = alarmValueMap.entrySet();
	    for (Entry<String, Long> entry : entrySet) {
		String key = entry.getKey();// timestamp
		Long value = entry.getValue();// alarm integer
		for (int bit = 0; bit < Constants.INT_BIT_16; bit++) {
		    // use 0x00000001 to and with value and test whether it is
		    // 0.
		    long j = 0x00000001 & value;
		    if (j == 0) {
			// update the alarm stop information of records in
			// database
			// check latest machine id,alarm time and alarm bit and
			// alarm stop
			// date time is null
			BPUAlarmReportAnalyseUtil.updateBPUAlarmEndInfo(alarmTag, bit, key);
		    } else {
			// save the alarm start information to database
			// you need to check alarm tag id and the alarm time and
			// the alarm
			// bit
			BPUAlarmReportAnalyseUtil.saveBPUAlarmStartInfo(alarmTag, bit, key);
		    }
		    value = value >> 1;
		}
		latestAlarmEndTime = key;
	    }

	    // update the latest analyze time to last alarm time
	    if (!latestAlarmEndTime.isEmpty()) {
		BPUAlarmReportAnalyseUtil.updateBPUAlarmAnalysePoint(point.getId(), latestAlarmEndTime);
	    }
	}
    }
}
