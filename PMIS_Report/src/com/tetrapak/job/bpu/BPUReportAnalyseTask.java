package com.tetrapak.job.bpu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tetrapak.util.bpu.BPUReportAnalyser;

public class BPUReportAnalyseTask {
    private static Logger log = LoggerFactory.getLogger(BPUReportAnalyseTask.class);

    public void bpuReportAnalyse() {
	try {
	    BPUReportAnalyser.bpuReportAnalyse();
	} catch (Exception e) {
	    if (log.isErrorEnabled()) {
		log.error("BPU Report Report Analyser Error", e);
	    }
	}
    }
}
