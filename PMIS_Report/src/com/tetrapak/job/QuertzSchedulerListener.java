package com.tetrapak.job;

import java.text.ParseException;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tetrapak.job.bpu.BPUAlarmAnalyseJob;
import com.tetrapak.job.bpu.BPUAlarmAnalyseTask;
import com.tetrapak.job.bpu.BPUReportAnalyseJob;
import com.tetrapak.job.bpu.BPUReportAnalyseTask;
import com.tetrapak.job.cip.CIPReportAnalyseJob;
import com.tetrapak.job.cip.CIPReportAnalyseTask;

public class QuertzSchedulerListener implements ServletContextListener {
    private static Logger log = LoggerFactory.getLogger(QuertzSchedulerListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent ctx) {
	if (log.isInfoEnabled())
	    log.info("Quertz Scheduler Context Destroyed...");
    }

    @Override
    public void contextInitialized(ServletContextEvent ctx) {
	/** CIP Report Analysis Job */
	CIPReportAnalyseTask task0 = new CIPReportAnalyseTask();
	JobDetailImpl job0 = new JobDetailImpl();
	job0.setName("cipReportAnalyseJob");
	job0.setJobClass(CIPReportAnalyseJob.class);
	Map<String, Object> dataMap0 = job0.getJobDataMap();
	dataMap0.put("schedulerCIPTask", task0);
	CronTriggerImpl trigger0 = new CronTriggerImpl();
	trigger0.setName("runCIPReportAnalyseJob");
	try {
	    trigger0.setCronExpression("0 */10 * * * ?");
	} catch (ParseException e0) {
	    if (log.isErrorEnabled())
		log.error(e0.getMessage(), e0);
	}

	/** BPU Report Analysis Job */
	BPUReportAnalyseTask task1 = new BPUReportAnalyseTask();
	JobDetailImpl job1 = new JobDetailImpl();
	job1.setName("bpuReportAnalyseJob");
	job1.setJobClass(BPUReportAnalyseJob.class);
	Map<String, Object> dataMap1 = job1.getJobDataMap();
	dataMap1.put("schedulerTaskBPUReport", task1);
	CronTriggerImpl trigger1 = new CronTriggerImpl();
	trigger1.setName("runBPUReportAnalyseJob");
	try {
	    trigger1.setCronExpression("0 */30 * * * ?");
	} catch (ParseException e1) {
	    if (log.isErrorEnabled())
		log.error(e1.getMessage(), e1);
	}

	/** BPU Alarm Analysis Job */
	BPUAlarmAnalyseTask task2 = new BPUAlarmAnalyseTask();
	JobDetailImpl job2 = new JobDetailImpl();
	job2.setName("bpuAlarmReportAnalyseJob");
	job2.setJobClass(BPUAlarmAnalyseJob.class);
	Map<String, Object> dataMap2 = job2.getJobDataMap();
	dataMap2.put("schedulerTaskBPUAlarmReport", task2);
	CronTriggerImpl trigger2 = new CronTriggerImpl();
	trigger2.setName("runBPUAlarmReportAnalyseJob");
	try {
	    trigger2.setCronExpression("0 */5 * * * ?");
	} catch (ParseException e2) {
	    if (log.isErrorEnabled())
		log.error(e2.getMessage(), e2);
	}

	Scheduler scheduler;
	try {
	    scheduler = new StdSchedulerFactory().getScheduler();
	    scheduler.start();
	    scheduler.scheduleJob(job0, trigger0);
	    scheduler.scheduleJob(job1, trigger1);
	    scheduler.scheduleJob(job2, trigger2);
	} catch (SchedulerException e) {
	    if (log.isErrorEnabled()) {
		log.error("Quertz Scheduler Listener context initialization error", e);
	    }
	}

    }

}
