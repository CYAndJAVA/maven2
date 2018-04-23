<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--左边-->
<div class="table-responsive" id="imgDiv">
	<table class="table table-hover table-striped"
		style="vertical-align: middle;">
		<thead>
			<tr class="text-success success">
				<th id="sequence">序号</th>
				<th>图片</th>
				<th>书名</th>
				<th>单价</th>
				<th>数量</th>
				<th>合计</th>
			</tr>
		</thead>
		<tbody id="tby">
			<c:forEach items="${sessionScope.myHashSet}" var="mcLs"
				varStatus="mn">
				<tr>
					<td>${mn.count+1000}</td>
					<td><img src="${path}/images/${mcLs.cimgurl}"></td>
					<td>${mcLs.book_name}</td>
					<td>${mcLs.newprive}元</td>
					<td>${mcLs.counts}</td>
					<td>${mcLs.allprice}$</td>
				</tr>
			</c:forEach>

		</tbody>
		<tfoot>
			<tr>
				<td colspan="4"></td>
				<td class="text-success">总价:</td>
				<td class="text-success">${allPriceNow}$:</td>
			</tr>
			<tr style="background-color: white;">
				<td><a href="${path}" class="btn btn-info">&lt;&lt;继续购买</a></td>
				<td colspan="4"></td>
				<td><a href="${path}/user/cart/order/orderListview" class="btn btn-warning">提交订单</a>
				</td>
			</tr>
		</tfoot>
	</table>
</div>

