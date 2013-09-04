$(document).ready(function() {
	// add page selector
	$("#bpu-report-result-page-list").change(function() {
		var page = $(this).val();
		$("#bpu-report-result-page").val(page);
		$("#bpu-report-query-form").submit();
	});

});