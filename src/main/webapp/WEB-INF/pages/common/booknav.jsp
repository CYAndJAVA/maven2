<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--导航部分  begin-->
        <div class="container" style="margin-top: 5px;">
        <input type="hidden" id="path" value="${path}"/>
            <nav class="navbar navbar-default well-sm" style="padding-left: 0px;" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
                            <span class="sr-only">切换导航</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="${path}/book/booksview">在线书城</a>
                    </div>
                    <div class="collapse navbar-collapse" id="example-navbar-collapse">
                        <ul class="nav navbar-nav pull-left">
                            <li class="active">
                                <a href="${path}/book/booksview">首页</a>
                            </li>
                    
                            <li>
                                <li class="dropdown">
                                    <a href="" class="dropdown-toggle" data-toggle="dropdown">
                                        图书类型
                                        <b class="caret"></b>
                                    </a>
                                    <ul class="dropdown-menu">
                                    <c:forEach items="${StyleList}" var="sty" >
                                        <li >
                                            <a href="${path}/book/bookStyleView?styleId=${sty.style_id}">${sty.stylename }</a>
                                        </li>
                                        <li class="divider"></li>
                                     </c:forEach>   
                                    </ul>
                                </li>
                             </li>
                             
                            <c:if test="${empty sessionScope.LoginUser}">
	                            <li>
	                                <a href="#" data-toggle="modal" data-target="#myLoginModal">登录</a>
	                            </li>
	                            <li>
	                                <a href="#" data-toggle="modal" data-target="#register">注册</a>
	                            </li>
                            </c:if>
                            <c:if test="${!empty sessionScope.LoginUser}">
                                <li><a href="">用户：${sessionScope.LoginUser.userName}</a></li>
	                            <li>
                                <a href="${path}/user/cart/BuyView">我的订单</a>
	                            </li>
	                            <li>
	                                <a href="${path}/user/cart/MyCart"><span class="glyphicon glyphicon-shopping-cart"> </span>我的购物车</a>
	                            </li>
	                            <li>
	                                <a href="${path}/user/safeExit">安全退出</a>
	                            </li>
	                        </c:if>
	                            <li>
	                               <a href="">${applicationScope.online}</a>
	                            </li>
                            
                        </ul>
                        
                        <div class="input-group col-md-3 pull-right" style="positon:relative;padding: 7px;">
                            <input id="searchName" type="text" value="${searchName}" class="form-control" placeholder="请输入图书名" />
                            <span class="input-group-btn">  
                                <button onclick="searchBookByName()" class="btn btn-info btn-search">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </span>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
        
        
        