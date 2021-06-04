/**
 * 活动详情页面
 */

$(document).ready(function () {
	
	
	$("#btn_addReserve").click(function(){
		var id = $("#activityId").text();
//		alert(id)
		$.get("addReserve?id="+id,function(data){
			if(data == true){
				location.reload();
			}
			else{
				alert("预约失败,请先登录");
			    window.location = "login";
			}
		});
	});
	
	$("#btn_cancelReserve").click(function(){
		var id = $("#activityId").text();
//		alert(id)
		$.get("cancelReserve?id="+id,function(data){
			if(data == true){
				location.reload();
			}
			else{
				alert("取消预约失败,请先登录");
				window.location = "login";
			}
		});
	});
	
	
});