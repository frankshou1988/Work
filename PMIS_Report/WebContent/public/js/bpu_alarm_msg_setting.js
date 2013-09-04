$(document).ready(
		function() {
			var bpuMachineList = $("#bpu-machine-list");
			var bpuAlarmTagList = $("#bpu-alarm-tag-list");
			var alarmMsgActionAddress = $("#alarmMsgActionAddress");
			// load alarm tags of bpu machine
			bpuMachineList.change(function() {
				var selected = $(this).find("option:selected");
				var bpuMachineId = $.trim(selected.val());
				getBPUAlarmTagListOfBPUMachine(bpuMachineId, null);
			});
			// load when page refreshed
			$(function() {
				var selected = bpuMachineList.find("option:selected");
				var bpuMachineId = $.trim(selected.val());
				getBPUAlarmTagListOfBPUMachine(bpuMachineId, $("#alarmTagSelectedValue").val());
			});

			function getBPUAlarmTagListOfBPUMachine(bpuMachineId, defaultValue) {
				var url = $("#getBPUAlarmTagListOfBPUMachineActionAddress").val();
				$
						.ajax({
							type : "POST",
							url : url,
							data : "bpuMachineId=" + bpuMachineId,
							dataType : "json",
							success : function(data) {
								bpuAlarmTagList.find("option").remove();
								if (data.BPUAlarmTagListOfBPUMachine == "success") {
									bpuAlarmTagList.append("<option value='0'>" + $("#please-select-text").val()
											+ "</option>");
									var bpuAlarmTags = data.bpuAlarmTagList;
									$.each(bpuAlarmTags, function(index) {
										var bpuAlarmTag = bpuAlarmTags[index];
										var id = bpuAlarmTag.id;
										var name = bpuAlarmTag.alarmTagName;
										bpuAlarmTagList.append("<option value='" + id + "'>" + name + "</option>");
									});
								}
								if (defaultValue != null) {
									bpuAlarmTagList.val(defaultValue);
								}
							}
						});
			}

			bpuAlarmTagList.change(function() {
				var bpuMachineId = $.trim(bpuMachineList.find("option:selected").val());
				var alarmTagId = $.trim($(this).find("option:selected").val());
				window.location = alarmMsgActionAddress.val() + "?bpuMachineId=" + bpuMachineId + "&alarmTagId="
						+ alarmTagId;
			});

			// save and edit
			var alarmMsgId = $("#alarm-msg-id");
			var addAlarmMsgButton = $("#add-alarm-msg-button");
			var editAlarmMsgButton = $("#edit-alarm-msg-button");
			var alarmMsgManageForm = $("#alarm-msg-manage-form");
			var addAlarmMsgUrl = $("#alarm-msg-add-url").val();
			var editAlarmMsgUrl = $("#alarm-msg-edit-url").val();
			addAlarmMsgButton.click(function() {
				alarmMsgId.val("");
				alarmMsgManageForm.attr("action", addAlarmMsgUrl);
				alarmMsgManageForm.submit();
			});
			editAlarmMsgButton.click(function() {
				alarmMsgManageForm.attr("action", editAlarmMsgUrl);
				alarmMsgManageForm.submit();
			});
			// delete
			var alarmMsgEditButton = $(".alarm-msg-edit-button");
			var alarmMsgDeleteButton = $(".alarm-msg-delete-button");
			alarmMsgDeleteButton.click(function() {
				var deleteFormId = $.trim($(this).attr("deleteFormId"));
				var alarmMsgDeleteForm = $("#" + deleteFormId);
				alarmMsgDeleteForm.submit();
			});
			alarmMsgEditButton.click(function() {
				var bpuMachineId = $.trim(bpuMachineList.find("option:selected").val());
				var alarmTagId = $.trim(bpuAlarmTagList.find("option:selected").val());
				var alarmMsgId = $.trim($(this).attr("alarmMsgId"));
				window.location = $("#alarmMsgActionAddress").val() + "?bpuMachineId=" + bpuMachineId + "&alarmTagId="
						+ alarmTagId + "&alarmMsgId=" + alarmMsgId;
			});
		});