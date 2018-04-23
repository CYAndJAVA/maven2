<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的购物车</title>
		<link type="text/css" rel="stylesheet" href="${path}/dist/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="${path}/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${path}/css/cart.css" />
		<link rel="stylesheet" type="text/css" href="${path}/css/animate.css" />
	</head>

	<body onload="changeNum()">
		<!--导航部分  begin-->
		<%@ include file="../common/booknav.jsp" %>
		<!--导航部分 end-->

		<!--最顶端轮播图片 begin-->
		<%@ include file="../common/lunbo.jsp" %>
		<!--最顶端轮播图片 end-->
		<!--购物车 begin-->
		<!--外层div-->
		<div class="container">
			<!--左边列表-->
			<%@ include file="MyCartList.jsp" %>
			
			<!-- <div id="cartListAndRightFile"></div> -->
			
			<!--右边-->
			<%@ include file="../common/rightFile.jsp" %>
		</div>

			<!--首页底部信息 begin-->
		<%@ include file="../common/foot.jsp" %>
		<!--end-->
        <!--删除提示模态框 begin-->
            <%@ include file="../modal/delModel.jsp" %>
        <!--删除提示模态框 end-->
		<!--引入js文件-->
        <script src="${path}/js/jquery.min.js"></script>
        <script src="${path}/js/carousel.js" ></script>
        <script src="${path}/dist/js/bootstrap.min.js"></script>
        <script src="${path}/js/wow.js"></script>
		<script src="${path}/js/cart.js" ></script>
		<script type="text/javascript">
			if(!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
				new WOW().init();
			};
			/* $(function (){
				$("#cartListAndRightFile").load("${path}/user/cart/MyCartListView");
			}); */
			
		</script>
	</body>

</html>