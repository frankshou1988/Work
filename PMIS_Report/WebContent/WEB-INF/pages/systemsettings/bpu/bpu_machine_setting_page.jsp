<jsp:include page="../../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/public/js/bpu_machine_setting.js"/>"></script>
<div id="main-container">
	<jsp:include page="bpu_setting_sidebar_page.jsp"></jsp:include>
	<div id="setting-main-container">
		<div id="bpuMachineSetting" style="height: 350px;" class="form-panel">
			<input type="hidden" value="<s:url value="/systemSettings/bpu/bpuMachine/add.action"/>" id="bpu-machine-add-url" /> <input type="hidden"
				value="<s:url value="/systemSettings/bpu/bpuMachine/edit.action"/>" id="bpu-machine-edit-url" />
			<form action="" method="POST" style="float: left;" autocomplete="off" id="bpu-machine-manage-form">
				<fieldset style="float: left; height: 191px;">
					<legend>
						<s:text name="i18n.bpu.machine.settings" />
					</legend>
					<ul>
						<li><label><s:text name="i18n.bpu.machine.name" /></label> <input type="text" name="bpuMachineName" id="bpu-machine-name" /></li>
						<li><label><s:text name="i18n.bpu.machine.desc" /></label> <input type="text" name="bpuMachineDesc" id="bpu-machine-desc" /></li>
						<li><label><s:text name="i18n.bpu.machine.serial.number" /></label> <input type="text" name="bpuMachineSerialNumber" id="bpu-machine-serial-number" /></li>
						<li><label><s:text name="i18n.bpu.machine.type" /></label> <input type="text" name="bpuMachineType" id="bpu-machine-type" /></li>
						<li><input type="hidden" value="" id="bpu-machine-id" name="bpuMachineId" /> <input type="button" value="<s:text name="i18n.add"/>" id="add-bpu-machine-button" class="btn btn-primary" />
							&nbsp;<input type="button" value="<s:text name="i18n.edit"/>" id="edit-bpu-machine-button" class="btn btn-primary" /></li>
					</ul>
				</fieldset>
			</form>
			<fieldset style="float: left; margin-left: 10px;">
				<select style="height: 250px; width: 400px; float: left; margin-right: 2px;" size="10" id="bpu-machine-list">
					<s:iterator value="@com.tetrapak.util.bpu.BPUMachineUtil@getBPUMachineList()" var="bpuMachine">
						<option value="<s:property value="id"/>" title="<s:property value="machineDesc"/>" serialNumber="<s:property value="machineSerialNumber"/>" machineType="<s:property value="machineType"/>">
							<s:property value="machineName" />
						</option>
					</s:iterator>
				</select>
				<form action="<s:url value="/systemSettings/bpu/bpuMachine/delete.action"/>" method="POST" style="float: left;" class="delete-form">
					<input type="hidden" name="bpuMachineId" value="" id="bpu-machine-to-delete-id" /> <input type="submit" value="<s:text name="i18n.delete"/>"
						style="vertical-align: top; margin-top: 0; margin-left: 5px;" class="btn btn-danger">
				</form>
				<script type="text/javascript">
					$(document).ready(function() {
						$("#bpu-machine-list").val("<s:property value="#parameters.bpuMachineId"/>");
					});
				</script>
			</fieldset>
		</div>
		<div class="cf"></div>
		<div id="bpuMachineTagSetting" class="form-panel">
			<form action="<s:url value="/systemSettings/bpu/bpuMachine/saveBPUMachineTag.action"/>" method="POST">
				<fieldset>
					<legend>
						<s:text name="i18n.bpu.tag" />
					</legend>
					<ul>
						<li><label><s:text name="i18n.bpu.step.tag" /></label> <input type="text" value="<s:property value="selectedBPUMachine.stepNumberInSQLTag"/>" name="stepNumberInSQLTag"></li>
						<li><label><s:text name="i18n.bpu.phase.stat.tag" /></label> <input type="text" value="<s:property value="selectedBPUMachine.phaseStatusInSQLTag"/>" name="phaseStatusInSQLTag"></li>
						<li><input type="hidden" value="<s:property value="selectedBPUMachine.id"/>" name="bpuMachineId" /> <input type="submit" value="<s:text name="i18n.save"/>" class="btn btn-primary"></li>
					</ul>
					<s:fielderror />
				</fieldset>
			</form>

		</div>
	</div>
	<div class="cf"></div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>
<input type="hidden" value="<s:url value="/systemSettings/bpu/bpuMachineSettingPage.action"/>" id="bpuMachineActionAddress" />