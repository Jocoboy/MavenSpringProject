<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctx}/public/css/font-awesome.min.css">
    <title>臻品生活家-美食详情</title>
</head>

<body>
    <div class="wrapper">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <a class="navbar-brand" href="">臻品生活家</a>
                <div class="col-sm-8">
                    <button class="btn btn-light" type="button" id="btn_home">首页</button>
                    <button class="btn btn-light active" type="button" id="btn_food">美食</button>
                    <button class="btn btn-light" type="button" id="btn_activity">活动</button>
                    <button class="btn btn-light" type="button" data-toggle="modal"
                        data-target="#staticBackdrop">关于</button>

                    <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false"
                        tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">关于臻品生活家</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <h5 class="font-weight-bold">我们的口号:</h5>
                                    <p>人世间，唯有爱与美食不可辜负！</p>
                                    <hr>
                                    <h5 class="font-weight-bold">我们的理念:</h5>
                                    <p>爱已经辜负的太多了，美食就不能再辜负了~</p>
                                    <p><a href="#" class="tooltip-test text-muted" title="更多详情">点击这里了解更多</a> </p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary" data-dismiss="modal">我知道了</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
<!--                 <div class="col-sm-4"> -->
<!--                     <button class="btn btn-light" type="button" id="btn_login">登录</button> -->
<!--                     <button class="btn btn-light" type="button" id="btn_register">注册</button> -->
<!--                 </div> -->
					<jsp:include page="layout/info.jsp"/>
            </div>
        </nav>
        <div class="container">
            <h1><c:out value="${food.foodName}" default="null"></c:out></h1>
            <button class="btn"> 
            	<c:if test="${collectFlag==null || collectFlag==false}">
            	 	<i class="fa fa-heart-o" aria-hidden="true"></i>
            	</c:if>
           		<c:if test="${collectFlag!=null && collectFlag==true}">
            	 	<i class="fa fa-heart" aria-hidden="true"></i>
            	</c:if>
                	收藏
            </button>
            <button class="btn"> <i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
               <c:out value="${food.likes}" default="null"></c:out>人
            </button>
            <hr>
            <div class="">
                <p><fmt:formatDate value="${food.deployDate}" pattern="yyyy-MM-dd"/></p>
                <img src="${food.fileAttach.filePath}" alt="${food.foodName}" class="d-block w-50">
                <p>
                    素材：<br>
                    <c:out value="${food.foodMaterial}" default="null"></c:out><br><br>
                    步骤：<br>
                    <c:forEach var="foodStep" items="${food.foodStepList}" varStatus="varStep" >
                    	<c:out value="${foodStep.stepDesc}" default="null"></c:out>
                   		<img src="${foodStep.fileAttach.filePath}" alt="${foodStep.stepNo}" class="d-block">
                	</c:forEach>
                </p>
            </div>
            
        </div>
        <footer class="navbar-fixed-bottom ">
            <div class="container mt-5">
                <div class="justify-content-left">
                    <p class="text-dark">
                        <i class="fa fa-copyright" aria-hidden="true"></i>
                        2018 臻品生活家
                        <a class="float-right mb-5" href="#">回到顶部</a>
                    </p>
                </div>
            </div>
        </footer>
    </div>
</body>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/js/bootstrap.min.js"></script>
<script src="${ctx}/public/js/index.js"></script>

</html>