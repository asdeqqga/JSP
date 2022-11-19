<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>customer::register</title>
	</head>
	<body>
		<h3>customer 등록</h3>
		
		<a href="/Bookstore2/">처음으로</a>
		<a href="/Bookstore2/customer/list.do">customer 목록</a>
		
		<form action="/Bookstore2/customer/register.do" method="post">
		<table border="1">
			<tr>
				<td>고객명</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<input type="submit" value="등록하기">
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>