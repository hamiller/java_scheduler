package com.innoq.scheduler;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchedulingService1 implements ServletContextListener {
	private Logger			logger	= LoggerFactory.getLogger(getClass().getCanonicalName());

	@EJB
	private ScheduledBeanJEE5 timer1;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("destroy");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("initialize SchedulingService1");
		timer1.initTimer();
	}

}
