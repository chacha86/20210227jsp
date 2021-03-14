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

<c:set var="y" value="7" />

<c:forEach var="line" begin="1" end="${y}">
	<c:forEach var="star" begin="1" end="${line}">
		*
	</c:forEach>
	<br>
</c:forEach>


</body>
</html>