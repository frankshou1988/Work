package com.tetrapak.util.common;

import java.util.ArrayList;
import java.util.List;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.comm.WorkshopType;

public class WorkshopTypeUtil {
    public static List<WorkshopType> getWorkshopTypeList() throws Exception {
	List<WorkshopType> workshopTypeList = new ArrayList<WorkshopType>();
	List<?> objList = CommonDao.getAllObj(WorkshopType.class, "workshopTypeName", true);
	for (Object obj : objList) {
	    workshopTypeList.add((WorkshopType) obj);
	}
	return workshopTypeList;
    }
}
