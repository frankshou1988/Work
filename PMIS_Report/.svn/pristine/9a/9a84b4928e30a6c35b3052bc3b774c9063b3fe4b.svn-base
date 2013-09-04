$(document).ready(function(){
	var cipTargetGroupList=$("#cip-target-group-list");
	var cipTargetList=$("#cip-target-list");
	var cipGetTargetOfGroupUrl=$("#cip-get-target-of-target-group-url");
	
	cipTargetGroupList.change(function() {
		var targetGroupId = $(this).val();
		if (targetGroupId == 0 || targetGroupId == "0") {
			cipTargetList.find("option").remove();
		} else {
			var url = cipGetTargetOfGroupUrl.val();
			$.ajax({
				type : "POST",
				url : url,
				data : "cipTargetGroupId=" + targetGroupId,
				dataType : "json",
				success : function(data) {
					cipTargetList.find("option").remove();
					if (data.CIPTargetOfTargetGroup == "success") {
						var targets = data.cipTargets;
						$.each(targets, function(data) {
							var cipTarget = targets[data];
							var id=cipTarget.id;
							var name = cipTarget.cipTargetName;
							var desc = cipTarget.cipTargetDesc;
							cipTargetList.append("<option value='" + id + "'>" + name+"&nbsp;"+desc + "</option>");
						});
					}
				}
			});
		}
	});
});