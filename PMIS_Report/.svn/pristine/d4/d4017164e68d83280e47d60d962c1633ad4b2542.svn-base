package com.tetrapak.insql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.tetrapak.config.Constants;
import com.tetrapak.config.PMISConfig;
import com.tetrapak.insql.InSQLDao;
import com.tetrapak.metaclass.EdgeSection;
import com.tetrapak.metaclass.EdgeStack;
import com.tetrapak.metaclass.TagQueryUtil;
import com.tetrapak.metaclass.TimePeriod;
import com.tetrapak.util.common.Tools;

public class InSQLDaoUtil {
    /**
     * Get Edge Section List
     * */
    public static List<EdgeSection> getEdgeSectionList(String tagName, String queryStartDateTime,
	    String queryEndDateTime) throws SQLException, ClassNotFoundException, IOException {
	List<EdgeSection> edgeSectionList = new ArrayList<EdgeSection>();
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	String query = TagQueryUtil.createDeltaQuery(tagName, queryStartDateTime, queryEndDateTime);
	ResultSet rs = stat.executeQuery(query);
	List<String> dateTimeList = new ArrayList<String>();
	List<Integer> valueList = new ArrayList<Integer>();

	while (rs.next()) {
	    String dateTime = rs.getString("DateTime");
	    int value = rs.getInt("vValue");
	    String fmtedDateTime = TagQueryUtil.formatDate(dateTime);
	    // int fmtedValue = TagQueryUtil.formatInteger(value);
	    int fmtedValue = value;
	    dateTimeList.add(fmtedDateTime);
	    valueList.add(fmtedValue);
	}
	rs.close();
	stat.close();
	con.close();

	// filter out the edge
	EdgeStack startStack = new EdgeStack();
	int size = dateTimeList.size();

	for (int i = 0; i < size; i++) {
	    int value = valueList.get(i);
	    if (value == Constants.EDGE_ZERO) {
		if (!startStack.isEmpty()) {
		    // this is the end
		    EdgeSection es = new EdgeSection();
		    es.setEdgeStartDateTime(dateTimeList.get(startStack.pop()));
		    es.setEdgeEndDateTime(dateTimeList.get(i));
		    edgeSectionList.add(es);
		}
	    } else if (value == Constants.EDGE_ONE) {
		if (startStack.isEmpty()) {
		    // start
		    startStack.push(i);
		}
	    }
	}
	return edgeSectionList;
    }

    /*
     * Get Reverse Edge Section List
     */
    public static List<EdgeSection> getReverseEdgeSectionList(String tagName, String queryStartDateTime,
	    String queryEndDateTime) throws SQLException, ClassNotFoundException, IOException {
	List<EdgeSection> edgeSectionList = new ArrayList<EdgeSection>();
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	String query = TagQueryUtil.createDeltaQuery(tagName, queryStartDateTime, queryEndDateTime);
	ResultSet rs = stat.executeQuery(query);
	List<String> dateTimeList = new ArrayList<String>();
	List<Integer> valueList = new ArrayList<Integer>();

	while (rs.next()) {
	    String dateTime = rs.getString("DateTime");
	    int value = rs.getInt("vValue");
	    String fmtedDateTime = TagQueryUtil.formatDate(dateTime);
	    // int fmtedValue = TagQueryUtil.formatInteger(value);
	    int fmtedValue = value;
	    dateTimeList.add(fmtedDateTime);
	    valueList.add(fmtedValue);
	}
	rs.close();
	stat.close();
	con.close();

	// filter out the edge
	EdgeStack startStack = new EdgeStack();
	int size = dateTimeList.size();

	for (int i = 0; i < size; i++) {
	    int value = valueList.get(i);
	    if (value == Constants.EDGE_ONE) {
		if (!startStack.isEmpty()) {
		    // this is the end
		    EdgeSection es = new EdgeSection();
		    es.setEdgeStartDateTime(dateTimeList.get(startStack.pop()));
		    es.setEdgeEndDateTime(dateTimeList.get(i));
		    edgeSectionList.add(es);
		}
	    } else if (value == Constants.EDGE_ZERO) {
		if (startStack.isEmpty()) {
		    // start
		    startStack.push(i);
		}
	    }
	}
	return edgeSectionList;
    }

