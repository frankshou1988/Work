package com.tetrapak.job.bpu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tetrapak.util.bpu.BPUAlarmReportAnalyser;

public class BPUAlarmAnalyseTask {
    private static Logger log = LoggerFactory.getLogger(BPUAlarmAnalyseTask.class);

    public void bpuAlarmReportAnalyse() {
	try {
	    BPUAlarmReportAnalyser.bpuAlarmReportAnalyse();
	} catch (Exception e) {
	    if (log.isErrorEnabled()) {
		log.error("BPU Alarm Report Report Analyser Error", e);
	    }
	}
    }
}
