package com.tetrapak.job.cip;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CIPReportAnalyseJob implements Job {

    @Override
    public void execute(JobExecutionContext ctx) throws JobExecutionException {
	Map<String, Object> dataMap = ctx.getJobDetail().getJobDataMap();
	CIPReportAnalyseTask task = (CIPReportAnalyseTask) dataMap.get("schedulerCIPTask");
	task.cipReportAnalyse();
    }

}
