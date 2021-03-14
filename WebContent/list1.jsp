<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="board.ArticleDao" %>
<%@ page import="board.Article" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!-- 값, 변수, 조건문, 반복문 -->

<%
	ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("list");
%>
<table border="1px">
	<!-- header -->
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
		<td>좋아요</td>
	</tr>
	
	<!-- 본문 -->
	<c:forEach items="${ list }" var="article">
		<tr>
			<td>${ article.id }</td>
			<td>${ article.title }</td>
			<td>${ article.nickname }</td>
			<td>${ article.regDate }</td>
			<td>${ article.hit }</td>
			<td>${ article.likeCnt}</td>
		</tr>
	</c:forEach>
</table>





</body>
</html>