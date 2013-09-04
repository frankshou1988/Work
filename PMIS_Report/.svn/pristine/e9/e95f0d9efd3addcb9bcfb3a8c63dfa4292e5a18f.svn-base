<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="../../header.jsp"></jsp:include>
<script type="text/javascript" src="<s:url value="/public/js/lib/jquery.flot.pie.min.js"/>"></script>
<div id="main-container">
	<div id="query-condition-result-tab" style="padding: 0;">
		<ul>
			<li><a href="#bpu-utilization-report-panel"><s:text name="i18n.select.query.condition" /></a></li>
			<li><a href="#bpu-efficacy-result-tab"><s:text name="i18n.bpu.efficacy.rate" /></a></li>
			<li><a href="#bpu-utilization-result-tab"><s:text name="i18n.bpu.utility.rate" /></a></li>
		</ul>
		<div id="bpu-utilization-report-panel" class="form-panel">
			<input type="hidden" value="<s:text name="i18n.all"/>" id="all-text" />
			<form action="<s:url value="/bpu/query/queryBPUUtilizationReportResult.action"/>" method="GET" id="bpuUtilizationReportForm" autocomplete="off" class="queryForm">
				<fieldset>
					<p class="formTitle">
						<s:text name="i18n.bpu.utility.rate.analysis" />
					</p>
					<table>
						<tr>
							<td><label><s:text name="i18n.bpu" /></label> <select name="bpuMachineName" id="bpu-machine-name">
									<option value="">
										<s:text name="i18n.please.select" />
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
									<option value="I_FIVE_DAY_BACK">
										<s:text name="i18n.query.time.interval.five.day.back" />
									</option>
									<option value="I_TEN_DAY_BACK">
										<s:text name="i18n.query.time.interval.ten.day.back" />
									</option>
									<option value="I_FIFTEEN_DAY_BACK">
										<s:text name="i18n.query.time.interval.fifteen.day.back" />
									</option>
									<option value="I_TWENTY_DAY_BACK">
										<s:text name="i18n.query.time.interval.twenty.day.back" />
									</option>
									<option value="I_TWENTY_FIVE_DAY_BACK">
										<s:text name="i18n.query.time.interval.twenty.five.day.back" />
									</option>
									<option value="I_THIRTY_DAY_BACK">
										<s:text name="i18n.query.time.interval.thirty.day.back" />
									</option>
									<option value="I_THREE_MONTH_BACK">
										<s:text name="i18n.query.time.interval.three.month.back" />
									</option>
									<option value="I_HALF_YEAR_BACK">
										<s:text name="i18n.query.time.interval.half.year.back" />
									</option>
									<option value="I_ONE_YEAR_BACK">
										<s:text name="i18n.query.time.interval.one.year.back" />
									</option>
							</select></td>
						</tr>
						<tr>
							<td><input type="submit" value="<s:text name="i18n.query"/>" style="margin-top: 0; margin-left: 0;" class="btn btn-primary" /></td>
						</tr>
					</table>
					<s:fielderror></s:fielderror>
				</fieldset>
			</form>
		</div>
		<s:if test="rateMap.size gt 0">
			<div id="bpu-efficacy-result-tab" style="padding: 20px;">
				<input type="hidden" id="pcolor0" value="#7633BD" /> <input type="hidden" id="pcolor3" value="#3D853D" /> <input type="hidden" id="pcolor2" value="#EDC240" /> <input type="hidden" id="pcolor1"
					value="#AFD8F8" /> <input type="hidden" id="pcolor4" value="#D31919" /> <input type="hidden" id="pcolor5" value="#3F99EF" /> <input type="hidden" id="pcolor6" value="#F47920" /> <input
					type="hidden" id="pcolor7" value="#585eaa" /> <input type="hidden" id="pcolor8" value="#C49EEE" /> <input type="hidden" id="pcolor9" value="#1B315E " /> <input type="hidden" id="pcolor10"
					value="#00ae9d" /> <input type="hidden" id="pcolor11" value="#7FB80E" /> <input type="hidden" id="pcolor12" value="#F391A9" />
				<script type="text/javascript">
					var efficacyData = [];
				</script>
				<div style="padding-bottom: 20px; float: left; margin-right: 20px;">
					<p style="font-size: 32px; color: #40AA53; padding: 10px; width: 600px; text-align: center; margin: 0 auto;">
						<s:property value="selectedBPUMachine.machineDesc" />
						<s:text name="i18n.bpu.efficacy.rate" />
						<s:iterator value="efficacyMap" var="each" status="stat">
							<s:if test="#each.key.machineType eq 'UHT'">
								<s:if test="#each.key.bpuPhaseStatN eq 2">
									<span style="font-size: 32px; color: #fff; background-color: #4DA74D; padding: 10px; width: 120px; text-align: center;"><s:property value="#each.value.rate" />%</span>
								</s:if>
							</s:if>
							<s:elseif test="#each.key.machineType eq 'ALSAFE'">
								<s:if test="#each.key.bpuPhaseStatN eq 1">
									<span style="font-size: 32px; color: #fff; background-color: #4DA74D; padding: 10px; width: 120px; text-align: center;"><s:property value="#each.value.rate" />%</span>
								</s:if>
							</s:elseif>
						</s:iterator>
					</p>
					<table class="bpu-result-table" style="width: 600px; margin: 0 auto; margin-top: 10px;">
						<thead>
							<tr>
								<th><s:text name="i18n.bpu.phase.name" /></th>
								<th><s:text name="i18n.bpu.phase.last.time" /></th>
								<th><s:text name="i18n.bpu.phase.rate" /></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="efficacyMap" var="each" status="stat">
								<tr>
									<td><input type="hidden" value="<s:property value="#each.key.bpuPhaseStatNDesc" />&nbsp;(<s:property value="#each.value.rate" />%)" id="eid<s:property value="#stat.index"/>" /> <s:property
											value="#each.key.bpuPhaseStatNDesc" /></td>
									<td><s:property value="#each.value.bpuLastTime" /></td>
									<td><s:property value="#each.value.rate" />%</td>
								</tr>
								<script type="text/javascript">
									efficacyData.push({
										label : $("#eid<s:property value="#stat.index"/>").val(),
										data : <s:property value="#each.value.rate" />,
										color : $("#pcolor<s:property value="#stat.index"/>").val()
									});
								</script>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div style="float: left; margin-top: 30px; margin-bottom: 20px;">
					<div id="efficacyMapHolder" style="width: 600px; height: 400px;"></div>
					<script type="text/javascript">
						$.plot($("#efficacyMapHolder"), efficacyData, {
							series : {
								pie : {
									show : true
								}
							}
						});
					</script>
				</div>
				<div class="cf"></div>
			</div>
			<div id="bpu-utilization-result-tab" style="padding: 20px;">
				<div style="float: left;">
					<div>
						<div style="font-size: 32px; color: #40AA53; padding: 10px; width: 350px; text-align: center; float: left;">
							<s:property value="selectedBPUMachine.machineDesc" />
							<s:text name="i18n.bpu.utility.rate" />
						</div>
						<div style="font-size: 32px; color: #fff; background-color: orange; padding: 10px; width: 120px; float: left; text-align: center;">
							<s:property value="rate" />
							%
						</div>
						<div class="cf"></div>
						<input type="hidden" id="utility-rate-text" value="<s:text name="i18n.bpu.utility.rate" />" /> <input type="hidden" id="unused-rate-text" value="<s:text name="i18n.bpu.utility.unused.rate"/>" />
						<div id="bpuUtilizationHolder" style="width: 400px; height: 300px; margin-top: 10px;"></div>
						<script type="text/javascript">
							var utilityData = [];
							var rate = [];
							var unused = [];
							var rateValue = <s:property value="rate"/>;
							var unsedValue = 100 - parseFloat(rateValue);
							rate.push([ 1, rateValue ]);
							unused.push([ 2, unsedValue ]);

							utilityData.push({
								label : $("#utility-rate-text").val(),
								data : rate
							});
							utilityData.push({
								label : $("#unused-rate-text").val(),
								data : unused
							});

							$.plot($("#bpuUtilizationHolder"), utilityData, {
								series : {
									pie : {
										show : true
									}
								}
							});
						</script>
					</div>
				</div>
				<div style="float: left;">
					<div style="font-size: 32px; color: #40AA53; padding: 10px; width: 1000px; margin-left: 20px; text-align: center; font-weight: bold;">
						<p>
							<s:text name="i18n.bpu.utility.rate.relative" />
						</p>
					</div>
					<div class="cf"></div>
					<div id="pl" style="margin-left: 20px; width: 1000px; height: 400px;"></div>
					<script type="text/javascript">
						var m = [];
					</script>
					<s:iterator value="rateMap" var="each" status="stat">
						<input type="hidden" id="pid<s:property value="#stat.index"/>" value="<s:property value="#each.key.machineDesc"/>(<s:property value="#each.value"/>%)" />
						<script type="text/javascript">
							var e = [];
							e.push([ <s:property value="#stat.index*2"/>, <s:property value="#each.value"/> ]);
							m.push({
								label : $("#pid<s:property value="#stat.index"/>").val(),
								data : e
							});
						</script>
					</s:iterator>
					<script type="text/javascript">
						$.plot($("#pl"), m, {
							series : {
								bars : {
									show : true
								}
							}
						});
					</script>
				</div>
				<div class="cf"></div>
				<script type="text/javascript">
					$("#query-condition-result-tab").tabs({
						active : 1
					});
				</script>
			</div>
		</s:if>
		<!-- set the parameters here -->
		<s:if test="#parameters.size gt 0">
			<script type="text/javascript">
				$(function() {
					$("#bpu-machine-name").val("<s:property value="#parameters.bpuMachineName"/>");
					$("input[name=queryStartDate]").val("<s:property value="#parameters.queryStartDate"/>");
					$("input[name=queryEndDate]").val("<s:property value="#parameters.queryEndDate"/>");
					$("#query-time-interval").val("<s:property value="#parameters.queryTimeInterval"/>");
				});
			</script>
		</s:if>
	</div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>