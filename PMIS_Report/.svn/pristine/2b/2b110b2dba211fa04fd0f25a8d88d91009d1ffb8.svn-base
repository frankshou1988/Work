$(document).ready(
		function() {
			var bpuMachineList = $("#bpu-machine-list");

			bpuMachineList.change(function() {
				var selected = $(this).find("option:selected");
				var bpuMachineId = $.trim(selected.val());
				window.location = $("#adminBPUStandardParamSettingAddress").val() + "?bpuMachineId=" + bpuMachineId;
			});

			var analogTagList = $("#analog-tag-list");
			analogTagList.change(function() {
				var selected = $(this).find("option:selected");
				var analogTagId = $.trim(selected.val());

				var bpuMachineSelected = bpuMachineList.find("option:selected");
				var bpuMachineId = $.trim(bpuMachineSelected.val());

				window.location = $("#adminBPUStandardParamSettingAddress").val() + "?bpuMachineId=" + bpuMachineId
						+ "&analogTagId=" + analogTagId;
			});
		});