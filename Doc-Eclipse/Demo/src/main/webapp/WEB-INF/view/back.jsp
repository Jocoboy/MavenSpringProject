<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>        
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
                         <!-- 收藏列表 -->
					    <div class="row" id="collect-container">         
							
					    </div> <!-- 收藏列表 row -->
						<div class="row">
							<ul id='example'  style="margin:0 auto; text-align:center;"></ul>
						</div>
						
						
                  </div>

                  <div class="my-reserve-box no-show">
                    <div class="fav-box-title" style="font-family: '宋体';">
                      <h3 class="text-light p-2" style="font-size: 1em;">我预约的活动</h3>
                    </div>
                        <!-- 预约列表 -->
					    <div class="row" id="reserve-container">         
							
					    </div> <!-- 预约列表 row -->
						<div class="row">
							<ul id='example'  style="margin:0 auto; text-align:center;"></ul>
						</div>
                </div>

                <div class="my-settings-box no-show">
                    <h3 class="p-2" style="font-family: '宋体';">修改密码</h3>
                    <form id="settings_form" class="mx-auto mt-5  p-3 mb-5 bg-white w-50">
                        <div class="form-row">
                          <div class="form-group col-md-6 offset-md-3">
                            <input id="input-username" type="text" class="form-control" name="email" placeholder="邮件" autocomplete="off"  disabled="disabled"/>
                          </div>
                          <div class="form-group col-md-6 offset-md-3">
                            <input type="password" class="form-control" name="password-old" placeholder="原来的密码" autocomplete="off" />
                          </div>
                          <div class="form-group col-md-6 offset-md-3">
                            <input type="password" class="form-control" name="password-new" placeholder="输入新密码" autocomplete="off" />
                          </div>
                          <div class="form-group col-md-6 offset-md-3">
                            <input type="password" class="form-control" name="password-new-confirm" placeholder="再次输入新密码" autocomplete="off" />
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
                 
                 
                  <div class="my-publish-box2 no-show">
                	<form  action="${ctx}/activity/deploy" method="post"  enctype="multipart/form-data" id="activity-publish-box">
                   
                       <div class="input-group mb-3">
 							<label for="activity_name" class="font-weight-bold m-1 mr-4 text-right">活动名称</label>
                        	<input type="text" name="activity_name" class="form-control" id="activity_name" placeholder="请输入活动名称" aria-label="Recipient's username" aria-describedby="basic-addon2" required>
 						</div>
 						<div class="input-group mb-3">
 							<div class="col-4">
 								<label for="activity_location" class="font-weight-bold m-1 mr-4 text-right">活动地点</label>
                        		<input type="text" name="activity_location" class="form-control" id="activity_location" placeholder="请输入活动地点" aria-label="Recipient's username" aria-describedby="basic-addon2" required>
 							</div>
 						
 						
 							<div class="col-8">
	 							<label for="activity_location_detail" class="font-weight-bold m-1 mr-4 text-right">活动详细地址</label>
	                        	<input type="text" name="activity_location_detail" class="form-control" id="activity_location_detail" placeholder="请输入活动详细地址" aria-label="Recipient's username" aria-describedby="basic-addon2" required>
 							</div>
 							
 						</div>
 					
 						<div class="input-group mb-3">
 						
 							<div class="col-6">
	 							<label for="activity_startDate" class="font-weight-bold m-1 mr-4 text-right">活动开始时间</label>
	                        	<input type="datetime-local" name="activity_startDate" class="form-control" id="activity_startDate" placeholder="请输入活动开始时间"  required/>
                        	</div>
                        	
                        	<div class="col-6">
	                        	<label for="activity_endDate" class="font-weight-bold m-1 mr-4 text-right">活动截止时间</label>
	                        	<input type="datetime-local" name="activity_endDate" class="form-control" id="activity_endDate" placeholder="请输入活动截止时间" required/>
 							</div>
 						</div>
 						
 						<div class="input-group mb-3">
 							<label for="activity_description" class="font-weight-bold m-1 mr-4 text-right">活动描述</label>
                        	<input type="text" name="activity_description" class="form-control" id="activity_description" placeholder="请输入活动描述" aria-label="Recipient's username" aria-describedby="basic-addon2" required>
 						</div>
 						
 						<div class="input-group mb-3">
 							<div class="col-3">
		                        <label for="activity_postnum" class="font-weight-bold m-1 mr-4 text-right">上传海报数量</label>
		                        <input type="text" name="activity_postnum" class="form-control" id="activity_postnum" placeholder="上传海报数量" aria-label="Recipient's username" aria-describedby="basic-addon2" required>
                    		</div>
	                            <button type="button" class="btn btn-success float-right ml-5 mt-3" id="btn_postConfirm">确定</button>
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
<script src="${ctx}/public/js/bootstrap-paginator.min.js"></script>
<script src="${ctx}/public/js/index.js"></script>
<script src="${ctx}/public/js/logout.js"></script>
<script src="${ctx}/public/js/back.js"></script>
<script src="${ctx}/public/js/manage-reserve.js"></script>
<script src="${ctx}/public/js/manage-collect.js"></script>
</html>