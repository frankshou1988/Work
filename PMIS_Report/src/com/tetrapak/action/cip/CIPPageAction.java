package com.tetrapak.action.cip;

import com.opensymphony.xwork2.ActionSupport;

public class CIPPageAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    /**
     * CIP Trend Query Page Action
     * */
    public String cipTrendQueryPage() {
	return SUCCESS;
    }

    /**
     * CIP Report Query Page Action
     * */
    public String cipReportQueryPage() {
	return SUCCESS;
    }

    /**
     * CIP Analysis Target Query Page Action
     * */
    public String cipPerformAnalysisTargetQueryPage() {
	return SUCCESS;
    }

    /**
     * CIP Analysis CIP Master Line Query Page Action
     * */
    public String cipPerformAnalysisMasterLineQueryPage() {
	return SUCCESS;
    }

}
