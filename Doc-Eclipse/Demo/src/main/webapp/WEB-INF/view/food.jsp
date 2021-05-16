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
    <title>臻品生活家-美食</title>
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
            <div class="row row-cols-1 row-cols-md-4">
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\ngfg-sm.jpg" class="card-img-top w-100" alt="南瓜葡萄发糕">
                        <div class="card-body">
                            <a href="food-detail">
                                <h5 class="card-title text-info">南瓜葡萄发糕</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2018-02-08</small></p>
                            <p class="card-text">面粉、玉米面、温水、细砂糖、酵母粉、南瓜泥、葡萄干。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\ngyz-sm.jpg" class="card-img-top w-100" alt="南瓜酒酿小圆子">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">南瓜酒酿小圆子</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2018-01-28</small></p>
                            <p class="card-text">面粉、糯米粉、酒酿、糖。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\xlmg-sm.jpg" class="card-img-top w-100" alt="雪梨银耳炖木瓜">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">雪梨银耳炖木瓜</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2018-01-18</small></p>
                            <p class="card-text">银耳、雪梨、木瓜、冰糖。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\xrdb-sm.jpg" class="card-img-top w-100" alt="藜麦秋葵虾仁蛋饼">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">藜麦秋葵虾仁蛋饼</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2018-01-18</small></p>
                            <p class="card-text">藜麦、虾仁、鸡蛋、秋葵、盐、黑胡椒。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\hjxl-sm.jpg" class="card-img-top w-100" alt="红酒雪梨">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">红酒雪梨</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2017-01-18</small></p>
                            <p class="card-text">梨、红酒、冰糖、肉桂皮。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\ngfg-sm.jpg" class="card-img-top w-100" alt="南瓜葡萄发糕">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">南瓜葡萄发糕</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2018-02-08</small></p>
                            <p class="card-text">面粉、玉米面、温水、细砂糖、酵母粉、南瓜泥、葡萄干。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\ngyz-sm.jpg" class="card-img-top w-100" alt="南瓜酒酿小圆子">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">南瓜酒酿小圆子</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2018-01-28</small></p>
                            <p class="card-text">面粉、糯米粉、酒酿、糖。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\xlmg-sm.jpg" class="card-img-top w-100" alt="雪梨银耳炖木瓜">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">雪梨银耳炖木瓜</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2018-01-18</small></p>
                            <p class="card-text">银耳、雪梨、木瓜、冰糖。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\xrdb-sm.jpg" class="card-img-top w-100" alt="藜麦秋葵虾仁蛋饼">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">藜麦秋葵虾仁蛋饼</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2018-01-18</small></p>
                            <p class="card-text">藜麦、虾仁、鸡蛋、秋葵、盐、黑胡椒。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\hjxl-sm.jpg" class="card-img-top w-100" alt="红酒雪梨">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">红酒雪梨</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2017-01-18</small></p>
                            <p class="card-text">梨、红酒、冰糖、肉桂皮。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\ngfg-sm.jpg" class="card-img-top w-100" alt="南瓜葡萄发糕">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">南瓜葡萄发糕</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2018-02-08</small></p>
                            <p class="card-text">面粉、玉米面、温水、细砂糖、酵母粉、南瓜泥、葡萄干。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\ngyz-sm.jpg" class="card-img-top w-100" alt="南瓜酒酿小圆子">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">南瓜酒酿小圆子</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2018-01-28</small></p>
                            <p class="card-text">面粉、糯米粉、酒酿、糖。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\xlmg-sm.jpg" class="card-img-top w-100" alt="雪梨银耳炖木瓜">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">雪梨银耳炖木瓜</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2018-01-18</small></p>
                            <p class="card-text">银耳、雪梨、木瓜、冰糖。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\xrdb-sm.jpg" class="card-img-top w-100" alt="藜麦秋葵虾仁蛋饼">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">藜麦秋葵虾仁蛋饼</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2018-01-18</small></p>
                            <p class="card-text">藜麦、虾仁、鸡蛋、秋葵、盐、黑胡椒。</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="${ctx}\public\images\food\hjxl-sm.jpg" class="card-img-top w-100" alt="红酒雪梨">
                        <div class="card-body">
                            <a href="#">
                                <h5 class="card-title text-info">红酒雪梨</h5>
                            </a>
                            <p class="card-text"><small class="text-muted">2017-01-18</small></p>
                            <p class="card-text">梨、红酒、冰糖、肉桂皮。</p>
                        </div>
                    </div>
                </div>
            </div>
            <nav aria-label="Page navigation example">
                <ul class="pagination  justify-content-center">
                  <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <li class="page-item active"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item"><a class="page-link" href="#">4</a></li>
                  <li class="page-item"><a class="page-link" href="#">5</a></li>
                  <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                    </a>
                  </li>
                </ul>
              </nav>
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
    </div>
</body>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/js/bootstrap.min.js"></script>
<script src="${ctx}/public/js/index.js"></script>

</html>