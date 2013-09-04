package com.tetrapak.metaclass;

import java.text.DecimalFormat;

import com.tetrapak.config.PMISConfig;

public class TagQueryUtil {
    public static String createRealtimeDiscreteQuery(String tagName) {
	String query = "SELECT v_DiscreteLive.TagName AS TagName, DateTime, Value " + " FROM v_DiscreteLive "
		+ " WHERE v_DiscreteLive.TagName IN ('" + tagName + "') ORDER BY TagName ASC";
	return query;
    }

    public static String createRealtimeAnalogQuery(String tagName) {
	String query = "SELECT v_AnalogLive.TagName AS TagName, DateTime, Value " + " FROM v_AnalogLive "
		+ " WHERE v_AnalogLive.TagName IN ('" + tagName + "')  ORDER BY TagName ASC";
	return query;
    }

    /**
     * Cycle
     * */
    public static String createCountQuery(String tagName, int count, String queryStartDateTime, String queryEndDateTime) {
	String query = "SET NOCOUNT ON;" + "DECLARE @StartDate DateTime;" + "DECLARE @EndDate DateTime;"
		+ "SET @StartDate = '" + queryStartDateTime + "';" + "SET @EndDate = '" + queryEndDateTime + "';"
		+ "SET NOCOUNT OFF;" + "SELECT  * FROM ( "
		+ "SELECT History.TagName, DateTime, Value, vValue, StartDateTime " + " FROM History "
		+ " WHERE History.TagName IN ('" + tagName + "') " + " AND vValue IS NOT NULL "
		+ " AND wwRetrievalMode = 'Cyclic' " + " AND wwCycleCount = " + count + " AND wwVersion = 'Latest' "
		+ " AND DateTime >= @StartDate "
		+ " AND DateTime <= @EndDate) temp WHERE temp.StartDateTime >= @StartDate " + "ORDER BY DateTime ASC";
	return query;
    }

    /**
     * Cycle
     * */
    public static String createIntervalQuery(String tagName, int intervalInMilliSeconds, String queryStartDateTime,
	    String queryEndDateTime) {
	String query = "SET NOCOUNT ON;" + "DECLARE @StartDate DateTime;" + "DECLARE @EndDate DateTime;"
		+ "SET @StartDate = '" + queryStartDateTime + "';" + "SET @EndDate = '" + queryEndDateTime + "';"
		+ "SET NOCOUNT OFF;" + "SELECT  * FROM ( "
		+ "SELECT History.TagName, DateTime, Value, vValue, StartDateTime " + " FROM History "
		+ " WHERE History.TagName IN ('" + tagName + "') " + " AND vValue IS NOT NULL "
		+ " AND wwRetrievalMode = 'Cyclic' " + " AND wwResolution = " + intervalInMilliSeconds
		+ " AND wwVersion = 'Latest' " + " AND DateTime >= @StartDate "
		+ " AND DateTime < @EndDate) temp WHERE temp.StartDateTime >= @StartDate " + "ORDER BY DateTime ASC";
	return query;
    }

    /**
     * Delta
     * */
    public static String createDeltaQuery(String tagName, String queryStartDateTime, String queryEndDateTime) {
	String query = "SET NOCOUNT ON; " + "DECLARE @StartDate DateTime; " + "DECLARE @EndDate DateTime; "
		+ "SET @StartDate = '" + queryStartDateTime + "';" + "SET @EndDate = '" + queryEndDateTime + "';"
		+ "SET NOCOUNT OFF;" + "SELECT  * FROM ( " + "SELECT DateTime, Value, vValue, StartDateTime"
		+ " FROM History " + " WHERE History.TagName IN ('" + tagName + "') " + " AND vValue IS NOT NULL "
		+ " AND wwRetrievalMode = 'Delta' " + " AND wwVersion = 'Latest' " + " AND DateTime >= @StartDate "
		+ " AND DateTime <= @EndDate) temp WHERE temp.StartDateTime >= @StartDate " + "ORDER BY DateTime ASC";
	return query;
    }

    public static String createDeltaQuery(String tagName, String queryStartDateTime, String queryEndDateTime, int value) {
	String query = "SET NOCOUNT ON; " + "DECLARE @StartDate DateTime; " + "DECLARE @EndDate DateTime; "
		+ "SET @StartDate = '" + queryStartDateTime + "';" + "SET @EndDate = '" + queryEndDateTime + "';"
		+ "SET NOCOUNT OFF;" + "SELECT  * FROM ( " + "SELECT DateTime, Value, vValue, StartDateTime"
		+ " FROM History " + " WHERE History.TagName IN ('" + tagName + "') " + " AND vValue IS NOT NULL "
		+ " AND wwRetrievalMode = 'Delta' " + " AND wwVersion = 'Latest' " + " AND DateTime >= @StartDate "
		+ " AND DateTime <= @EndDate " + " AND Value=" + value
		+ ") temp WHERE temp.StartDateTime >= @StartDate " + "ORDER BY DateTime ASC";
	return query;
    }

