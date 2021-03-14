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
번호 : ${ article.id }<br>
제목 : ${ article.title }<br>
내용 : ${ article.body }<br>
작성자 : ${ article.nickname }<br>
작성일 : ${ article.regDate }<br>
조회수 : ${ article.hit }<br>
좋아요 : ${ article.likeCnt }<br>
<hr>
<c:if test="${ article.mid == loginedMember.id }">
	<a href="article?action=updateForm&id=${ article.id }">수정</a><br>
	<a href="article?action=delete&id=${ article.id }">삭제</a><br><br>
</c:if>
<h3>댓글</h3>
<hr>
<c:forEach items="${ replies }" var="reply">
	${reply.nickname}<br>
	${reply.body}<br>
	${reply.regDate}<br>
	<hr>
</c:forEach>
<form action="article">
	${ loginedMember.nickname }<br>
	<input type="text" name="rbody" placeholder="댓글을 남겨보세요"/>
	<input type="hidden" name="aid" value="${ article.id }" />
	<input type="hidden" name="mid" value="${ loginedMember.id }" />
	<input type="hidden" name="action" value="insertReply" />
	<input type="submit" value="등록" />
</form>
</body>
</html>