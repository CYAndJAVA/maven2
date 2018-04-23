<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="gcarouse" class="container">
            <!--轮播-->
            <div id="myCarousel" class="carousel slide">
                <!-- 轮播（Carousel）指标 -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                    <c:forEach items="${lunlist}" var="lun" varStatus="luni">
	                    <c:if test="${luni.count==1}">
	                       <div class="item active">
	                           <a href=""><img src="${path}/images/${lun.imgurl}" class="pull-left" alt="First slide"></a>
                           </div>
	                    </c:if>
	                    <c:if test="${luni.count>1}">
	                       <div class="item">
	                           <a href=""><img src="${path}/images/${lun.imgurl}" class="pull-left" alt="First slide"></a>
                           </div>
	                    </c:if>
                    </c:forEach>
                </div>

                <!-- 轮播（Carousel）导航 -->
                <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
            </div>
        </div>