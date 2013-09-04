<jsp:include page="../../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/public/js/cip_line_setting.js"/>"></script>
<div id="main-container">
	<jsp:include page="cip_setting_sidebar_page.jsp"></jsp:include>
	<div id="setting-main-container">
		<div style="height: 400px;">
			<input type="hidden" value="<s:url value="/systemSettings/cip/cipMasterLine/add.action"/>" id="master-line-add-url" /> <input type="hidden"
				value="<s:url value="/systemSettings/cip/cipMasterLine/edit.action"/>" id="master-line-edit-url" />
			<form action="" method="POST" style="float: left;" autocomplete="off" id="master-line-manage-form">
				<fieldset style="float: left;">
					<legend>
						<s:text name="i18n.cip.master.line" />
					</legend>
					<ul>
						<li><label><s:text name="i18n.cip.master.line.name" /></label> <input type="text" name="masterLineName" id="master-line-name" /> <s:fielderror fieldName="masterLineName"
								cssClass="cip-setting-error" /></li>
						<li><label><s:text name="i18n.cip.master.line.desc" /></label> <input type="text" name="masterLineDesc" id="master-line-desc" /></li>
						<li><label><s:text name="i18n.plc.structure" /></label> <select name="plcStructureType" id="plc-structure-type">
								<option value="">
									<s:text name="i18n.please.select" />
								</option>
								<option value="TPM4">
									<s:text name="i18n.plc.structure.tpm4" />
								</option>
								<option value="TPM5">
									<s:text name="i18n.plc.structure.tpm5" />
								</option>
								<option value="TPM6">
									<s:text name="i18n.plc.structure.tpm6" />
								</option>
						</select></li>
						<li><label><s:text name="i18n.workshop.type" /></label> <select name="workshopType" id="workshop-type">
								<option value="">
									<s:text name="i18n.please.select" />
								</option>
								<s:iterator value="@com.tetrapak.util.common.WorkshopTypeUtil@getWorkshopTypeList()" var="wt">
									<option value="<s:property value="workshopTypeName"/>">
										<s:property value="workshopTypeDesc" />
									</option>
								</s:iterator>
						</select></li>
						<li><input type="hidden" value="" id="master-line-id" name="masterLineId" /> <input type="button" value="<s:text name="i18n.add"/>" id="add-master-line-button" class="btn btn-primary" />
							&nbsp;<input type="button" value="<s:text name="i18n.edit"/>" id="edit-master-line-button" class="btn btn-primary" /></li>
					</ul>
				</fieldset>
			</form>
			<fieldset style="float: left; margin-left: 20px; padding-top: 20px;">
				<select style="height: 260px; width: 400px; float: left; margin-right: 2px;" size="10" id="master-line-list">
					<s:iterator value="@com.tetrapak.util.cip.CIPLineUtil@getCIPMasterLineList()" var="cipMasterLine">
						<option value="<s:property value="id"/>" title="<s:property value="cipMasterLineDesc"/>" plcStructureType="<s:property value="plcStructureType"/>"
							workshopType="<s:property value="workshopType"/>">
							<s:property value="cipMasterLineName" />
						</option>
					</s:iterator>
				</select>
				<form action="<s:url value="/systemSettings/cip/cipMasterLine/delete.action"/>" method="POST" style="float: left;" class="delete-form">
					<input type="hidden" name="masterLineId" value="" id="master-line-to-delete-id" /> <input type="submit" value="<s:text name="i18n.delete"/>"
						style="vertical-align: top; margin-top: 0; margin-left: 5px;" class="btn btn-danger">
				</form>
				<script type="text/javascript">
					$(document).ready(function() {
						$("#master-line-list").val("<s:property value="#parameters.masterLineId"/>");
					});
				</script>
			</fieldset>
			<div class="cf"></div>
		</div>

		<div style="height: 300px;">
			<input type="hidden" value="<s:url value="/systemSettings/cip/cipSlaveLine/add.action"/>" id="slave-line-add-url" /> <input type="hidden"
				value="<s:url value="/systemSettings/cip/cipSlaveLine/edit.action"/>" id="slave-line-edit-url" />
			<form action="" method="POST" style="float: left;" autocomplete="off" id="slave-line-manage-form">
				<fieldset style="float: left;">
					<input type="hidden" name="masterLineId" id="slave-line-s-master-line-id" value="<s:property value="#parameters.masterLineId"/>" />
					<legend>
						<s:text name="i18n.cip.slave.line" />
					</legend>
					<ul>
						<li><label><s:text name="i18n.cip.slave.line.name" /></label> <input type="text" name="slaveLineName" id="slave-line-name" /> <s:fielderror fieldName="slaveLineName"
								cssClass="cip-setting-error" /></li>
						<li><label><s:text name="i18n.cip.slave.line.desc" /></label> <input type="text" name="slaveLineDesc" id="slave-line-desc" /></li>
						<li><input type="hidden" name="slaveLineId" value="" id="slave-line-id" /> <input type="submit" value="<s:text name="i18n.add"/>" id="add-slave-line-button" class="btn btn-primary" />&nbsp;
							<input type="submit" value="<s:text name="i18n.edit"/>" id="edit-slave-line-button" class="btn btn-primary" /></li>
					</ul>
				</fieldset>
				<s:fielderror fieldName="masterLineId" cssClass="cip-setting-error" />
			</form>
			<fieldset style="float: left; margin-left: 20px; padding-top: 20px;">
				<select style="height: 260px; width: 400px; float: left; margin-right: 2px;" size="10" id="slave-line-list">
					<s:iterator value="@com.tetrapak.util.cip.CIPLineUtil@getCIPSlaveLineListByMasterLineId(#parameters.masterLineId)" var="cipSlaveLine">
						<option value="<s:property value="id"/>" title="<s:property value="cipSlaveLineDesc"/>">
							<s:property value="cipSlaveLineName" />
						</option>
					</s:iterator>
				</select>
				<form action="<s:url value="/systemSettings/cip/cipSlaveLine/delete.action"/>" method="POST" style="float: left;" class="delete-form">
					<input type="hidden" name="slaveLineId" value="" id="slave-line-to-delete-id" /> <input type="hidden" name="masterLineId" value="<s:property value="#parameters.masterLineId"/>" /> <input
						type="submit" value="<s:text name="i18n.delete"/>" style="vertical-align: top; margin-top: 0px; margin-left: 5px;" class="btn btn-danger">
				</form>
			</fieldset>
			<div class="cf"></div>
		</div>

	</div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>
<input type="hidden" id="cipLineActionAddress" value="<s:url value="/systemSettings/cip/cipLineSettingPage.action"/>" />
