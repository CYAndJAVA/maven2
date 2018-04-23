<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>图书首页</title>
		<link rel="stylesheet" type="text/css" href="${path}/dist/css/bootstrap.min.css">
	</head>
	<body>
	<div class="container" style="margin-top: 20px">
		<c:forEach items="${pgBean.datas}" var="b" varStatus="bn">
		    <c:if test="${(bn.count+3)%4==0 }">
		        <div class="row">
		    </c:if>
			    <div class="col-sm-6 col-md-3 wow fadeInLeft animated">
       				<div class="thumbnail">
       					 <c:if test="${user.power==0 }">
       					 	<input type="checkbox" name="cks" value="${b.id}">
       					 </c:if>
       					 <a href="${path }/book/detail?seeBId=${b.bookid}">
         					 <img src="${path}/images/${b.imgurl}" alt="通用的占位符缩略图">
         			     </a>
          			    <div class="caption">
			                <h5 class="text-success" align="center">${b.bookname}</h5>
			                <p align="center"><span class="text-info">图书作者:</span>${b.author}</p>
			                <p align="center"><span class="text-info">图书价格:</span>${b.newprice}
			                
			                <c:if test="${!empty sessionScope.LoginUser}"> 
                                 <a class="pull-right glyphicon glyphicon-shopping-cart" href="javascript:addItem(${b.isbn},1)">
                                     add
                                 </a>
                            </c:if> 
			                </p>
			           	
			           	<c:if test="${user.power==0 }">
			           		<p class="pull-left"><a href="#"><span class="glyphicon glyphicon-trash text-danger"></span></a></p>
			           		<p align="right"><a href="${path}/book/update/search?id=${b.id}"><span class="glyphicon glyphicon-edit text-warning"></span></a></p>
			           	</c:if>	
			            </div>
				   </div>
			    </div>
		         <c:if test="${bn.count == pgBean.pageSize }">
	                 </div>
	             </c:if>
             
		</c:forEach>
    </div>

<!-- 可能需要改变的. -->
<c:set var="queryUrl" value="${path}/book/pageContorl?bookName=${bookName}&styleId=${styleId}&pageSize=${pgBean.pageSize}"></c:set>

<div class="container" align="center">
	<ul class="pagination">
		<li><a href="javascript:changePage2(1)">首页</a></li>
	    
	    <c:if test="${pgBean.current<=1 }">
		    <li class="disabled"><a>&laquo;</a></li>
	    </c:if>
	    <c:if test="${pgBean.current>1 }">
	    	 <li><a href="javascript:changePage2(${pgBean.previous})">&laquo;</a></li>
	    </c:if>	  
		
		<!-- 处理尾部 -->
		<c:if test="${pgBean.current+4<pgBean.pageNum }">
			<c:set var="endPage" value="${pgBean.current+4}"></c:set>
			<c:set var="startPage" value="${pgBean.current}"></c:set>
		</c:if>
		
		<c:if test="${pgBean.current+4>=pgBean.pageNum }">
			<c:set var="endPage" value="${pgBean.pageNum }"></c:set>
			<c:set var="startPage" value="${pgBean.pageNum-4}"></c:set>
		</c:if>
		
		<!-- 处理起始位置和结束位置 -->
		<c:forEach var="p" begin="${startPage<=0?1:startPage}" end="${endPage}">
			<c:if test="${pgBean.current==p}">
				<li class="active"><a href="javascript:changePage2(${pgBean.current})">${p}</a></li>
			</c:if>
			<c:if test="${pgBean.current!=p }">
				<li><a href="javascript:changePage2(${p})">${p}</a></li>
			</c:if>
		</c:forEach>	   
	    
	    <!-- 判断是否到达尾页 -->
	    <c:if test="${pgBean.current>=pgBean.pageNum }">
	    	<li class="disabled"><a>&raquo;</a></li>
	    </c:if>
	    
	    <c:if test="${pgBean.current<pgBean.pageNum }">
	    	<li><a href="javascript:changePage2(${pgBean.next})">&raquo;</a></li>
	    </c:if>
	    <li><a href="javascript:changePage2(${pgBean.pageNum})">尾页</a></li>
	    <li><a>当前页<span class="text-success">${pgBean.current}</span>/<span class="text-danger">${pgBean.pageNum}</span>总页</a><li>
	    <li>
			<div class="pull-left">
			    <form class="bs-example bs-example-form" role="form">
			        <div class="row">
			            <div class="col-md-8">
			                <div class="input-group">
			                    <input placeholder="跳转页" id="toPages" type="text" class="form-control">
			                    <span class="input-group-btn">
			                        <button class="btn btn-default" onclick="changePage()" type="button" >跳转页</button>
			                    </span>
			                </div>
			            </div>
			        </div>
			    </form>
			</div>
	    </li>
	    <li>   	
	    	<div class="pull-left">
	    		<form role="form">
					<div class="row">
						<div class="col-md-12">
							 <div class="form-group">
							    <select id="size" onchange="changePage()" class="form-control">
							      <option value="-1">==显示条数==</option>
							      <option value="4" <c:if test="${pgBean.pageSize==4}">selected</c:if>>4</option>
							      <option value="8" <c:if test="${pgBean.pageSize==8}">selected</c:if>>8</option>
							      <option value="12" <c:if test="${pgBean.pageSize==12}">selected</c:if>>12</option>
							      <option value="16" <c:if test="${pgBean.pageSize==16}">selected</c:if>>16</option>
							      <option value="20" <c:if test="${pgBean.pageSize==20}">selected</c:if>>20</option>
							    </select>
					  		</div>
						</div>
					</div>
			</form>
	    	</div>
	    </li>
	</ul>
</div>
<script src="${path}/js/wow.js"></script>
<script type="text/javascript">
		if(!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
	                new WOW().init();
	     };
         var path = document.getElementById("path").value;
     function changePage(){
         var newSize = document.getElementById("size").value;
         var style = document.getElementById("style").value;
         var bookname = document.getElementById("searchName").value;
         var turn = "1";
         var pageTurn = document.getElementById("toPages").value;
         var regex = /^[0-9]+$/;
             if(regex.test(pageTurn)){
                 turn = pageTurn;
             }else{
            	 alert("输入不合法，默认第一页！");
             }
         alert(path+"/book/pageContorl?sName="+bookname+
                 "&pgNow="+turn+"&pgSize="+newSize+"&sty_id="+style);
         window.location=path+"/book/pageContorl?sName="+bookname+
                 "&pgNow="+turn+"&pgSize="+newSize+"&sty_id="+style;
     }
     function changePage2(obj){
    	 var newSize = document.getElementById("size").value;
         var style = document.getElementById("style").value;
         var sbookname = document.getElementById("searchName").value;
         var pageTurn = "1";
         if(null!=obj){
        	pageTurn = obj; 
         }
         alert(path+"/book/pageContorl?sName="+sbookname+
                 "&pgNow="+pageTurn+"&pgSize="+newSize+"&sty_id="+style);
         window.location=path+"/book/pageContorl?sName="+sbookname+
                 "&pgNow="+pageTurn+"&pgSize="+newSize+"&sty_id="+style;
     }
     
</script>
</body>
</html>
