<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 변수 선언 -->
<%
	int a = 10;
%>

<c:set var="b" value="100" />

<!-- 출력 -->
<%
	out.println(a);
%>
<br>
<!-- el 표현 -->
<c:out value=" ${b}" />
<br>
<!-- 조건문  -->
<%
	int k = 40;
	if(k > 100) {
		out.println("100보다 큽니다.");
	} else if(k > 50) {
		out.println("50보다 큽니다.");
	} else {
		out.println("50보다 작거나 같습니다.");
	}
%>
<br>
<c:set var="k" value="40" />

<c:choose>
<c:when test="${ k > 100 }">
	100보다 큽니다.
</c:when>
<c:when test="${ k > 50 }">
	50보다 큽니다.
</c:when>
<c:otherwise>
	50보다 작거나 같습니다.
</c:otherwise>
</c:choose>

<br>
<!-- 반복문 -->
<%
	
	ArrayList<Integer> nlist = new ArrayList<>();
	
	for(int i = 0; i < 5; i++) {
		nlist.add(i + 1);
	}
	
	for(int n : nlist) {
		out.println(n);
	}
	
	pageContext.setAttribute("aa", nlist);

%>

<c:forEach var="i" begin="1" end="5" step="1">
	${i}
</c:forEach>

<c:forEach items="${aa}" var="n" >
	${ n }
</c:forEach>










</body>
</html>