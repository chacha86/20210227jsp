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
	<c:choose>
		<c:when test="${ flag == 'y' && reply.id == rid }"> <!-- 수정 링크를 눌렀냐 안눌렀냐 -->
			<form action="article">
				<input type="hidden" name="id" value="${ reply.id }"/>
				<input type="text" name="rbody" value="${ reply.body }"/>
				<input type="hidden" name="aid" value="${ article.id }" />
				<input type="hidden" name="mid" value="${ loginedMember.id }" />
				<input type="hidden" name="action" value="updateReply" />
				<input type="submit" value="등록" />
			</form>
			
		</c:when>
		<c:otherwise>
			${reply.body}<br>
		</c:otherwise>
	</c:choose>
	
	${reply.regDate} 
	<c:if test="${ loginedMember.id == reply.mid }">	
		<a href="article?action=detail&id=${ article.id }&flag=y&rid=${reply.id}">수정</a> <a href="#">삭제</a>
	</c:if>
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