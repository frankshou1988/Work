<jsp:include page="../../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/public/js/cip_master_line_tags_setting.js"/>"></script>
<div id="main-container">
	<jsp:include page="cip_setting_sidebar_page.jsp"></jsp:include>
	<input type="hidden" value="<s:url value="/systemSettings/cip/cipMasterLineTagsSettingPage.action"/>" id="cip-master-line-tags-url" />
	<div id="setting-main-container" class="cip-master-line-tag-setting-form">
		<form action="<s:url value="/systemSettings/cip/cipMasterLineTag/save.action"/>" method="POST" autocomplete="off">
			<fieldset>
				<legend>
					<s:text name="i18n.cip.master.line.tags" />
				</legend>
				<div style="float: left;">
					<table>
						<tr>
							<td><label><s:text name="i18n.cip.master.line" /></label> <select name="masterLineId" id="cmt-cip-master-line-id" size="10" style="height: 400px;">
									<s:iterator value="@com.tetrapak.util.cip.CIPLineUtil@getCIPMasterLineList()" var="cipMasterLine" status="stat">
										<option value="<s:property value="id"/>">
											<s:property value="cipMasterLineName" />
										</option>
									</s:iterator>
							</select></td>
						</tr>
						<tr>
							<td><input type="submit" value="<s:text name="i18n.save"/>" class="btn btn-primary" /></td>
						</tr>
					</table>
				</div>
				<div style="float: left; margin-left: 10px;">
					<table>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.oper.tag" /></label> <input type="text" name="masterLineOperTag" value="<s:property value="cipMasterLine.cipMasterLineOperTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.route.phase.id.tag" /></label> <input type="text" name="masterLineRoutePhaseIDTag"
								value="<s:property value="cipMasterLine.cipMasterLineRoutePhaseIDTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.cip.program.id.tag" /></label> <input type="text" name="masterLineCIPProgramIDTag"
								value="<s:property value="cipMasterLine.cipMasterLineCIPProgramIDTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.cip.operated.by.id.tag" /></label> <input type="text" name="masterLineOperatedByIDTag"
								value="<s:property value="cipMasterLine.cipMasterLineOperatedByIDTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.cip.result.id.tag" /></label> <input type="text" name="masterLineCIPResultIDTag"
								value="<s:property value="cipMasterLine.cipMasterLineCIPResultIDTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.steps.tag" /></label> <input type="text" name="masterLineStepsTag" value="<s:property value="cipMasterLine.cipMasterLineStepsTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.cip.step.timer.tag" /></label> <input type="text" name="masterLineStepTimerTag"
								value="<s:property value="cipMasterLine.cipMasterLineStepTimerTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.flow.out.tag" /></label> <input type="text" name="masterLineFlowOutTag" value="<s:property value="cipMasterLine.cipMasterLineFlowOutTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.temp.out.tag" /></label> <input type="text" name="masterLineTemperatureOutTag"
								value="<s:property value="cipMasterLine.cipMasterLineTemperatureOutTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.conductivity.back.tag" /></label> <input type="text" name="masterLineConductivityBackTag"
								value="<s:property value="cipMasterLine.cipMasterLineConductivityBackTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.temp.back.tag" /></label> <input type="text" name="masterLineTemperatureBackTag"
								value="<s:property value="cipMasterLine.cipMasterLineTemperatureBackTag"/>" /></td>
						</tr>
					</table>
				</div>
				<div style="float: left; margin-left: 10px;">
					<table>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.phase.activity.id.tag" /></label> <input type="text" name="phaseActivityIDTag" value="<s:property value="cipMasterLine.phaseActivityIDTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.pre.rinse.step.n.tag" /></label> <input type="text" name="preRinseStepNTag" value="<s:property value="cipMasterLine.preRinseStepNTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.pre.rinse.step.timer.hold.tag" /></label> <input type="text" name="preRinseStepTimerHoldTag"
								value="<s:property value="cipMasterLine.preRinseStepTimerHoldTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.int.rinse.step.n.tag" /></label> <input type="text" name="intRinseStepNTag" value="<s:property value="cipMasterLine.intRinseStepNTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.int.rinse.step.timer.hold.tag" /></label> <input type="text" name="intRinseStepTimerHoldTag"
								value="<s:property value="cipMasterLine.intRinseStepTimerHoldTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.final.rinse.step.n.tag" /></label> <input type="text" name="finalRinseStepNTag"
								value="<s:property value="cipMasterLine.finalRinseStepNTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.final.rinse.step.timer.hold.tag" /></label> <input type="text" name="finalRinseStepTimerHoldTag"
								value="<s:property value="cipMasterLine.finalRinseStepTimerHoldTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.lye.step.n.tag" /></label> <input type="text" name="lyeStepNTag" value="<s:property value="cipMasterLine.lyeStepNTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.lye.step.timer.hold.tag" /></label> <input type="text" name="lyeStepTimerHoldTag"
								value="<s:property value="cipMasterLine.lyeStepTimerHoldTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.acid.step.n.tag" /></label> <input type="text" name="acidStepNTag" value="<s:property value="cipMasterLine.acidStepNTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.acid.step.timer.hold.tag" /></label> <input type="text" name="acidStepTimerHoldTag"
								value="<s:property value="cipMasterLine.acidStepTimerHoldTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.hot.wat.step.n.tag" /></label> <input type="text" name="hotWatStepNTag" value="<s:property value="cipMasterLine.hotWatStepNTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.hot.wat.step.timer.hold.tag" /></label> <input type="text" name="hotWatStepTimerHoldTag"
								value="<s:property value="cipMasterLine.hotWatStepTimerHoldTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.chem.dis.step.n.tag" /></label> <input type="text" name="chemDisStepNTag" value="<s:property value="cipMasterLine.chemDisStepNTag"/>" /></td>
						</tr>
						<tr>
							<td><label><s:text name="i18n.cip.master.line.chem.dis.step.timer.hold.tag" /></label> <input type="text" name="chemDisStepTimerHoldTag"
								value="<s:property value="cipMasterLine.chemDisStepTimerHoldTag"/>" /></td>
						</tr>
					</table>
				</div>
				<s:fielderror></s:fielderror>
			</fieldset>

		</form>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#cmt-cip-master-line-id").val("<s:property value="#parameters.masterLineId"/>");
			});
		</script>
	</div>
	<div class="cf"></div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>