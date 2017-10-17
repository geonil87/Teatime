<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title> Login Form </title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">
	아이디 : <input type="text" name="userId"/><br>
	비밀번호 : <input type="password" name="userPw" /><br>
	<input type="submit" value="로그인"/><br>
</form>
<br>
${param.loginResult }

</body>
</html>