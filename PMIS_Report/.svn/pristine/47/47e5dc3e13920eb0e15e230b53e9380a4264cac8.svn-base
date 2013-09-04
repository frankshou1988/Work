<jsp:include page="../../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/public/js/cip_trend_tag_setting.js"/>"></script>
<div id="main-container">
	<jsp:include page="cip_setting_sidebar_page.jsp"></jsp:include>
	<div id="setting-main-container" class="form-panel">
		<form action="<s:url value="/systemSettings/cip/cipTrendTag/save.action"/>" method="POST" autocomplete="off" style="float: left;">
			<fieldset>
				<legend>
					<s:text name="i18n.cip.trend.tag" />
				</legend>
				<ul>
					<li><label><s:text name="i18n.cip.master.line" /></label> <select name="cipTrendTagMasterLineId" id="cip-trend-tag-master-line">
							<option value="">
								<s:text name="i18n.please.select" />
							</option>
							<s:iterator value="@com.tetrapak.util.cip.CIPLineUtil@getCIPMasterLineList()" var="cipMasterLine">
								<option value="<s:property value="id"/>" title="<s:property value="cipMasterLineDesc"/>">
									<s:property value="cipMasterLineName" />
								</option>
							</s:iterator>
					</select> <script type="text/javascript">
						$(document).ready(
								function() {
									$("#cip-trend-tag-master-line").val(
											"<s:property value="#parameters.cipTrendTagMasterLineId"/>");
								});
					</script></li>

					<li><label><s:text name="i18n.cip.trend.tag.name" /></label> <input type="text" name="cipTrendTagName" id="cip-trend-tag-name" value="<s:property value="cipTrendTag.cipTrendTagName"/>" /></li>
					<li><label><s:text name="i18n.cip.trend.tag.desc" /></label> <input type="text" name="cipTrendTagDesc" id="cip-trend-tag-desc" value="<s:property value="cipTrendTag.cipTrendTagDesc"/>" /></li>
					<li><label><s:text name="i18n.cip.trend.tag.unit" /></label> <input type="text" name="cipTrendTagUnit" id="cip-trend-tag-unit" value="<s:property value="cipTrendTag.cipTrendTagUnit"/>" /></li>
					<li><label><s:text name="i18n.cip.trend.tag.value.divided.by"/></label><input type="text" name="cipTrendTagValueDividedBy" id="cip-trend-tag-value-divided-by" value="<s:property value="cipTrendTag.cipTrendTagValueDividedBy"/>"/></label>
					<li><label><s:text name="i18n.cip.trend.tag.type" /></label> <select name="cipTrendTagType" id="cip-trend-tag-type">
							<option value="false">
								<s:text name="i18n.discrete.tag" />
							</option>
							<option value="true">
								<s:text name="i18n.analog.tag" />
							</option>
					</select> <s:if test="cipTrendTag.cipTrendTagAnalog">
							<script type="text/javascript">
								$(document).ready(function() {
									$("#cip-trend-tag-type").val("true");
								});
							</script>
						</s:if></li>
					<li><input type="submit" value="<s:text name="i18n.save"/>" class="btn btn-primary" /></li>
				</ul>
				<s:fielderror cssClass="cip-setting-error"></s:fielderror>
			</fieldset>
		</form>

		<fieldset style="float: left; margin-top: 75px; margin-left: 20px; width: 300px;">
			<select style="height: 355px;" size="20" id="cip-trend-tag-list">
				<s:iterator value="@com.tetrapak.util.cip.CIPTrendTagUtil@getCIPTrendTagsOfMasterLine(#parameters.cipTrendTagMasterLineId)" var="cipTrendTag">
					<option value="<s:property value="id"/>">
						<s:property value="cipTrendTagName" />
					</option>
				</s:iterator>
			</select>
			<script type="text/javascript">
				$(document).ready(function() {
					$("#cip-trend-tag-list").val("<s:property value="#parameters.cipTrendTagId"/>");
				});
			</script>
			<form action="<s:url value="/systemSettings/cip/cipTrendTag/delete.action"/>" method="POST" class="delete-form">
				<input type="hidden" name="cipTrendTagMasterLineId" value="<s:property value="#parameters.cipTrendTagMasterLineId"/>" /> <input type="hidden" name="cipTrendTagId"
					value="<s:property value="#parameters.cipTrendTagId"/>" /> <input type="submit" value="<s:text name="i18n.delete"/>" style="vertical-align: top; margin-top: 0;" class="btn btn-danger">
			</form>
		</fieldset>

		<div class="cf"></div>
	</div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>
<input type="hidden" id="cipTrendTagSettingPage" value="<s:url value="/systemSettings/cip/cipTrendTagSettingPage.action"/>" />
