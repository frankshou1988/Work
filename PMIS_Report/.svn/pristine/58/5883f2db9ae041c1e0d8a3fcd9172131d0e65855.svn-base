<jsp:include page="../../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/public/js/bpu_alarm_tag_setting.js"/>"></script>
<div id="main-container">
	<jsp:include page="bpu_setting_sidebar_page.jsp"></jsp:include>
	<div id="setting-main-container">
		<div id="bpuAlarmTag" style="height: auto; width: auto; float: left;" class="form-panel">
			<input type="hidden" value="<s:url value="/systemSettings/bpu/alarmTag/add.action"/>" id="alarm-tag-add-url" /> <input type="hidden"
				value="<s:url value="/systemSettings/bpu/alarmTag/edit.action"/>" id="alarm-tag-edit-url" />
			<form action="" method="POST" id="alarm-tag-manage-form">
				<fieldset>
					<legend>
						<s:text name="i18n.bpu.alarm" />
					</legend>
					<ul>
						<li><label><s:text name="i18n.bpu" /></label> <select name="bpuMachineId" id="bpu-machine-list">
								<option value="0">
									<s:text name="i18n.please.select" />
								</option>
								<s:iterator value="@com.tetrapak.util.bpu.BPUMachineUtil@getBPUMachineList()" var="bpuMachine">
									<option value="<s:property value="id"/>" title="<s:property value="machineDesc"/>">
										<s:property value="machineName" />
									</option>
								</s:iterator>
						</select></li>
						<li><label><s:text name="i18n.bpu.alarm.tag.name" /></label> <input type="text" name="alarmTagName" value="<s:property value="selectedAlarmTag.alarmTagName"/>" /></li>
						<li><label><s:text name="i18n.bpu.alarm.insql.tag.name" /></label> <input type="text" name="alarmInsqlTagName" value="<s:property value="selectedAlarmTag.alarmInsqlTagName"/>" /></li>
						<li><label><s:text name="i18n.bpu.alarm.tag.desc" /></label> <input type="text" name="alarmTagDesc" value="<s:property value="selectedAlarmTag.alarmTagDesc"/>" /></li>
						<li><input type="hidden" value="<s:property value="selectedAlarmTag.id"/>" id="alarm-tag-id" name="alarmTagId" /> <input type="button" name="" value="<s:text name="i18n.add"/>"
							id="add-alarm-tag-button" class="btn btn-primary"> <input type="button" name="" value="<s:text name="i18n.edit"/>" id="edit-alarm-tag-button" class="btn btn-primary"/></li>
					</ul>
					<s:fielderror />
				</fieldset>
			</form>
			<script type="text/javascript">
				$(document).ready(function() {
					$("#bpu-machine-list").val("<s:property value="#parameters.bpuMachineId"/>");
				});
			</script>
		</div>
		<div style="float: left; margin:20px;">
			<table class="bpu-result-table">
				<thead>
					<tr>
						<th><s:text name="i18n.no" /></th>
						<th><s:text name="i18n.bpu.alarm.tag.name" /></th>
						<th><s:text name="i18n.bpu.alarm.insql.tag.name" /></th>
						<th><s:text name="i18n.bpu.alarm.tag.desc" /></th>
						<th><s:text name="i18n.action" /></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="@com.tetrapak.util.bpu.BPUAlarmTagUtil@getBPUAlarmTagListOfBPUMachine(#parameters.bpuMachineId)" var="alarmTag" status="stat">
						<tr>
							<td><s:property value="#stat.index+1" /></td>
							<td><s:property value="alarmTagName" /></td>
							<td><s:property value="alarmInsqlTagName" /></td>
							<td><s:property value="alarmTagDesc" /></td>
							<td>
								<form style="margin:0;" action="<s:url value="/systemSettings/bpu/alarmTag/delete.action"/>" method="POST" id="alarm-tag-delete-form<s:property value="id"/>" class="delete-form">
									<input type="hidden" value="<s:property value="#parameters.bpuMachineId"/>" name="bpuMachineId" /> <input type="hidden" value="<s:property value="id"/>" name="alarmTagId" />
								</form> <input type="button" value="<s:text name="i18n.delete"/>" style="margin-right: 10px;" class="alarm-tag-delete-button btn btn-danger" deleteFormId="alarm-tag-delete-form<s:property value="id"/>"> <input
								type="button" value="<s:text name="i18n.edit"/>" class="alarm-tag-edit-button btn btn-info" alarmTagId="<s:property value="id"/>" />
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	<div class="cf"></div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>
<input type="hidden" value="<s:url value="/systemSettings/bpu/bpuAlarmTagSettingPage.action"/>" id="alarmTagActionAddress" />