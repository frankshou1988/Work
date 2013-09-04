<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div id="main-container">
	<div id=query-condition-result-tab>
		<ul>
			<li><a href="#query-condition-panel"><s:text name="i18n.current.cip" /></a></li>
		</ul>
		<div id="query-condition-panel">
			<table id="cip-realtime-data-table" class="cip-result-table">
				<thead>
					<tr>
						<th><s:text name="i18n.no" /></th>
						<th><s:text name="i18n.cip.master.line.name" /></th>
						<th><s:text name="i18n.cip.master.line.desc" /></th>
						<th><s:text name="i18n.cip.target.name" /></th>
						<th><s:text name="i18n.cip.target.desc" /></th>
						<th><s:text name="i18n.cip.slave.line" /></th>
						<th><s:text name="i18n.cip.type" /></th>
						<th><s:text name="i18n.cip.step" /></th>
						<th><s:text name="i18n.cip.flow.out" /></th>
						<th><s:text name="i18n.cip.tt.out" /></th>
						<th><s:text name="i18n.cip.ct.back" /></th>
						<th><s:text name="i18n.cip.tt.back" /></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<script type="text/javascript">
				$(document).ready(
						function() {
							function getCIPRealtimeData() {
								$.ajax({
									type : 'POST',
									url : '<s:url value="/cip/ajax/getCIPRealtimeData.action"/>',
									dataType : 'json',
									success : function(data) {
										var cipRealtimeDataTableBody = $("#cip-realtime-data-table>tbody");
										cipRealtimeDataTableBody.find("tr").remove();
										var counter = 1;
										if (data.cipRealtimeDataList.length > 0) {
											$.each(data.cipRealtimeDataList, function(rowIndex) {
												row = data.cipRealtimeDataList[rowIndex];
												var cipMasterLineName = row.cipMasterLine.cipMasterLineName;
												var cipMasterLineDesc = row.cipMasterLine.cipMasterLineDesc;
												var cipTargetName = row.cipPhase.cipTarget.cipTargetName;
												var cipTargetDesc = row.cipPhase.cipTarget.cipTargetDesc;
												var cipSlaveLine = row.cipPhase.cipSlaveLine.cipSlaveLineName;
												var cipType = row.cipTypeDesc;
												var cipStep = row.stepNum;
												var ftOut = row.ftOut;
												var ttOut = row.ttOut;
												var ctBack = row.ctBack;
												var ttBack = row.ttBack;
												cipRealtimeDataTableBody.append("<tr><td>" + counter + "</td><td>"
														+ cipMasterLineName + "</td><td>" + cipMasterLineDesc
														+ "</td><td>" + cipTargetName + "</td><td>" + cipTargetDesc
														+ "</td><td>" + cipSlaveLine + "</td><td>" + cipType
														+ "</td><td>" + cipStep + "</td><td>" + ftOut + "</td><td>"
														+ ttOut + "</td><td>" + ctBack + "</td><td>" + ttBack
														+ "</td></tr>");

												counter++;
											});
										}else{
											cipRealtimeDataTableBody.append('<tr><td colspan="12"><s:text name="i18n.no.cip.running"/></td></tr>');
										}
									}
								});
							}
							//user manually refresh page to get the latest cip data, to avoid the traffic pressure.
							//window.setInterval(getCIPRealtimeData, 15000);
							//execute once
							getCIPRealtimeData();
						});
			</script>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>