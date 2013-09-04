package com.tetrapak.insql;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tetrapak.config.PMISConfig;

/**
 * InSQLDao Use database pool to fetch connection from insql database
 * */
public class InSQLDao {
    private static Logger log = LoggerFactory.getLogger(InSQLDao.class);
    private static ComboPooledDataSource dataSource;
    private volatile static InSQLDao instance;
    private String insqlDBUrl;
    private String insqlDBUsername;
    private String insqlDBPassword;

    public static InSQLDao getInstance() throws ClassNotFoundException {
	if (instance == null) {
	    synchronized (InSQLDao.class) {
		if (instance == null) {
		    instance = new InSQLDao();
		    instance.initDataSource();
		}
	    }
	}
	return instance;
    }

    private InSQLDao() throws ClassNotFoundException {
	this.setInsqlDBUrl(PMISConfig.getInsqlDBUrl());
	this.setInsqlDBUsername(PMISConfig.getInsqlDBUsername());
	this.setInsqlDBPassword(PMISConfig.getInsqlDBPassword());
    }

    private void initDataSource() {
	try {
	    dataSource = new ComboPooledDataSource();
	    dataSource.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    dataSource.setJdbcUrl(this.getInsqlDBUrl());
	    dataSource.setUser(this.getInsqlDBUsername());
	    dataSource.setPassword(this.getInsqlDBPassword());
	    dataSource.setAutoCommitOnClose(false);
	    dataSource.setMaxPoolSize(15);
	    dataSource.setMinPoolSize(7);
	    dataSource.setMaxStatements(10);
	    dataSource.setInitialPoolSize(5);
	    dataSource.setMaxIdleTime(30);
	} catch (Exception e) {
	    if (log.isErrorEnabled())
		log.error(e.getMessage());
	}
    }

    public static ComboPooledDataSource getDataSource() {
	return dataSource;
    }

    public static void setDataSource(ComboPooledDataSource dataSource) {
	InSQLDao.dataSource = dataSource;
    }

    public String getInsqlDBUrl() {
	return insqlDBUrl;
    }

    public void setInsqlDBUrl(String insqlDBUrl) {
	this.insqlDBUrl = insqlDBUrl;
    }

    public String getInsqlDBUsername() {
	return insqlDBUsername;
    }

    public void setInsqlDBUsername(String insqlDBUsername) {
	this.insqlDBUsername = insqlDBUsername;
    }

    public String getInsqlDBPassword() {
	return insqlDBPassword;
    }

    public void setInsqlDBPassword(String insqlDBPassword) {
	this.insqlDBPassword = insqlDBPassword;
    }

    public Connection getConnection() throws SQLException {
	return dataSource.getConnection();
    }

}
