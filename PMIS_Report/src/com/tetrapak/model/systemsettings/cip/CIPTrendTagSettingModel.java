package com.tetrapak.model.systemsettings.cip;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.cip.CIPMasterLine;
import com.tetrapak.domain.cip.CIPTrendTag;

public class CIPTrendTagSettingModel {
    /**
     * Save or update cip trend tag information
     * */
    public static boolean saveCIPTrendTag(String cipTrendTagName, String cipTrendTagDesc, String cipTrendTagUnit,
	    Integer cipTrendTagValueDividedBy, Boolean cipTrendTagType, Integer cipTrendTagMasterLineId)
	    throws Exception {
	boolean result = false;
	CIPTrendTag tag = null;
	tag = (CIPTrendTag) CommonDao.getObjByUniqueColumn(CIPTrendTag.class, "cipTrendTagName", cipTrendTagName);
	if (tag == null) {
	    tag = new CIPTrendTag();
	}
	tag.setCipTrendTagName(cipTrendTagName);
	tag.setCipTrendTagDesc(cipTrendTagDesc);
	tag.setCipTrendTagUnit(cipTrendTagUnit);
	tag.setCipTrendTagValueDividedBy(cipTrendTagValueDividedBy);
	tag.setCipTrendTagAnalog(cipTrendTagType);

	CIPMasterLine ml = (CIPMasterLine) CommonDao.getObjById(CIPMasterLine.class, cipTrendTagMasterLineId);
	if (ml != null) {
	    tag.setCipMasterLine(ml);
	    result = CommonDao.saveOrUpdate(tag);
	}

	return result;
    }

    /**
     * Delete cip trend tag by id
     * */
    public static boolean deleteCIPTrendTagById(Integer id) throws Exception {
	boolean result = false;
	CIPTrendTag tag = new CIPTrendTag();
	tag.setId(id);
	result = CommonDao.delete(tag);
	return result;
    }
}
