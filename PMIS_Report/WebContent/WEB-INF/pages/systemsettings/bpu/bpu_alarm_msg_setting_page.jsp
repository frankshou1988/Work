<jsp:include page="../../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/public/js/bpu_alarm_msg_setting.js"/>"></script>
<div id="main-container">
	<jsp:include page="bpu_setting_sidebar_page.jsp"></jsp:include>
	<div id="setting-main-container">
		<div id="bpuAlarmMsg" style="height: auto; width: auto; float: left;" class="form-panel">
			<input type="hidden" value="<s:url value="/systemSettings/bpu/alarmMsg/add.action"/>" id="alarm-msg-add-url" /> <input type="hidden"
				value="<s:url value="/systemSettings/bpu/alarmMsg/edit.action"/>" id="alarm-msg-edit-url" />
			<form action="" method="POST" id="alarm-msg-manage-form">
				<fieldset>
					<legend>
						<s:text name="i18n.bpu.alarm.msg" />
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
						<li><label><s:text name="i18n.bpu.alarm.tag.name" /></label> <select name="alarmTagId" id="bpu-alarm-tag-list"></select></li>
						<li><label><s:text name="i18n.bpu.alarm.bit" /></label> <input type="text" name="alarmMsgBit" value="<s:property value="selectedAlarmMsg.alarmMsgBit"/>" /></li>
						<li><label><s:text name="i18n.bpu.alarm.info" /></label> <textarea name="alarmMsgInfo" class="bpuAlarmTextArea"><s:property value="selectedAlarmMsg.alarmMsgInfo" /></textarea></li>
						<li><input type="hidden" value="<s:property value="selectedAlarmMsg.id"/>" id="alarm-msg-id" name="alarmMsgId" /> <input type="button" name="" value="<s:text name="i18n.add"/>"
							id="add-alarm-msg-button" class="btn btn-primary"> <input type="button" name="" value="<s:text name="i18n.edit"/>" id="edit-alarm-msg-button" class="btn btn-primary" /></li>
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
		<div style="float: left; margin: 20px;">
			<table class="bpu-result-table">
				<thead>
					<tr>
						<th><s:text name="i18n.no" /></th>
						<th><s:text name="i18n.bpu.alarm.bit" /></th>
						<th><s:text name="i18n.bpu.alarm.info" /></th>
						<th><s:text name="i18n.action" /></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="@com.tetrapak.util.bpu.BPUAlarmMsgUtil@getAlarmMsgOfAlarmTag(#parameters.alarmTagId)" var="alarmMsg" status="stat">
						<tr>
							<td><s:property value="#stat.index+1" /></td>
							<td><s:property value="alarmMsgBit" /></td>
							<td><s:property value="alarmMsgInfo" /></td>
							<td>
								<form style="margin: 0;" action="<s:url value="/systemSettings/bpu/alarmMsg/delete.action"/>" method="POST" id="alarm-msg-delete-form<s:property value="id"/>" class="delete-form">
									<input type="hidden" value="<s:property value="#parameters.bpuMachineId"/>" name="bpuMachineId" /> <input type="hidden" value="<s:property value="#parameters.alarmTagId"/>" name="alarmTagId" />
									<input type="hidden" value="<s:property value="id"/>" name="alarmMsgId" />
								</form> <input type="button" value="<s:text name="i18n.delete"/>" style="margin-right: 10px;" class="alarm-msg-delete-button btn btn-danger"
								deleteFormId="alarm-msg-delete-form<s:property value="id"/>"> <input type="button" value="<s:text name="i18n.edit"/>" class="alarm-msg-edit-button btn btn-info"
								alarmMsgId="<s:property value="id"/>" />
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
<input type="hidden" value="<s:url value="/systemSettings/bpu/bpuAlarmMsgSettingPage.action"/>" id="alarmMsgActionAddress" />
<input type="hidden" value="<s:url value="/bpu/ajax/getBPUAlarmTagListOfBPUMachine.action"/>" id="getBPUAlarmTagListOfBPUMachineActionAddress" />
<input type="hidden" value="<s:property value="#parameters.alarmTagId"/>" id="alarmTagSelectedValue" />
<input type="hidden" value="<s:text name="i18n.please.select"/>" id="please-select-text" />