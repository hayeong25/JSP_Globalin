<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ELtag.Customer, java.util.ArrayList" %>
<%
	ArrayList<String> singer = new ArrayList<String>();
	singer.add("아라시");
	singer.add("엔플라잉");
	request.setAttribute("singer", singer);
	
	Customer[] customer = new Customer[2];
	customer[0] = new Customer();
	customer[0].setName("곰탱");
	customer[0].setEmail("bear@naver.com");
	customer[0].setPhone("010-1234-1234");
	customer[1] = new Customer();
	customer[0] = new Customer();
	customer[0].setName("코리락쿠마");
	customer[0].setEmail("kokuma@naver.com");
	customer[0].setPhone("010-1234-1234");
	request.setAttribute("customer", customer);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<ul>
		<li>${singer[0]}, ${singer[1]}</li>
	</ul>
	<ul>
		<li>이름 : ${customer[0].name}</li>
		<li>이메일 : ${customer[0].email}</li>
		<li>전화번호 : ${customer[0].phone}</li>
	</ul>
	<ul>
		<li>이름 : ${customer[1].name}</li>
		<li>이메일 : ${customer[1].email}</li>
		<li>전화번호 : ${customer[1].phone}</li>
	</ul>
</body>
</html>