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
<%
	request.setAttribute("num1",12341234);
	out.println((int)request.getAttribute("num1"));
%>
<%
	pageContext.setAttribute("b",30);
%>


	<!--�������� -->
	<%
		int a = 10;
	%>
<c:set var="c" value="11"/>
	
	<!-- ��� -->
	<% out.println(a); %>
	<!-- elǥ�� -->
	<c:out value="${b}"/>
	<c:out value="${c}"/>
	
	<br>
	
	
	<!-- �ݺ��� -->
	<%
		int k=100;
		if(k>100){
			out.println("100���� Ů�ϴ�");
		}
		else if(k==100){
			out.println("100�Դϴ�.");
		}
		else{
			out.println("100���� �۽��ϴ�.");
		}
	%>
	<c:set var="k" value="1111"/>
	<c:choose>
		<c:when test="${k>100 }">
			100���� Ů�ϴ�
		</c:when>
		<c:when test="${k>50 }">
			50���� Ů�ϴ�.
		</c:when>
		<c:otherwise>
			50���� �۽��ϴ�.
		</c:otherwise>
	</c:choose>
	
	
	
	
	
	
	
	<c:set var="k" value="10"/>
	<c:if test="${k<100}">
		100���� �۽��ϴ�.
		
	</c:if>
	<br>
	
	
	
	
	
	
	<!-- �ݺ��� -->
	<%
		for(int i=0;i<10;i++){
			out.println(i);
		}
	%>
	<br>
	<%
		ArrayList<Integer> nlist = new ArrayList<>();
		
		for(int i=0;i<5;i++){
			nlist.add(i+1);
		}

		for(int n:nlist){
			out.println(n);
		}
		
		pageContext.setAttribute("aa", nlist);
	%>
	<br>
	
	<c:forEach var="i" begin="1" end="5" step="1">
		z ${i }
	</c:forEach>
	
	<br>
	
	<c:forEach items="${aa}" var="n">
		${n}
	</c:forEach>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>