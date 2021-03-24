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


	<h1>리스트 페이지로 이동</h1>

	<a href="TestServlet?action=list"> <input type="button"
		value="바로입장" />
	</a>
	<c:choose>
		<c:when test="${ logined_member==null }">
			<h2>로그인</h2>
			<form action="http://localhost:9000/TestServlet" method="post">
				<input type="hidden" name="action" value="login" /> <input
					type="text" name="id" placeholder="아이디" /><br> <input
					type="password" name="pw" placeholder="비밀번호" /><br> <input
					type="submit" value="로그인" />
			</form>
			<a href="join.jsp">
				<input type="button" value="회원가입" />
			</a>
			
			<form action="http://localhost:9000/TestServlet" method="post">
				<input type="hidden" name="action" value="login" /> <input
					type="hidden" name="id" value="test" /><br> <input
					type="hidden" name="pw" value="test" /><br> <input
					type="submit" value="테스트로그인" />
			</form>
		</c:when>
		<c:otherwise>
			<h2>${ logined_member.nickname }님환영합니다.</h2><br>
			<a href="TestServlet?action=logout">
				<input type="button" value="로그아웃" />
			</a>
		</c:otherwise>
	</c:choose>





</body>
</html>