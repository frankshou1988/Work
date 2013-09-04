<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="../../header.jsp"></jsp:include>
<script type="text/javascript" src="<s:url value="/public/js/cip_report.js"/>"></script>
<div id="main-container">
	<div id="query-condition-result-tab">
		<ul>
			<li><a href="#query-condition-panel"><s:text name="i18n.select.query.condition" /></a></li>
			<li><a href="#query-result-panel"><s:text name="i18n.select.query.result" /></a></li>
		</ul>
		<div id="query-condition-panel">
			<input type="hidden" value="<s:text name="i18n.all"/>" id="all-text" />
			<form action="<s:url value="/cip/cipReportQuery.action"/>" method="GET" autocomplete="off" id="cip-report-form" class="form-horizontal query-form">
				<fieldset>
					<legend>
						<s:text name="i18n.cip.query" />
					</legend>
					<table class="table query-table">
						<tr>
							<td><label><s:text name="i18n.cip.master.line" /></label> <select name="cipMasterLineId" id="cip-master-line-list">
									<option value="0">
										<s:text name="i18n.all" />
									</option>
									<s:iterator value="@com.tetrapak.util.cip.CIPLineUtil@getCIPMasterLineListOfWorkshop('MAIN')" var="cipMasterLine" status="stat">
										<option value="<s:property value="id"/>">
											<s:property value="cipMasterLineDesc" />
										</option>
									</s:iterator>
							</select></td>
							<td><label><s:text name="i18n.query.start.datetime" /></label> <input type="text" name="queryStartDate" class="date-time-picker" /></td>
							<td></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.slave.line" /></label> <select name="cipSlaveLineId" id="cip-slave-line-list">
									<option value="0">
										<s:text name="i18n.all" />
									</option>
									<s:if test="cipMasterLineId">
										<s:iterator value="@com.tetrapak.util.cip.CIPLineUtil@getCIPSlaveLineListByMasterLineId(cipMasterLineId)" var="cipSlaveLine">
											<option value="<s:property value="id"/>">
												<s:property value="cipSlaveLineName" />
											</option>
										</s:iterator>
									</s:if>
							</select></td>
							<td><label><s:text name="i18n.query.end.datetime" /></label> <input type="text" name="queryEndDate" class="date-time-picker" /></td>
							<td></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.target" /></label> <select name="cipTargetName" id="cip-target-name">
									<option value="">
										<s:text name="i18n.all" />
									</option>
									<s:iterator value="@com.tetrapak.util.cip.CIPTargetUtil@getCIPTargetListOfWorkshop('MAIN')" var="cipTarget">
										<option value="<s:property value="cipTargetName"/>">
											<s:property value="cipTargetName" />&nbsp;<s:property value="cipTargetDesc" />
										</option>
									</s:iterator>
							</select></td>
							<td><label><s:text name="i18n.query.time.interval" /></label> <select name="cipQueryTimeInterval" id="query-time-interval">
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
							<td></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.type" /></label> <select name="cipTypePLCId" id="cip-type-plc-id">
									<option value="0">
										<s:text name="i18n.all" />
									</option>
									<s:iterator value="@com.tetrapak.util.cip.CIPTypeUtil@getCIPTypeListOfTPM6()" var="cipType" status="stat">
										<option value="<s:property value="cipTypePLCId"/>">
											<s:property value="cipTypeDesc" />
										</option>
									</s:iterator>
							</select></td>
							<td><label><s:text name="i18n.record.order" /></label> <select name="orderType" id="order-type">
									<option value="ORDER_BY_DATE_TIME_DESC">
										<s:text name="i18n.order.by.datetime.desc" />
									</option>
									<option value="ORDER_BY_DATE_TIME_ASC">
										<s:text name="i18n.order.by.datetime.asc" />
									</option>
							</select><input type="hidden" name="page" value="1" id="cip-report-result-page" /></td>
							<td><label>&nbsp;</label></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.result" /></label> <select name="cipResultPLCId" id="cip-result-plc-id">
									<option value="0">
										<s:text name="i18n.all" />
									</option>
									<s:iterator value="@com.tetrapak.util.cip.CIPResultUtil@getCIPResultListOfTPM6()" var="cipResult" status="stat">
										<option value="<s:property value="cipResultPLCId"/>">
											<s:property value="cipResultDesc" />
										</option>
									</s:iterator>
							</select></td>
							<td><label>&nbsp;</label> <input type="hidden" value="MAIN" name="workshopType" /><input type="submit" value="<s:text name="i18n.query"/>" class="btn btn-primary" /></td>
						</tr>
					</table>
				</fieldset>
				<s:fielderror></s:fielderror>
			</form>
		</div>
		<s:if test="cipReportResultList">
			<div id="query-result-panel">
				<s:if test="cipReportPageCount">
					<div style="margin-bottom: 2px;">
						<table style="width: 100%;">
							<tr>
								<td style="width: 300px;"><span style="font-weight: bold; font-size: 14px;"><s:text name="i18n.page.all" />&nbsp;<s:property value="cipReportPageCount" />&nbsp;<s:text
											name="i18n.pages" />,&nbsp;<s:text name="i18n.current.page" /></span> <select name="page" style="width: 80px; vertical-align: baseline;" id="cip-report-result-page-list">
										<s:iterator value="new int[cipReportPageCount]" var="page" status="stat">
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
				<table class="cip-result-table">
					<thead>
						<tr>
							<th colspan="11"><s:text name="i18n.cip.general.info" /></th>
							<th colspan="4"><s:text name="i18n.cip.pre.rinse" /></th>
							<th colspan="7"><s:text name="i18n.cip.lye" /></th>
							<th colspan="7"><s:text name="i18n.cip.acid" /></th>
							<th colspan="4"><s:text name="i18n.cip.final.rinse" /></th>
							<th colspan="4"><s:text name="i18n.cip.ster" /></th>
							<th><s:text name="i18n.trend" /></th>
						</tr>
						<tr>
							<th><s:text name="i18n.no" /></th>
							<th><s:text name="i18n.cip.target.name" /></th>
							<th><s:text name="i18n.cip.target.desc" /></th>
							<th><s:text name="i18n.cip.slave.line" /></th>
							<th><s:text name="i18n.cip.type" /></th>
							<th><s:text name="i18n.cip.start.time" /></th>
							<th><s:text name="i18n.cip.end.time" /></th>
							<th><s:text name="i18n.cip.last.time" /></th>
							<th><s:text name="i18n.cip.result" /></th>
							<th><s:text name="i18n.cip.operator" /></th>
							<th><s:text name="i18n.time.since.last.operation"/></th>

							<th><s:text name="i18n.cip.flush.time" /></th>
							<th><s:text name="i18n.cip.flow.out" /></th>
							<th><s:text name="i18n.cip.tt.out" /></th>
							<th><s:text name="i18n.cip.tt.back" /></th>

							<th><s:text name="i18n.cip.cycle.start.time" /></th>
							<th><s:text name="i18n.cip.cycle.end.time" /></th>
							<th><s:text name="i18n.cip.last.time" /></th>
							<th><s:text name="i18n.cip.flow.out" /></th>
							<th><s:text name="i18n.cip.tt.out" /></th>
							<th><s:text name="i18n.cip.tt.back" /></th>
							<th><s:text name="i18n.cip.ct.back" /></th>

							<th><s:text name="i18n.cip.cycle.start.time" /></th>
							<th><s:text name="i18n.cip.cycle.end.time" /></th>
							<th><s:text name="i18n.cip.last.time" /></th>
							<th><s:text name="i18n.cip.flow.out" /></th>
							<th><s:text name="i18n.cip.tt.out" /></th>
							<th><s:text name="i18n.cip.tt.back" /></th>
							<th><s:text name="i18n.cip.ct.back" /></th>

							<th><s:text name="i18n.cip.flush.time" /></th>
							<th><s:text name="i18n.cip.flow.out" /></th>
							<th><s:text name="i18n.cip.tt.out" /></th>
							<th><s:text name="i18n.cip.tt.back" /></th>

							<th><s:text name="i18n.cip.last.time" /></th>
							<th><s:text name="i18n.cip.flow.out" /></th>
							<th><s:text name="i18n.cip.tt.out" /></th>
							<th><s:text name="i18n.cip.tt.back" /></th>
							
							<th><s:text name="i18n.trend" /></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="cipReportResultList" var="cipReportResult" status="stat">
							<tr>
								<td class="light"><s:property value="#stat.index+1" /></td>
								<td class="light"><s:property value="cipTargetName" /></td>
								<td class="light"><s:property value="cipTargetDesc" /></td>
								<td class="light"><s:property value="cipSlaveLineName" /></td>
								<td class="light"><s:property value="cipType" /></td>
								<td class="light"><s:date name="cipStartDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
								<td class="light"><s:date name="cipEndDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
								<td class="light"><s:property value="cipLastTime" /></td>
								<s:if test="cipResultPLCId == 58">
									<td class="flushed"><s:property value="cipResult" /></td>
								</s:if>
								<s:elseif test="cipResultPLCId == 45">
									<td class="notclean"><s:property value="cipResult" /></td>
								</s:elseif>
								<s:elseif test="cipResultPLCId ==60">
									<td class="clean"><s:property value="cipResult" /></td>
								</s:elseif>
								<s:elseif test="cipResultPLCId ==62">
									<td class="stered"><s:property value="cipResult" /></td>
								</s:elseif>
								<s:else>
									<td>N/A</td>
								</s:else>
								<td class="light"><s:property value="cipOperatedByName" /></td>
								<td><s:property value="timeSinceLastOperation"/></td>

								<td><s:property value="cipPreRinseLastTime" /></td>
								<td><s:property value="cipPreRinseFlowOut" /></td>
								<td><s:property value="cipPreRinseTemperatureOut" /></td>
								<td><s:property value="cipPreRinseTemperatureBack" /></td>

								<td class="light"><s:date name="cipLyeCycleStartDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
								<td class="light"><s:date name="cipLyeCycleEndDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
								<td class="light"><s:property value="cipLyeCycleLastTime" /></td>
								<td class="light"><s:property value="cipLyeCycleFlowOut" /></td>
								<td class="light"><s:property value="cipLyeCycleTemperatureOut" /></td>
								<td class="light"><s:property value="cipLyeCycleTemperatureBack" /></td>
								<td class="light"><s:property value="cipLyeCycleConductivityBack" /></td>

								<td><s:date name="cipAcidCycleStartDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
								<td><s:date name="cipAcidCycleEndDateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
								<td><s:property value="cipAcidCycleLastTime" /></td>
								<td><s:property value="cipAcidCycleFlowOut" /></td>
								<td><s:property value="cipAcidCycleTemperatureOut" /></td>
								<td><s:property value="cipAcidCycleTemperatureBack" /></td>
								<td><s:property value="cipAcidCycleConductivityBack" /></td>

								<td class="light"><s:property value="cipFinalRinseLastTime" /></td>
								<td class="light"><s:property value="cipFinalRinseFlowOut" /></td>
								<td class="light"><s:property value="cipFinalRinseTemperatureOut" /></td>
								<td class="light"><s:property value="cipFinalRinseTemperatureBack" /></td>

								<td><s:property value="cipSterilizeLastTime" /></td>
								<td><s:property value="cipSterilizeFlowOut" /></td>
								<td><s:property value="cipSterilizeTemperatureOut" /></td>
								<td><s:property value="cipSterilizeTemperatureBack" /></td>
								
								<td><a target="_blank"
									href="<s:url value="/cip/cipTrend/cipTrendQuery.action"/>
								?cipTrendTagMasterLineId=<s:property value="cipMasterLineId"/>
								&queryStartDate=<s:date name="cipStartDateTime"  format="yyyy-MM-dd HH:mm:ss"/>
								&queryEndDate=<s:date name="cipEndDateTime"  format="yyyy-MM-dd HH:mm:ss"/>
								&cipQueryTimeInterval=I_DEFAULT
								&queryInterval=30
								&queryIntervalUnit=1
								<s:iterator value="@com.tetrapak.util.cip.CIPTrendTagUtil@getCIPTrendTagsOfMasterLine(cipMasterLineId)" var="cipTrendTag">
									&cipTrendTagNameList=<s:property value="cipTrendTagName"/>
								</s:iterator>
								">
										<img src="<s:url value="/public/images/trend.png"/>" />
								</a></td>
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
					$("#cip-master-line-list").val("<s:property value="#parameters.cipMasterLineId"/>");
					$("#cip-slave-line-list").val("<s:property value="#parameters.cipSlaveLineId"/>");
					$("#cip-type-plc-id").val("<s:property value="#parameters.cipTypePLCId"/>");
					$("#cip-result-plc-id").val("<s:property value="#parameters.cipResultPLCId"/>");
					$("input[name=queryStartDate]").val("<s:property value="#parameters.queryStartDate"/>");
					$("input[name=queryEndDate]").val("<s:property value="#parameters.queryEndDate"/>");
					$("#query-time-interval").val("<s:property value="#parameters.cipQueryTimeInterval"/>");
					$("#order-type").val("<s:property value="#parameters.orderType"/>");
					$("#cip-report-result-page-list").val("<s:property value="#parameters.page"/>");
					$("#cip-target-name").val("<s:property value="#parameters.cipTargetName"/>");
				});
			</script>
		</s:if>
	</div>
	<input type="hidden" id="cip-get-slave-line-of-master-line-url" value="<s:url value="/cip/ajax/getSlaveLineOfMasterLine.action"/>" />
	<div id="save-dialog" title="<s:text name="i18n.save.query.result"/>" class="popup-dialog">
		<form action="<s:url value="/cip/cipReportSave.action"/>" method="POST" id="save-query-result-form" class="form-horizontal save-dialog-form">
			<input type="hidden" name="cipMasterLineId" value="<s:property value="#parameters.cipMasterLineId"/>" /> <input type="hidden" name="cipSlaveLineId"
				value="<s:property value="#parameters.cipSlaveLineId"/>" /> <input type="hidden" name="cipTypePLCId" value="<s:property value="#parameters.cipTypePLCId"/>" /> <input type="hidden"
				name="cipResultPLCId" value="<s:property value="#parameters.cipResultPLCId"/>" /> <input type="hidden" name="cipTargetName" value="<s:property value="#parameters.cipTargetName"/>" /> <input
				type="hidden" name="queryStartDate" value="<s:property value="#parameters.queryStartDate"/>" /> <input type="hidden" name="queryEndDate" value="<s:property value="#parameters.queryEndDate"/>" />
			<input type="hidden" name="orderType" value="<s:property value="#parameters.orderType"/>" /><input type="hidden" value="<s:property value="#parameters.workshopType"/>" name="workshopType" />
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
					<label class="checkbox"><input type="checkbox" name="includeCIPDetails" checked value="INCLUDE_CIP_DETAILS" />&nbsp;<s:text name="i18n.file.include.cip.details" /></label>
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