    public static String createMaxValueQuery(String tagName, int intervalInMilliSeconds, String queryStartDateTime,
	    String queryEndDateTime, int value) {
	String query = "SET NOCOUNT ON;" + "DECLARE @StartDate DateTime;" + "DECLARE @EndDate DateTime;"
		+ "SET @StartDate = '"
		+ queryStartDateTime
		+ "';"
		+ "SET @EndDate = '"
		+ queryEndDateTime
		+ "';"
		+ "SET NOCOUNT OFF;"
		+ "SELECT  MAX(DateTime) AS DateTime FROM ( "
		+ "SELECT History.TagName, DateTime, Value, vValue, StartDateTime "
		+ " FROM History "
		+ " WHERE History.TagName IN ('"
		+ tagName
		+ "') "
		+ " AND vValue IS NOT NULL "
		+ " AND wwRetrievalMode = 'Cyclic' "
		+ " AND wwResolution = "
		+ intervalInMilliSeconds
		+ " AND wwVersion = 'Latest' "
		+ " AND DateTime >= @StartDate "
		+ " AND DateTime <= @EndDate) temp WHERE temp.StartDateTime >= @StartDate "
		+ " AND vValue="
		+ value
		+ " ORDER BY DateTime ASC";
	return query;
    }

    public static String createMinValueQuery(String tagName, int intervalInMilliSeconds, String queryStartDateTime,
	    String queryEndDateTime, int value) {
	String query = "SET NOCOUNT ON;" + "DECLARE @StartDate DateTime;" + "DECLARE @EndDate DateTime;"
		+ "SET @StartDate = '"
		+ queryStartDateTime
		+ "';"
		+ "SET @EndDate = '"
		+ queryEndDateTime
		+ "';"
		+ "SET NOCOUNT OFF;"
		+ "SELECT  MIN(DateTime) AS DateTime FROM ( "
		+ "SELECT History.TagName, DateTime, Value, vValue, StartDateTime "
		+ " FROM History "
		+ " WHERE History.TagName IN ('"
		+ tagName
		+ "') "
		+ " AND vValue IS NOT NULL "
		+ " AND wwRetrievalMode = 'Cyclic' "
		+ " AND wwResolution = "
		+ intervalInMilliSeconds
		+ " AND wwVersion = 'Latest' "
		+ " AND DateTime >= @StartDate "
		+ " AND DateTime <= @EndDate) temp WHERE temp.StartDateTime >= @StartDate "
		+ " AND vValue="
		+ value
		+ " ORDER BY DateTime ASC";
	return query;
    }

    public static String createMaxValueQuery(String tagName, int intervalInMilliSeconds, String queryStartDateTime,
	    String queryEndDateTime, long value) {
	String query = "SET NOCOUNT ON;" + "DECLARE @StartDate DateTime;" + "DECLARE @EndDate DateTime;"
		+ "SET @StartDate = '"
		+ queryStartDateTime
		+ "';"
		+ "SET @EndDate = '"
		+ queryEndDateTime
		+ "';"
		+ "SET NOCOUNT OFF;"
		+ "SELECT  MAX(DateTime) AS DateTime FROM ( "
		+ "SELECT History.TagName, DateTime, Value, vValue, StartDateTime "
		+ " FROM History "
		+ " WHERE History.TagName IN ('"
		+ tagName
		+ "') "
		+ " AND vValue IS NOT NULL "
		+ " AND wwRetrievalMode = 'Cyclic' "
		+ " AND wwResolution = "
		+ intervalInMilliSeconds
		+ " AND wwVersion = 'Latest' "
		+ " AND DateTime >= @StartDate "
		+ " AND DateTime <= @EndDate) temp WHERE temp.StartDateTime >= @StartDate "
		+ " AND vValue="
		+ value
		+ " ORDER BY DateTime ASC";
	return query;
    }

    public static String createMinValueQuery(String tagName, int intervalInMilliSeconds, String queryStartDateTime,
	    String queryEndDateTime, long value) {
	String query = "SET NOCOUNT ON;" + "DECLARE @StartDate DateTime;" + "DECLARE @EndDate DateTime;"
		+ "SET @StartDate = '"
		+ queryStartDateTime
		+ "';"
		+ "SET @EndDate = '"
		+ queryEndDateTime
		+ "';"
		+ "SET NOCOUNT OFF;"
		+ "SELECT  MIN(DateTime) AS DateTime FROM ( "
		+ "SELECT History.TagName, DateTime, Value, vValue, StartDateTime "
		+ " FROM History "
		+ " WHERE History.TagName IN ('"
		+ tagName
		+ "') "
		+ " AND vValue IS NOT NULL "
		+ " AND wwRetrievalMode = 'Cyclic' "
		+ " AND wwResolution = "
		+ intervalInMilliSeconds
		+ " AND wwVersion = 'Latest' "
		+ " AND DateTime >= @StartDate "
		+ " AND DateTime <= @EndDate) temp WHERE temp.StartDateTime >= @StartDate "
		+ " AND vValue="
		+ value
		+ " ORDER BY DateTime ASC";
	return query;
    }

