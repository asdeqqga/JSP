<%@page import="java.sql.PreparedStatement"%>
<%@page import="config.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String custId = request.getParameter("custId");
	String name = request.getParameter("name");
	String addres = request.getParameter("address");
	String phone = request.getParameter("phone");
	
	try{
		Connection conn = DBCP.getConnection();
		
		String sql = "update `customer` set `name`=?, `address`=?"
						+ ", `phone`=? where `custId`=?";
		
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, name);
		psmt.setString(2, addres);
		psmt.setString(3, phone);
		psmt.setString(4, custId);
		
		psmt.executeUpdate();
		
		conn.close();
		psmt.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	
	response.sendRedirect("./list.jsp");
%>