$(document).ready(function() {
	$("#cip-master-line-list").change(function() {
		var masterLineId = $(this).val();
		var cipSlaveLineList = $("#cip-slave-line-list");
		var all = $("#all-text").val();
		if (masterLineId == 0 || masterLineId == "0") {
			cipSlaveLineList.find("option").remove();
			cipSlaveLineList.append("<option value='0'>" + all + "</option>");
		} else {
			var url = $("#cip-get-slave-line-of-master-line-url").val();
			$.ajax({
				type : "POST",
				url : url,
				data : "masterLineId=" + masterLineId,
				dataType : "json",
				success : function(data) {
					cipSlaveLineList.find("option").remove();
					cipSlaveLineList.append("<option value='0'>" + all + "</option>");
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

	// add page selector
	$("#cip-report-result-page-list").change(function() {
		var page = $(this).val();
		$("#cip-report-result-page").val(page);
		$("#cip-report-form").submit();
	});

});