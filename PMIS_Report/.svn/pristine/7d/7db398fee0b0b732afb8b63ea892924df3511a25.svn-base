package com.tetrapak.action.bpu;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.domain.bpu.BPUMachine;
import com.tetrapak.domain.bpu.BPUPhaseStat;
import com.tetrapak.metaclass.BPUEfficacy;
import com.tetrapak.model.bpu.BPUUtilizationQueryModel;
import com.tetrapak.util.bpu.BPUMachineUtil;

public class BPUUtilizationAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private String bpuMachineName;
    private String queryStartDate;
    private String queryEndDate;
    private double rate;
    private Map<BPUMachine, Double> rateMap;
    private Map<BPUPhaseStat, BPUEfficacy> efficacyMap;
    private BPUMachine selectedBPUMachine;

    public double getRate() {
	return rate;
    }

    public void setRate(double rate) {
	this.rate = rate;
    }

    public Map<BPUMachine, Double> getRateMap() {
	return rateMap;
    }

    public void setRateMap(Map<BPUMachine, Double> rateMap) {
	this.rateMap = rateMap;
    }

    public String getBpuMachineName() {
	return bpuMachineName;
    }

    public void setBpuMachineName(String bpuMachineName) {
	this.bpuMachineName = bpuMachineName;
    }

    public String getQueryStartDate() {
	return queryStartDate;
    }

    public void setQueryStartDate(String queryStartDate) {
	this.queryStartDate = queryStartDate;
    }

    public String getQueryEndDate() {
	return queryEndDate;
    }

    public void setQueryEndDate(String queryEndDate) {
	this.queryEndDate = queryEndDate;
    }

    public BPUMachine getSelectedBPUMachine() {
	return selectedBPUMachine;
    }

    public void setSelectedBPUMachine(BPUMachine selectedBPUMachine) {
	this.selectedBPUMachine = selectedBPUMachine;
    }

    public Map<BPUPhaseStat, BPUEfficacy> getEfficacyMap() {
	return efficacyMap;
    }

    public void setEfficacyMap(Map<BPUPhaseStat, BPUEfficacy> efficacyMap) {
	this.efficacyMap = efficacyMap;
    }

    public String queryBPUUtilizationReportResult() throws Exception {
	rateMap = new TreeMap<BPUMachine, Double>();
	List<BPUMachine> bpuMachineList = BPUMachineUtil.getBPUMachineList();
	for (BPUMachine bpuMachine : bpuMachineList) {
	    String bmName = bpuMachine.getMachineName();
	    double urate = BPUUtilizationQueryModel.getPercentageOfUtilization(queryStartDate, queryEndDate, bmName);
	    if (bmName.equals(bpuMachineName)) {
		this.setRate(urate);
		this.setSelectedBPUMachine(bpuMachine);
	    }
	    rateMap.put(bpuMachine, urate);
	}
	// production efficacy
	this.setEfficacyMap(BPUUtilizationQueryModel.getBPUEfficacy(bpuMachineName, queryStartDate, queryEndDate));
	return SUCCESS;
    }
}
