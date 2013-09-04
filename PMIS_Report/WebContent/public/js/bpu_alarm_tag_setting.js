$(document).ready(
		function() {
			var alarmTagId = $("#alarm-tag-id");
			var bpuMachineList = $("#bpu-machine-list");
			var addAlarmTagButton = $("#add-alarm-tag-button");
			var editAlarmTagButton = $("#edit-alarm-tag-button");
			var alarmTagManageForm = $("#alarm-tag-manage-form");
			var addAlarmTagUrl = $("#alarm-tag-add-url").val();
			var editAlarmTagUrl = $("#alarm-tag-edit-url").val();
			addAlarmTagButton.click(function() {
				alarmTagId.val("");
				alarmTagManageForm.attr("action", addAlarmTagUrl);
				alarmTagManageForm.submit();
			});
			editAlarmTagButton.click(function() {
				alarmTagManageForm.attr("action", editAlarmTagUrl);
				alarmTagManageForm.submit();
			});

			bpuMachineList.change(function() {
				var selected = bpuMachineList.find("option:selected");
				var id = $.trim(selected.val());
				window.location = $("#alarmTagActionAddress").val() + "?bpuMachineId=" + id;
			});

			var alarmTagEditButton = $(".alarm-tag-edit-button");
			var alarmTagDeleteButton = $(".alarm-tag-delete-button");
			alarmTagDeleteButton.click(function() {
				var deleteFormId = $.trim($(this).attr("deleteFormId"));
				var alarmTagDeleteForm = $("#" + deleteFormId);
				alarmTagDeleteForm.submit();
			});
			alarmTagEditButton.click(function() {
				var bpuMachineId = $.trim(bpuMachineList.find("option:selected").val());
				var alarmTagId = $.trim($(this).attr("alarmTagId"));
				window.location = $("#alarmTagActionAddress").val() + "?bpuMachineId=" + bpuMachineId + "&alarmTagId="
						+ alarmTagId;
			});
		});