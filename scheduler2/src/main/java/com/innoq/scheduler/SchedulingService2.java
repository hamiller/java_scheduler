package com.innoq.scheduler;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import commonj.timers.TimerManager;

@Startup
@Singleton	// necessary to define this class as a bean
public class SchedulingService2 {
	private Logger logger = LoggerFactory.getLogger(getClass().getCanonicalName());

	// Inject timer manager
	@Resource
	private TimerManager tm;
	
	@PostConstruct
	public void initTimer() {
		logger.info("initialize SchedulingService2");
		
		// new timer
		tm.scheduleAtFixedRate(new ScheduledBeanWLS(), 0, 20 * 1000);
	}
}
