<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="margin-bottom: 5px;" id="addrDiv">
	<ul class="list-group" id="address">
	
	<c:forEach items="${addressList}" var="at">
	   <c:if test="${at.isdefault == 0 }">
	       <li onclick="checkOneAddress(${at.addressid})" class="list-group-item"><input type="radio" name="addr"
            checked>&nbsp;${at.area } ${at.detailaddress } &nbsp;
            <span class="text-success">默认地址</span></li>
	   </c:if>
	   <c:if test="${at.isdefault != 0 }">
	       <li onclick="checkOneAddress(${at.addressid})" class="list-group-item hidden"><input type="radio" 
            name="addr">&nbsp;${at.area } ${at.detailaddress }</li>
	   </c:if>
		
	
		
		
		
			
	</c:forEach>		
	</ul>
	<a href="#" class="text-info" onclick="dispalyMoreAddr(this)">更多地址↓&nbsp;&nbsp;</a>
	<a href="javascript:void(0)" id="addAddr" class="text-success"
		data-toggle="modal" data-target="#myAddressModal">添加新地址</a>
</div>
