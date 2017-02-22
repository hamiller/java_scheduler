package com.innoq.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Quartz specific example
 * 
 * @author florian
 *
 */
public class ScheduledBeanQuartz implements Job {
	private Logger logger = LoggerFactory.getLogger(getClass().getCanonicalName());
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("ScheduledBeanQuartz    [4] called");
	}
}