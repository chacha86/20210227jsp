<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<c:choose>
	<c:when test="${ loginedMember == null }">
		<a href="loginForm.jsp">로그인</a>
		<a href="#">회원가입</a>
		<a href="article?action=test">테스트 로그인</a>
	</c:when>
	<c:otherwise>
		${ loginedMember.nickname }! 반갑습니다.	
	</c:otherwise>
	</c:choose>
	<hr>
	<c:forEach items="${ list }" var="article">
		<div>
			번호 : ${ article.id }<br>
			제목 : <a href="article?action=detail&id=${ article.id }">${ article.title }</a> <br>
			작성자 : ${ article.nickname }<br>
			작성일 : ${ article.regDate }<br>
			조회수 : ${ article.hit }<br>
			좋아요 : ${ article.likeCnt}<br>
		</div>
		<hr>
	</c:forEach>
	
<a href="addForm.jsp">글쓰기</a>
</body>
</html>