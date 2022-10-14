<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="P76_IncludeFile.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>include 지시어</title>
		<!-- 
			날짜 : 2022/10/13
			이름 : 라성준
			내용 : include 지시어
		 -->
	</head>
	<body>
		<%
			out.println("오늘 날짜 : " + today);
			out.println("<br/>");
			out.println("내일 날짜 : " + tomorrow);		
		%>
	</body>
</html>