package com.tetrapak.model.cip;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.tetrapak.config.Constants;
import com.tetrapak.domain.cip.CIPTrendTag;
import com.tetrapak.insql.InSQLDao;
import com.tetrapak.metaclass.TagQueryResult;
import com.tetrapak.metaclass.TagQueryUtil;

public class CIPTrendQueryActionModel {

    public static List<TagQueryResult> queryTagData(List<CIPTrendTag> cipTrendTagList, String queryStartDate,
	    String queryEndDate, Integer queryInterval, Integer queryIntervalUnit) throws ClassNotFoundException,
	    SQLException, IOException {
	List<TagQueryResult> tagQueryResultList = new ArrayList<TagQueryResult>();
	String query = null;
	int intervalInMilliSeconds = 0;
	if (queryIntervalUnit == Constants.QUERY_INTERVAL_UNIT_MINUTE) {
	    intervalInMilliSeconds = queryInterval * 60000;
	} else {
	    intervalInMilliSeconds = queryInterval * 1000;
	}
	for (CIPTrendTag cipTrendTag : cipTrendTagList) {
	    TagQueryResult tagQueryResult = new TagQueryResult();
	    Map<String, String> resultMap = new TreeMap<String, String>();

	    query = TagQueryUtil.createIntervalQuery(cipTrendTag.getCipTrendTagName(), intervalInMilliSeconds,
		    queryStartDate, queryEndDate);

	    Connection con = InSQLDao.getInstance().getConnection();
	    Statement stat = con.createStatement();
	    ResultSet rs = stat.executeQuery(query);
	    while (rs.next()) {
		String dateTime = rs.getString("DateTime");
		String value = rs.getString("Value");
		resultMap.put(TagQueryUtil.formatDate(dateTime), TagQueryUtil.formatNumber(value));
	    }
	    con.close();

	    tagQueryResult.setTag(cipTrendTag);
	    tagQueryResult.setTagValue(resultMap);
	    tagQueryResultList.add(tagQueryResult);
	}
	return tagQueryResultList;
    }

    public static Map<String, List<String>> getQueryGeneral(List<TagQueryResult> tagQueryResultList) {
	Map<String, List<String>> tagQueryGeneral = new TreeMap<String, List<String>>();
	if (tagQueryResultList.size() > 0) {
	    TagQueryResult tagQueryResult = tagQueryResultList.get(0);
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
}
