package com.tetrapak.job.bpu;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BPUReportAnalyseJob implements Job {

    public void execute(JobExecutionContext ctx) throws JobExecutionException {
	Map<String, Object> dataMap = ctx.getJobDetail().getJobDataMap();
	BPUReportAnalyseTask task = (BPUReportAnalyseTask) dataMap.get("schedulerTaskBPUReport");
	task.bpuReportAnalyse();
    }

}
