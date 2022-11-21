<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String chkval = request.getParameter("inactiveToday");

	if(chkval != null && chkval.equals("1")){
		Cookie cookie = new Cookie("PopupClose", "off"); // 쿠키생성
		cookie.setPath(request.getContextPath()); // 경로 설정
		cookie.setMaxAge(60 * 60 * 24); // 유지 기간 설정
		response.addCookie(cookie); 	// 응답 객체에 추가
		out.println("쿠키 : 하루 동안 열지 않음");
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쿠키를 생성해 응답 객체에 추가</title>
		<!-- 
			날짜 : 2022/11/21
			이름 : 라성준
			내용 : 쿠키를 생성해 응답 객체에 추가, P151
		 -->
	</head>
	<body>
		
	</body>
</html>