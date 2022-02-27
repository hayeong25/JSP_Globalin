<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="MemberOne.StudentDAO" />
<%
	String id = request.getParameter("id");
	boolean check = dao.idCheck(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 아이디 중복체크 </title>
<link href="Style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="#ffffcc">
	<br>
	<div align="center">
	 <b><%=id %></b>
	 <%
	 	if(check) {
	 		out.println("이미 존재하는 아이디입니다.");
	 	}
	 	else {
	 		out.println("는 사용 가능한 아이디입니다.");
	 	}
	 %>
	 <a href="#" onclick="javascript:self.close()">닫기</a>
	</div>
</body>
</html>