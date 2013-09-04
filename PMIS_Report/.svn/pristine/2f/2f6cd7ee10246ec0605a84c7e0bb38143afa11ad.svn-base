package com.tetrapak.test;

import java.util.List;

import com.tetrapak.config.PMISConfigLoader;
import com.tetrapak.metaclass.CIPRealtimeData;
import com.tetrapak.model.cip.CIPRealtimeDataQueryActionModel;

public class TestCIPSlaveLine {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	PMISConfigLoader.loadConfig();
	// List<CIPSlaveLine> list =
	// CIPLineUtil.getCIPSlaveLineListByMasterLineId(1);
	// System.err.println(list.size());
	// List<CIPMasterLine> list=CIPLineUtil.getCIPMasterLineOfTPM5();
	// System.err.println(list.size());
	List<CIPRealtimeData> data = CIPRealtimeDataQueryActionModel.queryCIPRealtimeData();
	for (CIPRealtimeData d : data) {
	    System.err.println(d.getCipMasterLine().getCipMasterLineName() + "\t"
		    + d.getCipPhase().getCipTarget().getCipTargetName() + "\t"
		    + d.getCipPhase().getCipSlaveLine().getCipSlaveLineName() + "\t" + d.getCipTypeDesc() + "\t"
		    + d.getStepNum() + "\tFT:" + d.getFtOut() + "\tTT:" + d.getTtOut() + "\tCT:" + d.getCtBack()
		    + "\tTT:" + d.getTtBack());
	}
    }

}
