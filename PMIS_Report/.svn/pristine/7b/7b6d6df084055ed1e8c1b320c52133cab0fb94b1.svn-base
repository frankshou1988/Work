package com.tetrapak.action.settings;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.authz.User;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;
import com.tetrapak.util.authz.AuthzUtil;

public class UserPasswordChangeAction extends ActionSupport implements Action {
    private static final long serialVersionUID = -6925171538932972898L;
    private String oldUserPass;
    private String newUserPass;
    private String newUserConfirmPass;

    public String getOldUserPass() {
	return oldUserPass;
    }

    public void setOldUserPass(String oldUserPass) {
	this.oldUserPass = oldUserPass;
    }

    public String getNewUserPass() {
	return newUserPass;
    }

    public void setNewUserPass(String newUserPass) {
	this.newUserPass = newUserPass;
    }

    public String getNewUserConfirmPass() {
	return newUserConfirmPass;
    }

    public void setNewUserConfirmPass(String newUserConfirmPass) {
	this.newUserConfirmPass = newUserConfirmPass;
    }

    public String changePasswordPage() throws Exception {
	String result = null;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    result = INPUT;
	} else {
	    throw new HttpMethodNotSupportedForActionException();
	}
	return result;
    }

    public String changePassword() throws Exception {
	String result = INPUT;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    throw new HttpMethodNotSupportedForActionException();
	} else {
	    User u = (User) ActionContext.getContext().getSession().get("CURRENT_USER");
	    if (u != null) {
		if (newUserPass.equals(newUserConfirmPass)) {
		    if (u.getUserPass().equals(AuthzUtil.encryptPassword(oldUserPass))) {
			u.setUserPass(AuthzUtil.encryptPassword(newUserPass));
			boolean ur = CommonDao.saveOrUpdate(u);
			if (ur) {
			    addActionMessage(getText("i18n.pkg.action.msg.change.password.success"));
			    result = SUCCESS;
			}
		    } else {
			this.addActionError(getText("i18n.pkg.error.old.password.wrong"));
		    }
		} else {
		    this.addActionError(getText("i18n.pkg.error.new.pass.unmatch"));
		}
	    }
	}
	return result;
    }
}
