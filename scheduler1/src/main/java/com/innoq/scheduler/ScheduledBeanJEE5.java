package com.innoq.scheduler;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TimedObject;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JEE5 example
 * 
 * @author florian
 *
 */

@Stateless
public class ScheduledBeanJEE5 implements TimedObject {

	private Logger			logger	= LoggerFactory.getLogger(getClass().getCanonicalName());

	// Inject context
	@Resource
	private TimerService	timerService;

	public void initTimer() {
		logger.info("TestTimer1 init");

		// new timer
		timerService.createTimer(1000 * 10, 1000 * 20, "TestTimer1 example");
	}

	@Override
	public void ejbTimeout(Timer arg0) {
		logger.info("ScheduledBeanJEE5      [1] called");
	}

}
