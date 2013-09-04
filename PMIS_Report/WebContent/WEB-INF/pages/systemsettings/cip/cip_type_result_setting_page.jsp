<jsp:include page="../../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/public/js/cip_type_result_setting.js"/>"></script>
<div id="main-container">
	<jsp:include page="cip_setting_sidebar_page.jsp"></jsp:include>
	<div id="setting-main-container">
		<div id="cipTypeSetting" class="form-panel">
			<form action="<s:url value="/systemSettings/cip/cipType/save.action"/>" style="float: left;" method="POST" autocomplete="off">
				<fieldset>
					<legend>
						<s:text name="i18n.cip.type" />
					</legend>
					<ul>
						<li><label><s:text name="i18n.cip.plc.id" /></label> <input type="text" name="cipTypePLCIdValue" id="cip-type-plc-id" /> <s:fielderror fieldName="cipTypePLCIdValue"
								cssClass="cip-setting-error" /></li>
						<li><label><s:text name="i18n.desc" /></label> <input type="text" name="cipTypeDesc" id="cip-type-desc" /> <s:fielderror fieldName="cipTypeDesc" cssClass="cip-setting-error" /></li>
						<li><label><s:text name="i18n.plc.structure" /></label> <select name="plcStructureType" id="cip-type-plc-structure-type">
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
						<li><input type="submit" value="<s:text name="i18n.save"/>" class="btn btn-primary" /></li>
					</ul>
				</fieldset>
			</form>
			<fieldset style="float: left; margin-left: 20px; padding-top: 20px;">
				<select name="cipTypeList" style="height: 200px; width: 400px; float: left;" size="10" id="cip-type-list">
					<s:iterator value="@com.tetrapak.util.cip.CIPTypeUtil@getCIPTypeList()" var="cipType" status="stat">
						<option value="<s:property value="cipTypePLCId" />" id="<s:property value="id" />" plcStructureType="<s:property value="plcStructureType"/>" desc="<s:property value="cipTypeDesc" />">
							<s:property value="cipTypeDesc" />&nbsp;[<s:property value="plcStructureType" />]
						</option>
					</s:iterator>
				</select>
				<form action="<s:url value="/systemSettings/cip/cipType/delete.action"/>" method="POST" style="float: left;" class="delete-form">
					<input type="hidden" name="cipTypeId" value="" id="cip-type-to-delete-id" /> <input type="submit" value="<s:text name="i18n.delete"/>"
						style="vertical-align: top; margin-top: 0; margin-left: 5px;" class="btn btn-danger">
				</form>
			</fieldset>
			<div class="cf"></div>
		</div>
		<div id="cipResultSetting" class="form-panel">
			<form action="<s:url value="/systemSettings/cip/cipResult/save.action"/>" style="float: left;" method="POST" autocomplete="off">
				<fieldset>
					<legend>
						<s:text name="i18n.cip.result" />
					</legend>
					<ul>
						<li><label><s:text name="i18n.cip.plc.id" /></label> <input type="text" name="cipResultPLCIdValue" id="cip-result-plc-id" /> <s:fielderror fieldName="cipResultPLCIdValue"
								cssClass="cip-setting-error" /></li>
						<li><label><s:text name="i18n.desc" /></label> <input type="text" name="cipResultDesc" id="cip-result-desc" /></li>
						<li><label><s:text name="i18n.plc.structure" /></label> <select name="plcStructureType" id="cip-result-plc-structure-type">
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
						<s:fielderror fieldName="cipResultDesc" cssClass="cip-setting-error" />
						<li><input type="submit" value="<s:text name="i18n.save"/>" class="btn btn-primary" /></li>
					</ul>
				</fieldset>
			</form>
			<fieldset style="float: left; margin-left: 20px; padding-top: 20px;">
				<select name="cipResultList" style="height: 200px; width: 400px; float: left;" size="10" id="cip-result-list">
					<s:iterator value="@com.tetrapak.util.cip.CIPResultUtil@getCIPResultList()" var="cipResult" status="stat">
						<option value="<s:property value="cipResultPLCId" />" id="<s:property value="id" />" plcStructureType="<s:property value="plcStructureType"/>" desc="<s:property value="cipResultDesc" />">
							<s:property value="cipResultDesc" />&nbsp;[<s:property value="plcStructureType" />]
						</option>
					</s:iterator>
				</select>
				<form action="<s:url value="/systemSettings/cip/cipResult/delete.action"/>" method="POST" style="float: left;" class="delete-form">
					<input type="hidden" name="cipResultId" value="" id="cip-result-to-delete-id" /> <input type="submit" value="<s:text name="i18n.delete"/>"
						style="vertical-align: top; margin-top: 0; margin-left: 5px;" class="btn btn-danger">
				</form>
			</fieldset>
			<div class="cf"></div>
		</div>
	</div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>
