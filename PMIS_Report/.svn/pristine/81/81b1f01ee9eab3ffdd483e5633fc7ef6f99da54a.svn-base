<jsp:include page="../../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/public/js/bpu_analog_tag_setting.js"/>"></script>
<div id="main-container">
	<jsp:include page="bpu_setting_sidebar_page.jsp"></jsp:include>
	<div id="setting-main-container">
		<div id="bpuAnalogTag" style="height: auto; width: auto; float: left;" class="form-panel">
			<input type="hidden" value="<s:url value="/systemSettings/bpu/analogTag/add.action"/>" id="analog-tag-add-url" /> <input type="hidden"
				value="<s:url value="/systemSettings/bpu/analogTag/edit.action"/>" id="analog-tag-edit-url" />
			<form action="" method="POST" id="analog-tag-manage-form">
				<fieldset>
					<legend>
						<s:text name="i18n.bpu.trend.tag" />
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
						<li><label><s:text name="i18n.bpu.analog.tag.name" /></label> <input type="text" name="analogTagName" value="<s:property value="selectedAnalogTag.analogTagName"/>" /></li>
						<li><label><s:text name="i18n.bpu.analog.insql.tag.name" /></label> <input type="text" name="analogInsqlTagName" value="<s:property value="selectedAnalogTag.analogInsqlTagName"/>" /></li>
						<li><label><s:text name="i18n.bpu.analog.tag.desc" /></label> <input type="text" name="analogTagDesc" value="<s:property value="selectedAnalogTag.analogTagDesc"/>" /></li>
						<li><label><s:text name="i18n.bpu.analog.tag.unit" /></label> <input type="text" name="analogTagUnit" value="<s:property value="selectedAnalogTag.analogTagUnit"/>" /></li>
						<li><label><s:text name="i18n.bpu.analog.tag.value.type" /></label><select name="analogTagValueType" id="analog-tag-value-type"><option value="VT_DOUBLE">
									<s:text name="i18n.double" />
								</option>
								<option value="VT_INT">
									<s:text name="i18n.int" />
								</option></select></li>
						<li><label><s:text name="i18n.bpu.analog.tag.value.divided.by" /></label><input type="text" name="analogTagValueDividedBy" id="analog-tag-value-divided-by"
							value="<s:property value="selectedAnalogTag.analogTagValueDividedBy"/>" /></li>
						<li><input type="hidden" value="<s:property value="selectedAnalogTag.id"/>" id="analog-tag-id" name="analogTagId" /> <input type="button" name="" value="<s:text name="i18n.add"/>"
							id="add-analog-tag-button" class="btn btn-primary"> <input type="button" name="" value="<s:text name="i18n.edit"/>" id="edit-analog-tag-button" class="btn btn-primary" /></li>
					</ul>
					<s:fielderror />
				</fieldset>
			</form>
			<script type="text/javascript">
				$(document).ready(function() {
					$("#bpu-machine-list").val("<s:property value="#parameters.bpuMachineId"/>");
					$("#analog-tag-value-type").val('<s:property value="selectedAnalogTag.analogTagValueType"/>');
				});
			</script>
		</div>
		<div style="float: left; margin: 20px;">
			<table class="bpu-result-table">
				<thead>
					<tr>
						<th><s:text name="i18n.no" /></th>
						<th><s:text name="i18n.bpu.analog.tag.name" /></th>
						<th><s:text name="i18n.bpu.analog.insql.tag.name" /></th>
						<th><s:text name="i18n.bpu.analog.tag.desc" /></th>
						<th><s:text name="i18n.bpu.analog.tag.unit" /></th>
						<th><s:text name="i18n.bpu.analog.tag.value.type" /></th>
						<th><s:text name="i18n.bpu.analog.tag.value.divided.by" /></th>
						<th><s:text name="i18n.action" /></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="@com.tetrapak.util.bpu.BPUAnalogTagUtil@getBPUAnalogTagListOfBPUMachine(#parameters.bpuMachineId)" var="analogTag" status="stat">
						<tr>
							<td><s:property value="#stat.index+1" /></td>
							<td><s:property value="analogTagName" /></td>
							<td><s:property value="analogInsqlTagName" /></td>
							<td><s:property value="analogTagDesc" /></td>
							<td><s:property value="analogTagUnit" /></td>
							<td><s:property value="analogTagValueType" /></td>
							<td><s:property value="analogTagValueDividedBy" /></td>
							<td>
								<form style="margin: 0;" action="<s:url value="/systemSettings/bpu/analogTag/delete.action"/>" method="POST" id="analog-tag-delete-form<s:property value="id"/>" class="delete-form">
									<input type="hidden" value="<s:property value="#parameters.bpuMachineId"/>" name="bpuMachineId" /> <input type="hidden" value="<s:property value="id"/>" name="analogTagId" />
								</form> <input type="button" value="<s:text name="i18n.delete"/>" style="margin-right: 10px;" class="analog-tag-delete-button btn btn-danger"
								deleteFormId="analog-tag-delete-form<s:property value="id"/>"> <input type="button" value="<s:text name="i18n.edit"/>" class="analog-tag-edit-button btn btn-info"
								analogTagId="<s:property value="id"/>" />
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
<input type="hidden" value="<s:url value="/systemSettings/bpu/bpuAnalogTagSettingPage.action"/>" id="analogTagActionAddress" />