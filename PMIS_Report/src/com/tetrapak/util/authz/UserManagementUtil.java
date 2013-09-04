package com.tetrapak.util.authz;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.authz.User;
import com.tetrapak.domain.authz.UserRole;
import com.tetrapak.hibernate.HU;

public class UserManagementUtil {
    /**
     * Check whether the user name is duplicate
     * */
    public static boolean isUserDuplicate(String userName) throws Exception {
	boolean duplicate = false;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    @SuppressWarnings("unchecked")
	    List<Object> objList = s.createCriteria(User.class).add(Restrictions.eq("userName", userName))
		    .setMaxResults(1).list();
	    t.commit();
	    if (objList.size() > 0) {
		duplicate = true;
	    }
	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return duplicate;
    }

    public static List<User> getUserList(User user) throws Exception {
	List<User> userList = new ArrayList<User>();
	if (AuthzUtil.isAdmin(user)) {
	    List<?> objList = CommonDao.getAllObj(User.class, null, null);
	    for (Object obj : objList) {
		User u = (User) obj;
		if (!AuthzUtil.isRoot(u) && !u.getUserName().equals(user.getUserName())) {
		    userList.add(u);
		}
	    }
	}
	return userList;
    }

    public static User getUserById(Integer id) throws Exception {
	Object user = CommonDao.getObjById(User.class, id);
	return (User) user;
    }

    public static UserRole getRoleById(Integer id) throws Exception {
	Object role = CommonDao.getObjById(UserRole.class, id);
	return (UserRole) role;
    }

    public static UserRole getRoleByType(String roleType) throws Exception {
	Object obj = CommonDao.getObjByColumns(UserRole.class, new String[] { "roleType" }, new Object[] { roleType });
	UserRole userRole = null;
	if (obj != null) {
	    userRole = (UserRole) obj;
	}
	return userRole;
    }

    public static List<UserRole> getUserRoleList(User user) throws Exception {
	List<UserRole> userRoleList = new ArrayList<UserRole>();
	if (AuthzUtil.isAdmin(user)) {
	    List<?> objList = CommonDao.getAllObj(UserRole.class, null, null);
	    for (Object obj : objList) {
		UserRole role = (UserRole) obj;
		if (!role.getRoleType().equals(AuthzUtil.R_ROOT)) {
		    userRoleList.add(role);
		}
	    }
	}
	return userRoleList;
    }

}
