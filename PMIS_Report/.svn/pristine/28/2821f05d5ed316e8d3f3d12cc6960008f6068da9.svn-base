package com.tetrapak.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tetrapak.config.PMISConfigLoader;

/**
 * PMIS Configuration Loader Listener Automatic load the configuration file when
 * tomcat starts up.
 * */
public class PMISConfigLoaderListener implements ServletContextListener {
    private Logger log = LoggerFactory.getLogger(PMISConfigLoaderListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent e) {
	if (log.isDebugEnabled())
	    log.debug("Destroy the PMIS Configuration Loader Listener...");
    }

    @Override
    public void contextInitialized(ServletContextEvent e) {
	if (log.isDebugEnabled())
	    log.debug("Initialize the PMIS Configuration Loader Listener...");
	PMISConfigLoader.loadConfig();
    }

}
