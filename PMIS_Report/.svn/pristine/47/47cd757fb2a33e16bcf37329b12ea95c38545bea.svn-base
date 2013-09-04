$(document).ready(function() {
	$("#query-result-panel").tabs();

	$("#cip-trend-tag-master-line-list").click(function() {
		getCIPTrendTagListOfMasterLine();
	});

	function getCIPTrendTagListOfMasterLine() {
		var masterLineId = $("#cip-trend-tag-master-line-list").val();
		var cipTrendTagList = $("#cip-trend-tag-list");
		if (masterLineId == 0 || masterLineId == "0") {
			cipTrendTagList.find("option").remove();
		} else {
			var url = $("#cip-get-cip-trend-tag-of-master-line-url").val();
			$.ajax({
				type : "POST",
				url : url,
				data : "masterLineId=" + masterLineId,
				dataType : "json",
				success : function(data) {
					cipTrendTagList.find("option").remove();
					if (data.CIPTrendTagOfMasterLine == "success") {
						var cipTrendTags = data.cipTrendTags;
						$.each(cipTrendTags, function(index) {
							var cipTrendTag = cipTrendTags[index];
							var name = cipTrendTag.cipTrendTagName;
							var desc = cipTrendTag.cipTrendTagDesc;
							cipTrendTagList.append("<option value='" + name + "'>" + desc + "</option>");
						});
					}
				}
			});
		}
	}
});