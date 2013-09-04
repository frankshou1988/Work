package com.tetrapak.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HU {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
	try {
	    // Create the SessionFactory from hibernate.cfg.xml
	    Configuration config = new Configuration().configure();
	    SessionFactory sf = config.buildSessionFactory();
	    return sf;
	} catch (Throwable ex) {
	    throw new ExceptionInInitializerError(ex);
	}
    }

    public static SessionFactory getSessionFactory() {
	return sessionFactory;
    }
}
