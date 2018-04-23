<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<!--左边-->
		
		<div class="col-md-8 col-sm-12">
			<!--左边-->
			<ol class="breadcrumb">
				<li><a href="" class="text-success"><span
						class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;我的宝贝</a></li>
			</ol>

			<!--购物车表格 begin-->
			<div class="table-responsive" id="imgDiv">
				<table class="table table-hover table-striped"
					style="vertical-align: middle;">
					<thead>
						<tr>
							<td colspan="8"><label class="text-primary">显示条数:</label> <select
								id="cartSzie" class="form-control" style="display: inline"
								onchange="displaySize(this)">
								<c:forEach begin="1" end="${sessionScope.myHashSet.size()}" varStatus="cnn">
									<c:if test="${cnn.count == sessionScope.myHashSet.size()}">
									    <option value="${cnn.count}" selected>${cnn.count}</option>
									</c:if>
									<c:if test="${cnn.count != sessionScope.myHashSet.size()}">
                                        <option value="${cnn.count}">${cnn.count}</option>
                                    </c:if>
								</c:forEach>	
							</select></td>
						</tr>
						<tr class="text-success success">
							<th><input type="checkbox" id="selectAll"
								onclick="selectAll(this)"></th>
							<th id="sequence">序号</th>
							<th>图片</th>
							<th>书名</th>
							<th>单价</th>
							<th>数量</th>
							<th>合计</th>
						</tr>
					</thead>
					<tbody id="tby">
					<c:forEach items="${sessionScope.myHashSet}" var="mcLs" varStatus="mn">
						<tr>
							<td><input type="checkbox" name="cks" value="${mcLs.book_isbn}"></td>
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
							<td colspan="5"></td>
							<td class="text-success">总价:</td>
							<td class="text-success">${allPriceNow}$</td>
						</tr>
						<tr style="background-color: white;">
							<td><a href="${path}" class="btn btn-info">&lt;&lt;继续购买</a>
							</td>
							<td><button class="btn btn-danger" data-toggle="modal"
									data-target="#myModal" onclick="del()">删除商品</button></td>
							<td colspan="4"></td>
							<td><a href="javascript:buybooks()" class="btn btn-warning">结算商品</a>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
			<!--购物车 end-->
		</div>
		
		

