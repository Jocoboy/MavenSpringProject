/**
 * 后台美食发布
 */

$(document).ready(function () {
	
	$("#btn_stepConfirm").click(function(){
		var stepNum = $("input[name='food_stepnum']").val();
		$(".stepDiv").remove();
		$(".submitDiv").remove();
		for(var i = 1 ; i <= stepNum ; i++){
			var stepDiv = '';
			stepDiv += '<div class="input-group mb-3 stepDiv">';
			stepDiv += '<label for="food_step'+i+'" class="font-weight-bold m-1 mr-4 text-right">&nbsp;&nbsp;&nbsp;&nbsp;步骤'+i+'</label>';
			stepDiv += '<input type="text" name="step_desc" class="form-control" id="food_step'+i+'" placeholder="步骤'+i+'具体操作" aria-label="Recipient\'s username" aria-describedby="basic-addon2" required>';
			stepDiv += '<div class="input-group mb-3 mt-3">';
			stepDiv += '<label for="food_pic'+i+'" class="font-weight-bold m-1 mr-4 text-right">上传照片</label>';
			stepDiv += '<input type="file" name="pic" id="food-pic'+i+'" class="food-pic" accept="image/*"  required/>';
			stepDiv += '<div id="image-holder'+i+'" class="image-holder"> </div>';
			stepDiv += '</div></div>';
			$("#food-publish-box").append(stepDiv);
		}
		var submitDiv = '<div class="input-group mb-3 submitDiv"> <button type="submit" class="btn btn-light mx-auto">提交</button></div>';
		$("#food-publish-box").append(submitDiv);
		
		
		
		
		for(var j = 0 ; j <= stepNum ; j++){
	    	let index = j;
	    	let inputDiv = "#food-pic"+index;
	    	let imageHolderDiv = "#image-holder"+index;
	    	
	    	 $(inputDiv).on('change', function () {
	    		  
	    	        //获取上传文件的数量
	    	        var countFiles = $(this)[0].files.length;
	    	         
	    	        var imgPath = $(this)[0].value;
	    	        var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
	    	        var image_holder = $(imageHolderDiv);
	    	        image_holder.empty();
	    	         
	    	        if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
	    	         if (typeof (FileReader) != "undefined") {
	    	         
	    	          // 循环所有要上传的图片
	    	          for (var i = 0; i < countFiles; i++) {
	    	         
	    	           var reader = new FileReader();
	    	           reader.onload = function (e) {
	    	            $("<img />", {
	    	             "src": e.target.result,
	    	              "class": "thumb-image"
	    	            }).appendTo(image_holder);
	    	           }
	    	         
	    	           image_holder.show();
	    	           reader.readAsDataURL($(this)[0].files[i]);
	    	          }
	    	         
	    	         } else {
	    	          alert("你的浏览器不支持FileReader！");
	    	         }
	    	        } else {
	    	         alert("请选择图像文件。");
	    	        }
	    	       });
	    	    
	    	}
	});

	
})
