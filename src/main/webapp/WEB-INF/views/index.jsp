<%@ page language="java" contentType="text/html; charset=GBK"
         pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page import="com.tengxh.entity.DataInfo" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<c:forEach var="data" items="${requestScope.list}">
<c:out value="${data.dataName}" /><p>
    </c:forEach>
</body>