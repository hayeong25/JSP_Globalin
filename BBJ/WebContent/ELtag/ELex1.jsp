<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ELtag.Customer, java.util.HashMap" %>
<%
	Customer customer = new Customer();
	customer.setName("곰탱");
	customer.setEmail("bear@naver.com");
	customer.setPhone("010-1234-1234");
	request.setAttribute("customer", customer);
	
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("name", "부릉이");
	map.put("maker", "곰탱");
	request.setAttribute("car", map);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
</head>
<body>
	<ul>
		<li>이름 : ${customer.name}</li>
		<li>이메일 : ${customer.email}</li>
		<li>전화번호 : ${customer.phone}</li>
	</ul>
	<ul>
		<li>자동차 : ${car.name}</li>
		<li>제조사 : ${car.maker}</li>
	</ul>
</body>
</html>