<%@page import="bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="config.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<ProductBean> products = null;	

	try{
		Connection conn = DBCP.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `product`");
		
		products = new ArrayList<>();
		
		while(rs.next()){
			ProductBean pb = new ProductBean();
			pb.setProdNo(rs.getString(1));
			pb.setProdName(rs.getString(2));
			pb.setStock(rs.getString(3));
			pb.setPrice(rs.getInt(4));
			pb.setCompany(rs.getString(5));
			
			products.add(pb);
			
		}
		
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
		<title>product</title>
	</head>
	<body>
		<h3>상품목록</h3>
		<a href="#">고객목록</a>
		<a href="#">주문목록</a>
		<a href="#">상품목록</a>
		
		<table border="1">
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>재고량</th>
				<th>가격</th>
				<th>제조사</th>
				<th>주문</th>
				
			</tr>
			<%
			for(ProductBean pb : products){
			%>
			<tr>
				<td><%= pb.getProdNo() %></td>
				<td><%= pb.getProdName()%></td>
				<td><%= pb.getStock()%></td>
				<td><%= pb.getPrice()%></td>
				<td><%= pb.getCompany()%></td>
				<td>
					<form>
					<input type="submit" value="주문">	
					</form>
				</td>				
			</tr>
			<% } %>
		</table>
		
	</body>
</html>