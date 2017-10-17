<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<br>
세션아이디: ${sessionScope.sessionId }
<br>
세션닉네임: ${sessionScope.sessionNick }
<br>
<input type="button" value="로그인" onclick="location.href='${pageContext.request.contextPath}/login'">
<input type="button" value="로그아웃" onclick="location.href='${pageContext.request.contextPath}/logout'">
</body>
</html>
