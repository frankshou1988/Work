<jsp:include page="../../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/public/js/cip_target_setting.js"/>"></script>
<div id="main-container">
	<jsp:include page="cip_setting_sidebar_page.jsp"></jsp:include>
	<div id="setting-main-container">
		<div id="targetGroupSetting" style="height: 280px;" class="form-panel">
			<input type="hidden" value="<s:url value="/systemSettings/cip/cipTargetGroup/add.action"/>" id="target-group-add-url" /> <input type="hidden"
				value="<s:url value="/systemSettings/cip/cipTargetGroup/edit.action"/>" id="target-group-edit-url" />
			<form action="" method="POST" style="float: left;" autocomplete="off" id="target-group-manage-form">
				<fieldset style="float: left; height: 191px;">
					<legend>
						<s:text name="i18n.cip.target.group" />
					</legend>
					<ul>
						<li><label><s:text name="i18n.cip.target.group.name" /></label> <input type="text" name="cipTargetGroupName" id="cip-target-group-name" /> <s:fielderror fieldName="cipTargetGroupName"
								cssClass="cip-setting-error" /></li>
						<li><label><s:text name="i18n.cip.target.group.desc" /></label> <input type="text" name="cipTargetGroupDesc" id="cip-target-group-desc" /></li>
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
						<li><input type="hidden" value="" id="cip-target-group-id" name="cipTargetGroupId" /> <input type="button" value="<s:text name="i18n.add"/>" id="add-target-group-button"
							class="btn btn-primary" />&nbsp; <input type="button" value="<s:text name="i18n.edit"/>" id="edit-target-group-button" class="btn btn-primary" /></li>
					</ul>
				</fieldset>
			</form>
			<fieldset style="float: left; margin-left: 20px; padding-top: 20px;">
				<select style="height: 191px; width: 400px; float: left; margin-right: 2px;" size="10" id="cip-target-group-list">
					<s:iterator value="@com.tetrapak.util.cip.CIPTargetUtil@getCIPTargetGroupList()" var="cipTargetGroup">
						<option value="<s:property value="id"/>" title="<s:property value="cipTargetGroupDesc"/>" workshopType="<s:property value="workshopType"/>">
							<s:property value="cipTargetGroupName" />
						</option>
					</s:iterator>
				</select>
				<form action="<s:url value="/systemSettings/cip/cipTargetGroup/delete.action"/>" method="POST" style="float: left;" class="delete-form">
					<input type="hidden" name="cipTargetGroupId" value="" id="target-group-to-delete-id" /> <input type="submit" value="<s:text name="i18n.delete"/>"
						style="vertical-align: top; margin-top: 0; margin-left: 5px;" class="btn btn-danger">
				</form>
				<script type="text/javascript">
					$(document).ready(function() {
						$("#cip-target-group-list").val("<s:property value="#parameters.cipTargetGroupId"/>");
					});
				</script>
			</fieldset>
			<div class="cf"></div>
		</div>

		<div id="targetSetting" style="height: 291px;" class="form-panel">
			<input type="hidden" value="<s:url value="/systemSettings/cip/cipTarget/add.action"/>" id="target-add-url" /> <input type="hidden"
				value="<s:url value="/systemSettings/cip/cipTarget/edit.action"/>" id="target-edit-url" />
			<form action="" method="POST" style="float: left;" id="target-manage-form">
				<fieldset style="float: left; height: 251px;">
					<legend>
						<s:text name="i18n.cip.target" />
					</legend>
					<ul>
						<li><input type="hidden" value="" name="cipTargetGroupId" id="cip-target-s-group-id" /> <label><s:text name="i18n.cip.target.name" /></label> <input type="text" name="cipTargetName"
							id="cip-target-name" /> <s:fielderror fieldName="cipTargetName" cssClass="cip-setting-error" /></li>
						<li><label><s:text name="i18n.cip.target.desc" /></label> <input type="text" name="cipTargetDesc" id="cip-target-desc" /></li>
						<li><input type="hidden" value="" id="cip-target-id" name="cipTargetId" /> <input type="button" value="<s:text name="i18n.add"/>" id="add-target-button" class="btn btn-primary" />&nbsp; <input
							type="button" value="<s:text name="i18n.edit"/>" id="edit-target-button" class="btn btn-primary" /></li>
					</ul>
				</fieldset>
				<s:fielderror fieldName="cipTargetGroupId" cssClass="cip-setting-error" />
			</form>
			<fieldset style="float: left; margin-left: 20px; padding-top: 20px;">
				<select style="height: 251px; width: 400px; float: left; margin-right: 2px;" size="10" id="cip-target-list">
					<s:iterator value="@com.tetrapak.util.cip.CIPTargetUtil@getTargetListByGroupId(#parameters.cipTargetGroupId)" var="cipTarget">
						<option value="<s:property value="id"/>" title="<s:property value="cipTargetDesc"/>">
							<s:property value="cipTargetName" />
						</option>
					</s:iterator>
				</select>
				<form action="<s:url value="/systemSettings/cip/cipTarget/delete.action"/>" method="POST" style="float: left;" class="delete-form">
					<input type="hidden" name="cipTargetGroupId" value="<s:property value="#parameters.cipTargetGroupId"/>" /> <input type="hidden" name="cipTargetId" value="" id="target-to-delete-id" /> <input
						type="submit" value="<s:text name="i18n.delete"/>" style="vertical-align: top; margin-top: 0; margin-left: 5px;" class="btn btn-danger">
				</form>
			</fieldset>
			<div class="cf"></div>
		</div>
	</div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>
<input type="hidden" id="cipTargetActionAddress" value="<s:url value="/systemSettings/cip/cipTargetSettingPage.action"/>" />
