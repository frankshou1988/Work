<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="../../header.jsp"></jsp:include>
<div id="main-container">
	<div id="query-condition-result-tab" style="padding: 0;">
		<ul>
			<li><a href="#query-condition-panel"><s:text name="i18n.bpu.step.details" /></a></li>
		</ul>
		<div id="query-condition-panel" class="form-panel">
			<div>
				<table class="bpu-result-table">
					<thead>
						<tr>
							<th><s:text name="i18n.bpu.machine.name" /></th>
							<th><s:text name="i18n.bpu.machine.desc" /></th>
							<th><s:text name="i18n.bpu.machine.serial.number" /></th>
							<th><s:text name="i18n.bpu.start.time" /></th>
							<th><s:text name="i18n.bpu.end.time" /></th>
							<th><s:text name="i18n.bpu.last.time" /></th>
							<th><s:text name="i18n.action" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><s:property value="bpuReportResult.bpuMachineName" /></td>
							<td><s:property value="bpuReportResult.bpuMachineDesc" /></td>
							<td><s:property value="bpuReportResult.bpuMachineSerialNumber" /></td>
							<td><s:date name="bpuReportResult.bpuProdStartDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
							<td><s:date name="bpuReportResult.bpuProdEndDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
							<td><s:property value="bpuReportResult.bpuProdLastTime" /></td>
							<td><a target="_blank"
								href="<s:url value="/bpu/query/queryBPUTrend.action"/>
								?bpuMachineId=<s:property value="bpuReportResult.bpuMachineId"/>
								&queryStartDate=<s:date name="bpuReportResult.bpuProdStartDateTime" format="yyyy-MM-dd HH:mm:ss" />
								&queryEndDate=<s:date name="bpuReportResult.bpuProdEndDateTime" format="yyyy-MM-dd HH:mm:ss" />
								&queryTimeInterval=I_DEFAULT
								&queryInterval=30
								&queryIntervalUnit=0
								<s:iterator value="@com.tetrapak.util.bpu.BPUAnalogTagUtil@getBPUAnalogTagListOfBPUMachine(bpuReportResult.bpuMachineId)" var="bpuAnalogTag">
									&analogTagIdList=<s:property value="id"/>
								</s:iterator>"><img
									src="<s:url value="/public/images/trend.png"/>" style="width: 20px; height: 20px; margin-right: 5px;" title="<s:text name="i18n.bpu.trend" />"></a> <a
								href="<s:url value="/bpu/query/queryBPUAlarmReportResult.action?"/>?bpuMachineId=<s:property value="bpuReportResult.bpuMachineId"/>
									&queryStartDate=<s:date name="bpuReportResult.bpuProdStartDateTime" format="yyyy-MM-dd HH:mm:ss" />
									&queryEndDate=<s:date name="bpuReportResult.bpuProdEndDateTime" format="yyyy-MM-dd HH:mm:ss" />
									&queryTimeInterval=I_DEFAULT
									&orderType=ORDER_BY_DATE_TIME_ASC
									&page=1
									"
								target="_blank"><img src="<s:url value="/public/images/alarm.png"/>" title="<s:text name="i18n.bpu.alarm"/>" /></a> <a
								href="<s:url value="/bpu/query/queryBPUUtilizationReportResult.action?"/>?bpuMachineName=<s:property value="bpuReportResult.bpuMachineName"/>
									&queryStartDate=<s:date name="bpuReportResult.bpuProdStartDateTime" format="yyyy-MM-dd HH:mm:ss" />
									&queryEndDate=<s:date name="bpuReportResult.bpuProdEndDateTime" format="yyyy-MM-dd HH:mm:ss" />
									&queryTimeInterval=I_DEFAULT"
								target="_blank"><img src="<s:url value="/public/images/utility.png"/>" title="<s:text name="i18n.bpu.efficacy.utility.rate"/>" /></a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div style="margin-top: 10px;">
				<table class="bpu-result-table">
					<thead>
						<tr>
							<th><s:text name="i18n.bpu.phase.desc" /></th>
							<th><s:text name="i18n.bpu.phase.start.date.time" /></th>
							<th><s:text name="i18n.bpu.phase.end.date.time" /></th>
							<th><s:text name="i18n.bpu.phase.last.time" /></th>
							<th><s:text name="i18n.action" /></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="bpuReportPhaseSummaryList" var="summary">
							<tr>
								<td><s:property value="phaseDesc" /></td>
								<td><s:date name="phaseStartDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
								<td><s:date name="phaseEndDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
								<td><s:property value="phaseLastTime" /></td>
								<td><a target="_blank"
									href="<s:url value="/bpu/query/queryBPUTrend.action"/>
								?bpuMachineId=<s:property value="bpuReportResult.bpuMachineId"/>
								&queryStartDate=<s:date name="phaseStartDateTime" format="yyyy-MM-dd HH:mm:ss" />
								&queryEndDate=<s:date name="phaseEndDateTime" format="yyyy-MM-dd HH:mm:ss" />
								&queryTimeInterval=I_DEFAULT
								&queryInterval=30
								&queryIntervalUnit=0
								<s:iterator value="@com.tetrapak.util.bpu.BPUAnalogTagUtil@getBPUAnalogTagListOfBPUMachine(bpuReportResult.bpuMachineId)" var="bpuAnalogTag">
									&analogTagIdList=<s:property value="id"/>
								</s:iterator>"><img
										src="<s:url value="/public/images/trend.png"/>" style="width: 20px; height: 20px; margin-right: 5px;" title="<s:text name="i18n.bpu.trend" />"></a> <a
									href="<s:url value="/bpu/query/queryBPUAlarmReportResult.action?"/>?bpuMachineId=<s:property value="bpuReportResult.bpuMachineId"/>
									&queryStartDate=<s:date name="phaseStartDateTime" format="yyyy-MM-dd HH:mm:ss" />
									&queryEndDate=<s:date name="phaseEndDateTime" format="yyyy-MM-dd HH:mm:ss" />
									&queryTimeInterval=I_DEFAULT
									&orderType=ORDER_BY_DATE_TIME_ASC
									&page=1
									"
									target="_blank"><img src="<s:url value="/public/images/alarm.png"/>" title="<s:text name="i18n.bpu.alarm"/>" /></a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
			<div style="margin-top: 10px;">
				<table class="bpu-result-table">
					<thead>
						<tr>
							<th><s:text name="i18n.no" /></th>
							<th><s:text name="i18n.bpu.step.no" /></th>
							<th><s:text name="i18n.bpu.step.desc" /></th>
							<th><s:text name="i18n.bpu.step.start.date.time" /></th>
							<th><s:text name="i18n.bpu.step.end.date.time" /></th>
							<th><s:text name="i18n.bpu.step.last.time" /></th>
							<th style="display: none;"><s:text name="i18n.bpu.step.no" /></th>
							<th><s:text name="i18n.bpu.step.phase.desc" /></th>
							<th><s:text name="i18n.action" /></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="bpuReportStepResultList" var="bpuReportStepResult" status="stat">
							<tr>
								<td><s:property value="#stat.index+1" /></td>
								<td><s:property value="stepN" /></td>
								<td><s:property value="stepNDesc" /></td>
								<td><s:date name="stepStartDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
								<td><s:date name="stepEndDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
								<td><s:property value="stepLastTime" /></td>
								<td style="display: none;"><s:property value="stepPhaseStatN" /></td>
								<td><s:property value="stepPhaseStatDesc" /></td>
								<td><a target="_blank"
									href="<s:url value="/bpu/query/queryBPUTrend.action"/>
								?bpuMachineId=<s:property value="bpuReportResult.bpuMachineId"/>
								&queryStartDate=<s:date name="stepStartDateTime" format="yyyy-MM-dd HH:mm:ss" />
								&queryEndDate=<s:date name="stepEndDateTime" format="yyyy-MM-dd HH:mm:ss" />
								&queryTimeInterval=I_DEFAULT
								&queryInterval=30
								&queryIntervalUnit=0
								<s:iterator value="@com.tetrapak.util.bpu.BPUAnalogTagUtil@getBPUAnalogTagListOfBPUMachine(bpuReportResult.bpuMachineId)" var="bpuAnalogTag">
									&analogTagIdList=<s:property value="id"/>
								</s:iterator>"><img
										src="<s:url value="/public/images/trend.png"/>" style="width: 20px; height: 20px; margin-right: 5px;" title="<s:text name="i18n.bpu.parameter.trend" />"></a> <a
									href="<s:url value="/bpu/query/queryBPUAlarmReportResult.action?"/>?bpuMachineId=<s:property value="bpuReportResult.bpuMachineId"/>
									&queryStartDate=<s:date name="stepStartDateTime" format="yyyy-MM-dd HH:mm:ss" />
									&queryEndDate=<s:date name="stepEndDateTime" format="yyyy-MM-dd HH:mm:ss" />
									&queryTimeInterval=I_DEFAULT
									&orderType=ORDER_BY_DATE_TIME_ASC
									&page=1
									"
									target="_blank"><img src="<s:url value="/public/images/alarm.png"/>" title="<s:text name="i18n.bpu.alarm"/>" /></a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>