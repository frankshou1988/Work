<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="../../header.jsp"></jsp:include>
<script type="text/javascript" src="<s:url value="/public/js/lib/jquery.flot.pie.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/public/js/cip_perform_analysis_report.js"/>"></script>
<div id="main-container">
	<div id="query-condition-result-tab">
		<ul>
			<li><a href="#query-condition-panel"><s:text name="i18n.select.query.condition" /></a></li>
			<li><a href="#query-result-panel"><s:text name="i18n.select.query.result" /></a></li>
		</ul>
		<div id="query-condition-panel">
			<form action="<s:url value="/cip/cipPerformAnalysisMasterLineQuery.action"/>" method="GET" id="cip-report-form" autocomplete="off" class="form-horizontal query-form">
				<fieldset>
					<legend>
						<s:text name="i18n.cip.analysis.report.masterline.based" />
					</legend>
					<table>
						<tr>
							<td><label><s:text name="i18n.cip.master.line" /></label> <select name="cipMasterLineIdList" id="cip-master-line-list" multiple style="height: 300px;">
									<s:iterator value="@com.tetrapak.util.cip.CIPLineUtil@getCIPMasterLineList()" var="cipMasterLine" status="stat">
										<option value="<s:property value="id"/>">
											<s:property value="cipMasterLineDesc" />
										</option>
									</s:iterator>
							</select></td>
							<td style="vertical-align: top; padding-left: 20px;">
								<table>
									<tr>
										<td><label><s:text name="i18n.query.start.datetime" /></label> <input type="text" name="queryStartDate" class="date-time-picker" /></td>
										<td>
									</tr>
									<tr>
										<td><label><s:text name="i18n.query.end.datetime" /></label> <input type="text" name="queryEndDate" class="date-time-picker" /></td>
									</tr>
									<tr>
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
									</tr>
									<tr>
										<td><label>&nbsp;</label> <input type="submit" value="<s:text name="i18n.query"/>" style="margin-top: 0;" class="btn btn-primary" /></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td><s:fielderror></s:fielderror></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
		<s:if test="cipPerformAnalyseResult">
			<div id="query-result-panel">
				<div class="perform-result">
					<p class="perform-title">
						<s:text name="i18n.select.query.condition" />
					</p>
					<table class="perform-table">
						<tr>
							<td style="vertical-align: top;"><span class="perform-label"><s:text name="i18n.cip.master.line" /></span></td>
							<td><span class="perform-text"><s:iterator value="cipPerformAnalyseResult.cipMasterLineList" var="cipMasterLine">
										<span style="margin-bottom: 2px;"><s:property value="cipMasterLineDesc" /></span>
										<br />
									</s:iterator></span></td>
						</tr>
						<tr>
							<td><span class="perform-label"><s:text name="i18n.query.start.datetime" /></span></td>
							<td><span class="perform-text"><s:date name="cipPerformAnalyseResult.queryStartDateTime" format="yyyy-MM-dd HH:mm:ss" /></span></td>
						</tr>
						<tr>
							<td><span class="perform-label"><s:text name="i18n.query.end.datetime" /></span></td>
							<td><span class="perform-text"><s:date name="cipPerformAnalyseResult.queryEndDateTime" format="yyyy-MM-dd HH:mm:ss" /></span></td>
						</tr>
					</table>
				</div>

				<input type="hidden" value="<s:text name="i18n.cip.type.lye"/>" id="cip-type-lye" /> <input type="hidden" value="<s:text name="i18n.cip.type.acid"/>" id="cip-type-acid" /> <input type="hidden"
					value="<s:text name="i18n.cip.type.lye.acid"/>" id="cip-type-lye-acid" /> <input type="hidden" value="<s:text name="i18n.cip.type.rinse"/>" id="cip-type-rinse" /> <input type="hidden"
					value="<s:text name="i18n.cip.type.sterilize"/>" id="cip-type-sterilize" />
				<!-- cip time -->
				<div class="perform-result">
					<p>
						<span class="perform-label"><s:text name="i18n.cip.analysis.total.cip.time" /></span> <span class="perform-text"><s:property value="cipPerformAnalyseResult.cipTotalLastTime" /></span>
					</p>
					<table class="perform-table">
						<thead>
							<tr>
								<th><s:text name="i18n.cip.type.lye" /></th>
								<th><s:text name="i18n.cip.type.acid" /></th>
								<th><s:text name="i18n.cip.type.lye.acid" /></th>
								<th><s:text name="i18n.cip.type.rinse" /></th>
								<th><s:text name="i18n.cip.type.sterilize" /></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><s:property value="cipPerformAnalyseResult.cipLyeLastTime" /></td>
								<td><s:property value="cipPerformAnalyseResult.cipAcidLastTime" /></td>
								<td><s:property value="cipPerformAnalyseResult.cipLyeAcidLastTime" /></td>
								<td><s:property value="cipPerformAnalyseResult.cipRinseLastTime" /></td>
								<td><s:property value="cipPerformAnalyseResult.cipSterilizeLastTime" /></td>
							</tr>
						</tbody>
					</table>
					<div id="cipPerformTotalTimePlaceHolder" style="width: 400px; height: 400px;"></div>
					<script type="text/javascript">
						var cipPerformTotalTime = [];
						var cipPerformLyeTotalTime = [];
						var cipPerformAcidTotalTime = [];
						var cipPerformLyeAcidTotalTime = [];
						var cipPerformRinseTotalTime = [];
						var cipPerformSterilizeTotalTime = [];
						cipPerformLyeTotalTime.push([ 1,
								<s:property value="cipPerformAnalyseResult.cipLyeLastTime.timeInSeconds"/> ]);
						cipPerformAcidTotalTime.push([ 2,
								<s:property value="cipPerformAnalyseResult.cipAcidLastTime.timeInSeconds"/> ]);
						cipPerformLyeAcidTotalTime.push([ 3,
								<s:property value="cipPerformAnalyseResult.cipLyeAcidLastTime.timeInSeconds"/> ]);
						cipPerformRinseTotalTime.push([ 4,
								<s:property value="cipPerformAnalyseResult.cipRinseLastTime.timeInSeconds"/> ]);
						cipPerformSterilizeTotalTime.push([ 5,
								<s:property value="cipPerformAnalyseResult.cipSterilizeLastTime.timeInSeconds"/> ]);
						cipPerformTotalTime.push({
							label : $("#cip-type-lye").val(),
							data : cipPerformLyeTotalTime
						});
						cipPerformTotalTime.push({
							label : $("#cip-type-acid").val(),
							data : cipPerformAcidTotalTime
						});
						cipPerformTotalTime.push({
							label : $("#cip-type-lye-acid").val(),
							data : cipPerformLyeAcidTotalTime
						});
						cipPerformTotalTime.push({
							label : $("#cip-type-rinse").val(),
							data : cipPerformRinseTotalTime
						});
						cipPerformTotalTime.push({
							label : $("#cip-type-sterilize").val(),
							data : cipPerformSterilizeTotalTime
						});
						$.plot($("#cipPerformTotalTimePlaceHolder"), cipPerformTotalTime, {
							series : {
								pie : {
									show : true,
									label : {
										show : true
									}
								}
							},
							legend : {
								show : false
							}
						});
					</script>
				</div>

				<!-- cip count -->
				<div class="perform-result">
					<p>
						<span class="perform-label"><s:text name="i18n.cip.analysis.total.cip.count" /></span> <span class="perform-text"><s:property value="cipPerformAnalyseResult.cipTotalCount" /></span>
					</p>
					<table class="perform-table">
						<thead>
							<tr>
								<th><s:text name="i18n.cip.type.lye" /></th>
								<th><s:text name="i18n.cip.type.acid" /></th>
								<th><s:text name="i18n.cip.type.lye.acid" /></th>
								<th><s:text name="i18n.cip.type.rinse" /></th>
								<th><s:text name="i18n.cip.type.sterilize" /></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><s:property value="cipPerformAnalyseResult.cipLyeCount" /></td>
								<td><s:property value="cipPerformAnalyseResult.cipAcidCount" /></td>
								<td><s:property value="cipPerformAnalyseResult.cipLyeAcidCount" /></td>
								<td><s:property value="cipPerformAnalyseResult.cipRinseCount" /></td>
								<td><s:property value="cipPerformAnalyseResult.cipSterilizeCount" /></td>
							</tr>
						</tbody>
					</table>
					<div id="cipPerformTotalCountPlaceHolder" style="width: 400px; height: 400px;"></div>
					<script type="text/javascript">
						var cipPerformTotalCount = [];
						var cipPerformLyeTotalCount = [];
						var cipPerformAcidTotalCount = [];
						var cipPerformLyeAcidTotalCount = [];
						var cipPerformRinseTotalCount = [];
						var cipPerformSterilizeTotalCount = [];
						cipPerformLyeTotalCount.push([ 1, <s:property value="cipPerformAnalyseResult.cipLyeCount"/> ]);
						cipPerformAcidTotalCount
								.push([ 2, <s:property value="cipPerformAnalyseResult.cipAcidCount"/> ]);
						cipPerformLyeAcidTotalCount.push([ 3,
								<s:property value="cipPerformAnalyseResult.cipLyeAcidCount"/> ]);
						cipPerformRinseTotalCount
								.push([ 4, <s:property value="cipPerformAnalyseResult.cipRinseCount"/> ]);
						cipPerformSterilizeTotalCount.push([ 5,
								<s:property value="cipPerformAnalyseResult.cipSterilizeCount"/> ]);
						cipPerformTotalCount.push({
							label : $("#cip-type-lye").val(),
							data : cipPerformLyeTotalCount
						});
						cipPerformTotalCount.push({
							label : $("#cip-type-acid").val(),
							data : cipPerformAcidTotalCount
						});
						cipPerformTotalCount.push({
							label : $("#cip-type-lye-acid").val(),
							data : cipPerformLyeAcidTotalCount
						});
						cipPerformTotalCount.push({
							label : $("#cip-type-rinse").val(),
							data : cipPerformRinseTotalCount
						});
						cipPerformTotalCount.push({
							label : $("#cip-type-sterilize").val(),
							data : cipPerformSterilizeTotalCount
						});
						$.plot($("#cipPerformTotalCountPlaceHolder"), cipPerformTotalCount, {
							series : {
								pie : {
									show : true
								}
							},
							legend : {
								show : false
							}
						});
					</script>
				</div>
				<div class="cf"></div>
			</div>
			<script type="text/javascript">
				$(document).ready(function() {
					$("#query-condition-result-tab").tabs({
						active : 1
					});
				});
			</script>
		</s:if>
		<s:if test="#parameters.size gt 0">
			<script type="text/javascript">
				$(function() {
					<s:iterator value="#parameters.cipMasterLineIdList" var="id">
					$("#cip-master-line-list").find("option[value='<s:property value="#id"/>']").attr("selected", true);
					</s:iterator>

					$("input[name=queryStartDate]").val("<s:property value="#parameters.queryStartDate"/>");
					$("input[name=queryEndDate]").val("<s:property value="#parameters.queryEndDate"/>");
					$("#query-time-interval").val("<s:property value="#parameters.cipQueryTimeInterval"/>");
				});
			</script>
		</s:if>
	</div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>