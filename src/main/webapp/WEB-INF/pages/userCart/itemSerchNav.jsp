<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--订单查询导航 begin-->
                <div>
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">所有订单</a>
                        </div>

                        <form class="navbar-form navbar-left" role="search">
                            <input type="text" class="form-control" placeholder="输入订单号进行查询">
                            <button type="button" class="btn btn-search">
                                <span class="text-success">Search</span>&nbsp;&nbsp;<span class="glyphicon glyphicon-search"></span>
                            </button>
                        </form>

                        <ul class="nav navbar-nav navbar-left">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    交易状态
                                    <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">全部</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="#">已付款</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="#">未付款</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="#">交易成功</a>
                                    </li>
                                    <li class="divider"></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-left">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    订单排序
                                    <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">订单日期降序</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="#">订单日期升序</a>
                                    </li>
                                    <li class="divider"></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li style="padding-right: 15px;">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">更多筛选条件</a>
                            </li>
                        </ul>
                        
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="#">删除订单</a>
                            </li>
                        </ul>
                            <ul class="nav navbar-nav">
                            <li>
                                <a href="#">清空订单列表</a>
                            </li>
                        </ul>
                    </nav>
                </div>
                
                <!--订单查询导航 end-->
                <!--日期控件-->
                <div id="collapseTwo" class="panel-collapse collapse">
                    <div class="panel-body">
                        <div class="form-group">    
                            <div>
                                <form class="form-horizontal">
                                    <div class="form-group has-feedback">
                                        <div class="col-md-1" style="padding-top:5px ;">
                                            成交日期:
                                        </div>
                                        <div class="col-md-3">
                                            <input type="text" class="form-control" id="datetimepicker" placeholder="开始时间">
                                            <span class="glyphicon glyphicon-time form-control-feedback"></span>
                                        </div>
                                        <div class="col-md-1" style="padding-top:5px ;text-align:center;">
                                            至
                                        </div>
                                        <div class="col-md-3">
                                            <input type="text" class="form-control" id="datetimepicker2" placeholder="结束日期">
                                            <span class="glyphicon glyphicon-time form-control-feedback"></span>
                                        </div>
                                        <div class="col-md-3">
                                            <button type="button" class="btn btn-default">查询&nbsp;&nbsp;<span class="glyphicon glyphicon-search"></button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!--日期控件-->