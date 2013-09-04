package com.tetrapak.util.cip;

import java.util.ArrayList;
import java.util.List;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPTrendTag;

public class CIPTrendTagUtil {
    public static List<CIPTrendTag> getCIPTrendTagList() throws Exception {
	List<CIPTrendTag> tagList = new ArrayList<CIPTrendTag>();
	List<?> objList = CommonDao.getAllObj(CIPTrendTag.class, "cipTrendTagName", true);
	for (Object obj : objList) {
	    tagList.add((CIPTrendTag) obj);
	}
	return tagList;
    }

    public static List<CIPTrendTag> getCIPTrendTagsOfMasterLine(Integer masterLineId) throws Exception {
	List<CIPTrendTag> tagList = new ArrayList<CIPTrendTag>();
	List<?> objList = CommonDao.getAllObjByColumnsAndRef(CIPTrendTag.class, new String[] {}, new Object[] {},
		"cipMasterLine", "id", masterLineId, "cipTrendTagName", true);
	for (Object obj : objList) {
	    tagList.add((CIPTrendTag) obj);
	}
	return tagList;
    }

    public static CIPTrendTag getCIPTrendTagByTagName(String tagName) throws Exception {
	CIPTrendTag tag = null;
	tag = (CIPTrendTag) CommonDao.getObjByUniqueColumn(CIPTrendTag.class, "cipTrendTagName", tagName);
	return tag;
    }
}
