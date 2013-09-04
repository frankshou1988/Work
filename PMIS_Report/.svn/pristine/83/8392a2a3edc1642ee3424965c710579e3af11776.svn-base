package com.tetrapak.model.admin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.authz.User;
import com.tetrapak.domain.authz.UserRole;
import com.tetrapak.metaclass.DBMResult;
import com.tetrapak.util.authz.AuthzUtil;
import com.tetrapak.util.authz.UserManagementUtil;

public class UserManagementActionModel {

    public static boolean deleteUser(Integer userId) throws Exception {
	boolean result = false;
	User userToDel = new User();
	userToDel.setId(userId);
	result = CommonDao.delete(userToDel);
	return result;
    }

    public static int createUser(String userName, String userPass, List<String> userAuthedRoles) throws Exception {
	int result = DBMResult.DBM_ERROR;
	if (UserManagementUtil.isUserDuplicate(userName)) {
	    result = DBMResult.RECORD_ALREADY_EXITS;
	} else {
	    User user = new User();
	    user.setUserName(userName);
	    user.setUserPass(AuthzUtil.encryptPassword(userPass));
	    Set<UserRole> userRoles = new HashSet<UserRole>();
	    for (String roleType : userAuthedRoles) {
		UserRole userRole = UserManagementUtil.getRoleByType(roleType);
		if (userRole != null) {
		    userRoles.add(userRole);
		}
	    }
	    if (userRoles.size() > 0) {
		user.setUserRoles(userRoles);
		if (CommonDao.save(user)) {
		    result = DBMResult.ADD_RECORD_SUCCESS;
		}
	    }
	}
	return result;
    }

}
