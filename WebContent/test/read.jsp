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
	<c:set value="${read}" var="article"/>

	번호 : ${article.id}
	<br> 제목 : ${article.title}
	<br> 내용 : ${article.body}
	<br> 작성자 : ${article.mid}
	<br> 조회수 : ${article.hit}
	<br> 작성일 : ${article.regDate}
	<br>
	
	<a href="TestServlet?action=list">
		<input type="button" value="돌아가기"/>
	</a>
	
	<table border="1px">
		<!-- 해더 -->
		<tr>
			<td>내용</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<!-- 본문 -->
		<c:forEach items="${replies}" var="replies">
			<tr>
				<td>${replies.body }</td>
				<td>${replies.nickname}</td>
				<td>${replies.regDate }</td>
				<td>
					<a href="TestServlet?action=update_reply&aid=${article.id }">
						<input type="button" value="수정"/>
					</a>
				</td>
				<td>
					<a href="TestServlet?action=delete_reply&aid=${article.id }">
						<input type="button" value="삭제"/>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<form action="http://localhost:9090/TestServlet" method="post">
		<input type="hidden" name="action" value="regReply" />
		<input type="hidden" name="mid" value="${ logined_member.id }"/>
		<input type="hidden" name="aid" value="${ article.id }" />
		<input type="text" name="body" placeholder="내용" /><br>
		<input type="submit" value="댓글쓰기" />
	</form>
	
	
	


</body>
</html>