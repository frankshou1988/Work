package com.tetrapak.test;

import com.tetrapak.config.PMISConfigLoader;
import com.tetrapak.util.bpu.BPUAlarmReportAnalyser;

public class GenerateBPUAlarmReportData {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	PMISConfigLoader.loadConfig();
	BPUAlarmReportAnalyser.bpuAlarmReportAnalyse();
    }

}
