package com.innoq.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import commonj.timers.Timer;
import commonj.timers.TimerListener;

/**
 * Weblogic specific example
 * 
 * @author florian
 *
 */
public class ScheduledBeanWLS implements TimerListener {

	private Logger logger = LoggerFactory.getLogger(getClass().getCanonicalName());
	
	@Override
	public void timerExpired(Timer timer) {
		logger.info("ScheduledBeanWLS       [2] called");
	}

}
