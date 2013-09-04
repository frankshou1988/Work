package com.tetrapak.model.bpu;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.tetrapak.config.Constants;
import com.tetrapak.domain.bpu.BPUMachine;
import com.tetrapak.domain.bpu.BPUPhaseStat;
import com.tetrapak.domain.bpu.BPUReportResult;
import com.tetrapak.domain.bpu.BPUReportStepResult;
import com.tetrapak.metaclass.BPUEfficacy;
import com.tetrapak.metaclass.PeriodLastTime;
import com.tetrapak.util.bpu.BPUMachineUtil;
import com.tetrapak.util.bpu.BPUPhaseStatUtil;
import com.tetrapak.util.common.Tools;

public class BPUUtilizationQueryModel {
    public static double getPercentageOfUtilization(String queryStartDate, String queryEndDate, String bpuMachineName)
	    throws Exception {
	double rate = 0d;
	List<BPUReportResult> bpuReportResultList = BPUReportQueryActionModel.queryBPUReportResult(bpuMachineName,
		queryStartDate, queryEndDate, Constants.ORDER_BY_DATE_TIME_DESC);
	PeriodLastTime bpuProdTotalTime = new PeriodLastTime();
	for (BPUReportResult each : bpuReportResultList) {
	    PeriodLastTime tt = new PeriodLastTime();
	    tt.parsePeriodLastTime(each.getBpuProdLastTime());
	    bpuProdTotalTime.add(tt);
	}
	PeriodLastTime totalTime = Tools.dateDiffMinutes(queryStartDate, queryEndDate);
	long totalTimeInSeconds = totalTime.getTimeInSeconds();
	if (totalTimeInSeconds != 0) {
	    rate = bpuProdTotalTime.getTimeInSeconds() * 100.0 / totalTimeInSeconds;
	}
	return Tools.formatDoubleFourOutFiveIn(rate);
    }

    public static Map<BPUPhaseStat, BPUEfficacy> getBPUEfficacy(String bpuMachineName, String queryStartDate,
	    String queryEndDate) throws Exception {
	BPUMachine bpuMachine = BPUMachineUtil.getBPUMachineByName(bpuMachineName);
	Map<BPUPhaseStat, BPUEfficacy> efficacyMap = new TreeMap<BPUPhaseStat, BPUEfficacy>();
	List<BPUPhaseStat> bpuPhaseStatList = BPUPhaseStatUtil.getBPUPhaseStatOfMachine(bpuMachine.getMachineType());
	long timeInSeconds = 0;
	for (BPUPhaseStat bpuPhaseStat : bpuPhaseStatList) {
	    int phaseStatN = bpuPhaseStat.getBpuPhaseStatN();
	    List<BPUReportStepResult> bpuReportStepResultList = BPUReportStepQueryActionModel.queryBPUReportStepResult(
		    bpuMachineName, queryStartDate, queryEndDate, phaseStatN);
	    PeriodLastTime phaseLastTime = new PeriodLastTime();

	    for (BPUReportStepResult bpuReportStepResult : bpuReportStepResultList) {
		PeriodLastTime tmp = new PeriodLastTime();
		tmp.parsePeriodLastTime(bpuReportStepResult.getStepLastTime());
		phaseLastTime.add(tmp);
	    }
	    timeInSeconds += phaseLastTime.getTimeInSeconds();
	    BPUEfficacy eff = new BPUEfficacy();
	    eff.setBpuLastTime(phaseLastTime);
	    efficacyMap.put(bpuPhaseStat, eff);
	}
	Set<Entry<BPUPhaseStat, BPUEfficacy>> entrySet = efficacyMap.entrySet();
	for (Entry<BPUPhaseStat, BPUEfficacy> entry : entrySet) {
	    BPUEfficacy eff = entry.getValue();
	    double rate = 0;
	    if (timeInSeconds != 0) {
		rate = Tools.formatDoubleFourOutFiveIn(eff.getBpuLastTime().getTimeInSeconds() * 100.0 / timeInSeconds);
	    }
	    eff.setRate(rate);
	}
	return efficacyMap;
    }
}
