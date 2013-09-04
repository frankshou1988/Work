package com.tetrapak.util.authz;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

import com.tetrapak.domain.authz.User;
import com.tetrapak.domain.authz.UserRole;
import com.tetrapak.util.common.MD5Util;

/**
 * Check the role of the user
 * */
public class AuthzUtil {
    private static String SALT = "9a3135e47023a7e5c9c735f9075391e4";
    // role level 100
    public static String R_OPERATOR = "R_OPER";
    // role level 200
    public static String R_QA = "R_QA";
    // role level 300
    public static String R_ADMIN = "R_ADMIN";
    // role level 400
    public static String R_ROOT = "R_ROOT";

    public static String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	StringBuilder sb = new StringBuilder(password);
	sb.append(SALT);
	return MD5Util.MD5(sb.toString());
    }

    public static boolean isOperator(User user) {
	boolean result = false;
	if (user != null) {
	    Set<UserRole> userRoles = user.getUserRoles();
	    for (UserRole r : userRoles) {
		if (r.getRoleType().equals(R_OPERATOR)) {
		    result = true;
		    break;
		}
	    }
	}
	return result;
    }

    public static boolean isAdmin(User user) {
	boolean result = false;
	if (user != null) {
	    Set<UserRole> userRoles = user.getUserRoles();
	    for (UserRole r : userRoles) {
		if (r.getRoleType().equals(R_ADMIN)) {
		    result = true;
		    break;
		}
	    }
	}
	return result;
    }

    public static boolean isQA(User user) {
	boolean result = false;
	if (user != null) {
	    Set<UserRole> userRoles = user.getUserRoles();
	    for (UserRole r : userRoles) {
		if (r.getRoleType().equals(R_QA)) {
		    result = true;
		    break;
		}
	    }
	}
	return result;
    }

    public static boolean isRoot(User user) {
	boolean result = false;
	if (user != null) {
	    Set<UserRole> userRoles = user.getUserRoles();
	    for (UserRole r : userRoles) {
		if (r.getRoleType().equals(R_ROOT)) {
		    result = true;
		    break;
		}
	    }
	}
	return result;
    }
}
