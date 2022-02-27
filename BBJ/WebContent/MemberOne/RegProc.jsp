<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JAVA Bean으로 DB 가입 처리 --%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class="MemberOne.StudentDAO" />
<jsp:useBean id="vo" class="MemberOne.StudentVO" />
<jsp:setProperty property="*" name="vo" />
<%
	boolean flag = dao.MemberInsert(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인</title>
<link href="Style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#ffffcc">
	<br><br>
	<div align="center">
		<%
			if(flag) {
				out.println("<b>회원가입을 축하합니다.</b><br>");
				out.println("<a href=Login.jsp>로그인</a>");
			}
			else {
				out.println("<b>다시 입력해주세요.</b><br>");
				out.println("<a href=RegForm.jsp>다시 가입</a>");
			}
		%>
	</div>
</body>
</html>