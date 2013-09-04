package com.tetrapak.util.common;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import sun.misc.BASE64Encoder;

import com.tetrapak.config.Constants;
import com.tetrapak.config.PMISConfig;
import com.tetrapak.metaclass.PeriodLastTime;

public class Tools {
    /**
     * Convert from format y-m-d H:I:S to milliseconds plus 28800000
     * 
     * @throws ParseException
     * */
    public static String toFlotTimestamp(String dateTime) throws ParseException {
	DateFormat f = new SimpleDateFormat("y-M-d H:m:s");
	Date date = f.parse(dateTime);
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	long millis = c.getTimeInMillis();
	millis += 28800000;
	return millis + "";
    }

    public static Calendar toDate(String dateTimeStr) throws ParseException {
	DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = f.parse(dateTimeStr);
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	return c;
    }

    public static String toDateStr(Date date) {
	String result = "";
	if (date != null) {
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    result = f.format(date);
	}
	return result;
    }

    /**
     * Get the minutes diff between two date
     * */
    public static PeriodLastTime dateDiffMinutes(String dateStrA, String dateStrB) throws ParseException {
	DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date dateA = f.parse(dateStrA);
	Date dateB = f.parse(dateStrB);
	return dateDiffMinutes(dateA, dateB);
    }

    public static PeriodLastTime dateDiffMinutes(Date dateA, Date dateB) {
	Calendar dateCA = Calendar.getInstance();
	dateCA.setTime(dateA);
	Calendar dateCB = Calendar.getInstance();
	dateCB.setTime(dateB);
	long diffInMillis = Math.abs(dateCA.getTimeInMillis() - dateCB.getTimeInMillis());
	PeriodLastTime cipLastTime = new PeriodLastTime();
	long diffInSeconds = diffInMillis / 1000;
	int hours = (int) (diffInSeconds / 3600);
	int minutes = (int) ((diffInSeconds - hours * 3600) / 60);
	int seconds = (int) (diffInSeconds - hours * 3600 - minutes * 60);
	cipLastTime.setHours(hours);
	cipLastTime.setMinutes(minutes);
	cipLastTime.setSeconds(seconds);
	return cipLastTime;
    }

    public static PeriodLastTime dateDiffMinutes(String from, String to, boolean checkNull) throws ParseException {
	if (checkNull) {
	    if (from == null || to == null) {
		return new PeriodLastTime();
	    }
	}
	return dateDiffMinutes(from, to);
    }

    public static String getUTF8Text(String i18nText) throws UnsupportedEncodingException {
	return new String(i18nText.getBytes("ISO-8859-1"), "UTF-8");
    }

    public static String getValue(Object fromValue) {
	String result = null;
	if (fromValue == null) {
	    result = "";
	} else {
	    result = fromValue.toString();
	}
	return result;
    }

    public static String like(String from) {
	return new StringBuilder("%").append(from).append("%").toString();
    }

    public static Calendar addUpdateInterval(Calendar c) {
	c.add(Calendar.SECOND, PMISConfig.getDaserverUpdateInterval());
	return c;
    }

    public static Calendar minusUpdateInterval(Calendar c) {
	c.add(Calendar.SECOND, -PMISConfig.getDaserverUpdateInterval());
	return c;
    }

    public static String addUpdateInterval(String fromDate) throws ParseException {
	return Tools.toDateStr(Tools.addUpdateInterval(Tools.toDate(fromDate)).getTime());
    }

    public static String minusUpdateInterval(String fromDate) throws ParseException {
	return Tools.toDateStr(Tools.minusUpdateInterval(Tools.toDate(fromDate)).getTime());
    }

    public static double parseDouble(String value) {
	Double result = 0d;
	if (value != null) {
	    result = Double.parseDouble(value);
	}
	return result;
    }

    public static double formatDoubleFourOutFiveIn(double v) {
	DecimalFormat df = new DecimalFormat("######0.00");
	return Double.parseDouble(df.format(v));
    }

    public static String createBPUReportUniqueId(String machineName) {
	long millis = System.currentTimeMillis();
	StringBuilder sb = new StringBuilder();
	sb.append(millis);
	sb.append(machineName);
	BASE64Encoder base64en = new BASE64Encoder();
	String to = base64en.encode(sb.toString().getBytes());
	return to.substring(0, to.length() - 1);
    }

    /*public static Integer getBPUStat(int phaseStat) {
	int m = 0x00000fff;
	return m & phaseStat;
    }

    public static Integer getBPUPhase(int stat) {
	int result = 0;
	if (stat == 11) {
	    result = (int) Math.pow(2, stat);
	} else {
	    result = 0x00001000 | stat;
	}
	return result;
    }
     */
    public static int getBPUParamTableCount(int tagCount) {
	int re = tagCount % Constants.BPU_PARAM_REPORT_COLS;
	int div = tagCount / Constants.BPU_PARAM_REPORT_COLS;
	return (re == 0) ? div : div + 1;
    }

    public static String createErrorMsg(String msg) {
	return "[JEMYDEBUG]:" + msg;

    }

}
