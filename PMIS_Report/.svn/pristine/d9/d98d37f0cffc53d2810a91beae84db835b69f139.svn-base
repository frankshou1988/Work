package com.tetrapak.model.authz;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.authz.User;
import com.tetrapak.util.authz.AuthzUtil;

public class UserAuthenticationActionModel {

    public static User validateUser(String userName, String userPass) throws Exception {
	User user = (User) CommonDao.getObjByColumns(User.class, new String[] { "userName", "userPass" }, new Object[] {
		userName, AuthzUtil.encryptPassword(userPass) });
	return user;
    }

}
