<%@page import="bean.BookBean"%>
<%@page import="config.DBCP"%>
<%@page import="java.util.List"%>
<%@page import="bean.CustomerBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<CustomerBean> customers = null;
	

	try{
		Connection conn = DBCP.getConnection();
		
		// 3단계
		Statement stmt = conn.createStatement();
		
		// 4단계
		ResultSet rs = stmt.executeQuery("SELECT * FROM `customer`");
		
		// 5단계
		customers = new ArrayList<>();
		
		while(rs.next()){
			CustomerBean cb = new CustomerBean();
			cb.setCustId(rs.getInt(1));
			cb.setName(rs.getString(2));
			cb.setAddr(rs.getString(3));
			cb.setHp(rs.getInt(4));
	
			customers.add(cb);
		}
		// 6단계
		rs.close();
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>





<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user::list</title>
	</head>
	<body>
		<h3>도서 목록</h3>
		<a href="../index.jsp">처음으로</a>
		<a href="./register.jsp">도서목록</a>
		
		<table border="1">
			<tr>
				<th>고객번호</th>
				<th>고객명</th>
				<th>주소</th>
				<th>휴대폰</th>
				<th>관리</th>
			</tr>
			<%
			for(CustomerBean cb: customers){
			%>
			<tr>
				<td><%= cb.getCustId() %></td>
				<td><%= cb.getName() %></td>
				<td><%= cb.getAddr() %></td>
				<td><%= cb.getHp() %></td>
				<td>
					<a href="./modify.jsp?custId=<%= cb.getCustId() %>">수정</a>
					<a href="./delete.jsp?custId=<%= cb.getCustId() %>">삭제</a>
				</td>				
			</tr>
			<% } %>
		</table>
		
	</body>
</html>