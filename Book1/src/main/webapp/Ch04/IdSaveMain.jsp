<%@page import="utils.CookieManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
	<!-- 
		날짜 : 2022/111/21
		이름 : 라성준
		내용 : 로그인 페이지 ,P159
 	-->
 <%
 	String loginId = CookieManager.readCookie(request, "loginId");
 
 	String cookieCheck = "";
 	if (!loginId.equals("")) {
 		cookieCheck = "checked";
 	}
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cookie - 아이디 저장하기</title>
	</head>
	<body>
		<h2>로그인 페이지</h2>
		<form action="IdSaveProcess.jsp" method="post">
			<!-- 쿠키값이 있을경우 아이디 창에 아이디를 자동으로 입력하고
				 아이디 저장하기에 자동 체크 -->
			아이디 : <input type="text" name="user_id" value="<%= loginId %>"/>
				<input type="checkbox" name="save_check" value="Y" <%= cookieCheck %>/>
				아이디 저장하기
			<br>
			패스워드 : <input type="text" name="user_pw">
			<br>
			<input type="submit" value="로그인하기">
		</form>
	</body>
</html>