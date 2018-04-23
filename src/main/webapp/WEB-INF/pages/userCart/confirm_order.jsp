<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>结算</title>
        <link type="text/css" rel="stylesheet" href="${path}/dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${path}/css/index.css" />
        <link rel="stylesheet" type="text/css" href="${path}/css/cart.css" />
        <link rel="stylesheet" type="text/css" href="${path}/css/animate.css" />
        <style type="text/css">
            .form-control{
                width: 100%;
            }
        </style>
    </head>
	<body>
		<!--导航部分  begin-->
        <%@ include file="../common/booknav.jsp" %>
        <!--导航部分 end-->

        <!--最顶端轮播图片 begin-->
        <%@ include file="../common/lunbo.jsp" %>
        <!--最顶端轮播图片 end-->
		
		<!--购物车 begin-->
		<!--外层div-->
		<div class="container">
			<!--左边-->
			<div class="col-md-8 col-sm-12">
				<ol class="breadcrumb">
					<li>
						<a href="#" class="text-success"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;送货地址</a>
					</li>
				</ol>
				
				<!--送货地址  begin-->
				<div id="addresslist"></div>
				<hr>
				<!--左边-->
				<ol class="breadcrumb">
					<li>
						<a href="${path}/user/cart/order/orderListview" class="text-success"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;结算清单</a>
					</li>
				</ol>
				<!--购物车表格 begin-->
				<%@ include file="BuyCartList.jsp" %>
				<!--购物车 end-->
			</div>

			<!--右边-->
			<%@ include file="../common/rightFile.jsp" %>
		</div>

		<div class="container">
			<!--首页底部信息 begin-->
			<%@ include file="../common/foot.jsp" %>
		</div>
		<!--end-->
		<!--删除提示模态框 begin-->
         <%@ include file="../modal/delModel.jsp" %>
         <!--删除提示模态框 end-->
         <!--添加新地址模态框 begin-->
         <%@ include file="../modal/addressModel.jsp" %>
         <!-- 模态框（Modal） -->
		<script src="${path}/js/jquery.min.js"></script>
		<script src="${path}/js/wow.js"></script>
		<script src="${path}/js/carousel.js" type="text/javascript"></script>
		<script src="${path}/dist/js/bootstrap.min.js"></script>
		<script src="${path}/dist/js/distpicker.data.min.js"></script>
		<script src="${path}/dist/js/distpicker.min.js"></script>
		<script src="${path}/js/details.js" ></script>
		<script src="${path}/js/cart.js"></script>
		<script src="${path}/js/confirm_order.js"></script>
		<script type="text/javascript">
			if(!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
				new WOW().init();
			};
			$(function(){
				$("#addresslist").load("${path}/user/cart/order/addressView");
			});
			function checkOneAddress(param){
                $("#addresslist").load("${path}/user/cart/order/addressView",{"addressId":param});
            } 
		</script>
	</body>
</html>
