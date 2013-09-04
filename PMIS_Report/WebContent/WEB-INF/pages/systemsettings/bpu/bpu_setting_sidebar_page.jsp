<%@ taglib uri="/struts-tags" prefix="s"%>
<div id="setting-sidebar">
	<ul class="nav nav-list setting-sidenav">
		<li><a href="<s:url value="/systemSettings/bpu/bpuMachineSettingPage.action"/>"><s:text name="i18n.bpu.machine.settings" /></a></li>
		<li><a href="<s:url value="/systemSettings/bpu/bpuAnalogTagSettingPage.action"/>"><s:text name="i18n.bpu.analog.tag.settings" /></a></li>
		<li><a href="<s:url value="/systemSettings/bpu/bpuAlarmTagSettingPage.action"/>"><s:text name="i18n.bpu.alarm.tag.settings" /></a></li>
		<li><a href="<s:url value="/systemSettings/bpu/bpuAlarmMsgSettingPage.action"/>"><s:text name="i18n.bpu.alarm.msg.settings" /></a></li>
	</ul>
</div>