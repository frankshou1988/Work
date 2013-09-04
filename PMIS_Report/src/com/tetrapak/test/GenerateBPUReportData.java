package com.tetrapak.test;

import com.tetrapak.config.PMISConfigLoader;
import com.tetrapak.util.bpu.BPUReportAnalyser;

public class GenerateBPUReportData {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	PMISConfigLoader.loadConfig();
	BPUReportAnalyser.bpuReportAnalyse();
    }

}
