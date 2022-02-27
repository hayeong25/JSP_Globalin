<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BoardMVC.BoardDAO" %>
<%@ page import="java.sql.Timestamp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%-- 반으로 데이터베이스 처리 --%>
<jsp:useBean id="article" class="BoardMVC.BoardVO" />
<jsp:setProperty name="article" property="*" />
<%
	article.setRegdate(new Timestamp(System.currentTimeMillis()));
	article.setIp(request.getRemoteAddr());
	
	BoardDAO dbPro = BoardDAO.getInstance();
	dbPro.insertArticle(article);
	
	response.sendRedirect("list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	
</body>
</html>