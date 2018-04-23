<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书详情</title>
<link type="text/css" rel="stylesheet" href="${path}/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/index.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/animate.css" />
</head>
<body>

	<!--导航部分  begin-->
	<%@ include file="../common/booknav.jsp"%>
	<!--导航部分 end-->
	<!--最顶端轮播图片 begin-->
	<%@ include file="../common/lunbo.jsp"%>
	<br>
	<!--最顶端轮播图片 end-->
	
        <!--外层div-->
        <div class="container">
            <!--左边-->
            <div class="col-md-8 col-sm-12">
                <ol class="breadcrumb">
                    <li>
                        <a href="">图书详情</a>
                    </li>
                    <li>
                        <a href="">${book.bookname }</a>
                    </li>
                </ol>

                <div class="row">
                    <div class="col-sm-12 col-md-6">
                        <div class="thumbnail">
                            <a><img src="${path }/images/${book.imgurl}" style="height: 200px;" alt="通用的占位符缩略图"></a>
                            <div class="caption">
                                <h3>${book.bookname }</h3>
                                <p>双十一特价,包邮哟!亲<img src="${path }/images/${book.imgurl}" style="width: 24px;height: 24px;"></p>
                                <p>
                                    <div style="margin-bottom: 5px;width: 100px;">
                                        <input id="itemCNumber" type="number" class="form-control" placeholder="购买数量" min="1" max="100" onclick="selectByCount(this)">
                                    </div>
                                    <div style="clear: both;">
                                        <!-- <input type="number" class="form-control" placeholder="请输入" min="1" max="100" onclick="selectByCount(this)"> -->
                                    <c:if test="${!empty sessionScope.LoginUser}">   
                                        <a href="confirm_order.html" class="btn btn-default" role="button">
                                            <span class="glyphicon glyphicon-usd"></span> 立即购买
                                        </a>
                                        <a href="javascript:addItems(${book.isbn})" class="btn btn-default" role="button">
                                            <span class="glyphicon glyphicon-shopping-cart"></span> 加入购物车
                                        </a>
                                     </c:if>    
                                    </div>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-12 col-md-6">
                        <div class="thumbnail">
                            <ul class="list-group">
                                <li class="list-group-item"><span class="text-success">图书名称:${book.bookname }</span></li>
                                <li class="list-group-item"><span class="text-info">作者:</span>${book.author }</li>
                                <li class="list-group-item"><span class="text-info">
                                出版日期:<fmt:formatDate value="${book.publish_date}" pattern="YYYY年MM月dd日"></fmt:formatDate>
                                </span></li>
                                <li class="list-group-item"><span class="text-info">出版社:</span>${book.publisher }</li>
                                <li class="list-group-item"><span class="text-info" style="text-decoration: line-through;">原价:</span><span style="text-decoration: line-through;">$${book.oldprice }元</span></li>
                                <li class="list-group-item"><span class="text-info">现价:</span>$${book.newprice }元</li>
                                <li class="list-group-item"><span class="text-info">说明:</span>${book.info}
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!--<hr>-->
                <!--折叠部分 begin-->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                            展开详细信息
                        </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <!--tab选项卡 begin-->
                            <ul id="myTab" class="nav nav-tabs">
                                <li class="active">
                                    <a href="#home" data-toggle="tab">
                                        商品详情
                                    </a>
                                </li>
                                <li>
                                    <a href="#ios" data-toggle="tab"> <span class="badge pull-right">0</span>累计评价</a>
                                </li>
                            </ul>
                            <div id="myTabContent" class="tab-content">
                                <div class="tab-pane fade in active" id="home">
                                    <p>
                                        <em>产品参数：</em>
                                    </p>
                                    <div class="row">
                                        <div class="col-sm-12 col-md-6">
                                            <ul class="nav navbar-collapse" style="line-height: 3;">
                                                <li class="text-info">产品名称：${book.bookname }</li>
                                                <li class="text-info">是否是套装: ${book.suit }</li>
                                                <li class="text-info">书名:${book.bookname }</li>
                                                <li class="text-info">定价: ${book.newprice }元</li>
                                                <li class="text-info">出版社名称: ${book.publisher }</li>
                                                <li class="text-info">出版时间: 
                                                <fmt:formatDate value="${book.publish_date}" pattern="YYYY年MM月dd日"></fmt:formatDate>
                                                </li>
                                                <li class="text-info">作者: ${book.author }</li>
                                                <li class="text-info">作者地区: ${book.author_loc }</li>
                                                <li class="text-info">书名: ${book.bookname }</li>
                                                <li class="text-info">ISBN编号: ${book.isbn }</li>
                                            </ul>
                                        </div>
                                        <span class="visible-sm visible-xs"><hr></span>
                                        
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="ios">
                                    <p>
                                        <ul class="list-group">
                                            <li class="list-group-item"><span class="text-info">a:</span><span class="text-success ">这真的是一本好书<img src="${path }/images/emotions/1.gif "></span></li>
                                            <li class="list-group-item"><span class="text-info">b:</span><span class="text-danger ">书的质量很差<img src="${path }/images/emotions/2.gif "></span></li>
                                            <li class="list-group-item"><span class="text-info">c:</span><span class="text-success ">很值得初学者学习<img src="${path }/images/emotions/13.gif "></span></li>
                                            <li class="list-group-item"><span class="text-info">d:</span><span class="text-danger ">被坑大发了.<img src="${path }/images/emotions/17.gif "></span></li>
                                            <li class="list-group-item"><span class="text-info">e:</span><span class="text-danger ">卖家态度恶劣.<img src="${path }/images/emotions/11.gif "></span></li>
                                        </ul>
                                    </p>
                                    <p>
                                        <ul class="pager">
                                            <li>
                                                <a href="">&larr;上一页</a>
                                                <a href="">下一页 &rarr;</a>
                                            </li>
                                        </ul>
                                    </p>
                                </div>
                            </div>
                            <!--tab选项卡 end-->
                        </div>
                    </div>
                </div>
                <!--折叠部分end-->
            </div>
            <!--左边end-->
            
            <!--右边-->
            <%@ include file="../common/rightFile.jsp" %>
            <!-- 右边 -->
        </div>
        <!-- 外层DIV -->
	
		
		<!-- 结尾部分 -->
        <%@ include file="../common/foot.jsp" %>
        <!-- 登录注册模态框部分 -->
        <%@ include file="../modal/loginmodal.jsp" %>
        <script src="${path}/js/jquery.min.js"></script>
        <script src="${path}/js/carousel.js" ></script>
        <script src="${path}/dist/js/bootstrap.min.js"></script>
        <script src="${path}/js/index.js"></script>
        <script src="${path}/js/wow.js"></script>
		<script src="${path}/js/details.js"></script>
		<script src="${path}/js/MyItem.js"></script>
		<script type="text/javascript">
			if(!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
				new WOW().init();
			};
		</script>
	</body>
</html>