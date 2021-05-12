<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${ctx}/public/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/public/css/base.css">

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/js/bootstrap.min.js"></script>
<script src="${ctx}/public/js/index.js"></script>
<script src="${ctx}/public/js/login.js"></script>

<script>
	$(document).ready(function () {
		$.get("getCurrUser",function(data){
			if(data == null){
				$('#btn_login').html('登录');
				$('#btn_register').html('注册');
			    $("#btn_login").click(function () {
			        window.location = "login";
			    });
			    $("#btn_register").click(function () {
			        window.location = "register";
			    });
			}
			else{
				$('#btn_login').html(data.Username);
				$('#btn_register').html('注销');
			    $("#btn_login").click(function () {
			        window.location = "back";
			    });

			    $("#btn_register").click(function () {
			        window.location = "index";
			    });
			}
	});

</script>

<div class="col-sm-4">
	<button class="btn btn-light active" type="button" id="btn_login"></button>
	<button class="btn btn-light" type="button" id="btn_register"></button>
</div>