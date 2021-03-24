<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@ page import="board.Article"%>
	<%@ page import="board.ArticleDao"%>
	<%@ page import="board.Member"%>
	<%@ page import="board.Reply"%>
	<%@ page import="java.util.ArrayList" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 등록 페이지</h1>
	${logined_member.id}
	<form action="http://127.0.0.1:9000/TestServlet" method="post">
		<input type="hidden" name="action" value="insert"/>
		<input type="text" name="title" placeholder="제목"/>
		<input type="text" name="body" placeholder="내용"/>
		<input type="hidden" name="mid" value="${logined_member.id}"/>
		<input type="submit"/>
	</form>
	
</body>
</html>