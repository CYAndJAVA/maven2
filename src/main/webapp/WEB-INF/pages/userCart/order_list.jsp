<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>我的订单</title>
<link type="text/css" rel="stylesheet"
	href="${path}/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/index.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/animate.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/order_list.css" />
</head>

<body>
	<!--导航部分  begin-->
	<%@ include file="../common/booknav.jsp"%>
	<!--最顶端轮播图片 begin-->
	<%@ include file="../common/lunbo.jsp"%>

	<!--订单begin-->
	<!--外层div-->
	<div class="container">
		<!--左边-->
		<div class="container pull-left">
			<ol class="breadcrumb">
				<li><a href="#" class="text-success"><span
						class="glyphicon glyphicon-list"></span>&nbsp;&nbsp;我的订单</a></li>
			</ol>
		</div>
		<!--查询的导航栏-->
		<%@ include file="itemSerchNav.jsp" %>
		<!--内容展示 begin-->
		<!--内容展示 begin-->
		<c:forEach items="${liste}" var="a" varStatus="b">
                <div class="table-responsive">
                  <table class="table table-hover table-striped">
                    <caption class="text-info">
                        <div class="col-md-10" style="padding-left: 0px;">
                            <input type="checkbox" name="cks">&nbsp;<%-- ${a.ord.createdate} --%>  订单号:<%-- ${a.ord.ordernum} --%>单
                        </div>
                        <div class="col-md-2" style="text-align: right;">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">订单详情</a>
                        </div>
                    </caption>
                    <thead>
                        <tr id="collapseThree" class="panel-collapse collapse">
                            <td colspan="9">
                            <div class="panel-body">
                                <!--tab选项卡 begin-->
                                <ul id="myTab" class="nav nav-tabs">
                                    <li class="active">
                                        <a href="#home" data-toggle="tab">
                                            联系人信息
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#ios" data-toggle="tab">订单信息</a>
                                    </li>
                                </ul>
                                <div id="myTabContent" class="tab-content">
                                    <div class="tab-pane fade in active" id="home">
                                        <div class="row">
                                            <div>
                                                <ul class="nav navbar-collapse" style="line-height: 3;">
                                                    <li class="text-info"><span class="text-success">姓名:</span><span class="text-info">${a.address.reciver }</span></li>
                                                    <li class="text-info"><span class="text-success">联系方式:</span> ${a.address.tel }</li>
                                                    <li class="text-info"><span class="text-success">收货地址:</span>${a.address.detailaddress }</li>
                                                </ul>
                                            </div>
                                        </div>
                                        </p>
                                    </div>
                                    <div class="tab-pane fade" id="ios">
                                        <div class="row">
                                            <div>
                                                <ul class="nav navbar-collapse" style="line-height: 3;">
                                                    <li class="text-info"><span class="text-success">订单编号:</span><span class="text-info"><%-- ${a.ord.ordernum} --%></span></li>
                                                    <li class="text-info"><span class="text-success">交易时间:</span><%-- ${a.ord.createdate} --%></li>
                                                    <li class="text-info"><span class="text-success">订单总金额:</span>${a.allPrice}元</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--tab选项卡 end-->   
                            </td>
                        </tr>
                        <tr class="active">
                            <th>序号</th>
                            <th>图片</th>
                            <th>图片名称</th>
                            <th>单价(元)</th>
                            <th>数量</th>
                            <th>实付款(元)</th>
                            <th>付款日期</th>
                            <th>交易状态</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${a.list }" var="c">
                    
                      <tr class="warning">
                        <td>${b.count+1000}</td>
                        <td><img src="${path}/images/${c.cimgurl}"></td>
                        <td>${c.book_name}</td>
                        <td>${c.newprive}</td>
                        <td>${c.counts}</td>
                        <td>${c.allprice}</td>
                        <td><%-- ${a.ord.createdate} --%></td>
                        <td><%-- ${a.ord.orderstatus} --%></td>
                      </tr>
                      
                      </c:forEach>
                    </tbody>
                  </table>
                  
                    
                </div>
                <!--内容展示end-->
            </div>
            <!--分页begin-->
            <div class="container">
                <div class="row text-center">
                    <div class="col-md-12">
                        <ul class="pagination">
                            <li><a href="#">首页</a></li>
                            <li class="disabled"><a href="#">&laquo;</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li class="active"><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">&raquo;</a></li>
                            <li><a href="#" style="border: 1px solid #ddd;">尾页</a></li>
                            <li><a style="border: 0px;margin-left: 0px;">当前页3/5总页</a></li>
                            <li>
                                
                                <div id="search" class="input-group" style="positon:relative;">
                                    <input type="text" class="form-control" placeholder="跳转指定页" />
                                    <span class="input-group-btn">  
                                        <button class="btn btn-info btn-search">GO</button>
                                    </span>
                                </div>
                           </li>
                            <li><a style="padding-top: 0px;border: 0px;">
                                <label>每页显示:</label>
                                <select id="pageSize" class="form-control" style="width: 100px;display: inline;">
                                    <option value="2">2</option>
                                    <option value="2">4</option>
                                    <option value="2">6</option>
                                    <option value="2">8</option>
                                </select>
                                <label>条</label>
                             </a>
                           </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!--分页end-->
        </div>
	</c:forEach>
	
	<hr>
	<!--首页底部信息 begin-->
	<%@ include file="../common/foot.jsp"%>
	<!--end-->
	<script src="${path}/js/jquery.min.js"></script>
	<script src="${path}/dist/js/bootstrap.min.js"></script>
	<script src="${path}/js/moment.js"></script>
	<script src="${path}/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript">
		$('#datetimepicker').datetimepicker();
		$('#datetimepicker2').datetimepicker();
	</script>
</body>
</html>