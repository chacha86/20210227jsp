<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	ArrayList<Integer> nlist = new ArrayList<>();
	
	for(int i = 1; i <= 10; i++) {
		nlist.add(i);
	}
%>

<% for(int i = 0; i < nlist.size(); i++) { %> 
	
	<%= nlist.get(i) %> <br> 
	
<% } %>

</body>
</html>