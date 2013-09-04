package com.tetrapak.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TPPMS Configuration Loader - load configuration file of tppms.config.xml
 * */
public class PMISConfigLoader {
    private static Logger log = LoggerFactory.getLogger(PMISConfigLoader.class);

    public static void loadConfig() {
	SAXReader reader = new SAXReader();
	try {
	    Document doc = reader.read(PMISConfigLoader.class.getClassLoader().getResourceAsStream("pmis.config.xml"));
	    Node appNameNode = doc.selectSingleNode("//PMISConfig/AppName");
	    PMISConfig.setAppName(appNameNode.getText());

	    Node appMainVersionNode = doc.selectSingleNode("//PMISConfig/AppVersion/MainVersion");
	    PMISConfig.setAppMainVersion(appMainVersionNode.getText());

	    Node appSubVersionNode = doc.selectSingleNode("//PMISConfig/AppVersion/SubVersion");
	    PMISConfig.setAppSubVersion(appSubVersionNode.getText());

	    Node odbcDatasourceNode = doc.selectSingleNode("//PMISConfig/InSQL/DBConfig/Url");
	    PMISConfig.setInsqlDBUrl(odbcDatasourceNode.getText());

	    Node odbcUsernameNode = doc.selectSingleNode("//PMISConfig/InSQL/DBConfig/Username");
	    PMISConfig.setInsqlDBUsername(odbcUsernameNode.getText());

	    Node odbcPasswordNode = doc.selectSingleNode("//PMISConfig/InSQL/DBConfig/Password");
	    PMISConfig.setInsqlDBPassword(odbcPasswordNode.getText());

	    Node tagMinValueNode = doc.selectSingleNode("//PMISConfig/InSQL/TagValue/TagMinValue");
	    PMISConfig.setTagMinValue(Integer.parseInt(tagMinValueNode.getText()));

	    Node tagValueIntervalMillisNode = doc
		    .selectSingleNode("//PMISConfig/InSQL/TagValue/TagValueIntervalMillis");
	    PMISConfig.setTagValueIntervalMillis(Integer.parseInt(tagValueIntervalMillisNode.getText()));

	    Node avoidTagValueNullCountNode = doc
		    .selectSingleNode("//PMISConfig/InSQL/TagValue/AvoidTagValueNullCount");
	    PMISConfig.setAvoidTagValueNullCount(Integer.parseInt(avoidTagValueNullCountNode.getText()));

	    Node daserverUpdateIntervalNode = doc.selectSingleNode("//PMISConfig/InSQL/DaserverUpdateInterval");
	    PMISConfig.setDaserverUpdateInterval(Integer.parseInt(daserverUpdateIntervalNode.getText()));

	    Node cipReportPageCountNode = doc.selectSingleNode("//PMISConfig/CIPReport/CIPReportPageCount");
	    PMISConfig.setCipReportPageCount(Integer.parseInt(cipReportPageCountNode.getText()));

	    Node bpuReportPageCountNode = doc.selectSingleNode("//PMISConfig/BPUReport/BPUReportPageCount");
	    PMISConfig.setBpuReportPageCount(Integer.parseInt(bpuReportPageCountNode.getText()));

	    Node bpuAlarmReportPageCountNode = doc.selectSingleNode("//PMISConfig/BPUReport/BPUAlarmReportPageCount");
	    PMISConfig.setBpuAlarmReportPageCount(Integer.parseInt(bpuAlarmReportPageCountNode.getText()));

	} catch (DocumentException e) {
	    if (log.isErrorEnabled())
		log.error("Unable to load PMIS Configuration file pmis.config.xml", e);
	}
    }
}
