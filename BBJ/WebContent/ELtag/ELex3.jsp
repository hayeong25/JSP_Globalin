<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 연산자</title>
</head>
<body>
	<h3>EL</h3>
	<p>연산자 사용과 내장객체 사용</p>
	<table border="1">
		<tr>
			<td><b>표현식</b></td>
			<td><b>값</b></td>
		</tr>
		<tr>
			<td>\${2+5}</td>
			<td>${2+5}</td>
		</tr>
		<tr>
			<td>\${4/5}</td>
			<td>${4-5}</td>
		</tr>
		<tr>
			<td>\${5 div 6}</td>
			<td>${5 div 6}</td> <!-- div 태그로 인식해 빨간 줄. 에러는 아님 -->
		</tr>
		<tr>
			<td>\${2 mod 5}</td>
			<td>${2 mod 5}</td>
		</tr>
		<tr>
			<td>\${2 < 3}</td>
			<td>${2 < 3}</td>
		</tr>
		<tr>
			<td>\${2 gt 5}</td>
			<td>${2 gt 5}</td>
		</tr>
		<tr>
			<td>\${3.1 le 3.2}</td>
			<td>${3.1 le.2}</td>
		</tr>
		<tr>
			<td>\${(5 > 3) ? 5 : 3}</td>
			<td>${(5 > 3) ? 5 : 3}</td>
		</tr>
		<tr>
			<td>\${header["host"]}</td>
			<td>${header["host"]}</td>
		</tr>
		<tr>
			<td>\${header["user-agent"]}</td>
			<td>${header["user-agent"]}</td>
		</tr>
	</table>
</body>
</html>