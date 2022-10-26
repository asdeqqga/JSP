<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>3_page 지시어 - errorPage, isErrorPage 속성</title>
		<!-- 
			날짜 : 2022/10/11
			이름 : 라성준
			내용 : JSP 에러 발생 페이지 실습하기
			P67
		 -->
	</head>
	<body>
		<%
		int myAge = Integer.parseInt(request.getParameter("age")) + 10; // 에러 발생
		out.println("10년 후 당신의 나이는 " + myAge + "입니다."); // 실행되지 않음
		%>
	</body>
</html>