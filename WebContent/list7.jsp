<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="board.Article"%>
<%@ page import="board.ArticleDao"%>
<%@ page import="board.Member"%>
<%@ page import="board.Reply"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${ logined_member==null }">
			<a href="start_page.jsp">
				<input type="button" value="로그인" />
			</a>
		</c:when>
		<c:otherwise>
			<h2>안녕하세요. ${logined_member.nickname}님</h2>	
			<a href="start_page.jsp">
				<input type="button" value="처음화면" />
			</a>	
			<a href="TestServlet?action=logout">
				<input type="button" value="로그아웃" />
			</a>	
		</c:otherwise>
	</c:choose>

	<table border="1px">
		<!-- 해더 -->
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
			<td>좋아요</td>
			<td>상세보기</td>
			<td>update</td>
			<td>delete</td>
		</tr>
		<!-- 본문 -->
		<c:forEach items="${list}" var="article">
			<tr>
				<td>${article.id }</td>
				<td>${article.title}</td>
				<td>${article.nickname }</td>
				<td>${article.regDate }</td>
				<td>${article.hit }</td>
				<td>${article.likeCnt }</td>
				<td>
					<a href="TestServlet?action=read_article&aid=${article.id }">
						<input type="button" value="상세보기"/>
					</a>				
				</td>
				<td>
					<a href="TestServlet?action=update_article&id=${article.id }">
						<input type="button" value="수정"/>
					</a>
				</td>
				<td>
					<a href="TestServlet?action=delete&id=${article.id }">
						<input type="button" value="삭제"/>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="TestServlet2?action=login">테스트 로그인</a>
	<a href="addForm.jsp">글쓰기</a>
	<form action="http://127.0.0.1:9090/TestServlet" method="post">
		<input type="hidden" name="action" value="delete"/>
		<input type="text" name="id" placeholder="글번호"/>
	</form>

</body>
</html>