package com.tetrapak.test;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.tetrapak.config.Constants;
import com.tetrapak.config.PMISConfigLoader;
import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPReportResult;
import com.tetrapak.insql.InSQLDaoUtil;
import com.tetrapak.util.bpu.BPUAlarmReportAnalyseUtil;
import com.tetrapak.util.common.Tools;

public class GetBPUReport {

    /**
     * @param args
     * @throws Exception
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException, Exception {
	// TODO Auto-generated method stub
	// List<?> objList = CommonDao.getAllObjByColumns(CIPReportResult.class,
	// new String[] { "cipStartDateTime" },
	// new Object[] { Tools.toDate("2013-06-26 09:12:01").getTime() }, null,
	// null);
	// System.err.println(objList.size());
	PMISConfigLoader.loadConfig();
	String[] alarmTags = new String[] { "UHT1_ALARM_1", "UHT1_ALARM_2", "UHT1_ALARM_3", "UHT1_ALARM_4",
		"UHT1_ALARM_5", };
	String queryStartDate = "2013-07-16 12:00:00";
	String queryEndDate = "2013-07-17 18:00:00";
	for (String alarmTag : alarmTags) {
	    Map<String, Integer> alarmValueMap = InSQLDaoUtil.getIntValueMap(alarmTag, queryStartDate, queryEndDate);
	    Set<Entry<String, Integer>> entrySet = alarmValueMap.entrySet();
	    for (Entry<String, Integer> entry : entrySet) {
		String key = entry.getKey();// timestamp
		Integer value = entry.getValue();// alarm integer
		// because the alarm in plc 500 is 16bit integer, we only need
		// to test the 16 bits.
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

		    } else {
			// save the alarm start information to database
			// you need to check alarm tag id and the alarm time and
			// the alarm
			// bit
			System.err.println(alarmTag + ", " + key + ", " + bit);
		    }
		    value = value >> 1;
		}
	    }
	}
    }

}
