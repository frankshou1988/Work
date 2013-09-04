<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="../../header.jsp"></jsp:include>
<script type="text/javascript" src="<s:url value="/public/js/cip_trend.js"/>"></script>
<div id="main-container">
	<div id=query-condition-result-tab>
		<ul>
			<li><a href="#query-condition-panel"><s:text name="i18n.select.query.condition" /></a></li>
			<li><a href="#query-result-panel"><s:text name="i18n.select.query.result" /></a></li>
		</ul>
		<div id="query-condition-panel">
			<form action="<s:url value="/cip/cipTrend/cipTrendQuery.action"/>" method="GET" id="cip-trend-form" autocomplete="off" class="form-horizontal query-form">
				<fieldset>
					<legend>
						<s:text name="i18n.cip.trend" />
					</legend>
					<table class="cip-trend-query-table">
						<tr>
							<td><label><s:text name="i18n.cip.master.line" /></label> <select name="cipTrendTagMasterLineId" id="cip-trend-tag-master-line-list" size="10" style="height: 246px;">
									<s:iterator>
										<s:iterator value="@com.tetrapak.util.cip.CIPLineUtil@getCIPMasterLineList()" var="cipMasterLine">
											<option value="<s:property value="id"/>" title="<s:property value="cipMasterLineDesc"/>">
												<s:property value="cipMasterLineDesc" />
											</option>
										</s:iterator>
									</s:iterator>
							</select></td>
							<td><label><s:text name="i18n.cip.trend.tag" /></label> <select name="cipTrendTagNameList" style="height: 246px;" size="10" id="cip-trend-tag-list" multiple>
									<s:iterator value="@com.tetrapak.util.cip.CIPTrendTagUtil@getCIPTrendTagsOfMasterLine(#parameters.cipTrendTagMasterLineId)" var="cipTrendTag">
										<option value="<s:property value="cipTrendTagName"/>">
											<s:property value="cipTrendTagDesc" />
										</option>
									</s:iterator>
							</select></td>
							<td style="vertical-align: top;"><label><s:text name="i18n.query.start.datetime" /></label> <input type="text" name="queryStartDate" class="date-time-picker" /> <label><s:text
										name="i18n.query.end.datetime" /></label> <input type="text" name="queryEndDate" class="date-time-picker" /> <label><s:text name="i18n.query.time.interval" /></label> <select
								name="cipQueryTimeInterval" id="query-time-interval">
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
							</select> <label><s:text name="i18n.interval" /></label> <select name="queryInterval" id="query-interval" style="width: 60px;">
									<s:iterator value="{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,40,50,60}" var="e">
										<option value="<s:property value="#e"/>">
											<s:property value="#e" />
										</option>
									</s:iterator>
							</select> <select name="queryIntervalUnit" id="query-interval-unit" class="interval" style="width: 85px; margin-left: 2px;">
									<option value="0">
										<s:text name="i18n.minute" />
									</option>
									<option value="1">
										<s:text name="i18n.second" />
									</option>
							</select> <input type="submit" value="<s:text name="i18n.query"/>" class="btn btn-primary" style="vertical-align: top;" /></td>
						</tr>
					</table>
					<s:fielderror></s:fielderror>
				</fieldset>
			</form>
		</div>
		<s:if test="tagQueryResultList">
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
					var dataDiscrete = [];
					var dbAnalog = [];
					var dbDiscrete = [];
					var tagDesc = [];
				</script>
				<div id="trend-result-raw-tab" style="margin: 0; padding: 0;">
					<s:iterator value="tagQueryResultList" var="tagQueryResult" status="stat">
						<s:if test="tag.cipTrendTagAnalog">
							<script type="text/javascript">
								dataAnalog["<s:property value="tag.cipTrendTagName"/>"] = [];
							</script>
						</s:if>
						<s:else>
							<script type="text/javascript">
								dataDiscrete["<s:property value="tag.cipTrendTagName"/>"] = [];
							</script>
						</s:else>
					</s:iterator>

					<table class="cip-result-table">
						<thead>
							<tr>
								<th><s:text name="i18n.no" /></th>
								<th><s:text name="i18n.timestamp" /></th>
								<s:iterator value="cipTrendTagList" var="tag">
									<th><s:property value="cipTrendTagDesc" /> (<s:property value="cipTrendTagUnit" />)</th>
								</s:iterator>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="tagQueryResultGeneral" var="resultRow" status="stat">
								<tr>
									<td><s:property value="#stat.index+1" /></td>
									<td><s:property value="#resultRow.key" /></td>
									<s:iterator value="#resultRow.value" var="v">
										<td><s:property value="v" /></td>
									</s:iterator>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>

				<s:iterator value="tagQueryResultList" var="tagQueryResult" status="stat">
					<s:set value="tag" var="tag" />
					<script type="text/javascript">
						tagDesc["<s:property value="tag.cipTrendTagName"/>"] = "<s:property value="tag.cipTrendTagDesc"/>&nbsp;(<s:property value="tag.cipTrendTagUnit"/>)";
					</script>
					<s:iterator value="tagValue" var="tagValue" status="stat">
						<s:set value="@com.tetrapak.util.common.Tools@toFlotTimestamp(#tagValue.key)" var="timestamp" />
						<s:if test="tag.cipTrendTagAnalog">
							<script type="text/javascript">
								dataAnalog["<s:property value="#tag.cipTrendTagName"/>"].push([
										"<s:property value="#timestamp"/>", "<s:property value="#tagValue.value"/>"/"<s:property value="#tag.cipTrendTagValueDividedBy"/>" ]);
							</script>
						</s:if>
						<s:else>
							<script type="text/javascript">
								dataDiscrete["<s:property value="#tag.cipTrendTagName"/>"].push([
										"<s:property value="#timestamp"/>", "<s:property value="#tagValue.value"/>" ]);
							</script>
						</s:else>
					</s:iterator>
					<script type="text/javascript">
						if (dataAnalog["<s:property value="#tag.cipTrendTagName"/>"]) {
							dbAnalog.push({
								label : tagDesc["<s:property value="#tag.cipTrendTagName"/>"],
								data : dataAnalog["<s:property value="#tag.cipTrendTagName"/>"]
							});
						}

						if (dataDiscrete["<s:property value="#tag.cipTrendTagName"/>"]) {
							dbDiscrete.push({
								label : tagDesc["<s:property value="#tag.cipTrendTagName"/>"],
								data : dataDiscrete["<s:property value="#tag.cipTrendTagName"/>"]
							});
						}
					</script>
				</s:iterator>
				<div id="trend-result-graph-tab">
					<div id="analogPanel" style="display: none;">
						<div style="height: 18px; margin-bottom: 5px; font-weight: bold;">
							<span><s:text name="i18n.current.value" /></span> (<span id="x"></span> , <span id="y"></span>)
						</div>
						<div id="placeholderAnalog" style="width: 1600px; height: 600px; margin: 0 auto;"></div>
					</div>
					<div id="discretePanel" style="display: none;">
						<div style="height: 18px; margin-bottom: 5px; font-weight: bold; margin-top: 10px;">
							<span><s:text name="i18n.current.value" /></span> (<span id="x-d"></span>)
						</div>
						<div id="placeholderDiscrete" style="width: 1600px; height: 600px; margin: 20px auto;"></div>
					</div>
					<script type="text/javascript">
						if (dbAnalog.length > 0) {
							$("#analogPanel").show();
							$.plot($("#placeholderAnalog"), dbAnalog, {
								series : {
									lines : {
										show : true,
										steps : false
									}
								},
								grid : {
									hoverable : true
								},
								xaxis : {
									mode : "time",
									minTickSize : [ 1, "minute" ],
									timeformat : "%y-%m-%d<br/>%H:%M:%S"
								},
								legend : {
									position : 'nw'
								}
							});
							$("#placeholderAnalog").bind("plothover", function(event, pos, item) {
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
								var date = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
								$("#x").text(date);
								$("#y").text(pos.y.toFixed(2));
							});
						}

						if (dbDiscrete.length > 0) {
							$("#discretePanel").show();
							$.plot($("#placeholderDiscrete"), dbDiscrete, {
								series : {
									lines : {
										show : true,
										steps : true
									}
								},
								grid : {
									hoverable : true
								},
								xaxis : {
									mode : "time",
									minTickSize : [ 1, "minute" ],
									timeformat : "%y-%m-%d<br/>%H:%M:%S"
								},
								legend : {
									position : 'nw'
								}
							});
							$("#placeholderDiscrete").bind("plothover", function(event, pos, item) {
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
								var date = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
								$("#x-d").text(date);
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
	</div>
	<s:if test="#parameters.size gt 0">
		<!-- set the parameters here -->
		<script type="text/javascript">
			$(document).ready(function() {
				$("#cip-trend-tag-master-line-list").val("<s:property value="#parameters.cipTrendTagMasterLineId"/>");
				<s:iterator value="#parameters.cipTrendTagNameList" var="tagName">
				$("#cip-trend-tag-list").find("option[value='<s:property value="#tagName"/>']").attr("selected", true);
				</s:iterator>
				$("input[name=queryStartDate]").val("<s:property value="#parameters.queryStartDate"/>");
				$("input[name=queryEndDate]").val("<s:property value="#parameters.queryEndDate"/>");
				$("#query-interval").val("<s:property value="#parameters.queryInterval"/>");
				$("#query-interval-unit").val("<s:property value="#parameters.queryIntervalUnit"/>");
				$("#query-time-interval").val("<s:property value="#parameters.cipQueryTimeInterval"/>");
			});
		</script>
	</s:if>
	<input type="hidden" id="cip-get-cip-trend-tag-of-master-line-url" value="<s:url value="/cip/ajax/getCIPTrendTagOfMasterLine.action"/>" />
	<div id="save-dialog" title="<s:text name="i18n.save.query.result"/>" class="popup-dialog">
		<form action="<s:url value="/cip/cipTrend/cipTrendSave.action"/>" method="POST" id="save-query-result-form" class="form-horizontal save-dialog-form">
			<input type="hidden" name="cipTrendTagMasterLineId" value="<s:property value="#parameters.cipTrendTagMasterLineId"/>" />
			<s:iterator value="#parameters.cipTrendTagNameList" var="tagName">
				<input type="hidden" name="cipTrendTagNameList" value="<s:property value="#tagName"/>" />
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