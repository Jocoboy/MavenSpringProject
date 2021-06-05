/**
 * 后台-管理我的预约
 */

$(document).ready(function () {
	var pageSize=2;
	
	function getReserveList(pageNumber){		

		var query={
			pageNumber: pageNumber,
			pageSize: pageSize,
		
		};

		$.get("getReserveList",query,function(data,status){
			var reserveHtmls = "";	
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
								getReserveList(page);              
							}
						};
					$('#example').bootstrapPaginator(options); 	
				}	
				$('#example > li').addClass("mr-3");
				
				reserveHtmls += '<ul class="list-group list-group-flush w-100">';
				$.each(data.records, function(index, item){
					reserveHtmls += '<li class="list-group-item bg-c1 m-3">';
					reserveHtmls += '<a href="/Demo/activity-detail?id='+item.activity.id+'" class="c1 text-muted font-weight-bold ">'+item.activity.title+'</a>';
					reserveHtmls += '<img src="' +item.activity.fileAttach.filePath + '" alt="'+item.activity.title+'" class="d-block w-25 mb-4">';
					reserveHtmls += '<button type="button" class="btn btn-success float-right">已预约，点击取消</button>';
					reserveHtmls += '</li>';
				});
				reserveHtmls += '</ul>';
			}else{
				reserveHtmls='<div class="row " style="margin:0 auto; text-align:center;" id="reserve-container"> <div class="col-sm-6 col-md-4 col-lg-3 "><div class="thumbnail">'
						+'<div class="caption"> <h3>No Records</h3></div></div></div>';
			}
			$("#reserve-container").html(reserveHtmls);
		}, "json");	
		
	
	}
	
	
	getReserveList(1);


});
