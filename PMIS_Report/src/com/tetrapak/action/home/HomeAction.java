package com.tetrapak.action.home;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.exception.HttpMethodNotSupportedForActionException;
import com.tetrapak.metaclass.HttpRequestMethod;

public class HomeAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    public String execute() throws Exception {
	String result = null;
	String reqMethod = ServletActionContext.getRequest().getMethod();
	if (reqMethod.equalsIgnoreCase(HttpRequestMethod.GET)) {
	    result = SUCCESS;
	} else {
	    throw new HttpMethodNotSupportedForActionException();
	}
	return result;
    }
}
