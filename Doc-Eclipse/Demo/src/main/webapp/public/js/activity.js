/**
 * 活动页面
 */

$(document).ready(function () {
	var pageSize=1;
	
	function getActivityList(pageNumber){		

		var query={
			pageNumber: pageNumber,
			pageSize: pageSize,
			endDate : "2099-12-31"
		};

		$.get("getActivityList",query,function(data,status){
			var activityHtmls = "";	
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
								getActivityList(page);              
							}
						};
					$('#example').bootstrapPaginator(options); 	
				}	
				$('#example > li').addClass("mr-3");
				
				
				$.each(data.records, function(index, item){
					activityHtmls += '<div class="border mt-4 mx-auto"  style="margin:0 auto; text-align:center;">';
					activityHtmls += ' <h1 class="">'+item.title+'</h1>';
					activityHtmls += '<p class="text-muted"><i class="fa fa-map-marker" aria-hidden="true"></i>'+ item.location+'</p>';
					activityHtmls += '<span class="mr-5"><span class="font-weight-bold">活动时间</span>:'+item.startDate+' —— '+ item.endDate +'</span>';
					activityHtmls += '<span><span class="font-weight-bold">活动地点</span>:'+ item.detailLocation+'</span>';
					activityHtmls += ' <hr>';
					activityHtmls += ' <p>'+ item.description+'</p>';
					for(let i = 0 ; i < item.multiFileAttachList.length ; i++){
						activityHtmls += '<img src="'+item.multiFileAttachList[i].fileAttach.filePath+'" alt="'+item.title+'" class="d-block w-50 mb-4  mx-auto">';
					}
					activityHtmls += '<a class="btn btn-primary"  href="/Demo/activity-detail?id='+item.id+'" title="'+item.title+'" target="_self">查看详情</a>';
					activityHtmls += ' <div class="text-center">';
					activityHtmls += '</div></div>'
				});
			}else{
				activityHtmls='<div class="row " style="margin:0 auto; text-align:center;" id="activity-container"> <div class="col-sm-6 col-md-4 col-lg-3 "><div class="thumbnail">'
						+'<div class="caption"> <h3>No Records</h3></div></div></div>';
			}
			$("#activity-container").html(activityHtmls);
		}, "json");	
		
	
	}
	
	
	getActivityList(1);


});
