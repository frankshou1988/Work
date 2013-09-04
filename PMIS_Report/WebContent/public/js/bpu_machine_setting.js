$(document).ready(function() {
	var bpuMachineId = $("#bpu-machine-id");
	var bpuMachineName = $("#bpu-machine-name");
	var bpuMachineDesc = $("#bpu-machine-desc");
	var bpuMachineType = $("#bpu-machine-type");
	var bpuMachineSerialNumber = $("#bpu-machine-serial-number");
	var bpuMachineList = $("#bpu-machine-list");
	var bpuMachineToDeleteId = $("#bpu-machine-to-delete-id");
	var addProdEquipGroupButton = $("#add-bpu-machine-button");
	var editProdEquipGroupButton = $("#edit-bpu-machine-button");
	var bpuMachineManageForm = $("#bpu-machine-manage-form");
	var addProdEquipGroupUrl = $("#bpu-machine-add-url").val();
	var editProdEquipGroupUrl = $("#bpu-machine-edit-url").val();
	addProdEquipGroupButton.click(function() {
		bpuMachineId.val("");
		bpuMachineManageForm.attr("action", addProdEquipGroupUrl);
		bpuMachineManageForm.submit();
	});
	editProdEquipGroupButton.click(function() {
		bpuMachineManageForm.attr("action", editProdEquipGroupUrl);
		bpuMachineManageForm.submit();
	});

	bpuMachineList.click(function() {
		var selected = bpuMachineList.find("option:selected");
		var id = $.trim(selected.val());
		if (id != undefined && id != "") {
			window.location = $("#bpuMachineActionAddress").val() + "?bpuMachineId=" + id;
		}
	});

	$(function() {
		var selected = bpuMachineList.find("option:selected");
		var id = $.trim(selected.val());
		var name = $.trim(selected.text());
		var desc = $.trim(selected.attr("title"));
		var serialNumber = $.trim(selected.attr("serialNumber"));
		var machineType = $.trim(selected.attr("machineType"));

		bpuMachineId.val(id);
		bpuMachineName.val(name);
		bpuMachineDesc.val(desc);
		bpuMachineSerialNumber.val(serialNumber);
		bpuMachineType.val(machineType);
		bpuMachineToDeleteId.val(id);
	});
});