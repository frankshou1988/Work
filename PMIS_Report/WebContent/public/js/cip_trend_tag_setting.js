$(document).ready(function() {
	var settingUrl = $("#cipTrendTagSettingPage").val();

	$("#cip-trend-tag-master-line").change(function() {
		var selected = $(this).find("option:selected");
		var mid = selected.val();
		window.location = settingUrl + "?cipTrendTagMasterLineId=" + mid;
	});

	$("#cip-trend-tag-list").click(function() {
		var selected = $(this).find("option:selected");
		var tagId = selected.val();
		if (tagId != undefined && tagId != "") {
			var mid = $("#cip-trend-tag-master-line").val();
			window.location = settingUrl + "?cipTrendTagMasterLineId=" + mid + "&cipTrendTagId=" + tagId;
		}
	});
});