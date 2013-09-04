<jsp:include page="../header.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div id="main-container">
	<form action="<s:url value="/settings/user/changePassword.action"/>" method="POST" autocomplete="off" class="form-horizontal action-form">
		<fieldset>
			<p class="form-title">
				<s:text name="i18n.change.password" />
			</p>
			<div class="form-body">
				<div class="control-group">
					<div class="control-label">
						<label><s:text name="i18n.old.password" /></label>
					</div>
					<div class="controls">
						<input type="password" name="oldUserPass" />
						<s:fielderror fieldName="oldUserPass" cssClass="text-error" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">
						<label><s:text name="i18n.new.password" /></label>
					</div>
					<div class="controls">
						<input type="password" name="newUserPass" />
						<s:fielderror fieldName="newUserPass" cssClass="text-error" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">
						<label><s:text name="i18n.new.password.confirm" /></label>
					</div>
					<div class="controls">
						<input type="password" name="newUserConfirmPass" />
						<s:fielderror fieldName="newUserConfirmPass" cssClass="text-error" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">
						<label>&nbsp;</label>
					</div>
					<div class="controls">
						<input type="submit" value="<s:text name="i18n.save"/>" class="btn btn-primary" />
						<s:actionerror />
						<s:actionmessage />
					</div>
				</div>
			</div>
		</fieldset>
	</form>
</div>

<jsp:include page="../footer.jsp"></jsp:include>