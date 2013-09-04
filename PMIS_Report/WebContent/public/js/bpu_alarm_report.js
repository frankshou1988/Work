$(document).ready(function() {
	// add page selector
	$("#bpu-alarm-report-result-page-list").change(function() {
		var page = $(this).val();
		$("#bpu-alarm-report-result-page").val(page);
		$("#bpu-alarm-report-form").submit();
	});

});