<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>


<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	$(document).ready(function () {
		var maxUsernameLength = 20;
		
		$.get("getCurrUser",function(data){
// 			alert(data);
			if(data.length > maxUsernameLength){
// 				alert("data is null");
				$('#btn_login').html('登录');
				$('#btn_register').html('注册');
			    $("#btn_login").click(function () {
			    	
			        window.location = "login";
			        $("#btn_login").addClass("active");
			    	$("#btn_register").removeClass("active");
			    });
			    $("#btn_register").click(function () {
			    
			        window.location = "register";
			    	$("#btn_login").removeClass("active");
			    	$("#btn_register").addClass("active");
			    });
			}
			else{
// 				alert("data is not null");
				$('#btn_login').html(data);
				$('#btn_register').html('注销');
			    $("#btn_login").click(function () {
			    
			        window.location = "back";
			    	$("#btn_login").addClass("active");
			    	$("#btn_register").removeClass("active");
			    });

			    $("#btn_register").click(function () {
			    	$.get("logout",function(e){
			    		
			    		window.location = "index";
			    		$("#btn_login").removeClass("active");
				    	$("#btn_register").addClass("active");
			    	})	      
			    });
			}
	});
});
</script>

<div class="col-sm-4">
	<button class="btn btn-light" type="button" id="btn_login"></button>
	<button class="btn btn-light" type="button" id="btn_register"></button>
</div>