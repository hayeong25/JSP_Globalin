<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="vo" class="JSTL.MemberVO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:set target="${vo}" property="name" value="곰탱"/>
	<c:set target="${vo}" property="email">bear@naver.com</c:set>
	<c:set var="age" value="30" />
</body>
</html>