<%@page import="java.sql.PreparedStatement"%>
<%@page import="config.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String bookId = request.getParameter("custId");
	
	try{
		Connection conn = DBCP.getConnection();
		
		String sql = "DELETE FROM `customer` where `custId`=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, bookId);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
		
	}catch (Exception e){
		e.printStackTrace();
	}
	
	response.sendRedirect("./list.jsp");
%>