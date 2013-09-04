<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="i18n.page.title" /></title>
<link type="text/css" href="<s:url value="/public/css/bootstrap.css"/>" rel="stylesheet" />
<link type="text/css" href="<s:url value="/public/css/jquery.ui.ie.css"/>" rel="stylesheet" />
<link type="text/css" href="<s:url value="/public/css/jquery-ui.custom.css"/>" rel="stylesheet" />
<link type="text/css" href="<s:url value="/public/css/main.css" />" rel="stylesheet"></link>
<script type="text/javascript" src="<s:url value="/public/js/lib/jquery.min.js"/>"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="<s:url value="/public/js/lib/flot/excanvas.min.js"/>"></script><![endif]-->
<script type="text/javascript" src="<s:url value="/public/js/lib/jquery.flot.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/public/js/lib/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/public/js/lib/jquery-ui.custom.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/public/js/lib/jquery.ui.datepicker-zh-CN.js"/>"></script>
<script type="text/javascript" src="<s:url value="/public/js/lib/jquery.ui.datepicker-en-US.js"/>"></script>
<script type="text/javascript" src="<s:url value="/public/js/lib/jquery-ui-timepicker-addon.js"/>"></script>
<script type="text/javascript" src="<s:url value="/public/js/lib/date.js"/>"></script>
<script type="text/javascript" src="<s:url value="/public/js/main.js"/>"></script>
</head>
<s:set var="currentUser" value="#session.CURRENT_USER" />
<s:set var="isOperator" value="@com.tetrapak.util.authz.AuthzUtil@isOperator(#currentUser)" />
<s:set var="isAdmin" value="@com.tetrapak.util.authz.AuthzUtil@isAdmin(#currentUser)" />
<s:set var="isRoot" value="@com.tetrapak.util.authz.AuthzUtil@isRoot(#currentUser)" />
<body>
	<div id="header">
		<ul>
			<li><a href="<s:url value="/"/>"><img src="<s:url value="/public/images/home.png"/>" title="<s:text name="i18n.home" />" /> </a></li>
			<!-- <li><a href="<s:url value="/cip/cipReportQueryPage.action"/>"><img src="<s:url value="/public/images/cip_report.png"/>" title="<s:text name="i18n.cip.report" />" /> </a></li>
			<li><a href="<s:url value="/cip/cipTrendQueryPage.action"/>"><img src="<s:url value="/public/images/cip_trend.png"/>" title="<s:text name="i18n.cip.trend.report" />" /> </a></li>
			<li><a href="<s:url value="/cip/cipPerformAnalysisMasterLineQueryPage.action"/>"><img src="<s:url value="/public/images/cip_analysis.png"/>"
					title="<s:text
						name="i18n.cip.analysis.report.masterline.based" />" /> </a></li>
			<li><a href="<s:url value="/cip/cipPerformAnalysisTargetQueryPage.action"/>"><img src="<s:url value="/public/images/cip_analysis_target.png"/>"
					title="<s:text
						name="i18n.cip.analysis.report.target.based" />" /> </a></li>
			-->
			<li><a href="<s:url value="/bpu/query/bpuTrendQueryPage.action"/>"><img src="<s:url value="/public/images/bpu_trend.png"/>" title="<s:text name="i18n.bpu.trend"/>" /></a></li>
			<li><a href="<s:url value="/bpu/query/bpuAlarmReportQueryPage.action"/>"><img src="<s:url value="/public/images/bpu_alarm.png"/>" title="<s:text name="i18n.bpu.alarm"/>" /></a></li>
			<li><a href="<s:url value="/bpu/query/bpuReportQueryPage.action"/>"><img src="<s:url value="/public/images/bpu_report.png"/>" title="<s:text name="i18n.bpu.report"/>" /></a></li>
			<li><a href="<s:url value="/bpu/query/bpuUtilizationQueryPage.action"/>"><img src="<s:url value="/public/images/bpu_analysis.png"/>" title="<s:text name="i18n.bpu.analysis"/>" /></a></li>
			<s:if test="#isRoot">
				<li><a href="<s:url value="/systemSettings/cip/cipSettingPage.action"/>"><img src="<s:url value="/public/images/cip_settings.png"/>" title="<s:text name="i18n.cip.system.settings" />" />
				</a></li>
				<li><a href="<s:url value="/systemSettings/bpu/bpuSettingPage.action"/>"><img src="<s:url value="/public/images/bpu_settings.png"/>" title="<s:text name="i18n.bpu.system.settings" />" />
				</a></li>
			</s:if>

			<s:if test="#isAdmin">
				<!-- user management page -->
				<li><a href="<s:url value="/admin/userManage/userManagePage.action"/>"><img src="<s:url value="/public/images/user_management.png"/>" title="<s:text name="i18n.user.management" />" /></a></li>
				<li><a href="<s:url value="/admin/bpu/bpuStandardParamSettingPage.action"/>"><img src="<s:url value="/public/images/bpu_std_param_settings.png"/>"
						title="<s:text name="i18n.admin.bpu.standard.param.setting"/>" /></a>
			</s:if>
			<s:if test="#isOperator">
				<li><a href="<s:url value="/settings/user/changePasswordPage.action"/>"><img src="<s:url value="/public/images/change_password.png"/>" title="<s:text name="i18n.change.password" />" /> </a></li>
				<li><a href="<s:url value="/authz/logout.action"/>"><img src="<s:url value="/public/images/logout.png"/>"
						title="<s:text name="i18n.logout" />&nbsp;<s:property value="#currentUser.userName" />"></a></li>
			</s:if>
			<s:else>
				<li><a href="<s:url value="/authz/loginPage.action"/>"><img src="<s:url value="/public/images/login.png"/>" title="<s:text name="i18n.login"/>" /></a></li>
			</s:else>
		</ul>
		<div class="cf"></div>
		<div id="header-bottom">
			<img src="<s:url value="/public/images/tetrapak.png"/>" id="logo-img" />
			<div id="logo-text">
				<s:text name="i18n.pmis" />
			</div>
		</div>
	</div>