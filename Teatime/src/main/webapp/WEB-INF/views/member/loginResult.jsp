<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title> login Result </title>
</head>
<body>
<h1> 로그인 성공 </h1>
<br>
세션아이디: ${sessionScope.sessionId }
<br>
세션닉네임: ${sessionScope.sessionNick }
<br>
<input type="button" value="메인가기" onclick="location.href='${pageContext.request.contextPath}/home'">
</body>
</html>