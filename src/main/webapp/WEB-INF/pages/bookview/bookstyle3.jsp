<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

         <div class="container">
            <!--图书 begin-->
            <div>
                <div class="text-primary"><img src="${path}/images/${imgSigel}" alt="" title="图书类型">
                    <a href="${path}/book/bookStyleView?styleId=${bookStyle3.style_id}">${bookStyle3.stylename}</a>
                </div>
                <div class="container">
                    <div class="row">
                        <c:forEach items="${pageBean3.datas}" var="data3" varStatus="datan3">
                        <c:set var="LookBook" value="${path }/book/detail?seeBId=${data3.bookid}"></c:set>
                        <div class="col-sm-6 col-md-3 wow fadeInLeft animated">
                            <div class="thumbnail">
                                <a href="${LookBook}"><img src="${path}/images/${data3.imgurl}" alt="通用的占位符缩略图"></a>
                                <div class="caption">
                                    <h3>${data3.bookname}</h3>
                                    <p>${data3.newprice}&nbsp;&nbsp;作者:${data3.author}&nbsp;&nbsp;</p>
                                    <p>
                                        <a href="${LookBook}">
                                            更多信息
                                        </a>
                                    <c:if test="${!empty sessionScope.LoginUser}"> 
                                        <a class="pull-right glyphicon glyphicon-shopping-cart" href="javascript:addItem(${data3.isbn},1)">
                                            add
                                        </a>
                                    </c:if> 
                                    </p>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    <!--分页-->
                    <div class="container">
                        <ul class="pager">
                            <li>
                                <c:if test="${pageBean3.current > 1}">
                                    <a href="javascript:nextPage3(${pageBean3.previous})">&larr;上一页</a>
                                </c:if>
                                <c:if test="${pageBean3.current < pageBean3.next }">
                                    <a href="javascript:nextPage3(${pageBean3.next})">下一页 &rarr;</a>
                                </c:if>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- 图书end -->
        </div>
        <script type="text/javascript">
        if(!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
                new WOW().init();
            };
         </script>
        