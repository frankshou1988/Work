package com.tetrapak.action.authz;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.domain.authz.User;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.model.authz.UserAuthenticationActionModel;
import com.tetrapak.util.authz.AuthzUtil;

public class UserAuthenticationAction extends ActionSupport {
    private static final long serialVersionUID = -3331268716019208162L;
    private String userName;
    private String userPass;

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

    public String loginPage() throws Exception {
	String result = null;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    User u = (User) ActionContext.getContext().getSession().get("CURRENT_USER");
	    if (u == null || !AuthzUtil.isOperator(u)) {
		result = INPUT;
	    } else {
		result = SUCCESS;
	    }
	} else {
	    throw new HttpMethodNotSupportedForActionException();
	}
	return result;
    }

    public String login() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else if (reqMethod.equalsIgnoreCase(HttpRequestMethod.POST)) {
	    User u = UserAuthenticationActionModel.validateUser(userName, userPass);
	    if (u != null && AuthzUtil.isOperator(u)) {
		ActionContext.getContext().getSession().put("CURRENT_USER", u);
		result = SUCCESS;
	    } else {
		this.addActionError(getText("i18n.pkg.login.failed"));
	    }
	}
	return result;
    }

    public String logout() throws Exception {
	String result = SUCCESS;
	ActionContext.getContext().getSession().remove("CURRENT_USER");
	return result;
    }

}
