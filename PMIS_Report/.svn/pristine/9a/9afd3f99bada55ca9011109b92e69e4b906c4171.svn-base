package com.tetrapak.util.bpu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tetrapak.domain.bpu.BPUMachine;
import com.tetrapak.domain.bpu.BPUPhaseStat;
import com.tetrapak.domain.bpu.BPUReportAnalysePoint;
import com.tetrapak.domain.bpu.BPUReportResult;
import com.tetrapak.domain.bpu.BPUReportStepResult;
import com.tetrapak.domain.bpu.BPUStepN;
import com.tetrapak.insql.InSQLDaoUtil;
import com.tetrapak.metaclass.AlsafePhaseStat;
import com.tetrapak.metaclass.AlsafeStep;
import com.tetrapak.metaclass.BPUMachineTypes;
import com.tetrapak.util.common.Tools;

public class BPUReportAnalyser {
    private static Logger log = LoggerFactory.getLogger(BPUReportAnalyser.class);

    public static void bpuReportAnalyse() throws Exception {
	String queryEndDate = Tools.toDateStr(new Date());
	List<BPUMachine> bpuMachineList = BPUMachineUtil.getBPUMachineList();
	for (BPUMachine bpuMachine : bpuMachineList) {
	    String latestAnalysisDateTime = "";
	    BPUReportAnalysePoint point = BPUReportAnalyseUtil.getBPUReportAnalysePointOfBPUMachine(bpuMachine
		    .getMachineName());
	    String queryStartDate = point.getBpuReportLatestAnalyseDateTime();
	    List<String> bpuSectionDateTimeList = BPUReportAnalyseUtil.getBPUSectionList(
		    bpuMachine.getStepNumberInSQLTag(), queryStartDate, queryEndDate);
	    int bpuSectionSize = bpuSectionDateTimeList.size();
	    if (bpuSectionSize > 0) {
		/**
		 * we treat 0 as a start point and the next 0 as an end point,so
		 * the last 0 will be put into the next analysis process
		 * */
		for (int i = 0; i < bpuSectionSize; i++) {
		    if (i + 1 < bpuSectionSize) {
			String bpuSectionStartDate = bpuSectionDateTimeList.get(i);
			String bpuSectionEndDate = bpuSectionDateTimeList.get(i + 1);
			// add update interval
			bpuSectionStartDate = Tools.addUpdateInterval(bpuSectionStartDate);
			// get the status and steps between this period
			Map<String, Integer> bpuStepsMap = InSQLDaoUtil.getIntValueMap(
				bpuMachine.getStepNumberInSQLTag(), bpuSectionStartDate, bpuSectionEndDate);
			String bpuReportResultUniqueId = Tools.createBPUReportUniqueId(bpuMachine.getMachineName());
			Set<Entry<String, Integer>> entrySet = bpuStepsMap.entrySet();
			boolean prodStartDateTimeSet = false;
			String prodStartDateTime = null;
			String prodEndDateTime = null;
			/**
			 * Step start/end date time
			 * */
			String bpuStepAnalysisStartDateTime = bpuSectionStartDate;
			String bpuStepAnalysisEndDateTime = null;
			List<String> stepStartTimeList = new ArrayList<String>();
			stepStartTimeList.addAll(bpuStepsMap.keySet());
			int count = 0;
			int keyCount = stepStartTimeList.size();

			for (Entry<String, Integer> entry : entrySet) {
			    String timestamp = entry.getKey();
			    Integer step = entry.getValue();
			    if (step != 0 && !prodStartDateTimeSet) {
				prodStartDateTime = timestamp;
				prodStartDateTimeSet = true;
			    }
			    if (count + 1 < keyCount) {
				bpuStepAnalysisEndDateTime = stepStartTimeList.get(count + 1);
				count += 1;
			    } else {
				bpuStepAnalysisEndDateTime = bpuSectionEndDate;
			    }

			    // analyze the bpu steps here
			    bpuStepAnalysisStartDateTime = analyseBPUSteps(step, bpuMachine,
				    bpuStepAnalysisStartDateTime, bpuStepAnalysisEndDateTime, bpuReportResultUniqueId);
			}
			// set prod end date time
			prodEndDateTime = bpuSectionEndDate;
			// save bpu report result
			BPUReportResult bpuReportResult = new BPUReportResult();
			bpuReportResult.setBpuReportResultUniqueId(bpuReportResultUniqueId);
			bpuReportResult.setBpuMachineId(bpuMachine.getId());
			bpuReportResult.setBpuMachineName(bpuMachine.getMachineName());
			bpuReportResult.setBpuMachineDesc(bpuMachine.getMachineDesc());
			bpuReportResult.setBpuMachineSerialNumber(bpuMachine.getMachineSerialNumber());
			if (prodStartDateTime != null && prodEndDateTime != null) {
			    bpuReportResult.setBpuProdStartDateTime(Tools.toDate(prodStartDateTime).getTime());
			    bpuReportResult.setBpuProdEndDateTime(Tools.toDate(prodEndDateTime).getTime());
			    bpuReportResult.setBpuProdLastTime(Tools.dateDiffMinutes(prodStartDateTime,
				    prodEndDateTime, true).getHumanTime());
			    BPUReportAnalyseUtil.saveBPUReportResult(bpuReportResult);
			} else {
			    if (prodStartDateTime == null) {
				if (log.isErrorEnabled())
				    log.error(Tools.createErrorMsg("Can not find bpu start time\t"
					    + bpuMachine.getMachineName())
					    + "\t" + bpuReportResultUniqueId);
			    }
			    if (prodEndDateTime == null) {
				if (log.isErrorEnabled())
				    log.error(Tools.createErrorMsg("Can not find bpu end time\t"
					    + bpuMachine.getMachineName())
					    + "\t" + bpuReportResultUniqueId);
			    }
			}
		    }
		}
		latestAnalysisDateTime = bpuSectionDateTimeList.get(bpuSectionSize - 1);
		// update latest date time
		if (!latestAnalysisDateTime.isEmpty()) {
		    BPUReportAnalyseUtil.updateBPUReportAnalysePoint(point.getId(), latestAnalysisDateTime);
		}
	    }
	}
    }

