/**
 * 美食页面
 */

$(document).ready(function () {
	var pageSize=1;
	
	function getFoodList(pageNumber){		
		var sort = $("input[name='options']:checked").val();
		var foodName=$("#txtFoodName").val();
		var deployUser=$("#txtDeployUser").val();
		var startDate=$("#dateB").val();
		var endDate=$("#dateE").val();
		var query={
			pageNumber: pageNumber,
			pageSize: pageSize,
			sort:sort,
			foodName:foodName,
			deployUser:deployUser,
			startDate:startDate,
			endDate:endDate
		};
//		alert("pageNumber: "+pageNumber+"\n pageSize: "+pageSize+"\n sort: "+sort+"\n foodName: "+foodName+"\n deployUser: "+deployUser+"\n startDate: "+startDate+"\n endDate: "+endDate);
		$.get("getFoodList",query,function(data,status){
			var foodHtmls = "";	
			if (data != null && data.records != null && data.records.length!=0) {
				if(pageNumber==1){
			
					var options = {
							bootstrapMajorVersion: 3, 	//版本
							currentPage: data.currentPage, 	//当前页数
							totalPages: data.pageCount, 		//总页数
							size: "large",
							itemTexts: function(type, page, current) {
								switch(type) {
									case "first":
										return "首页";
									case "prev":
										return "上一页";
									case "next":
										return "下一页";
									case "last":
										return "末页";
									case "page":
										return page;
								}
							} ,
							//点击事件，用于通过Ajax来刷新整个list列表
							onPageClicked: function(event, originalEvent, type, page) {
								getFoodList(page);              
							}
						};
					$('#example').bootstrapPaginator(options); 	
				}	
				$('#example > li').addClass("mr-3");
				
				
				$.each(data.records, function(index, item){
					foodHtmls += '<div class="col-sm-6 col-md-4 col-lg-3  mt-5 "  style="margin:0 auto; text-align:center;">';
					foodHtmls += '<div class="thumbnail">';
					foodHtmls += '<a href="/Demo/food-detail?id='+item.id+'" title="'+item.foodName+'" target="_blank" ><img class="lazy w-75" src="'+item.fileAttach.filePath+'"   alt="'+item.foodName+'"></a>';
					foodHtmls += "<div class='caption'>";
					var d=new Date(item.deployDate);
					foodHtmls += '<div class="caption"> <h3><a href="/Demo//food-detail?id='+item.id+'" title="'+item.foodName+'" target="_blank">'+item.foodName+'<br><small>'+d.toLocaleDateString()+'</small></a></h3>';
					foodHtmls +='<p>'+item.foodMaterial+'</p>  </div>';
					foodHtmls += "</div>";
					foodHtmls += "</div>";
					foodHtmls += "</div>";
				});
			}else{
				foodHtmls='<div class="row " style="margin:0 auto; text-align:center;" id="food-container"> <div class="col-sm-6 col-md-4 col-lg-3 "><div class="thumbnail">'
						+'<div class="caption"> <h3>No Records</h3></div></div></div>';
			}
			$("#food-container").html(foodHtmls);
		}, "json");	
	}
	getFoodList(1);
	$("#query").click(function(){ getFoodList(1); });
	$("input[name='options']").change(function(){ getFoodList(1); });
});
