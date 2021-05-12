/**
 * 登录页面
 */

$(document).ready(function () {
	
	  $("#btn_login_confirm").click(function(){
		  	var data = {};
 		 	data.Username = $("input[name='username']").val();
 		 	data.Password =  $("input[name='password']").val();
 		 
		  	var isUsernameRight = false;
		  	var isPasswordRight = false;
//		  	var Username = $("input[name='username']").val();
//		  	var Password = $("input[name='password']").val();
		  	
		 	 $.get("loginConfirm",function(e){
		 		 
//		 		 alert(e);
//		 		 window.location.href='/Demo/index';
		 		 
//		 		 var error = request.getAttribute("errorMsg");
//		 		 if(error!=null){
//		 			 alert(error);
//		 		 }
//		 		 else{
//		 			 alert("登录成功");
//		 		 }
		 	 });
		  
// 			$.get("checkUsername?Username="+Username,function(data){
//				if(data){
//					showError('用户名不存在');
//					return;
//				}
//				else{
//					isUsernameRight = true;
//					
//					$.get("checkPassword?Password="+Password,function(data){
//						if(!data){
//							showError('用户密码错误');
//							return;
//						}
//						else{
//							isPasswordRight = true;
//						}
//					});
//				}
//			});
// 			
// 		 	if(isUsernameRight&&isPasswordRight){
// 		 		 window.location.href='/Demo/back';
// 		 	}
 		 	

	  });
	
});