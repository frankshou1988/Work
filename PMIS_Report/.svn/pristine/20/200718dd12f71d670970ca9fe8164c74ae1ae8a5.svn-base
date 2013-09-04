$(document).ready(
		function() {
			var addTargetGroupButton = $("#add-target-group-button");
			var editTargetGroupButton = $("#edit-target-group-button");
			var targetGroupManageForm = $("#target-group-manage-form");
			var addTargetGroupUrl = $("#target-group-add-url").val();
			var editTargetGroupUrl = $("#target-group-edit-url").val();
			var targetGroupId = $("#cip-target-group-id");
			addTargetGroupButton.click(function() {
				targetGroupId.val("");
				targetGroupManageForm.attr("action", addTargetGroupUrl);
				targetGroupManageForm.submit();
			});
			editTargetGroupButton.click(function() {
				targetGroupManageForm.attr("action", editTargetGroupUrl);
				targetGroupManageForm.submit();
			});

			var cipTargetGroupList = $("#cip-target-group-list");
			cipTargetGroupList.click(function() {
				var selected = cipTargetGroupList.find("option:selected");
				var id = $.trim(selected.val());
				if (id != undefined && id != "") {
					window.location = $("#cipTargetActionAddress").val()
							+ "?cipTargetGroupId=" + id;
				}
			});

			$(function() {
				var selected = cipTargetGroupList.find("option:selected");
				var id = $.trim(selected.val());
				var name = $.trim(selected.text());
				var desc = $.trim(selected.attr("title"));
				var wst=$.trim(selected.attr("workshopType"));
				$("#cip-target-group-id").val(id);
				$("#cip-target-group-name").val(name);
				$("#cip-target-group-desc").val(desc);
				$("#target-group-to-delete-id").val(id);
				$("#cip-target-s-group-id").val(id);
				$("#workshop-type").val(wst);
			});

			var addTargetButton = $("#add-target-button");
			var editTargetButton = $("#edit-target-button");
			var targetManageForm = $("#target-manage-form");
			var addTargetUrl = $("#target-add-url").val();
			var editTargetUrl = $("#target-edit-url").val();
			var targetId = $("#cip-target-id");
			addTargetButton.click(function() {
				targetId.val("");
				targetManageForm.attr("action", addTargetUrl);
				targetManageForm.submit();
			});
			editTargetButton.click(function() {
				targetManageForm.attr("action", editTargetUrl);
				targetManageForm.submit();
			});

			var cipTargetList = $("#cip-target-list");
			cipTargetList.click(function() {
				var selected = $(this).find("option:selected");
				var id = $.trim(selected.val());
				var name = $.trim(selected.text());
				var desc = $.trim(selected.attr("title"));
				var targetType = selected.attr("targettype");

				$("#cip-target-id").val(id);
				$("#cip-target-name").val(name);
				$("#cip-target-desc").val(desc);
				$("#target-to-delete-id").val(id);
				$("#cip-target-type").val(targetType);
			});
		});