<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
	날짜 : 2022/11/22
	이름 : 라성준
	내용 : 세션 설정값 확인, P212
 -->
<%
// 날짜 표시 형식
SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss"); 

// 최초 요청(세션 생성) 시각
long creationTime = session.getCreationTime();
String creationTimeStr = dateFormat.format(new Date(creationTime));

// 마지막 요청 시각
long lastTime = session.getLastAccessedTime();
String lastTimeStr = dateFormat.format(new Date(lastTime));
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Session 설정 확인</title>
	</head>
<body>
	<h2>Session 설정 확인</h2>
	<ul>
		<li>세션 유지 기간 : <%= session.getMaxInactiveInterval() %></li>
		<li>세션 아이디 : <%= session.getId() %></li>
		<li>최초 요청 시각 : <%= creationTimeStr %></li>
		<li>마지막 요청 시각 : <%= lastTimeStr %></li>
	</ul>
</body>
</html>