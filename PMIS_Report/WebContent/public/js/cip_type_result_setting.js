$(document).ready(function() {
	$("#cip-type-list").click(function() {
		var selected = $(this).find("option:selected");
		if (selected != undefined) {
			var cipTypePlcId = selected.val();
			var cipTypeDesc = $.trim(selected.attr("desc"));
			var cipTypeId = $.trim(selected.attr("id"));
			var plcStructureType = $.trim(selected.attr("plcStructureType"));
			$("#cip-type-plc-id").val(cipTypePlcId);
			$("#cip-type-desc").val(cipTypeDesc);
			$("#cip-type-plc-structure-type").val(plcStructureType);
			$("#cip-type-to-delete-id").val(cipTypeId);
		}
	});

	$("#cip-result-list").click(function() {
		var selected = $(this).find("option:selected");
		if (selected != undefined) {
			var cipResultPlcId = selected.val();
			var cipResultDesc = $.trim(selected.attr("desc"));
			var cipResultId = $.trim(selected.attr("id"));
			var plcStructureType = $.trim(selected.attr("plcStructureType"));
			$("#cip-result-plc-id").val(cipResultPlcId);
			$("#cip-result-desc").val(cipResultDesc);
			$("#cip-result-plc-structure-type").val(plcStructureType);
			$("#cip-result-to-delete-id").val(cipResultId);
		}
	});
});