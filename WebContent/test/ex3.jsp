<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	
	<!-- 1������ -->
	<c:set var="first" value="4"/>
	<c:choose>
		<c:when test="${first%2==1 }">
			odd
		</c:when>
		<c:otherwise>
			even
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<br>

	<!-- 2�� ���� -->
	<c:set var="age" value="66"/>
	<c:choose>
		<c:when test="${age<=19||age>=60 }">
			���δ���Դϴ�.
		</c:when>
		<c:otherwise>
			���δ���� �ƴմϴ�.
		</c:otherwise>
	</c:choose>

	<br>
	<br>
	<br>
	
	
	<!-- 3�� ���� -->
	<c:forEach var="i" begin="2" end="100" step="2">
		${i}
		<c:if test="${i%20==0}">
			<br>
		</c:if>
	</c:forEach>
	<br>
	<br>
	<br>


	<!-- 4������ -->
	<c:set var="n" value="2"/>
	<c:set var="m" value="9"/>
	<c:set var="limit" value="11"/>

	<c:forEach var="dan" begin="${n}" end="${m}">
		<c:if test="${dan%2==1}">
			<c:forEach var="num" begin="1" end="${limit}">
				<c:if test="${num%2==0}">
					${dan} x ${num} = ${dan*num}
					<br>
				</c:if>
			</c:forEach>
			<br>
		</c:if>
	</c:forEach>


	<br>
	<br>
	<br>
	<!-- 5�� ���� -->
	<c:set var="tri" value="2"/>
	<c:forEach var="floar" begin="1" end="${tri}">
		<c:forEach var="draw" begin="1" end="${floar}">
			*
		</c:forEach>
		<br>
	</c:forEach>











</body>
</html>