<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<a href="start_page.jsp">
		<input type="button" value="돌아가기"/>
	</a>
	
	<h2>정보입력</h2>
	<form action="http://localhost:9000TestServlet" method="post">
		<input type="hidden" name="action" value="join"/>
		<input type="text" name="JoinId" placeholder="아이디"/><br>
		<input type="password" name="JoinPw" placeholder="비밀번호"/><br>
		<input type="text" name="JoinNickname" placeholder="이름"/><br>
		<input type="submit" value="회원가입"/>
	</form>
	
	
</body>
</html>