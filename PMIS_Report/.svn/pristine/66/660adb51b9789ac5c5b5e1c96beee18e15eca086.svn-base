package com.tetrapak.model.cip;

import java.util.ArrayList;
import java.util.List;

import com.tetrapak.config.Constants;
import com.tetrapak.domain.cip.CIPMasterLine;
import com.tetrapak.domain.cip.CIPPhase;
import com.tetrapak.domain.cip.CIPType;
import com.tetrapak.insql.InSQLDaoUtil;
import com.tetrapak.metaclass.CIPRealtimeData;
import com.tetrapak.metaclass.PLCStructureTypes;
import com.tetrapak.util.cip.CIPLineUtil;
import com.tetrapak.util.cip.CIPReportUtil;
import com.tetrapak.util.common.Tools;

public class CIPRealtimeDataQueryActionModel {
    public static List<CIPRealtimeData> queryCIPRealtimeData() throws Exception {
	List<CIPRealtimeData> cipRealtimeDataList = new ArrayList<CIPRealtimeData>();
	List<CIPMasterLine> cipMasterLineList = CIPLineUtil.getCIPMasterLineList();
	for (CIPMasterLine cipMasterLine : cipMasterLineList) {
	    String operTagName = cipMasterLine.getCipMasterLineOperTag();
	    int operValue = InSQLDaoUtil.getRealtimeDiscreteValue(operTagName);
	    if (operValue == Constants.DISCRETE_ON) {
		CIPRealtimeData data = new CIPRealtimeData();

		// get cip phase
		String phaseIDTagName = cipMasterLine.getCipMasterLineRoutePhaseIDTag();
		int phaseID = InSQLDaoUtil.getRealtimeAnalogValueInt(phaseIDTagName);
		CIPPhase cipPhase = CIPReportUtil.getCIPPhaseByPhaseID(phaseID);
		// get step num
		String stepNumTagName = cipMasterLine.getCipMasterLineStepsTag();
		int stepNum = InSQLDaoUtil.getRealtimeAnalogValueInt(stepNumTagName);
		// get cip type
		String cipTypeTagName = cipMasterLine.getCipMasterLineCIPProgramIDTag();
		int cipTypePlcId = InSQLDaoUtil.getRealtimeAnalogValueInt(cipTypeTagName);
		if (cipMasterLine.getPlcStructureType().equalsIgnoreCase(PLCStructureTypes.TPM6)) {
		    CIPType cipType = CIPReportUtil.getCIPTypeByProgramIDOfTPM6(cipTypePlcId);
		    // set data
		    data.setCipTypePlcId(cipTypePlcId);
		    data.setCipTypeDesc(cipType.getCipTypeDesc());
		}
		if (cipMasterLine.getPlcStructureType().equalsIgnoreCase(PLCStructureTypes.TPM5)) {
		    CIPType cipType = CIPReportUtil.getCIPTypeByProgramIDOfTPM5(cipTypePlcId);
		    // set data
		    data.setCipTypePlcId(cipTypePlcId);
		    data.setCipTypeDesc(cipType.getCipTypeDesc());
		} else if (cipMasterLine.getPlcStructureType().equalsIgnoreCase(PLCStructureTypes.TPM4)) {
		    CIPType cipType = CIPReportUtil.getCIPTypeByProgramIDOfTPM4(cipTypePlcId);
		    // set data
		    data.setCipTypePlcId(cipTypePlcId);
		    data.setCipTypeDesc(cipType.getCipTypeDesc());
		}

		// get analog meter value
		String ftOutTagName = cipMasterLine.getCipMasterLineFlowOutTag();
		double ftOut = InSQLDaoUtil.getRealtimeAnalogValueDouble(ftOutTagName);
		String ttOutTagName = cipMasterLine.getCipMasterLineTemperatureOutTag();
		double ttOut = InSQLDaoUtil.getRealtimeAnalogValueDouble(ttOutTagName);
		String ctBackTagName = cipMasterLine.getCipMasterLineConductivityBackTag();
		double ctBack = InSQLDaoUtil.getRealtimeAnalogValueDouble(ctBackTagName);
		String ttBackTagName = cipMasterLine.getCipMasterLineTemperatureBackTag();
		double ttBack = InSQLDaoUtil.getRealtimeAnalogValueDouble(ttBackTagName);

		// set data
		data.setCipMasterLine(cipMasterLine);
		data.setCipPhase(cipPhase);
		data.setStepNum(stepNum);
		data.setFtOut(Tools.formatDoubleFourOutFiveIn(ftOut));
		data.setTtOut(Tools.formatDoubleFourOutFiveIn(ttOut));
		data.setCtBack(Tools.formatDoubleFourOutFiveIn(ctBack));
		data.setTtBack(Tools.formatDoubleFourOutFiveIn(ttBack));
		cipRealtimeDataList.add(data);
	    }
	}
	return cipRealtimeDataList;
    }
}
