package com.tetrapak.job.cip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tetrapak.util.cip.TPM5CIPReportAnalyser;
import com.tetrapak.util.cip.TPM4CIPReportAnalyser;
import com.tetrapak.util.cip.TPM6CIPReportAnalyser;

public class CIPReportAnalyseTask {
    private static Logger log = LoggerFactory.getLogger(CIPReportAnalyseTask.class);

    public void cipReportAnalyse() {
	try {
	    TPM6CIPReportAnalyser.cipReportAnalyse();
	    TPM5CIPReportAnalyser.cipReportAnalyse();
	    TPM4CIPReportAnalyser.cipReportAnalyse();
	} catch (Exception e) {
	    if (log.isErrorEnabled()) {
		log.error("CIP Report Report Analyser Error", e);
	    }
	}
    }
}
