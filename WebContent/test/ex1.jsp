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
	<%-- JSP 주석문입니다 이코드는 서블릿으로 변환할 때 자바 코드로 변하지 않아요. --%>
	<%-- 문제 1. 변수 선언하고 출력하기 --%>
	<%
		int age = 22;
	String name = "여정훈";
	%>

	<h1>자기소개</h1>
	<div>
		안녕하세요. 저는
		<%=age%>살
		<%=name%>입니다.
	</div>
	<div>
		안녕하세요. 저는
		<%
		out.println(age);
	%>살
		<%
		out.println(name);
	%>입니다.
	</div>

	<h2>구구단</h2>
	<div>
		<%
			for (int i = 2; i <= 9; i++) {
			for (int j = 1; j < 10; j++) {
		%>
		<%=i%>
		x
		<%=j%>
		=
		<%=i * j%><br>

		<%
			}
		}
		%>
	</div>

	<h2>ArrayList import하기</h2>
	<div>
	<%
		ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("list");
		
		for(int i=0;i<articles.size();i++) {
			out.println("제목 : "+articles.get(i).getTitle()+"<br>");
			out.println("내용 : "+articles.get(i).getBody()+"<br>");
		}
	%>
	</div>
	<h2>ArrayList 내용 뽑아내기</h2>
	<div>
	<%
		Article test = new Article();
		//test=adao.getArticleById(1);
	%>
	내용 출력<br>
	<%= test.getTitle()%>
	
	</div>
	
	
	내장 객체 request, response, out  3개

</body>
</html>