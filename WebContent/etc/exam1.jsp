<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%-- JSP 주석문입니다  이코드는 서블릿으로 변환할 때 자바 코드로 변하지 않아요. --%>

<%-- 문제 1. 변수 선언하고 출력하기 --%>

<%
	int age = 32;
	String name = "임꺽정";
%>

<h1>자기소개</h1>
<div>안녕하세요 저는 <% out.println(age); %>살 <% out.println(name); %>입니다.</div>