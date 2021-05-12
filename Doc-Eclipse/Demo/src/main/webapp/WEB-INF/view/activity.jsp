<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctx}/public/css/font-awesome.min.css">
    <title>臻品生活家-活动</title>
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
                    <button class="btn btn-light" type="button" id="btn_food">美食</button>
                    <button class="btn btn-light active" type="button" id="btn_activity">活动</button>
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
                <div class="col-sm-4">
                    <button class="btn btn-light" type="button" id="btn_login">登录</button>
                    <button class="btn btn-light" type="button" id="btn_register">注册</button>
                </div>
<%-- 				<jsp:include page="layout/info.jsp"/> --%>
            </div>
        </nav>
        <div class="container">
            <div class="border mt-4">
                <h1 class="">新年家宴-云南菜</h1>
                <p class="text-muted">
                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                    上海
                </p>
                <span class="mr-5"><span class="font-weight-bold">活动时间</span>:2017年1月5日 10:30-13:30</span>
                <span><span class="font-weight-bold">活动地点</span>:上海市徐汇区桃江路8号</span>
                <hr>
                <p>学习制作，佤乡辣子鱼、石屏香煎包浆豆腐，演示，香辣野生牛肝菌，品尝，石林鸡丝凉米线、尼西带皮黑山羊火锅、菌香包烧花米饭、芒果芒果、白米酒、大理酸奶。</p>
                <img src="${ctx}\public\images\activity\yunnan01.jpg" alt="yunnan01" class="d-block w-100 mb-4">
                <img src="${ctx}\public\images\activity\yunnan02.jpg" alt="yunnan02" class="d-block w-100">
                <div class="text-center"> 
                    <button type="button" class="btn btn-outline-secondary m-4">点击预约</button>
                </div>

            </div>
            <div class="border mt-4">
                <h1 class="">新年家宴-法式甜品</h1>
                <p class="text-muted">
                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                    上海
                </p>
                <span class="mr-5"><span class="font-weight-bold">活动时间</span>:2017年1月11日 10:30-13:30</span>
                <span><span class="font-weight-bold">活动地点</span>:上海市徐汇区桃江路8号</span>
                <hr>
                <p>学习制作TARTE TATIN法式苹果塔，巧克力慕斯。</p>
                <img src="${ctx}\public\images\activity\fstp01.jpg" alt="fstp01" class="d-block w-100 mb-4">
                <img src="${ctx}\public\images\activity\fstp02.jpg" alt="fstp02" class="d-block w-100">
                <div class="text-center"> 
                    <button type="button" class="btn btn-success m-4">已预约，点击取消</button>
                </div>

            </div>
            <div class="border mt-4">
                <h1 class="">纳福家宴-烘焙特辑</h1>
                <p class="text-muted">
                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                    北京
                </p>
                <span class="mr-5"><span class="font-weight-bold">活动时间</span>:2017年1月7日 14:00-17:00</span>
                <span><span class="font-weight-bold">活动地点</span>:北京市东城区春秀路</span>
                <hr>
                <p>学习制作，Napoli提拉米苏、手指饼干，品尝，树莓慕斯、草莓竹炭乳酪、坚果塔、香橙玛德琳。</p>
                <img src="${ctx}\public\images\activity\hongbei01.jpg" alt="hongbei01" class="d-block w-100 mb-4">
                <img src="${ctx}\public\images\activity\hongbei02.jpg" alt="hongbei02" class="d-block w-100">
                <div class="text-center"> 
                    <button type="button" class="btn btn-outline-secondary m-4">点击预约</button>
                </div>

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