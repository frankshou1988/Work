<jsp:include page="../../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/public/js/cip_phase_setting.js"/>"></script>
<div id="main-container">
	<jsp:include page="cip_setting_sidebar_page.jsp"></jsp:include>
	<div id="setting-main-container" class="form-panel">
		<form action="<s:url value="/systemSettings/cip/cipPhase/save.action"/>" method="POST" id="cipPhaseSettingForm">
			<fieldset>
				<legend>
					<s:text name="i18n.cip.phase" />
				</legend>
				<div style="float: left;">
					<table>
						<tr>
							<td><label><s:text name="i18n.cip.phase.list" /></label> <select name="id" id="cip-phase-list" size="10" style="height: 600px; width: 300px;">
									<s:iterator value="@com.tetrapak.util.cip.CIPPhaseSettingUtil@getCIPPhaseList()" var="cipPhase" status="stat">
										<option value="<s:property value="id"/>">
											<s:property value="phaseName" />
										</option>
									</s:iterator>
							</select></td>
						</tr>
					</table>
				</div>
				<div style="float: left; margin-left: 10px;">
					<table>
						<tr>
							<td><label><s:text name="i18n.cip.phase.name" /></label> <input type="text" name="cipPhaseName" id="cip-phase-setting-name" value="<s:property value="cipPhase.phaseName"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.phase.id" /></label> <input type="text" name="cipPhaseID" id="cip-phase-setting-id" value="<s:property value="cipPhase.phaseID"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line" /></label> <select name="cipPhaseMasterLineId" id="cip-phase-setting-master-line">
									<option value="0">
										<s:text name="i18n.please.select" />
									</option>
									<s:iterator value="@com.tetrapak.util.cip.CIPLineUtil@getCIPMasterLineList()" var="cipMasterLine" status="stat">
										<option value="<s:property value="id"/>">
											<s:property value="cipMasterLineName" />
										</option>
									</s:iterator>
							</select></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.slave.line" /></label> <select name="cipPhaseSlaveLineId" id="cip-phase-setting-slave-line">
									<s:if test="#cipPhase != null">
										<s:iterator value="@com.tetrapak.util.cip.CIPLineUtil@getCIPSlaveLineListByMasterLineId(cipPhase.cipSlaveLine.cipMasterLine.id)" var="cipSlaveLine">
											<option value="<s:property value="id"/>">
												<s:property value="cipSlaveLineName" />
											</option>
										</s:iterator>
									</s:if>
							</select></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.target.group" /></label> <select name="cipPhaseTargetGroupId" id="cip-phase-setting-target-group">
									<option value="0">
										<s:text name="i18n.please.select" />
									</option>
									<s:iterator value="@com.tetrapak.util.cip.CIPTargetUtil@getCIPTargetGroupList()" var="cipTargetGroup">
										<option value="<s:property value="id"/>" title="<s:property value="cipTargetGroupDesc"/>">
											<s:property value="cipTargetGroupName" />
										</option>
									</s:iterator>
							</select></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.target" /></label><select name="cipPhaseTargetId" id="cip-phase-setting-target">
									<s:if test="#cipPhase != null">
										<s:iterator value="@com.tetrapak.util.cip.CIPTargetUtil@getTargetListByGroupId(cipPhase.cipTarget.cipTargetGroup.id)" var="cipTarget">
											<option value="<s:property value="id"/>">
												<s:property value="cipTargetName" />
											</option>
										</s:iterator>
									</s:if>
							</select></td>
						</tr>
						<tr>
							<td><label></label> <input type="submit" value="<s:text name="i18n.save"/>" class="btn btn-primary" /> <input type="hidden"
								value="<s:url value="/systemSettings/cip/cipPhase/delete.action"/>" id="cip-phase-delete-url" /> <input type="submit" value="<s:text name="i18n.delete"/>" id="cip-phase-delete-button"
								class="btn btn-danger" /></td>
						</tr>
					</table>
					<s:fielderror cssClass="cip-setting-error"></s:fielderror>
				</div>
				<script type="text/javascript">
					$(document).ready(
							function() {
								$("#cip-phase-list").val("<s:property value="#parameters.cipPhaseId"/>");
								$("#cip-phase-setting-master-line").val(
										"<s:property value="cipPhase.cipSlaveLine.cipMasterLine.id"/>");
								$("#cip-phase-setting-slave-line")
										.val("<s:property value="cipPhase.cipSlaveLine.id"/>");
								$("#cip-phase-setting-target-group").val(
										"<s:property value="cipPhase.cipTarget.cipTargetGroup.id"/>");
								$("#cip-phase-setting-target").val("<s:property value="cipPhase.cipTarget.id"/>");
							});
				</script>
			</fieldset>
		</form>
	</div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>
<input type="hidden" id="cip-get-slave-line-of-master-line-url" value="<s:url value="/cip/ajax/getSlaveLineOfMasterLine.action"/>" />
<input type="hidden" id="cip-get-target-of-target-group-url" value="<s:url value="/cip/ajax/getCIPTargetOfTargetGroup.action"/>" />
<input type="hidden" id="cip-phase-setting-url" value="<s:url value="/systemSettings/cip/cipPhaseSettingPage.action"/>" />
