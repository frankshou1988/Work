$(document).ready(
		function() {
			var analogTagId = $("#analog-tag-id");
			var bpuMachineList = $("#bpu-machine-list");
			var addAnalogTagButton = $("#add-analog-tag-button");
			var editAnalogTagButton = $("#edit-analog-tag-button");
			var analogTagManageForm = $("#analog-tag-manage-form");
			var addAnalogTagUrl = $("#analog-tag-add-url").val();
			var editAnalogTagUrl = $("#analog-tag-edit-url").val();
			addAnalogTagButton.click(function() {
				analogTagId.val("");
				analogTagManageForm.attr("action", addAnalogTagUrl);
				analogTagManageForm.submit();
			});
			editAnalogTagButton.click(function() {
				analogTagManageForm.attr("action", editAnalogTagUrl);
				analogTagManageForm.submit();
			});

			bpuMachineList.change(function() {
				var selected = bpuMachineList.find("option:selected");
				var id = $.trim(selected.val());
				window.location = $("#analogTagActionAddress").val() + "?bpuMachineId=" + id;
			});

			var analogTagEditButton = $(".analog-tag-edit-button");
			var analogTagDeleteButton = $(".analog-tag-delete-button");
			analogTagDeleteButton.click(function() {
				var deleteFormId = $.trim($(this).attr("deleteFormId"));
				var analogTagDeleteForm = $("#" + deleteFormId);
				analogTagDeleteForm.submit();
			});
			analogTagEditButton.click(function() {
				var bpuMachineId = $.trim(bpuMachineList.find("option:selected").val());
				var analogTagId = $.trim($(this).attr("analogTagId"));
				window.location = $("#analogTagActionAddress").val() + "?bpuMachineId=" + bpuMachineId
						+ "&analogTagId=" + analogTagId;
			});
		});