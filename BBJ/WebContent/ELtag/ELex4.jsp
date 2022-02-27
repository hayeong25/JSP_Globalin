<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "곰탱");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 기본 객체</title>
</head>
<body>
	요청 URI : ${pageContext.request.requestURI}<br><br>
	request의 name 속성 : ${requestScope.name}<br><br>
	code 파라미터 : ${param.code}
</body>
</html>