$(document).ready(function() {
	$("#cip-phase-setting-master-line").change(function() {
		var masterLineId = $(this).val();
		var cipSlaveLineList = $("#cip-phase-setting-slave-line");
		if (masterLineId == 0 || masterLineId == "0") {
			cipSlaveLineList.find("option").remove();
		} else {
			var url = $("#cip-get-slave-line-of-master-line-url").val();
			$.ajax({
				type : "POST",
				url : url,
				data : "masterLineId=" + masterLineId,
				dataType : "json",
				success : function(data) {
					cipSlaveLineList.find("option").remove();
					if (data.slaveLineOfMasterLine == "success") {
						var slaveLines = data.cipSlaveLines;
						$.each(slaveLines, function(data) {
							var slaveLine = slaveLines[data];
							var id = slaveLine.id;
							var name = slaveLine.cipSlaveLineName;
							cipSlaveLineList.append("<option value='" + id + "'>" + name + "</option>");
						});
					}
				}
			});
		}
	});

	$("#cip-phase-setting-target-group").change(function() {
		var targetGroupId = $(this).val();
		var cipTargetList = $("#cip-phase-setting-target");
		if (targetGroupId == 0 || targetGroupId == "0") {
			cipTargetList.find("option").remove();
		} else {
			var url = $("#cip-get-target-of-target-group-url").val();
			$.ajax({
				type : "POST",
				url : url,
				data : "cipTargetGroupId=" + targetGroupId,
				dataType : "json",
				success : function(data) {
					cipTargetList.find("option").remove();
					if (data.CIPTargetOfTargetGroup == "success") {
						var targets = data.cipTargets;
						$.each(targets, function(data) {
							var cipTarget = targets[data];
							var id = cipTarget.id;
							var name = cipTarget.cipTargetName;
							cipTargetList.append("<option value='" + id + "'>" + name + "</option>");
						});
					}
				}
			});
		}
	});

	$("#cip-phase-list").click(function() {
		var url = $("#cip-phase-setting-url").val();
		var selected = $(this).val();
		if (selected != undefined) {
			window.location = url + "?cipPhaseId=" + selected;
		}
	});

	$("#cip-phase-delete-button").click(function() {
		var deleteUrl = $("#cip-phase-delete-url").val();
		var cipPhaseSettingForm = $("#cipPhaseSettingForm");
		cipPhaseSettingForm.attr("action", deleteUrl);
		cipPhaseSettingForm.submit();
	});
});