package com.innoq.scheduler;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JEE 6 example
 * 
 * @author florian
 *
 */
@Singleton	// necessary to define this class as a bean
public class ScheduledBeanJEE6 {

	private Logger logger = LoggerFactory.getLogger(getClass().getCanonicalName());
	
	@Schedule(second = "*/20", minute = "*", hour="*", persistent=true)
	public void log() {
		logger.info("ScheduledBeanJEE6      [3] called");
	}

}
