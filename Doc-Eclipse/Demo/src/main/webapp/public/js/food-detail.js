/**
 * 美食详情页
 */

$(document).ready(function () {
	
	$("#btn_like").click(function(){
		var id = $("#foodId").text();
//		alert(id)
		$.get("foodLikes?id="+id,function(data){
			if(data == true){
				location.reload();
			}
			else{
				alert("点赞失败");
			}
		});
	});
	
	$("#btn_addCollect").click(function(){
		var id = $("#foodId").text();
//		alert(id)
		$.get("addCollect?id="+id,function(data){
			if(data == true){
				location.reload();
			}
			else{
				alert("收藏失败,请先登录");
			    window.location = "login";
			}
		});
	});
	
	$("#btn_cancelCollect").click(function(){
		var id = $("#foodId").text();
//		alert(id)
		$.get("cancelCollect?id="+id,function(data){
			if(data == true){
				location.reload();
			}
			else{
				alert("取消收藏失败,请先登录");
				window.location = "login";
			}
		});
	});
		
//		$.ajax({
//		    url:"/food-detail/foodLikes",
//		    type:"GET",
//		    contentType: "application/json;charset=UTF-8",
//		    dataType:"json",
//		    success:function (data) {
//		    	if(data == true){
//		    		location.reload();
//		    	}
//		    	else{
//		    		alert("点赞失败");
//		    	}
//		    }
//		});
//	});
	
});