<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
번호 : ${ article.id }<br>
제목 : ${ article.title }<br>
내용 : ${ article.body }<br>
작성자 : ${ article.nickname }<br>
작성일 : ${ article.regDate }<br>
조회수 : ${ article.hit }<br>
좋아요 : ${ article.likeCnt }<br>
<hr>
</body>
</html>