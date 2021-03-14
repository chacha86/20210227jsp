<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 수정 페이지</h1>
	
	<form action="http://127.0.0.1:9000/article"> <!-- action -> query 보낼 목적지 -->
		<input type="hidden" name="action" value="update"/> <!-- 숨겨진 값 -->
		<input type="text" name="title" value="${ article.title }"/> <!-- 입력창 -->
		<input type="text" name="body" value="${ article.body }"/> <!-- 입력창 -->
		<input type="hidden" name="id" value="${ article.id }"/> <!-- 숨겨진 값 -->
		<input type="submit" /> <!-- 전송버튼 -->
	</form>
</body>
</html>