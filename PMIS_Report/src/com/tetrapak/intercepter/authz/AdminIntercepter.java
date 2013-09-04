package com.tetrapak.intercepter.authz;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tetrapak.domain.authz.User;
import com.tetrapak.util.authz.AuthzUtil;

public class AdminIntercepter extends AbstractInterceptor {

    /**
     * Authority Intercepter
     */
    private static final long serialVersionUID = -6739701494575230797L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
	String result = Action.LOGIN;
	ActionContext ctx = invocation.getInvocationContext();
	User user = (User) ctx.getSession().get("CURRENT_USER");
	if (user != null && AuthzUtil.isAdmin(user)) {
	    result = invocation.invoke();
	}
	return result;
    }
}
