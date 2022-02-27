<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="MemberOne.*" %>
    <% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class="MemberOne.StudentDAO" />
<jsp:useBean id="vo" class="MemberOne.StudentVO" />
<jsp:setProperty name="vo" property="*" />
<%
	String loginID = (String)session.getAttribute("loginID");
	vo.setId(loginID);
	dao.updateMember(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="3;url=Login.jsp"> <!-- Refresh : 새로고침 --> <!-- 3; url="" : 3초 후에 지정한 url로 이동 -->
<title>회원 정보 수정</title>
</head>
<body>
	<div align="center">
		<b>회원정보가 수정되었습니다.<br>3초 후에 로그인 페이지로 이동합니다.</b>
	</div>
</body>
</html>