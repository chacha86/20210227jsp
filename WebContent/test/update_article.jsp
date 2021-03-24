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
	<%
		Article article = (Article)request.getAttribute("article");
	%>


	<h1>게시물 수정 페이지</h1>
	
	<form action="http://127.0.0.1:9000/TestServlet" method="post">
		<input type="hidden" name="action" value="update"/>
		<input type="hidden" name="id" value="${article.id }"/>
		<input type="text" name="title" value="${article.title }"/>
		<input type="text" name="body" value="${article.body }"/>
		<input type="submit"/>
	</form>

</body>
</html>