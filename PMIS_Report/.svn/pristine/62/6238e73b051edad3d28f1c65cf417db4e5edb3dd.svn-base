package com.tetrapak.model.bpu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.tetrapak.config.Constants;
import com.tetrapak.domain.bpu.BPUAnalogTag;
import com.tetrapak.insql.InSQLDao;
import com.tetrapak.metaclass.BPUTagQueryResult;
import com.tetrapak.metaclass.TagQueryUtil;

public class BPUTagQueryActionModel {
    public static List<BPUTagQueryResult> queryTagData(List<BPUAnalogTag> bpuAnalogTagList, String queryStartDate,
	    String queryEndDate, Integer queryInterval, Integer queryIntervalUnit) throws Exception {
	List<BPUTagQueryResult> tagQueryResultList = new ArrayList<BPUTagQueryResult>();
	String query = null;
	int intervalInMilliSeconds = 0;
	if (queryIntervalUnit.equals(Constants.QUERY_INTERVAL_UNIT_MINUTE)) {
	    intervalInMilliSeconds = queryInterval * 60000;
	} else {
	    intervalInMilliSeconds = queryInterval * 1000;
	}
	Connection con = InSQLDao.getInstance().getConnection();
	for (BPUAnalogTag bpuAnalogTag : bpuAnalogTagList) {
	    BPUTagQueryResult tagQueryResult = new BPUTagQueryResult();
	    Map<String, String> resultMap = new TreeMap<String, String>();

	    query = TagQueryUtil.createIntervalQuery(bpuAnalogTag.getAnalogInsqlTagName(), intervalInMilliSeconds,
		    queryStartDate, queryEndDate);

	    Statement stat = con.createStatement();
	    ResultSet rs = stat.executeQuery(query);
	    while (rs.next()) {
		String dateTime = rs.getString("DateTime");
		String value = rs.getString("Value");
		resultMap.put(TagQueryUtil.formatDate(dateTime),
			TagQueryUtil.formatNumberDividedBy(value, bpuAnalogTag.getAnalogTagValueDividedBy()));
	    }

	    tagQueryResult.setTag(bpuAnalogTag);
	    tagQueryResult.setTagValue(resultMap);
	    tagQueryResultList.add(tagQueryResult);
	}
	con.close();
	return tagQueryResultList;
    }

    public static Map<String, List<String>> getQueryGeneral(List<BPUTagQueryResult> tagQueryResultList) {
	Map<String, List<String>> tagQueryGeneral = new TreeMap<String, List<String>>();
	if (tagQueryResultList.size() > 0) {
	    BPUTagQueryResult tagQueryResult = tagQueryResultList.get(0);
	    Set<String> timestampSet = tagQueryResult.getTagValue().keySet();
	    int tagQueryResultSize = tagQueryResultList.size();
	    for (String timestamp : timestampSet) {
		List<String> valueList = new ArrayList<String>();
		for (int i = 0; i < tagQueryResultSize; i++) {
		    String value = tagQueryResultList.get(i).getTagValue().get(timestamp);
		    valueList.add(value);
		}
		tagQueryGeneral.put(timestamp, valueList);
	    }
	}
	return tagQueryGeneral;
    }

    public static Map<BPUAnalogTag, List<String>> getQueryCustomized(List<BPUTagQueryResult> tagQueryResultList) {
	Map<BPUAnalogTag, List<String>> tagQueryCustomized = new TreeMap<BPUAnalogTag, List<String>>();
	if (tagQueryResultList.size() > 0) {
	    for (BPUTagQueryResult eachResult : tagQueryResultList) {
		List<String> valueList = new ArrayList<String>();
		valueList.addAll(eachResult.getTagValue().values());
		tagQueryCustomized.put(eachResult.getTag(), valueList);
	    }

	}
	return tagQueryCustomized;
    }
}
