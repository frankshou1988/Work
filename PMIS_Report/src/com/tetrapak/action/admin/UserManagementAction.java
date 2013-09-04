package com.tetrapak.action.admin;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.DBMResult;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.model.admin.UserManagementActionModel;

public class UserManagementAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String userName;
    private String userPass;
    private String userPassConfirm;
    private List<String> userAuthedRoles;

    public Integer getUserId() {
	return userId;
    }

    public void setUserId(Integer userId) {
	this.userId = userId;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getUserPass() {
	return userPass;
    }

    public void setUserPass(String userPass) {
	this.userPass = userPass;
    }

    public String getUserPassConfirm() {
	return userPassConfirm;
    }

    public void setUserPassConfirm(String userPassConfirm) {
	this.userPassConfirm = userPassConfirm;
    }

    public List<String> getUserAuthedRoles() {
	return userAuthedRoles;
    }

    public void setUserAuthedRoles(List<String> userAuthedRoles) {
	this.userAuthedRoles = userAuthedRoles;
    }

    public String userManagePage() {
	return SUCCESS;
    }

    public String addUser() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    int cuResult = UserManagementActionModel.createUser(userName, userPass, userAuthedRoles);
	    if (cuResult == DBMResult.ADD_RECORD_SUCCESS) {
		addActionMessage(getText("i18n.pkg.action.msg.add.user.success"));
		result = SUCCESS;
	    } else if (cuResult == DBMResult.RECORD_ALREADY_EXITS) {
		addActionError(getText("i18n.pkg.action.error.user.already.exists"));
	    }
	}
	return result;

    }

    public String deleteUser() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    boolean dc = UserManagementActionModel.deleteUser(userId);
	    if (dc) {
		result = SUCCESS;
	    }
	}
	return result;

    }
}
