<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
		
		
		<div id="outer"></div>
        <div id="outer2"></div>
        <div id="outer3"></div>
        
		<!--图书内容部分end--><hr>
		<!-- 结尾部分 -->
		<%@ include file="../common/foot.jsp" %>
		<!-- 登录注册模态框部分 -->
		<%@ include file="../modal/loginmodal.jsp" %>
		<script src="${path}/js/jquery.min.js"></script>
        <script src="${path}/js/carousel.js" ></script>
        <script src="${path}/dist/js/bootstrap.min.js"></script>
        <script src="${path}/js/index.js"></script>
        <script src="${path}/js/wow.js"></script>
        <script src="${path}/js/carousel.js"></script>
        <script src="${path}/js/MyItem.js"></script>
		<script type="text/javascript">
			$(function(){
                $("#outer").load("${path}/book/bookseek1?searchName1=${searchName}");
            });
            function nextPage(param){
                $("#outer").load("${path}/book/bookseek1",{"pageNow":param});
            }
            
            $(function(){
                $("#outer2").load("${path}/book/bookseek2?searchName2=${searchName}");
            });
            function nextPage2(param2){
                $("#outer2").load("${path}/book/bookseek2",{"pageNow2":param2});
            }
            
            $(function(){
                $("#outer3").load("${path}/book/bookseek3?searchName3=${searchName}");
            });
            function nextPage3(param3){
                $("#outer3").load("${path}/book/bookseek3",{"pageNow3":param3});
            }
            
            function searchBookByName(){
                var name = document.getElementById("searchName").value;
                window.location="${path}/book/booksview?searchName="+name;
            }
            
		</script>
	</body>

</html>