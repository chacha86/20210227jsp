<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>게시물 등록 페이지</h1>

	<form action="http://127.0.0.1:9000/article" method="POST"> <!-- action -> query 보낼 목적지 -->
		<input type="hidden" name="action" value="insert"/> <!-- 숨겨진 값 -->
		<input type="text" name="title" placeholder="제목"/><br> <!-- 입력창 -->
		<input type="text" name="body" placeholder="내용"/><br> <!-- 입력창 -->
		<input type="hidden" name="mid" value="${ loginedMember.id }"/><br> <!-- 숨겨진 값 -->
		<input type="submit" /> <!-- 전송버튼 -->
	</form>
</body>
</html>