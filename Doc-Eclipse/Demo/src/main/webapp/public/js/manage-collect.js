/**
 * 后台-管理我的收藏
 */

$(document).ready(function () {
	var pageSize=2;
	
	function getCollectList(pageNumber){		

		var query={
			pageNumber: pageNumber,
			pageSize: pageSize,
		
		};

		$.get("getCollectList",query,function(data,status){
			var collectHtmls = "";	
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
								getCollectList(page);              
							}
						};
					$('#example').bootstrapPaginator(options); 	
				}	
				$('#example > li').addClass("mr-3");
				
				collectHtmls += '<ul class="list-group list-group-flush w-100">';
				$.each(data.records, function(index, item){
					collectHtmls += '<li class="list-group-item bg-c1 m-3">';
					collectHtmls += '<a href="/Demo/food-detail?id='+item.food.id+'" class="c1 text-muted font-weight-bold ">'+item.food.foodName+'</a>';
					collectHtmls += '<img src="' +item.food.fileAttach.filePath + '" alt="'+item.food.foodName+'" class="d-block w-25 mb-4">';
					collectHtmls += '<button type="button" class="btn btn-success float-right">已收藏，点击取消</button>';
					collectHtmls += '</li>';
				});
				collectHtmls += '</ul>';
			}else{
				collectHtmls='<div class="row " style="margin:0 auto; text-align:center;" id="collect-containerr"> <div class="col-sm-6 col-md-4 col-lg-3 "><div class="thumbnail">'
						+'<div class="caption"> <h3>No Records</h3></div></div></div>';
			}
			$("#collect-container").html(collectHtmls);
		}, "json");	
		
	
	}
	
	
	getCollectList(1);


});
