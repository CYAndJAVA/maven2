<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>引导页</title>
    </head>
    <body>
        <!-- 设置全局的应用路径path -->
        <c:set var="path" value="${pageContext.servletContext.contextPath }" 
                scope="application"></c:set>
        
        <!-- 设置默认首页跳转的路径 -->
        <c:redirect url="/book/booksview"></c:redirect>
    </body>
</html>