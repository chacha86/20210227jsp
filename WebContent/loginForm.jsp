<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="article">
	<input type="hidden" name="action" value="doLogin" />
	<input type="text" name="loginId" placeholder="아이디" /><br>
	<input type="password" name="loginPw" placeholder="비밀번호" /><br>
	<input type="submit" value="로그인" /><br>
</form>
</body>
</html>