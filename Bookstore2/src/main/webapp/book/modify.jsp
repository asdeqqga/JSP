<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>book::list</title>
	</head>
	<body>
		<h3>Book 목록</h3>
		<a href="/Bookstore2/">처음으로</a>
		<a href="/Bookstore2/book/list.do">book 등록</a>
		
		<form action="/Bookstore2/book/modify.do" method="post">
		<table border="1">
			<tr>
				<td>도서번호</td>
				<td><input type="text" name="bookId" value="${vo.bookId}"></td>
			</tr>
			<tr>
				<td>도서명</td>
				<td><input type="text" name="bookName" value="${vo.bookName}"></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="publisher" value="${vo.publisher}"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" value="${vo.price}"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<input type="submit" value="수정하기">
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>