$(document).ready(function() {
	$("#query-result-panel").tabs();

	var bpuMachineList = $("#bpu-machine-list");
	var analogTagList = $("#analog-tag-list");
	var analogTagSelectAllButton = $("#analog-tag-select-all-button");
	var selectAll = false;

	bpuMachineList.change(function() {
		var bpuMachineId = bpuMachineList.val();
		getBPUAnalogListOfBPUMachine(bpuMachineId, null);
	});

	function getBPUAnalogListOfBPUMachine(bpuMachineId, defaultValue) {
		var url = $("#getBPUAnalogListOfBPUMachineAddress").val();
		$.ajax({
			type : "POST",
			url : url,
			data : "bpuMachineId=" + bpuMachineId,
			dataType : "json",
			success : function(data) {
				analogTagList.find("option").remove();
				if (data.BPUAnalogListOfBPUMachine == "success") {
					var bpuAnalogTags = data.bpuAnalogTagList;
					$.each(bpuAnalogTags, function(index) {
						var bpuAnalogTag = bpuAnalogTags[index];
						var id = bpuAnalogTag.id;
						var name = bpuAnalogTag.analogTagName;
						var desc = bpuAnalogTag.analogTagDesc;
						analogTagList.append("<option value='" + id + "' title='" + name + "'>" + desc + "</option>");
					});
				}
				if (defaultValue != null) {
					analogTagList.val(defaultValue);
				}
			}
		});
	}
	analogTagSelectAllButton.click(function() {
		if (!selectAll) {
			// select all
			analogTagList.find("option").each(function() {
				$(this).attr("selected", true);
			});
			selectAll = true;
		} else {
			// deselect all
			analogTagList.find("option").each(function() {
				$(this).attr("selected", false);
			});
			selectAll = false;
		}
	});
});