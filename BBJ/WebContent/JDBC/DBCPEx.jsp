<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="javax.sql.DataSource"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.Context"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>  </title>
</head>
<body>
	<h3> DBCP 연동 </h3>
	<%
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		// DataSource 객체 얻기 위해 initContext 객체 사용
		// lookup 메소드를 사용해 DataSource 객체 얻어옴
		// 매개변수는 context.xml 파일에서 resource 태그에 설정된 이름으로 값 지정
		
		Connection conn = ds.getConnection();
		
		out.println("DBCP 연동 성공");
	%>
</body>
</html>