<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="elfunc" uri="/tlds/el-function.tld"%>
<%
	java.util.Date today = new java.util.Date();
	request.setAttribute("today", today);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	오늘은 <b>${elfunc:dateFormat(today)}</b>입니다.
</body>
</html>