<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="../../header.jsp"></jsp:include>
<script type="text/javascript" src="<s:url value="/public/js/bpu_report.js"/>"></script>
<div id="main-container">
	<div id="query-condition-result-tab">
		<ul>
			<li><a href="#query-condition-panel"><s:text name="i18n.select.query.condition" /></a></li>
			<li><a href="#query-result-panel"><s:text name="i18n.select.query.result" /></a></li>
		</ul>
		<div id="query-condition-panel" class="form-panel">
			<input type="hidden" value="<s:text name="i18n.all"/>" id="all-text" />
			<form action="<s:url value="/bpu/query/queryBPUReportResult.action"/>" method="GET" id="bpu-report-query-form" autocomplete="off" class="form-horizontal query-form">
				<fieldset>
					<legend>
						<s:text name="i18n.bpu.report" />
					</legend>
					<table class="table query-table">
						<tr>
							<td><label><s:text name="i18n.bpu" /></label> <select name="bpuMachineName" id="bpu-machine-name">
									<option value="S_ALL">
										<s:text name="i18n.all" />
									</option>
									<s:iterator value="@com.tetrapak.util.bpu.BPUMachineUtil@getBPUMachineList()" var="bpuMachine">
										<option value="<s:property value="machineName"/>" title="<s:property value="machineDesc"/>">
											<s:property value="machineName" />
											&nbsp;&nbsp;&nbsp;&nbsp;
											<s:property value="machineSerialNumber" />
										</option>
									</s:iterator>
							</select></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.query.start.datetime" /></label> <input type="text" name="queryStartDate" class="date-time-picker" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.query.end.datetime" /></label> <input type="text" name="queryEndDate" class="date-time-picker" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.query.time.interval" /></label> <select name="queryTimeInterval" id="query-time-interval">
									<option value="I_DEFAULT">
										<s:text name="i18n.query.time.interval.default" />
									</option>
									<option value="I_LAST_FOUR_HOUR">
										<s:text name="i18n.query.time.interval.last.four.hour" />
									</option>
									<option value="I_ONE_DAY_BACK">
										<s:text name="i18n.query.time.interval.one.day.back" />
									</option>
									<option value="I_TWO_DAY_BACK">
										<s:text name="i18n.query.time.interval.two.day.back" />
									</option>
									<option value="I_ONE_WEEK_BACK">
										<s:text name="i18n.query.time.interval.one.week.back" />
									</option>
									<option value="I_ONE_MONTH_BACK">
										<s:text name="i18n.query.time.interval.one.month.back" />
									</option>
							</select></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.record.order" /></label> <select name="orderType" id="order-type">
									<option value="ORDER_BY_DATE_TIME_DESC">
										<s:text name="i18n.order.by.datetime.desc" />
									</option>
									<option value="ORDER_BY_DATE_TIME_ASC">
										<s:text name="i18n.order.by.datetime.asc" />
									</option>
							</select> <input type="hidden" name="page" value="1" id="bpu-report-result-page" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="<s:text name="i18n.query"/>" class="btn btn-primary" /></td>
						</tr>
					</table>
					<s:fielderror></s:fielderror>
				</fieldset>
			</form>
		</div>
		<s:if test="bpuReportResultList">
			<div id="query-result-panel">
				<s:if test="bpuReportPageCount">
					<div style="margin-bottom: 2px;">
						<table style="width: 100%;">
							<tr>
								<td style="width: 300px;"><span style="font-weight: bold; font-size: 14px;"><s:text name="i18n.page.all" />&nbsp;<s:property value="bpuReportPageCount" />&nbsp;<s:text
											name="i18n.pages" />,&nbsp;<s:text name="i18n.current.page" /></span> <select name="page" style="width: 80px; vertical-align: baseline;" id="bpu-report-result-page-list">
										<s:iterator value="new int[bpuReportPageCount]" var="page" status="stat">
											<option value="<s:property value="#stat.index+1"/>">
												<s:property value="#stat.index+1" />
											</option>
										</s:iterator>
								</select></td>
								<td style="text-align: right;"><input type="button" value=""
									style="background:url(<s:url value="/public/images/save.png"/>);width:25px;height:25px;border:0;cursor:pointer;float:right;margin-bottom:5px;" alt="<s:text name="i18n.save.query.result"/>"
									title="<s:text name="i18n.save.query.result"/>" id="save-query-result-button" /></td>
							</tr>
						</table>
					</div>
				</s:if>
				<table class="bpu-result-table">
					<thead>
						<tr>
							<th><s:text name="i18n.no" /></th>
							<th><s:text name="i18n.bpu.machine.name" /></th>
							<th><s:text name="i18n.bpu.machine.desc" /></th>
							<th><s:text name="i18n.bpu.machine.serial.number" /></th>
							<th><s:text name="i18n.bpu.start.time" /></th>
							<th><s:text name="i18n.bpu.end.time" /></th>
							<th><s:text name="i18n.bpu.last.time" /></th>
							<th><s:text name="i18n.details" /></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="bpuReportResultList" var="bpuReportResult" status="stat">
							<tr>
								<td><s:property value="#stat.index+1" /></td>
								<td><s:property value="bpuMachineName" /></td>
								<td><s:property value="bpuMachineDesc" /></td>
								<td><s:property value="bpuMachineSerialNumber" /></td>
								<td><s:date name="bpuProdStartDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
								<td><s:date name="bpuProdEndDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
								<td><s:property value="bpuProdLastTime" /></td>
								<td><a href="<s:url value="/bpu/query/queryBPUReportStepResult.action?uid="/><s:property value="bpuReportResultUniqueId"/>"><img src="<s:url value="/public/images/details.png"/>"
										alt="<s:text name="i18n.details"/>" title="<s:text name="i18n.details"/>" style="width: 20px; height: 20px; margin-right: 5px;" /></a><a target="_blank"
									href="<s:url value="/bpu/query/queryBPUTrend.action"/>
								?bpuMachineId=<s:property value="bpuMachineId"/>
								&queryStartDate=<s:date name="bpuProdStartDateTime" format="yyyy-MM-dd HH:mm:ss" />
								&queryEndDate=<s:date name="bpuProdEndDateTime" format="yyyy-MM-dd HH:mm:ss" />
								&queryTimeInterval=I_DEFAULT
								&queryInterval=30
								&queryIntervalUnit=0
								<s:iterator value="@com.tetrapak.util.bpu.BPUAnalogTagUtil@getBPUAnalogTagListOfBPUMachine(bpuMachineId)" var="bpuAnalogTag">
									&analogTagIdList=<s:property value="id"/>
								</s:iterator>"><img
										src="<s:url value="/public/images/trend.png"/>" style="width: 20px; height: 20px; margin-right: 5px;" title="<s:text name="i18n.bpu.trend" />"></a> <a
									href="<s:url value="/bpu/query/queryBPUAlarmReportResult.action?"/>?bpuMachineId=<s:property value="bpuMachineId"/>
									&queryStartDate=<s:date name="bpuProdStartDateTime" format="yyyy-MM-dd HH:mm:ss" />
									&queryEndDate=<s:date name="bpuProdEndDateTime" format="yyyy-MM-dd HH:mm:ss" />
									&queryTimeInterval=I_DEFAULT
									&orderType=ORDER_BY_DATE_TIME_ASC
									&page=1
									"
									target="_blank"><img src="<s:url value="/public/images/alarm.png"/>" title="<s:text name="i18n.bpu.alarm"/>" /></a> <a
									href="<s:url value="/bpu/query/queryBPUUtilizationReportResult.action?"/>?bpuMachineName=<s:property value="bpuMachineName"/>
									&queryStartDate=<s:date name="bpuProdStartDateTime" format="yyyy-MM-dd HH:mm:ss" />
									&queryEndDate=<s:date name="bpuProdEndDateTime" format="yyyy-MM-dd HH:mm:ss" />
									&queryTimeInterval=I_DEFAULT"
									target="_blank"><img src="<s:url value="/public/images/utility.png"/>" title="<s:text name="i18n.bpu.efficacy.utility.rate"/>" /></a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
			<script type="text/javascript">
				$(document).ready(function() {
					$("#query-condition-result-tab").tabs({
						active : 1
					});
				});
			</script>
		</s:if>
		<!-- set the parameters here -->
		<s:if test="#parameters.size gt 0">
			<script type="text/javascript">
				$(function() {
					$("#bpu-machine-name").val("<s:property value="#parameters.bpuMachineName"/>");
					$("input[name=queryStartDate]").val("<s:property value="#parameters.queryStartDate"/>");
					$("input[name=queryEndDate]").val("<s:property value="#parameters.queryEndDate"/>");
					$("#query-time-interval").val("<s:property value="#parameters.queryTimeInterval"/>");
					$("#order-type").val("<s:property value="#parameters.orderType"/>");
					$("#bpu-report-result-page-list").val("<s:property value="#parameters.page"/>");
				});
			</script>
		</s:if>
	</div>
	<div id="save-dialog" title="<s:text name="i18n.save.query.result"/>" class="popup-dialog">
		<form action="<s:url value="/bpu/query/bpuReportResultSave.action"/>" method="POST" id="save-query-result-form" class="form-horizontal save-dialog-form">
			<input type="hidden" name="bpuMachineName" value="<s:property value="#parameters.bpuMachineName"/>" /> <input type="hidden" name="queryStartDate"
				value="<s:property value="#parameters.queryStartDate"/>" /> <input type="hidden" name="queryEndDate" value="<s:property value="#parameters.queryEndDate"/>" /> <input type="hidden"
				name="orderType" value="<s:property value="#parameters.orderType"/>" />
			<div class="control-group">
				<div class="control-label">
					<label><s:text name="i18n.file.type" /></label>
				</div>
				<div class="controls">
					<select name="saveFileType" id="save-file-type">
						<option value="F_PDF">Adobe PDF Format(*.pdf)</option>
						<option value="F_EXCEL">Microsoft Office Excel (*.xls)</option>
					</select>
				</div>
			</div>
			<div class="control-group">
				<div class="control-label">
					<label><s:text name="i18n.file.name" /></label>
				</div>
				<div class="controls">
					<input type="text" name="saveFileName" value="" id="save-file-name" /> <label id="save-file-error-label" class="text-error default-none-display"><s:text name="i18n.file.name.required" /></label>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<input type="submit" value="<s:text name="i18n.save"/>" class="btn btn-primary" /> <input type="button" value="<s:text name="i18n.cancel"/>" id="cancel-save-dialog-button"
						class="btn btn-primary" />
				</div>
			</div>
		</form>
	</div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>