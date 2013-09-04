<jsp:include page="../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/public/js/admin_bpu_standard_param_setting.js"/>"></script>
<div id="main-container">
	<div id="setting-main-container" class="form-panel">
		<form action="<s:url value="/admin/bpu/bpuStandardParamSave.action"/>" method="POST" id="bpuStandardParamSettingForm" autocomplete="off" style="float: left; width: auto;">
			<fieldset>
				<legend>
					<s:text name="i18n.admin.bpu.standard.param.setting" />
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
					<li><label><s:text name="i18n.bpu.parameter.tag" /></label> <select name="analogTagId" id="analog-tag-list" style="height: 400px;" multiple>
							<s:iterator value="@com.tetrapak.util.bpu.BPUAnalogTagUtil@getBPUAnalogTagListOfBPUMachine(#parameters.bpuMachineId)" var="analogTag">
								<option value="<s:property value="id"/>">
									<s:property value="analogTagName" />
								</option>
							</s:iterator>
					</select></li>
					<li><label><s:text name="i18n.bpu.standard.param.min" /></label> <input type="text" name="bpuStandardParamMinValue" value="<s:property value="selectedAnalogTag.analogStandardMinValue"/>" /></li>
					<li><label><s:text name="i18n.bpu.standard.param.max" /></label> <input type="text" name="bpuStandardParamMaxValue" value="<s:property value="selectedAnalogTag.analogStandardMaxValue"/>" /></li>
					<li><input type="submit" value="<s:text name="i18n.save"/>" class="btn btn-primary" /></li>
				</ul>
				<s:fielderror />
			</fieldset>
		</form>
		<fieldset style="float: left; margin-left: 10px;">
			<table class="bpu-result-table">
				<thead>
					<tr>
						<th><s:text name="i18n.no" /></th>
						<th><s:text name="i18n.bpu.analog.tag.name" /></th>
						<th><s:text name="i18n.bpu.analog.tag.desc" /></th>
						<th><s:text name="i18n.bpu.analog.tag.unit" /></th>
						<th><s:text name="i18n.bpu.standard.param.min" /></th>
						<th><s:text name="i18n.bpu.standard.param.max" /></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="@com.tetrapak.util.bpu.BPUAnalogTagUtil@getBPUAnalogTagListOfBPUMachine(#parameters.bpuMachineId)" var="analogTag" status="stat">
						<tr>
							<td><s:property value="#stat.index+1" /></td>
							<td><s:property value="analogTagName" /></td>
							<td><s:property value="analogTagDesc" /></td>
							<td><s:property value="analogTagUnit" /></td>
							<td><s:property value="analogStandardMinValue" /></td>
							<td><s:property value="analogStandardMaxValue" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</fieldset>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#bpu-machine-list").val('<s:property value="#parameters.bpuMachineId"/>');
				$("#analog-tag-list").val('<s:property value="#parameters.analogTagId"/>');
			});
		</script>
		<div class="cf"></div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
<input type="hidden" value="<s:url value="/admin/bpu/bpuStandardParamSettingPage.action"/>" id="adminBPUStandardParamSettingAddress" />