    private static String analyseBPUSteps(Integer step, BPUMachine bpuMachine, String bpuSectionStartDate,
	    String bpuSectionEndDate, String bpuReportResultUniqueId) throws Exception {
	String bpuStepAnalysisStartDateTime = bpuSectionStartDate;
	if (step != 0) {
	    bpuStepAnalysisStartDateTime = analyseBPUStepInfo(step, bpuMachine, bpuSectionStartDate, bpuSectionEndDate,
		    bpuReportResultUniqueId);
	}
	return bpuStepAnalysisStartDateTime;
    }

    public static String analyseBPUStepInfo(int step, BPUMachine bpuMachine, String bpuSectionStartDate,
	    String bpuSectionEndDate, String bpuReportResultUniqueId) throws Exception {
	String bpuStepAnalysisStartDateTime = bpuSectionStartDate;
	String insqlStepTag = bpuMachine.getStepNumberInSQLTag();
	String insqlPhaseStatTag = bpuMachine.getPhaseStatusInSQLTag();
	String machineType = bpuMachine.getMachineType();
	String stepStartDateTime = InSQLDaoUtil.getMinTimestampOfTagValue(insqlStepTag, step, bpuSectionStartDate,
		bpuSectionEndDate);
	String stepEndDateTime = InSQLDaoUtil.getMaxTimestampOfTagValue(insqlStepTag, step, bpuSectionStartDate,
		bpuSectionEndDate);
	if (stepStartDateTime == null || stepEndDateTime == null) {
	    if (stepStartDateTime == null) {
		if (log.isErrorEnabled())
		    log.error(Tools.createErrorMsg("Can not find step start time for step number " + step + " of tag "
			    + insqlStepTag + "\t" + bpuSectionStartDate + "\t" + bpuSectionEndDate)
			    + "\t" + bpuReportResultUniqueId);
	    }
	    if (stepEndDateTime == null) {
		if (log.isErrorEnabled())
		    log.error(Tools.createErrorMsg("Can not find step end time for step number " + step + " of tag "
			    + insqlStepTag + "\t" + bpuSectionStartDate + "\t" + bpuSectionEndDate)
			    + "\t" + bpuReportResultUniqueId);
	    }
	} else {
	    bpuStepAnalysisStartDateTime = stepEndDateTime;
	    Integer phaseStatN = 0;
	    if (machineType.equals(BPUMachineTypes.UHT) && insqlPhaseStatTag != null && !insqlPhaseStatTag.isEmpty()) {
		// get phase stat during this step
		phaseStatN = InSQLDaoUtil.getInSQLIntValue(insqlPhaseStatTag, stepStartDateTime, stepEndDateTime);
	    } else if (machineType.equals(BPUMachineTypes.ALSAFE)) {
		if (step == AlsafeStep.STEP_PROD) {
		    phaseStatN = AlsafePhaseStat.ALSAFE_PROD_PHASE;
		} else {
		    phaseStatN = AlsafePhaseStat.ALSAFE_OTHER_PHASE;
		}
	    }
	    // save bpu report step result
	    BPUReportStepResult stepResult = new BPUReportStepResult();
	    stepResult.setBpuMachineId(bpuMachine.getId());
	    stepResult.setBpuMachineName(bpuMachine.getMachineName());
	    stepResult.setBpuReportResultUniqueId(bpuReportResultUniqueId);
	    stepResult.setStepStartDateTime(Tools.toDate(stepStartDateTime).getTime());
	    stepResult.setStepEndDateTime(Tools.toDate(stepEndDateTime).getTime());
	    stepResult.setStepLastTime(Tools.dateDiffMinutes(stepStartDateTime, stepEndDateTime).getHumanTime());
	    stepResult.setStepN(step);
	    BPUStepN stepNObj = BPUStepNUtil.getBPUStepNByStep(step, bpuMachine.getMachineType());
	    if (stepNObj != null) {
		stepResult.setStepNDesc(stepNObj.getBpuStepNDesc());
	    } else {
		if (log.isErrorEnabled())
		    log.error(Tools.createErrorMsg("Can not find bpu step desc for step " + step + "\t"
			    + bpuReportResultUniqueId));
	    }
	    stepResult.setStepPhaseStatN(phaseStatN);
	    if (phaseStatN != 0) {
		BPUPhaseStat phaseStat = BPUPhaseStatUtil.getBPUPhaseStatByPhaseNumber(phaseStatN,
			bpuMachine.getMachineType());
		if (phaseStat != null) {
		    stepResult.setStepPhaseStatDesc(phaseStat.getBpuPhaseStatNDesc());
		} else {
		    if (log.isErrorEnabled())
			log.error(Tools.createErrorMsg("Can not find bpu phase for phase id " + phaseStatN + "\t"
				+ bpuReportResultUniqueId));
		}
	    } else {
		if (log.isErrorEnabled())
		    log.error(Tools.createErrorMsg("Can not find phase stat for step " + step + " of tag "
			    + insqlPhaseStatTag + "\t" + stepStartDateTime + "\t" + stepEndDateTime)
			    + "\t" + bpuReportResultUniqueId);
	    }
	    BPUReportAnalyseUtil.saveBPUReportStepResult(stepResult);
	}
	return bpuStepAnalysisStartDateTime;
    }
}
