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
	<%-- JSP �ּ����Դϴ� ���ڵ�� �������� ��ȯ�� �� �ڹ� �ڵ�� ������ �ʾƿ�. --%>
	<%-- ���� 1. ���� �����ϰ� ����ϱ� --%>
	<%
		int age = 22;
	String name = "������";
	%>

	<h1>�ڱ�Ұ�</h1>
	<div>
		�ȳ��ϼ���. ����
		<%=age%>��
		<%=name%>�Դϴ�.
	</div>
	<div>
		�ȳ��ϼ���. ����
		<%
		out.println(age);
	%>��
		<%
		out.println(name);
	%>�Դϴ�.
	</div>

	<h2>������</h2>
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

	<h2>ArrayList import�ϱ�</h2>
	<div>
	<%
		ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("list");
		
		for(int i=0;i<articles.size();i++) {
			out.println("���� : "+articles.get(i).getTitle()+"<br>");
			out.println("���� : "+articles.get(i).getBody()+"<br>");
		}
	%>
	</div>
	<h2>ArrayList ���� �̾Ƴ���</h2>
	<div>
	<%
		Article test = new Article();
		//test=adao.getArticleById(1);
	%>
	���� ���<br>
	<%= test.getTitle()%>
	
	</div>
	
	
	���� ��ü request, response, out  3��

</body>
</html>