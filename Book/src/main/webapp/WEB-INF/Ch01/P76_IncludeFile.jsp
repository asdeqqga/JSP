<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.LocalDate"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
		<!-- 
			날짜 : 2022/10/13
			이름 : 라성준
			내용 : include 지시어
		 -->
<% 
	LocalDate today = LocalDate.now();  // 오늘 날짜
	LocalDateTime tomorrow = LocalDateTime.now().plusDays(1); // 내일 날짜
%>