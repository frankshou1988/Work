$(document).ready(function() {
	var locale = $("#current-locale").val();
	if (locale != "") {
		$.datepicker.setDefaults($.datepicker.regional[locale]);
		$.timepicker.setDefaults($.timepicker.regional[locale]);
	} else {
		$.datepicker.setDefaults($.datepicker.regional["zh_CN"]);
		$.timepicker.setDefaults($.timepicker.regional["zh_CN"]);
	}
	$(".date-time-picker").datetimepicker({
		dateFormat : 'yy-mm-dd',
		timeFormat : 'hh:mm:ss',
		showSecond : true,
		changeYear : true
	});

	$(".time-picker").timepicker({
		timeFormat : 'hh:mm:ss'
	});

	// auto complete the date
	var now = new Date();
	var queryEnd = now.toString("yyyy-MM-dd HH:mm:ss");
	var queryStart = now.addHours(-1).toString("yyyy-MM-dd HH:mm:ss");
	$("input[name=queryStartDate]").val(queryStart);
	$("input[name=queryEndDate]").val(queryEnd);

	$("#query-time-interval").change(function() {
		var selectedVal = $(this).val();
		var now = new Date();
		var queryEnd = now.toString("yyyy-MM-dd HH:mm:ss");
		$("input[name=queryEndDate]").val(queryEnd);
		var queryStart = null;
		if (selectedVal == "I_DEFAULT") {
			queryStart = now.addHours(-1).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_LAST_FOUR_HOUR") {
			queryStart = now.addHours(-4).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_ONE_DAY_BACK") {
			queryStart = now.addDays(-1).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_TWO_DAY_BACK") {
			queryStart = now.addDays(-2).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_ONE_WEEK_BACK") {
			queryStart = now.addDays(-7).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_ONE_MONTH_BACK") {
			queryStart = now.addDays(-30).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_THREE_MONTH_BACK") {
			queryStart = now.addDays(-90).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_HALF_YEAR_BACK") {
			queryStart = now.addDays(-180).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_ONE_YEAR_BACK") {
			queryStart = now.addDays(-360).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_FIVE_DAY_BACK") {
			queryStart = now.addDays(-5).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_TEN_DAY_BACK") {
			queryStart = now.addDays(-10).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_FIFTEEN_DAY_BACK") {
			queryStart = now.addDays(-15).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_TWENTY_DAY_BACK") {
			queryStart = now.addDays(-20).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_TWENTY_FIVE_DAY_BACK") {
			queryStart = now.addDays(-25).toString("yyyy-MM-dd HH:mm:ss");
		} else if (selectedVal == "I_THIRTY_DAY_BACK") {
			queryStart = now.addDays(-30).toString("yyyy-MM-dd HH:mm:ss");
		}
		$("input[name=queryStartDate]").val(queryStart);
	});

	/**
	 * Loading Dialog
	 */
	$("#dialog:ui-dialog").dialog("destroy");
	$("#loading-dialog").dialog({
		autoOpen : false,
		width : 200,
		height : 100,
		modal : true,
		resizable : false
	}).siblings('.ui-dialog-titlebar').remove();

	$(".query-form").submit(function() {
		$("#loading-dialog").dialog("open");
	});
	/**
	 * Report Save Dialog
	 */
	$("#dialog:ui-dialog").dialog("destroy");
	var saveDialog = $("#save-dialog");
	saveDialog.dialog({
		autoOpen : false,
		width : 560,
		height : 350,
		modal : true,
		resizable : false
	});
	$("#save-query-result-button").click(function() {
		saveDialog.dialog("open");
	});

	$("#cancel-save-dialog-button").click(function() {
		saveDialog.dialog("close");
	});

	$("#save-query-result-form").submit(function() {
		var result = true;
		var saveFileName = $.trim($("#save-file-name").val());
		var saveFileType = $.trim($("#save-file-type").val());
		if (saveFileName == "" || saveFileType == "") {
			$("#save-file-error-label").show();
			result = false;
		}
		if (result) {
			saveDialog.dialog("close");
		}
		return result;
	});

	/**
	 * Delete action confirmation
	 */
	$(".delete-form").submit(function() {
		return confirm($("#delete-warning-text").val());
	});

	/**
	 * Make tabs for query form
	 */
	$("#query-condition-result-tab").tabs();
	$("#admin-ui-tab").tabs();
});
