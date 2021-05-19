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
    <link rel="stylesheet" href="${ctx}/public/css/base.css">
    <title>臻品生活家-用户登录</title>
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
<!--                     <button class="btn btn-light" type="button" id="btn_out">退出</button> -->
<!--                 </div> -->
						<jsp:include page="layout/info.jsp"/>
            </div>
        </nav>
        <div class="list-back">
            <div class="list-group mt-5 mr-5 ml-2 " style="width: 10%;float: left;">
                <a href="#" id="my-fav" class="list-group-item  text-light bg-c2 no-border list-left" aria-current="true">
                    收藏的美食
                </a>
                <a href="#" id="my-reserve" class="list-group-item  c1 no-border bg-c3 list-left" >预约的活动</a>
                <a href="#" id="my-settings" class="list-group-item  c1 no-border bg-c3 list-left">设置</a>
                <a href="#" id="my-publish-food" class="list-group-item  c1 no-border bg-c3 list-left">美食发布</a>
                <a href="#" id="my-publish-activity" class="list-group-item c1 no-border bg-c3 list-left">活动发布</a>
                
              </div>
              <div class="headline" style="float: left;width: 80%;">
                  <h2 class="text-left text-muted mt-3" style="font-family: '宋体';font-size: 2em;">管理我的臻品生活</h2>
                  <hr>
                  <div class="my-fav-box ">
                      <div class="fav-box-title" style="font-family: '宋体';">
                        <h3 class="text-light p-2" style="font-size: 1em;">我收藏的美食</h3>
                      </div>
                      <ul class="list-group list-group-flush">
                        <li class="list-group-item bg-c1 m-3"><a href="#" class="c1">南瓜葡萄发糕</a></li>
                        <li class="list-group-item bg-c1 m-3"><a href="#" class="c1">雪梨银耳炖木瓜</a></li>
                        <li class="list-group-item bg-c1 m-3"><a href="#" class="c1">南瓜酒酿小圆子</a></li>
                      </ul>
                  </div>

                  <div class="my-reserve-box no-show">
                    <div class="fav-box-title" style="font-family: '宋体';">
                      <h3 class="text-light p-2" style="font-size: 1em;">我预约的活动</h3>
                    </div>
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item bg-c1 m-3">
                          <a href="#" class="c1">新年家宴-云南菜</a>
                          <button type="button" class="btn btn-danger float-right">取消</button>
                        </li>
                      <li class="list-group-item bg-c1 m-3">
                          <a href="#" class="c1">新年家宴-法式甜品</a>
                          <button type="button" class="btn btn-success float-right">活动结束</button>
                        </li>
                    </ul>
                </div>

                <div class="my-settings-box no-show">
                    <h3 class="p-2" style="font-family: '宋体';">修改密码</h3>
                    <form id="settings_form" class="mx-auto mt-5  p-3 mb-5 bg-white w-50">
                        <div class="form-row">
                          <div class="form-group col-md-6 offset-md-3">
                            <input type="text" class="form-control" name="email" placeholder="邮件" autocomplete="off" />
                          </div>
                          <div class="form-group col-md-6 offset-md-3">
                            <input type="password" class="form-control" name="password-old" placeholder="原来的密码" autocomplete="off" />
                          </div>
                          <div class="form-group col-md-6 offset-md-3">
                            <input type="password" class="form-control" name="password-new" placeholder="输入新密码" autocomplete="off" />
                          </div>
                          <button type="button" class="btn btn-info col-md-6 offset-md-3 mb-5" id="btn_settings">提交</button>
                        </div>
                       
                      </form>
                </div>

                <div class="my-publish-box no-show">
                	<form  action="${ctx}/food/deploy" method="post"  enctype="multipart/form-data" id="food-publish-box">
                    <div class="input-group mb-3">
                        <label for="food_name" class="font-weight-bold m-1 mr-4 text-right">美食名称</label>
                        <input type="text" name="food_name" class="form-control" id="food_name" placeholder="请输入美食名称" aria-label="Recipient's username" aria-describedby="basic-addon2" required>
                      </div>
                      <div class="input-group mb-3">
                        <label for="food_pic0" class="font-weight-bold m-1 mr-4 text-right">上传照片</label>
                        <input type="file" name="pic" id="food-pic0" class="food-pic"  accept="image/*" required/>
                        <div id="image-holder0" class="image-holder"> </div>
                      </div>
                      <div class="input-group mb-3">
                        <label for="food_mat" class="font-weight-bold m-1 mr-4 text-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;材料</label>
                        <input type="text" name="food_mat" class="form-control" id="food_mat" placeholder="需要材料" aria-label="Recipient's username" aria-describedby="basic-addon2" required>
                      </div>
                      <div class="input-group mb-3">
                        <label for="food_stepnum" class="font-weight-bold m-1 mr-4 text-right">&nbsp;&nbsp;&nbsp;&nbsp;步骤数</label>
                        <input type="text" name="food_stepnum" class="form-control" id="food_stepnum" placeholder="步骤数" aria-label="Recipient's username" aria-describedby="basic-addon2" required>
                        <button type="button" class="btn btn-success float-right ml-5" id="btn_stepConfirm">确定</button>
                    </div>
                  

                 	</form>
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
<script src="${ctx}/public/js/logout.js"></script>
<script src="${ctx}/public/js/back.js"></script>
</html>