    public static int getInSQLIntValue(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws ClassNotFoundException, SQLException, IOException {
	int intValue = 0;
	String query = TagQueryUtil.createDeltaQuery(tagName, edgeLeadingTime, edgeTrailingTime);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	List<Integer> intValueList = new ArrayList<Integer>();
	while (rs.next()) {
	    int id = rs.getInt("vValue");
	    if (id != 0) {
		intValueList.add(id);
	    }
	}
	rs.close();
	stat.close();
	con.close();
	int size = intValueList.size();
	if (size > 0) {
	    intValue = intValueList.get(size - 1);
	}
	return intValue;
    }

    public static long getInSQLLongValue(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws ClassNotFoundException, SQLException, IOException {
	long longValue = 0;
	String query = TagQueryUtil.createDeltaQuery(tagName, edgeLeadingTime, edgeTrailingTime);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	List<Long> longValueList = new ArrayList<Long>();
	while (rs.next()) {
	    long id = rs.getLong("vValue");
	    if (id != 0) {
		longValueList.add(id);
	    }
	}
	rs.close();
	stat.close();
	con.close();
	int size = longValueList.size();
	if (size > 0) {
	    longValue = longValueList.get(size - 1);
	}
	return longValue;
    }

    public static List<Integer> getIntValueList(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws SQLException, ClassNotFoundException, IOException {
	List<Integer> idList = new ArrayList<Integer>();
	String query = TagQueryUtil.createDeltaQuery(tagName, edgeLeadingTime, edgeTrailingTime);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	while (rs.next()) {
	    int value = rs.getInt("vValue");
	    if (!idList.contains(value)) {
		idList.add(value);
	    }
	}
	rs.close();
	stat.close();
	con.close();
	return idList;
    }

    public static Map<String, Integer> getIntValueMap(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws ClassNotFoundException, SQLException, IOException {
	Map<String, Integer> intValueMap = new TreeMap<String, Integer>();
	String query = TagQueryUtil.createDeltaQuery(tagName, edgeLeadingTime, edgeTrailingTime);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	while (rs.next()) {
	    String dateTime = TagQueryUtil.formatDate(rs.getString("DateTime"));
	    int value = rs.getInt("vValue");
	    intValueMap.put(dateTime, value);
	}
	rs.close();
	stat.close();
	con.close();
	return intValueMap;
    }

    public static List<Long> getLongValueList(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws SQLException, ClassNotFoundException, IOException {
	List<Long> idList = new ArrayList<Long>();
	String query = TagQueryUtil.createDeltaQuery(tagName, edgeLeadingTime, edgeTrailingTime);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	while (rs.next()) {
	    long value = rs.getLong("vValue");
	    if (!idList.contains(value)) {
		idList.add(value);
	    }
	}
	rs.close();
	stat.close();
	con.close();
	return idList;
    }

    public static Map<String, Long> getLongValueMap(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws ClassNotFoundException, SQLException, IOException {
	Map<String, Long> longValueMap = new TreeMap<String, Long>();
	String query = TagQueryUtil.createDeltaQuery(tagName, edgeLeadingTime, edgeTrailingTime);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	while (rs.next()) {
	    String dateTime = TagQueryUtil.formatDate(rs.getString("DateTime"));
	    long value = rs.getLong("vValue");
	    longValueMap.put(dateTime, value);
	}
	rs.close();
	stat.close();
	con.close();
	return longValueMap;
    }

    /**
     * BUG-FIX 001 Only calculate the value when CQ**StepTimer.TT=1 Get the edge
     * section list and calculate all the values during the edge section
     * */
    public static String getDeviceStatus(String stepTimerTag, String tagName, String cycleStartTime, String cycleEndTime)
	    throws ClassNotFoundException, SQLException, IOException {
	String result = "";
	List<EdgeSection> stepTimerEdgeSectionList = InSQLDaoUtil.getEdgeSectionList(stepTimerTag, cycleStartTime,
		cycleEndTime);
	/** This part of code is for the TT=1 of the last section */
	String fromDateTime = cycleStartTime;
	for (EdgeSection ec : stepTimerEdgeSectionList) {
	    fromDateTime = ec.getEdgeEndDateTime();
	}
	fromDateTime = InSQLDaoUtil.getStepTimerOn(stepTimerTag, fromDateTime, cycleEndTime);
	if (fromDateTime != null) {
	    EdgeSection ec = new EdgeSection(fromDateTime, cycleEndTime);
	    stepTimerEdgeSectionList.add(ec);
	}
	/***/
	if (stepTimerEdgeSectionList.size() > 0) {
	    Double sum = 0d;
	    int count = 0;
	    for (EdgeSection stepTimerEdgeSection : stepTimerEdgeSectionList) {
		String timerOnStartTime = stepTimerEdgeSection.getEdgeStartDateTime();
		String timerOnEndTime = stepTimerEdgeSection.getEdgeEndDateTime();
		String query = TagQueryUtil.createIntervalQuery(tagName, PMISConfig.getTagValueIntervalMillis(),
			timerOnStartTime, timerOnEndTime);
		Connection con = InSQLDao.getInstance().getConnection();
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery(query);

		while (rs.next()) {
		    Double dValue = Double.parseDouble(rs.getString("Value"));
		    if (TagQueryUtil.tagValuePassed(dValue)) {
			sum += dValue;
			count += 1;
		    }
		}
		rs.close();
		stat.close();
		con.close();
	    }

	    if (count != 0) {
		result = TagQueryUtil.formatNumber(sum / count);
	    }
	}
	if (result == null || result.trim().isEmpty()) {
	    result = getDeviceStatusNoTimer(tagName, cycleStartTime, cycleEndTime);
	}
	return result;
    }

    /**
     * Get device status for TPM6 based CIP program, we use activity tags
     * StepTimerHold to check whether the step timer is on, which means if
     * StepTimerHold is off, then the step timer is on.
     * 
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     * */

    public static String getDeviceStatusOfTPM6(String stepTimerHoldTag, String tagName, String cycleStartTime,
	    String cycleEndTime) throws SQLException, ClassNotFoundException, IOException {
	String result = "";
	List<EdgeSection> stepTimerHoldEdgeSectionList = InSQLDaoUtil.getReverseEdgeSectionList(stepTimerHoldTag,
		cycleStartTime, cycleEndTime);
	/**
	 * This part of code is for the last section of step timer hold=0
	 * */
	String fromDateTime = cycleStartTime;
	for (EdgeSection ec : stepTimerHoldEdgeSectionList) {
	    fromDateTime = ec.getEdgeEndDateTime();
	}
	fromDateTime = InSQLDaoUtil.getStepTimerHoldOff(stepTimerHoldTag, fromDateTime, cycleEndTime);
	if (fromDateTime != null) {
	    EdgeSection ec = new EdgeSection(fromDateTime, cycleEndTime);
	    stepTimerHoldEdgeSectionList.add(ec);
	}
	if (stepTimerHoldEdgeSectionList.size() > 0) {
	    Double sum = 0d;
	    int count = 0;
	    for (EdgeSection stepTimerEdgeSection : stepTimerHoldEdgeSectionList) {
		String timerOnStartTime = stepTimerEdgeSection.getEdgeStartDateTime();
		String timerOnEndTime = stepTimerEdgeSection.getEdgeEndDateTime();
		String query = TagQueryUtil.createIntervalQuery(tagName, PMISConfig.getTagValueIntervalMillis(),
			timerOnStartTime, timerOnEndTime);
		Connection con = InSQLDao.getInstance().getConnection();
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery(query);

		while (rs.next()) {
		    Double dValue = Double.parseDouble(rs.getString("Value"));
		    if (TagQueryUtil.tagValuePassed(dValue)) {
			sum += dValue;
			count += 1;
		    }
		}
		rs.close();
		stat.close();
		con.close();
	    }

	    if (count != 0) {
		result = TagQueryUtil.formatNumber(sum / count);
	    }
	}
	if (result == null || result.trim().isEmpty()) {
	    result = getDeviceStatusNoTimer(tagName, cycleStartTime, cycleEndTime);
	}
	return result;
    }

    /**
     * Get the timestamp of step timer on
     * 
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     * */
    public static String getStepTimerOn(String stepTimerTag, String startTime, String endTime)
	    throws ClassNotFoundException, SQLException, IOException {
	String result = null;
	String query = TagQueryUtil.createDeltaQuery(stepTimerTag, startTime, endTime, Constants.ON);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	while (rs.next()) {
	    String dateTime = TagQueryUtil.formatDate(rs.getString("DateTime"));
	    int value = rs.getInt("vValue");
	    if (value == Constants.ON) {
		result = dateTime;
		break;
	    }
	}
	rs.close();
	stat.close();
	con.close();
	return result;
    }

    public static String getStepTimerHoldOff(String stepTimerHoldTag, String startTime, String endTime)
	    throws ClassNotFoundException, SQLException, IOException {
	String result = null;
	String query = TagQueryUtil.createDeltaQuery(stepTimerHoldTag, startTime, endTime, Constants.ON);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	while (rs.next()) {
	    String dateTime = TagQueryUtil.formatDate(rs.getString("DateTime"));
	    int value = rs.getInt("vValue");
	    if (value == Constants.OFF) {
		result = dateTime;
		break;
	    }
	}
	rs.close();
	stat.close();
	con.close();
	return result;
    }

    public static String getDeviceStatusNoTimer(String tagName, String cycleStartTime, String cycleEndTime)
	    throws ClassNotFoundException, SQLException, IOException {
	String query = TagQueryUtil.createIntervalQuery(tagName, PMISConfig.getTagValueIntervalMillis(),
		cycleStartTime, cycleEndTime);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	Double sum = 0d;
	int count = 0;
	while (rs.next()) {
	    Double dValue = Double.parseDouble(rs.getString("Value"));
	    if (TagQueryUtil.tagValuePassed(dValue)) {
		sum += dValue;
		count += 1;
	    }
	}
	rs.close();
	stat.close();
	con.close();
	String result = "";
	if (count != 0) {
	    result = TagQueryUtil.formatNumber(sum / count);
	}
	return result;
    }

    public static TimePeriod getTimePeriodOfTagValue(String tagName, int value, String queryStartDateTime,
	    String queryEndDateTime) throws ClassNotFoundException, SQLException, IOException {
	TimePeriod timePeriod = new TimePeriod();
	String startDateTime = getMinTimestampOfTagValue(tagName, value, queryStartDateTime, queryEndDateTime);
	String endDateTime = getMaxTimestampOfTagValue(tagName, value, queryStartDateTime, queryEndDateTime);
	timePeriod.setStartDateTime(startDateTime);
	timePeriod.setEndDateTime(endDateTime);
	return timePeriod;
    }

    public static String getMaxTimestampOfTagValue(String tagName, int value, String queryStartDateTime,
	    String queryEndDateTime) throws SQLException, ClassNotFoundException, IOException {
	String result = null;
	String query = TagQueryUtil.createMaxValueQuery(tagName, PMISConfig.getTagValueIntervalMillis(),
		queryStartDateTime, queryEndDateTime, value);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	if (rs.next()) {
	    result = TagQueryUtil.formatDate(rs.getString("DateTime"));
	}
	rs.close();
	stat.close();
	con.close();
	return result;
    }

    public static String getMinTimestampOfTagValue(String tagName, int value, String queryStartDateTime,
	    String queryEndDateTime) throws ClassNotFoundException, SQLException, IOException {
	String result = null;
	String query = TagQueryUtil.createMinValueQuery(tagName, PMISConfig.getTagValueIntervalMillis(),
		queryStartDateTime, queryEndDateTime, value);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	if (rs.next()) {
	    result = TagQueryUtil.formatDate(rs.getString("DateTime"));
	}
	rs.close();
	stat.close();
	con.close();
	return result;
    }

    public static String getMaxTimestampOfTagValue(String tagName, long value, String queryStartDateTime,
	    String queryEndDateTime) throws SQLException, ClassNotFoundException, IOException {
	String result = null;
	String query = TagQueryUtil.createMaxValueQuery(tagName, PMISConfig.getTagValueIntervalMillis(),
		queryStartDateTime, queryEndDateTime, value);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	if (rs.next()) {
	    result = TagQueryUtil.formatDate(rs.getString("DateTime"));
	}
	rs.close();
	stat.close();
	con.close();
	return result;
    }

    public static String getMinTimestampOfTagValue(String tagName, long value, String queryStartDateTime,
	    String queryEndDateTime) throws ClassNotFoundException, SQLException, IOException {
	String result = null;
	String query = TagQueryUtil.createMinValueQuery(tagName, PMISConfig.getTagValueIntervalMillis(),
		queryStartDateTime, queryEndDateTime, value);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	if (rs.next()) {
	    result = TagQueryUtil.formatDate(rs.getString("DateTime"));
	}
	rs.close();
	stat.close();
	con.close();
	return result;
    }

    public static String getValueOfDateTime(String tagName, String queryDateTime) throws ClassNotFoundException,
	    SQLException, IOException {
	String result = null;
	String query = TagQueryUtil.createValueOfDateTimeQuery(tagName, PMISConfig.getTagValueIntervalMillis(),
		queryDateTime);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	if (rs.next()) {
	    result = rs.getString("Value");
	}
	rs.close();
	stat.close();
	con.close();
	return result;
    }

    public static double getActualAmount(String tagName, String queryStartDateTime, String queryEndDateTime)
	    throws Exception {
	double minAmount = 0d;
	double maxAmount = 0d;
	// get max amount
	String maxAmountQuery = TagQueryUtil.createMaxValueQuery(tagName, PMISConfig.getTagValueIntervalMillis(),
		queryStartDateTime, queryEndDateTime);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(maxAmountQuery);
	if (rs.next()) {
	    maxAmount = Tools.parseDouble(rs.getString("MaxValue"));
	}
	rs.close();
	stat.close();
	con.close();
	// get min amount
	String minAmountQuery = TagQueryUtil.createMinValueNotZeroQuery(tagName,
		PMISConfig.getTagValueIntervalMillis(), queryStartDateTime, queryEndDateTime);
	con = InSQLDao.getInstance().getConnection();
	stat = con.createStatement();
	rs = stat.executeQuery(minAmountQuery);
	if (rs.next()) {
	    minAmount = Tools.parseDouble(rs.getString("MinValue"));
	}
	rs.close();
	stat.close();
	con.close();
	double diff = maxAmount - minAmount;
	return diff;
    }

    public static Map<String, Integer> getSteps(String tagName, String edgeLeadingTime, String edgeTrailingTime)
	    throws ClassNotFoundException, SQLException, IOException {
	return InSQLDaoUtil.getIntValueMap(tagName, edgeLeadingTime, edgeTrailingTime);
    }

    public static double getRealtimeAnalogValueDouble(String tagName) throws SQLException, ClassNotFoundException {
	double value = 0;
	String query = TagQueryUtil.createRealtimeAnalogQuery(tagName);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	if (rs.next()) {
	    value = rs.getDouble("Value");
	}
	rs.close();
	stat.close();
	con.close();
	return value;
    }

    public static int getRealtimeAnalogValueInt(String tagName) throws SQLException, ClassNotFoundException {
	int value = 0;
	String query = TagQueryUtil.createRealtimeAnalogQuery(tagName);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	if (rs.next()) {
	    value = rs.getInt("Value");
	}
	rs.close();
	stat.close();
	con.close();
	return value;
    }

    public static int getRealtimeDiscreteValue(String tagName) throws SQLException, ClassNotFoundException {
	int value = Constants.DISCRETE_NULL;
	String query = TagQueryUtil.createRealtimeDiscreteQuery(tagName);
	Connection con = InSQLDao.getInstance().getConnection();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(query);
	if (rs.next()) {
	    value = rs.getInt("Value");
	}
	rs.close();
	stat.close();
	con.close();
	return value;
    }
}
