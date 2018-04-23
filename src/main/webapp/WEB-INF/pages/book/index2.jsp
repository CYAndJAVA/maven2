<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head lang="en">
		<meta charset="UTF-8">
		<title>在线书城首页</title>
		<link type="text/css" rel="stylesheet" href="${path}/dist/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="${path}/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${path}/css/animate.css" />
	</head>

	<body>
	    <!-- 导航部分 -->
		<%@ include file="../common/booknav.jsp" %>

		<!--最顶端轮播图片 begin-->
		<%@ include file="../common/lunbo.jsp" %> <br>
		<!--最顶端轮播图片 end-->
		<!--图书内容部分 begin-->
		<div class="container">   
            <ol class="breadcrumb">
                <li><a href="#">图书列表</a></li>
                <li><a href="#">${stle.stylename }</a></li>
            </ol>
        </div>
        
        
        <input type="hidden" id="style" value="${stle.style_id}"/>    
        
        
		<!-- 数据显示 -->
		<%@ include file="../common/pageBean.jsp" %>
		
		
		
		<!--图书内容部分end--><hr>
		<!-- 结尾部分 -->
		<%@ include file="../common/foot.jsp" %>
		<!-- 登录注册模态框部分 -->
		<%@ include file="../modal/loginmodal.jsp" %>
		
		<script src="${path}/js/jquery.min.js"></script>
        <script src="${path}/js/carousel.js" ></script>
        <script src="${path}/dist/js/bootstrap.min.js"></script>
        <script src="${path}/js/index.js"></script>
        <script src="${path}/js/MyItem.js"></script>
        
		
	</body>

</html>