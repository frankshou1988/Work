package com.tetrapak.action.systemsettings.bpu;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractBPUSettingAction extends ActionSupport implements Action {
    private static final long serialVersionUID = 1L;

    /**
     * Add Object
     * */
    public abstract String add() throws Exception;

    /**
     * Edit Object
     * */
    public abstract String edit() throws Exception;

    /**
     * Delete Object
     * */
    public abstract String delete() throws Exception;
}
