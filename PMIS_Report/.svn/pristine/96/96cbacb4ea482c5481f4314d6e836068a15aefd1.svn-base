<jsp:include page="../../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/public/js/bpu_trend_query.js"/>"></script>
<div id="main-container">
	<div id="query-condition-result-tab">
		<ul>
			<li><a href="#query-condition-panel"><s:text name="i18n.select.query.condition" /></a></li>
			<li><a href="#query-result-panel"><s:text name="i18n.select.query.result" /></a></li>
		</ul>
		<div id="query-condition-panel" class="form-fanel">
			<form action="<s:url value="/bpu/query/queryBPUTrend.action"/>" method="GET" class="form-horizontal query-form">
				<fieldset>
					<legend>
						<s:text name="i18n.bpu.trend" />
					</legend>
					<table class="table query-table">
						<tr>
							<td><label><s:text name="i18n.bpu" /></label> <select name="bpuMachineId" id="bpu-machine-list">
									<option value="0">
										<s:text name="i18n.please.select" />
									</option>
									<s:iterator value="@com.tetrapak.util.bpu.BPUMachineUtil@getBPUMachineList()" var="bpuMachine">
										<option value="<s:property value="id"/>" title="<s:property value="machineDesc"/>">
											<s:property value="machineName" />
											&nbsp;&nbsp;&nbsp;&nbsp;
											<s:property value="machineSerialNumber" />
										</option>
									</s:iterator>
							</select></td>
							<td><label><s:text name="i18n.query.start.datetime" /></label> <input type="text" name="queryStartDate" class="date-time-picker" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.bpu.parameter.tag" /></label> <select name="analogTagIdList" id="analog-tag-list" style="height: 400px;" multiple>
									<s:iterator value="@com.tetrapak.util.bpu.BPUAnalogTagUtil@getBPUAnalogTagListOfBPUMachine(#parameters.bpuMachineId)" var="analogTag">
										<option value="<s:property value="id"/>" title="<s:property value="analogTagName"/>">
											<s:property value="analogTagDesc" />
										</option>
									</s:iterator>
							</select> <label><input type="checkbox" name="analogTagSelectAllButton" id="analog-tag-select-all-button" style="margin-right: 5px;"> <s:text name="i18n.select.all" /></label></td>
							<td style="vertical-align: top;"><label><s:text name="i18n.query.end.datetime" /></label> <input type="text" name="queryEndDate" class="date-time-picker" /> <label><s:text
										name="i18n.query.time.interval" /></label> <select name="queryTimeInterval" id="query-time-interval">
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
							</select> <label><s:text name="i18n.interval" /></label> <select name="queryInterval" id="query-interval" style="width: 100px;">
									<s:iterator value="{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,40,50,60}" var="e">
										<option value="<s:property value="#e"/>">
											<s:property value="#e" />
										</option>
									</s:iterator>
							</select> <select name="queryIntervalUnit" id="query-interval-unit" class="interval" style="width: 100px; margin-left: 5px;">
									<option value="0">
										<s:text name="i18n.minute" />
									</option>
									<option value="1">
										<s:text name="i18n.second" />
									</option>
							</select> <label>&nbsp;</label> <input type="submit" value="<s:text name="i18n.query"/>" class="btn btn-primary" />
								<div class="cf"></div></td>
						</tr>
					</table>
					<s:fielderror />
				</fieldset>
			</form>
		</div>
		<s:if test="bpuTagQueryResultList">
			<div id="query-result-panel">
				<input type="button" value="" style="background:url(<s:url value="/public/images/save.png"/>);width:25px;height:25px;border:0;cursor:pointer;float:right;"
					alt="<s:text name="i18n.save.query.result"/>" title="<s:text name="i18n.save.query.result"/>" id="save-query-result-button" />
				<div class="cf"></div>
				<ul>
					<li><a href="#trend-result-graph-tab"><s:text name="i18n.data.graph" /></a></li>
					<li><a href="#trend-result-raw-tab"><s:text name="i18n.data.raw" /></a></li>
				</ul>
				<script type="text/javascript">
					var dataAnalog = [];
					var dbAnalog = [];
					var tagDesc = [];
				</script>
				<div id="trend-result-raw-tab" style="margin: 0; padding: 0;">
					<table class="bpu-result-table">
						<thead>
							<tr>
								<th><s:text name="i18n.no" /></th>
								<th><s:text name="i18n.timestamp" /></th>
								<s:iterator value="bpuAnalogTagList" var="tag" status="stat">
									<th id="ah<s:property value="#stat.index"/>" title="<s:property value="analogTagDesc"/>" min="<s:property value="analogStandardMinValue"/>" max="<s:property value="analogStandardMaxValue"/>"><s:property
											value="analogTagName" /> (<s:property value="analogTagUnit" />)</th>
								</s:iterator>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="bpuTagQueryResultGeneral" var="resultRow" status="stat1">
								<tr>
									<td><s:property value="#stat1.index+1" /></td>
									<td><s:property value="#resultRow.key" /></td>
									<s:iterator value="#resultRow.value" var="v" status="stat">
										<td id="id<s:property value="#stat1.index"/><s:property value="#stat.index"/>"><span><s:property value="v" /></span> <script type="text/javascript">
											$(document)
													.ready(
															function() {
																var obj = $("#ah<s:property value="#stat.index"/>");
																var min = $.trim(obj.attr("min"));
																var max = $.trim(obj.attr("max"));
																if (min != "" && max != "") {
																	min = parseFloat(min);
																	max = parseFloat(max);
																	var val = parseFloat(<s:property value="v"/>);
																	if (val >= min && val <= max) {
																		$("#id<s:property value="#stat1.index"/><s:property value="#stat.index"/>")
																				.addClass("data-valid");
																	} else {
																		$("#id<s:property value="#stat1.index"/><s:property value="#stat.index"/>")
																				.addClass("data-invalid");
																	}
																}
															});
										</script></td>
									</s:iterator>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>

				<s:iterator value="bpuTagQueryResultList" var="tagQueryResult" status="stat">
					<script type="text/javascript">
						dataAnalog["<s:property value="tag.analogTagName"/>"] = [];
					</script>
				</s:iterator>
				<s:iterator value="bpuTagQueryResultList" var="tagQueryResult" status="stat">
					<s:set value="tag" var="tag" />
					<script type="text/javascript">
						tagDesc["<s:property value="tag.analogTagName"/>"] = "<s:property value="tag.analogTagDesc"/>&nbsp;(<s:property value="tag.analogTagUnit"/>)";
					</script>
					<s:iterator value="tagValue" var="tagValue" status="stat">
						<s:set value="@com.tetrapak.util.common.Tools@toFlotTimestamp(#tagValue.key)" var="timestamp" />
						<script type="text/javascript">
							dataAnalog["<s:property value="#tag.analogTagName"/>"].push([
									"<s:property value="#timestamp"/>", "<s:property value="#tagValue.value"/>" ]);
						</script>
					</s:iterator>
					<script type="text/javascript">
						if (dataAnalog["<s:property value="#tag.analogTagName"/>"]) {
							dbAnalog.push({
								label : tagDesc["<s:property value="#tag.analogTagName"/>"],
								data : dataAnalog["<s:property value="#tag.analogTagName"/>"]
							});
						}
					</script>
				</s:iterator>
				<div id="trend-result-graph-tab">
					<div id="analogPanel" style="display: none;">
						<div style="height: 18px; margin-bottom: 5px; font-weight: bold;" class="bpuTrendChoices">
							<span><s:text name="i18n.current.value" /></span> (<span id="x"></span> , <span id="y"></span>)
						</div>
						<div id="placeholderAnalog" style="width: 1600px; height: 600px; margin: 0 auto; margin-bottom: 20px;" class="placeholder"></div>
						<div>
							<input type="button" id="selectTrendAll" value="<s:text name="i18n.select.all" />" />&nbsp; <input type="button" id="selectTrendNone" value="<s:text
								name="i18n.select.none" />" />
						</div>
						<div id="bpuTrendChoices" class="bpu-trend-choices"></div>
						<div class="cf"></div>
					</div>
					<script type="text/javascript">
						if (dbAnalog.length > 0) {
							$("#analogPanel").show();
							var i = 0;
							$.each(dbAnalog, function(key, val) {
								val.color = i;
								++i;
							});
							var choiceContainer = $("#bpuTrendChoices");
							$
									.each(
											dbAnalog,
											function(key, val) {
												choiceContainer
														.append('<label for="id' + key + '"><input type="checkbox" name="' + key +
		                               '" checked="checked" id="id' + key + '">&nbsp;'
																+ val.label + '</label>');
											});
							choiceContainer.find("input").click(plotAccordingToChoices);
							function plotAccordingToChoices() {
								var data = [];
								choiceContainer.find("input:checked").each(function() {
									var key = $(this).attr("name");
									if (key && dbAnalog[key])
										data.push(dbAnalog[key]);
								});

								if (data.length > 0) {
									$.plot($("#placeholderAnalog"), data, {
										yaxis : {
											min : 0
										},
										grid : {
											hoverable : true
										},
										xaxis : {
											mode : "time",
											minTickSize : [ 1, "minute" ],
											timeformat : "%y-%m-%d<br/>%H:%M:%S"
										}
									});
									$("#placeholderAnalog").bind(
											"plothover",
											function(event, pos, item) {
												var d = new Date();
												var millis = parseInt(pos.x.toFixed(0));
												millis = millis - 28800000;
												d.setTime(millis);
												var year = d.getFullYear();
												var month = d.getMonth() + 1;
												var day = d.getDate();
												var hour = d.getHours();
												var minute = d.getMinutes();
												var second = d.getSeconds();
												var date = year + "-" + month + "-" + day + " " + hour + ":" + minute
														+ ":" + second;
												$("#x").text(date);
												$("#y").text(pos.y.toFixed(2));
											});
								}
							}
							plotAccordingToChoices();
							$("#selectTrendAll").click(function() {
								choiceContainer.find("input").each(function() {
									$(this).attr("checked", true);
								});
								plotAccordingToChoices();
							});
							$("#selectTrendNone").click(function() {
								choiceContainer.find("input").each(function() {
									$(this).attr("checked", false);
								});
								plotAccordingToChoices();
							});

						}
					</script>
				</div>
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
			<!-- set the parameters here -->
			<script type="text/javascript">
				$(function() {
					$("#bpu-machine-list").val('<s:property value="#parameters.bpuMachineId"/>');
					<s:iterator value="#parameters.analogTagIdList" var="analogTagId">
					$("#analog-tag-list").find("option[value='<s:property value="#analogTagId"/>']").attr("selected",
							true);
					</s:iterator>
					$("input[name=queryStartDate]").val("<s:property value="#parameters.queryStartDate"/>");
					$("input[name=queryEndDate]").val("<s:property value="#parameters.queryEndDate"/>");
					$("#query-interval").val("<s:property value="#parameters.queryInterval"/>");
					$("#query-interval-unit").val("<s:property value="#parameters.queryIntervalUnit"/>");
					$("#query-time-interval").val("<s:property value="#parameters.queryTimeInterval"/>");
					$("#analog-tag-select-all-button")
							.val("<s:property value="#parameters.analogTagSelectAllButton"/>");
				});
			</script>
		</s:if>
	</div>
	<div id="save-dialog" title="<s:text name="i18n.save.query.result"/>" class="popup-dialog">
		<form action="<s:url value="/bpu/query/queryTrendSave.action"/>" method="POST" id="save-query-result-form" class="form-horizontal save-dialog-form">
			<input type="hidden" name="bpuMachineId" value="<s:property value="#parameters.bpuMachineId"/>" />
			<s:iterator value="#parameters.analogTagIdList" var="analogTagId">
				<input type="hidden" name="analogTagIdList" value="<s:property value="analogTagId"/>" />
			</s:iterator>
			<input type="hidden" name="queryStartDate" value="<s:property value="#parameters.queryStartDate"/>" /> <input type="hidden" name="queryEndDate"
				value="<s:property value="#parameters.queryEndDate"/>" /> <input type="hidden" name="queryInterval" value="<s:property value="#parameters.queryInterval"/>" /> <input type="hidden"
				name="queryIntervalUnit" value="<s:property value="#parameters.queryIntervalUnit"/>" />
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
<input type="hidden" value="<s:url value="/bpu/ajax/getBPUAnalogListOfBPUMachine.action"/>" id="getBPUAnalogListOfBPUMachineAddress" />