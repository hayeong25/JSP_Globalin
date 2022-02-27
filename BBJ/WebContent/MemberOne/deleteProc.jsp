<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="MemberOne.*" %>
<jsp:useBean id="dao" class="MemberOne.StudentDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="3;url=Login.jsp">
<title>회원탈퇴</title>
</head>
<%
	String id = (String)session.getAttribute("loginID");
	String pass = request.getParameter("pass");
	int check = dao.deleteMember(id, pass);
	
	if(check == 1) {
		session.invalidate();
%>
<body>
	<div align="center">
		회원정보가 삭제되었습니다.<br>
		이용해주셔서 감사합니다.<br>
		3초 후 로그인 페이지로 이동합니다.
	</div>
<%
	}
%>
</body>
</html>