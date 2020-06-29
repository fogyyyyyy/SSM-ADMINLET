<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<%--1.最low的超链接跳转--%>
<%--<a href="${pageContext.request.contextPath}/product/findAll.do">查询所有的产品信息</a>--%>

<%--2.jsp重定向，直接跳转首页--%>
<jsp:forward page="/pages/main.jsp"></jsp:forward>
</body>
</html>
