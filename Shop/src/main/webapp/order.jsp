<%@page import="java.sql.PreparedStatement"%>
<%@page import="bean.OrderBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="org.apache.tomcat.dbcp.dbcp2.PoolingConnection.StatementType"%>
<%@page import="config.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<OrderBean> orders = null;

	try{
		Connection conn = DBCP.getConnection();
		
		String sql = "SELECT a.`orderNo`, b.`name`, c.`prodName`, a.`orderCount`, a.`orderDate` "
				   + "from `order` AS a "
				   + "join `customer` AS b ON a.orderId = b.custId "
				   + "join `product` AS c ON a.orderProduct = c.prodNo";
		
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		
		orders = new ArrayList<>();
		
		while(rs.next()){
			OrderBean ob = new OrderBean();
			ob.setOrderNo(rs.getInt(1));
			ob.setName(rs.getNString(2));
			ob.setProdName(rs.getString(3));
			ob.setOrderCount(rs.getInt(4));
			ob.setOrderDate(rs.getString(5));
			
			orders.add(ob);
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>order</title>
	</head>
	<body>
		<h3>주문목록</h3>
		<a href="#">고객목록</a>
		<a href="#">주문목록</a>
		<a href="#">상품목록</a>
		
		<table border="1">
			<tr>
				<th>주문번호</th>
				<th>주문자</th>
				<th>주문상품</th>
				<th>주문수량</th>
				<th>주문일</th>
			</tr>
			<% 
			for(OrderBean ob : orders){
			%>
			<tr>
				<td><%= ob.getOrderNo()%></td>
				<td><%= ob.getName()%></td>
				<td><%= ob.getProdName()%></td>
				<td><%= ob.getOrderCount()%></td>
				<td><%= ob.getOrderDate()%></td>
				
			</tr>
			<% } %>
		</table>
		
	</body>
</html>