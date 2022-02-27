<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="MemberOne.StudentDAO" />
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	int check = dao.loginCheck(id, pass);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		if(check == 1) { // 로그인 성공
			session.setAttribute("loginID", id);
			response.sendRedirect("Login.jsp");
		}
		else if(check == 0) { // 비밀번호 오류
	%>
	<script type="type/javascript">
		alert("비밀번호가 틀렸습니다.");
		history.go(-1);
	</script>
	<%
		}
		else {
	%>
	<script type="text/javascript">
		alert("존재하지 않는 아이디입니다.");
		history.back();
	</script>
	<%
		}
	%>
</body>
</html>