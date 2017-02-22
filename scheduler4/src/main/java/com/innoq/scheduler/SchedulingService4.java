package com.innoq.scheduler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Startup
@Singleton // necessary to define this class as a bean
public class SchedulingService4 {
	private Logger		logger	= LoggerFactory.getLogger(getClass().getCanonicalName());
	private Scheduler	scheduler;

	@PostConstruct
	public void initCrons() {
		try {
			logger.info("initialize SchedulingService4");

			scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			JobDetail job1 = JobBuilder.newJob(ScheduledBeanQuartz.class).withIdentity("job1", "group1").build();
			Trigger trigger1 = TriggerBuilder	.newTrigger().withIdentity("trigger1", "group1").startNow()
												.withSchedule(SimpleScheduleBuilder	.simpleSchedule().withIntervalInSeconds(20)
																					.repeatForever())
												.build();

			scheduler.start();
			if (!scheduler.checkExists(job1.getKey())) {
				scheduler.scheduleJob(job1, trigger1);
			}
		}
		catch (Exception ex) {
			logger.error("{}", ex);
		}
	}
	
	@PreDestroy
	public void deleteCrons() {
		logger.info("destroy SchedulingService4");
		try {
			for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals("group1"))) {
				scheduler.deleteJob(jobKey);
			}
		}
		catch (SchedulerException ex) {
			logger.error("Could NOT delete cron jobs: {}", ex);
		}
	}
}
