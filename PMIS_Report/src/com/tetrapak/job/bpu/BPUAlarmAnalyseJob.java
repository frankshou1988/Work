package com.tetrapak.job.bpu;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BPUAlarmAnalyseJob implements Job {

    public void execute(JobExecutionContext ctx) throws JobExecutionException {
	Map<String, Object> dataMap = ctx.getJobDetail().getJobDataMap();
	BPUAlarmAnalyseTask task = (BPUAlarmAnalyseTask) dataMap.get("schedulerTaskBPUAlarmReport");
	task.bpuAlarmReportAnalyse();
    }

}
