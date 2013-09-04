<jsp:include page="../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div id="main-container">
	<form action="<s:url value="/authz/login.action"/>" method="POST" id="login-form" autocomplete="off" class="form-horizontal action-form">
		<fieldset>
			<p class="form-title">
				<s:text name="i18n.user.login.title" />
			</p>
			<div class="form-body">
				<div class="control-group">
					<div class="control-label">
						<label><s:text name="i18n.user.name" /></label>
					</div>
					<div class="controls">
						<input type="text" name="userName" value="" />
						<s:fielderror fieldName="userName" cssClass="text-error" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">
						<label><s:text name="i18n.user.pass" /></label>
					</div>
					<div class="controls">
						<input type="password" name="userPass" value="" />
						<s:fielderror fieldName="userPass" cssClass="text-error" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">
						<label>&nbsp;</label>
					</div>
					<div class="controls">
						<input type="submit" value="<s:text name="i18n.login"/>" class="btn btn-primary" />
						<s:actionerror cssClass="text-error"/>
					</div>
				</div>
			</div>
		</fieldset>
	</form>
</div>
<jsp:include page="../footer.jsp"></jsp:include>