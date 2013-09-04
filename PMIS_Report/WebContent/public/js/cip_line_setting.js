$(document).ready(function() {
	var masterLineId = $("#master-line-id");
	var masterLineName = $("#master-line-name");
	var masterLineDesc = $("#master-line-desc");
	var plcStructureType = $("#plc-structure-type");
	var workshopType = $("#workshop-type");
	var masterLineList = $("#master-line-list");
	var masterLineToDeleteId = $("#master-line-to-delete-id");
	var slaveLinesMasterLineId = $("#slave-line-s-master-line-id");
	var addMasterLineButton = $("#add-master-line-button");
	var editMasterLineButton = $("#edit-master-line-button");
	var masterLineManageForm = $("#master-line-manage-form");
	var addMasterLineUrl = $("#master-line-add-url").val();
	var editMasterLineUrl = $("#master-line-edit-url").val();
	addMasterLineButton.click(function() {
		masterLineId.val("");
		masterLineManageForm.attr("action", addMasterLineUrl);
		masterLineManageForm.submit();
	});
	editMasterLineButton.click(function() {
		masterLineManageForm.attr("action", editMasterLineUrl);
		masterLineManageForm.submit();
	});

	masterLineList.click(function() {
		var selected = masterLineList.find("option:selected");
		var id = $.trim(selected.val());
		if (id != undefined && id != "") {
			window.location = $("#cipLineActionAddress").val() + "?masterLineId=" + id;
		}
	});

	// set the master line data after the page loaded.
	$(function() {
		var selected = masterLineList.find("option:selected");
		var id = $.trim(selected.val());
		var name = $.trim(selected.text());
		var desc = $.trim(selected.attr("title"));
		var plcSType = $.trim(selected.attr("plcStructureType"));
		var wsType = $.trim(selected.attr("workshopType"));
		masterLineId.val(id);
		masterLineName.val(name);
		masterLineDesc.val(desc);
		plcStructureType.val(plcSType);
		workshopType.val(wsType);
		masterLineToDeleteId.val(id);
		slaveLinesMasterLineId.val(id);
	});

	var addSlaveLineButton = $("#add-slave-line-button");
	var editSlaveLineButton = $("#edit-slave-line-button");
	var slaveLineManageForm = $("#slave-line-manage-form");
	var addSlaveLineUrl = $("#slave-line-add-url").val();
	var editSlaveLineUrl = $("#slave-line-edit-url").val();

	var slaveLineId = $("#slave-line-id");
	var slaveLineName = $("#slave-line-name");
	var slaveLineDesc = $("#slave-line-desc");
	var slaveLineToDeleteId = $("#slave-line-to-delete-id");
	var slaveLineList = $("#slave-line-list");
	slaveLineList.click(function() {
		var selected = $(this).find("option:selected");
		var id = $.trim(selected.val());
		var name = $.trim(selected.text());
		var desc = $.trim(selected.attr("title"));

		slaveLineId.val(id);
		slaveLineName.val(name);
		slaveLineDesc.val(desc);
		slaveLineToDeleteId.val(id);

	});

	addSlaveLineButton.click(function() {
		slaveLineId.val("");
		slaveLineManageForm.attr("action", addSlaveLineUrl);
		slaveLineManageForm.submit();
	});
	editSlaveLineButton.click(function() {
		slaveLineManageForm.attr("action", editSlaveLineUrl);
		slaveLineManageForm.submit();
	});
});