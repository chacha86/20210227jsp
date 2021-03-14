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

<c:set var="n" value="4" />
<c:set var="m" value="19" />
<c:set var="limit" value="11" />

<c:forEach begin="${n}" end="${m}" var="dan">
	<c:if test="${ dan % 2 != 0 }">
		<c:forEach begin="1" end="${limit}" var="i">
			<c:if test="${ i % 2 == 0 }">
				${dan} X ${i} = ${ dan * i } <br />
			</c:if>
		</c:forEach>	
	</c:if>
</c:forEach>

	

</body>
</html>