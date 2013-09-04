package com.tetrapak.test;

import java.util.List;
import java.util.Set;

import com.tetrapak.config.PMISConfigLoader;
import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.authz.User;
import com.tetrapak.domain.authz.UserRole;
import com.tetrapak.domain.bpu.BPUAlarmReportResult;
import com.tetrapak.util.authz.AuthzUtil;

public class TestUuser {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	PMISConfigLoader.loadConfig();

	List<?> objList = CommonDao.getAllObj(BPUAlarmReportResult.class, null, null);
	System.err.println(objList.size());
    }
}
