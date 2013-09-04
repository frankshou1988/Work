<jsp:include page="../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div id="main-container">
	<div id="setting-main-container">
		<div id="admin-ui-tab">
			<ul>
				<li><a href="#login-user-manage-tab"><s:text name="i18n.login.user.management" /></a></li>
				<li><a href="#hmi-operator-manage-tab"><s:text name="i18n.hmi.operator.management" /></a></li>
			</ul>
			<div id="login-user-manage-tab">
				<form action="<s:url value="/admin/userManage/addUser.action"/>" method="POST" id="user-management-form" autocomplete="off" style="float: left;">
					<fieldset>
						<legend>
							<s:text name="i18n.login.user.management" />
						</legend>
						<div class="control-group">
							<div class="control-label">
								<label> <s:text name="i18n.user.name" />
								</label>
							</div>
							<div class="controls">
								<input type="text" name="userName" id="setting-user-name" />
								<s:fielderror fieldName="userName"></s:fielderror>
							</div>
						</div>
						<div class="control-group">
							<div class="control-label">
								<label><s:text name="i18n.user.pass" /></label>
							</div>
							<div class="controls">
								<input type="password" name="userPass" id="setting-user-pass" />
								<s:fielderror fieldName="userPass"></s:fielderror>
							</div>
						</div>
						<div class="control-group">
							<div class="control-label">
								<label> <s:text name="i18n.user.pass.confirm" />
								</label>
							</div>
							<div class="controls">
								<input type="password" name="userPassConfirm" id="setting-user-pass-confirm" />
								<s:fielderror fieldName="userPassConfirm"></s:fielderror>
							</div>
						</div>
						<div class="control-group">
							<select name="userAuthedRoles" multiple style="height: 100px; overflow: auto;">
								<s:iterator value="@com.tetrapak.util.authz.UserManagementUtil@getUserRoleList(#currentUser)" var="userRole">
									<option value="<s:property value="roleType"/>">
										<s:property value="roleDesc" />
									</option>
								</s:iterator>
							</select>
						</div>
						<div class="control-group">
							<div class="control-label">&nbsp;</div>
							<div class="controls">
								<input type="submit" value="<s:text name="i18n.add"/>" class="btn btn-primary" />
								<s:actionmessage />
								<s:actionerror />
							</div>
						</div>
					</fieldset>
				</form>
				<div style="float: right; margin-left: 20px; margin-top: 30px;">
					<div>
						<label style="width: 200px;" class="user-table-header-label"><s:text name="i18n.user.name" /></label><label style="width: 400px;" class="user-table-header-label"><s:text
								name="i18n.user.role" /></label><label style="width: 80px;" class="user-table-header-label"><s:text name="i18n.action" /></label>
					</div>
					<div style="height: 500px; overflow: auto;">
						<table id="user-table">
							<tbody>
								<s:iterator value="@com.tetrapak.util.authz.UserManagementUtil@getUserList(#currentUser)" var="user">
									<tr>
										<td style="width: 200px;"><s:property value="userName" /></td>
										<td style="width: 400px;"><s:iterator value="userRoles" var="userRole">
												<span style="background-color: green; color: #fff; padding: 2px; border-radius: 2px;"><s:property value="roleDesc" /></span>
											</s:iterator></td>
										<td style="width: 60px;">
											<form action="<s:url value="/admin/userManage/deleteUser.action"/>" method="POST" style="display: inline;" class="delete-form">
												<input type="hidden" value="<s:property value="id"/>" name="userId" /> <input type="submit" class="btn btn-danger" value="<s:text name="i18n.delete" />" />
											</form>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
				<div class="cf"></div>
			</div>
			<div id="hmi-operator-manage-tab">
				<form action="<s:url value="/admin/hmiOperatorManage/save.action"/>" style="float: left;" method="POST" autocomplete="off">
					<fieldset>
						<legend>
							<s:text name="i18n.hmi.operator.management" />
						</legend>
						<ul>
							<li><label><s:text name="i18n.hmi.operator.plc.id" /></label> <input type="text" name="plcId" id="hmi-operator-plc-id" /> <s:fielderror fieldName="cipTypePLCIdValue"
									cssClass="cip-setting-error" /></li>
							<li><label><s:text name="i18n.hmi.operator.name" /></label> <input type="text" name="operatorName" id="hmi-operator-name" /> <s:fielderror fieldName="cipTypeDesc"
									cssClass="cip-setting-error" /></li>
							<li><label><s:text name="i18n.plc.structure" /></label> <select name="plcStructureType" id="hmi-operator-plc-structure-type">
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
						<s:fielderror></s:fielderror>
					</fieldset>
				</form>
				<fieldset style="float: left; margin-left: 20px; padding-top: 20px;">
					<select name="hmiOperatorList" style="height: 200px; width: 400px; float: left;" size="10" id="hmi-operator-list">
						<s:iterator value="@com.tetrapak.util.common.HMIOperatorUtil@getHMIOperatorList()" var="cipType" status="stat">
							<option value="<s:property value="plcId" />" id="<s:property value="id" />" plcStructureType="<s:property value="plcStructureType"/>" desc="<s:property value="operatorName" />">
								<s:property value="operatorName" />
								&nbsp;[
								<s:property value="plcStructureType" />
								]
							</option>
						</s:iterator>
					</select>
					<form action="<s:url value="/admin/hmiOperatorManage/delete.action"/>" method="POST" style="float: left;" class="delete-form">
						<input type="hidden" name="operatorId" value="" id="hmi-operator-to-delete-id" /> <input type="submit" value="<s:text name="i18n.delete"/>"
							style="vertical-align: top; margin-top: 0; margin-left: 5px;" class="btn btn-danger">
					</form>
				</fieldset>
				<div class="cf"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#admin-ui-tab").tabs({
				active : <s:property value="#parameters.tab"/>
			});
		});
	</script>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$("#hmi-operator-list").click(function() {
			var selected = $(this).find("option:selected");
			if (selected != undefined) {
				var id = $.trim(selected.attr("id"));
				var plcId = selected.val();
				var operatorName = $.trim(selected.attr("desc"));
				var plcStructureType = $.trim(selected.attr("plcStructureType"));
				$("#hmi-operator-plc-id").val(plcId);
				$("#hmi-operator-name").val(operatorName);
				$("#hmi-operator-plc-structure-type").val(plcStructureType);
				$("#hmi-operator-to-delete-id").val(id);
			}
		});
	});
</script>
<jsp:include page="../footer.jsp"></jsp:include>