    public static String createValueOfDateTimeQuery(String tagName, int intervalInMilliSeconds, String queryDateTime) {
	String query = "SET NOCOUNT ON;" + "DECLARE @QueryDate DateTime;" + "SET @QueryDate = '" + queryDateTime + "';"
		+ "SET NOCOUNT OFF;" + "SELECT * FROM ( "
		+ "SELECT History.TagName, DateTime, Value, vValue, StartDateTime " + " FROM History "
		+ " WHERE History.TagName IN ('" + tagName + "') " + " AND vValue IS NOT NULL "
		+ " AND wwRetrievalMode = 'Cyclic' " + " AND wwResolution = " + intervalInMilliSeconds
		+ " AND wwVersion = 'Latest' " + " AND DateTime = @QueryDate "
		+ " ) temp WHERE temp.StartDateTime >= @QueryDate " + " ORDER BY DateTime ASC";
	return query;
    }

    public static String createMaxValueQuery(String tagName, int intervalInMilliSeconds, String queryStartDateTime,
	    String queryEndDateTime) {
	String query = "SET NOCOUNT ON;" + "DECLARE @StartDate DateTime;" + "DECLARE @EndDate DateTime;"
		+ "SET @StartDate = '" + queryStartDateTime + "';" + "SET @EndDate = '" + queryEndDateTime + "';"
		+ "SET NOCOUNT OFF;" + "SELECT  MAX(Value) AS MaxValue FROM ( "
		+ "SELECT History.TagName, DateTime, Value, vValue, StartDateTime " + " FROM History "
		+ " WHERE History.TagName IN ('" + tagName + "') " + " AND vValue IS NOT NULL "
		+ " AND wwRetrievalMode = 'Cyclic' " + " AND wwResolution = " + intervalInMilliSeconds
		+ " AND wwVersion = 'Latest' " + " AND DateTime >= @StartDate "
		+ " AND DateTime <= @EndDate) temp WHERE temp.StartDateTime >= @StartDate ";
	return query;
    }

    public static String createMinValueNotZeroQuery(String tagName, int intervalInMilliSeconds,
	    String queryStartDateTime, String queryEndDateTime) {
	String query = "SET NOCOUNT ON;" + "DECLARE @StartDate DateTime;" + "DECLARE @EndDate DateTime;"
		+ "SET @StartDate = '" + queryStartDateTime + "';" + "SET @EndDate = '" + queryEndDateTime + "';"
		+ "SET NOCOUNT OFF;" + "SELECT  MIN(Value) AS MinValue FROM ( "
		+ "SELECT History.TagName, DateTime, Value, vValue, StartDateTime " + " FROM History "
		+ " WHERE History.TagName IN ('" + tagName + "') " + " AND vValue IS NOT NULL "
		+ " AND wwRetrievalMode = 'Cyclic' " + " AND wwResolution = " + intervalInMilliSeconds
		+ " AND wwVersion = 'Latest' " + " AND DateTime >= @StartDate "
		+ " AND DateTime <= @EndDate) temp WHERE temp.StartDateTime >= @StartDate " + " AND Value!=0";
	return query;
    }

    public static String formatDate(String dateTime) {
	if (dateTime == null)
	    return null;
	int index = dateTime.lastIndexOf(".");
	return dateTime.substring(0, index);
    }

    public static String formatNumber(Double number) {
	DecimalFormat fmt = new DecimalFormat("#0.#");
	return fmt.format(number);
    }

    public static String formatNumberDividedBy(String numberStr, Double dividedBy) {
	Double number = Double.parseDouble(numberStr);
	number = number / dividedBy;
	return formatNumber(number);
    }

    public static String formatNumber(String numberStr) {
	Double number = Double.parseDouble(numberStr);
	return formatNumber(number);
    }

    public static int formatInteger(String numberStr) {
	DecimalFormat fmt = new DecimalFormat("#0");
	Double number = Double.parseDouble(numberStr);
	String numberFmted = fmt.format(number);
	return Integer.parseInt(numberFmted);
    }

    public static Boolean formatBoolean(String boolValue) {
	Boolean retValue = null;
	if (boolValue != null) {
	    int result = formatInteger(boolValue);
	    retValue = (result == 0) ? false : true;
	}
	return retValue;
    }

    public static boolean tagValuePassed(double d) {
	boolean result = false;
	if (d - PMISConfig.getTagMinValue() > 0) {
	    result = true;
	}
	return result;
    }

}
