/**
 * 注册页面
 */

$(document).ready(function () {
	/*用户名（邮箱）校验
	[a-zA-Z0-9_-]+ 邮件名称由若干个字母、数字、下划线和中划线组成
	[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+ 域名部分
	*/
	var pattern_username = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
	/*密码强度校验
	(?=.*[a-z_]) ：匹配至少一个a-z和下划线中的字符
	(?=.*\d)：匹配至少一个数字
	[\S]：匹配任意字符
	{8,}: 长度大于8
	/i: 无视大小写
	*/
	var pattern_password = /(?=.*[a-z_])(?=.*\d)[\S]{8,}/i;

	var isUsernameRight = false;
	var isPasswordFormatRight = false;
	var isPasswordConfirmRight = false;
	
	function showError(msg){
		$('#errorInfo').html(msg);
		$('#errorInfo').fadeIn();
		$('#errorInfo').fadeOut(3000);
		alert(msg);
	}
	
	function changeUsername(){
		var Username = $("input[name='username']").val();
		if(!pattern_username.test(Username)){
			$("input[name='username']").removeClass("is-valid");
			$("input[name='username']").addClass("is-invalid");
			isUsernameRight = false;
		}
		else{
			$("input[name='username']").removeClass("is-invalid");
			$("input[name='username']").addClass("is-valid");
			//ajax判断是否用户名已存在
			$.get("checkUsername?Username="+Username,function(data){
					if(!data){
						showError('该用户名已被注册!');
	    				isUsernameRight = false;
						return;
					}
				});
				isUsernameRight = true;
			}

		
		}
	function changePassword(){
		if(!pattern_password.test( $("input[name='password']").val()  ) ){
			$("input[name='password']").removeClass("is-valid");
			$("input[name='password']").addClass("is-invalid");
			isPasswordFormatRight = false;
		}
		else{
			$("input[name='password']").removeClass("is-invalid");
			$("input[name='password']").addClass("is-valid");
			isPasswordFormatRight = true;
		}
	}
	
	function changeConfirmPassword(){
		var password = $("#register_form input[name='password']").val();
   	 	var confirm_password = $("#register_form input[name='password_confirm']").val();
   	 	if(password!=confirm_password){
   			$("#register_form input[name='password_confirm']").removeClass("is-valid");
   			$("#register_form input[name='password_confirm']").addClass("is-invalid");
   			isPasswordConfirmRight = false;
   	 	}
   	 	else{
   	 		$("#register_form input[name='password_confirm']").removeClass("is-invalid");
			$("#register_form input[name='password_confirm']").addClass("is-valid");
			isPasswordConfirmRight = true;
   	 	}
	}
	
	
	changeUsername();
	changePassword();
	//changeConfirmPassword();
	
     $("input[name='username']").change(function(){
    	 changeUsername();
     });
     $("input[name='password']").change(function(){
    	 changePassword();
     });
     
     $("#register_form input[name='password_confirm']").change(function(){
    	 changeConfirmPassword();
     });
     
//     $("#btn_login_confirm").click(function(){
//    	 changePassword();
//     });
     
     $("#btn_register_confirm").click(function(){
    	// changeConfirmPassword();
    	 if(isUsernameRight&&isPasswordFormatRight&&isPasswordConfirmRight){
//    		 var data = {
//    				 Username : $("input[name='username']").val(),
//    		 		 Password: $("input[name='password']").val()
//    		 }
    		 var data = {};
    		 data.Username = $("input[name='username']").val();
    		 data.Password =  $("input[name='password']").val();
    		 //submit
    		 $.post("regUser",data,function(e){
//        		 var json = $.parseJSON(data);
    			 alert(e);
    			 window.location.href='/Demo/login';
     		 })
    		 
//    		 $.ajax({
//    			    url:"register",
//    			    type:"post",
//    			    data:JSON.stringify({
//    			        Username:$("input[name='username']").val(),
//    			        password:$("input[name='password']").val()
//    			    }),
//    			    contentType: "application/json;charset=UTF-8",
//    			    dataType:"json",
//    			    success:function (e) {
//    			    	alert(e);
//    			    }
//    			});
    		 
    	 }else{
    		 showError('请正确填写注册信息!');
    	 }
     });
     
});
    