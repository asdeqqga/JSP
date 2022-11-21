<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<% 
String popupMode = "on";

Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie c : cookies) {
		String cookieName = c.getName();
		String cookieValue = c.getValue();
		if (cookieName.equals("PopupClose")) {
			popupMode = cookieValue;
		}
	}
}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쿠키를 이용한 팝업 관리</title>
		<!-- 
			날짜 : 2022/11/21
			이름 : 라성준
			내용 : 레이어 팝업창 관리(완성), P148
		 -->
		<style>
			div#popup {
				position: absolute;
				top:100px;
				left:100px;
				color:yellow;
				width:300px;
				height:100px;
				background-color:gray;
			}
			
			div#popup > div {
				position:relative;
				background-color:#ffffff;
				top:0px;
				border:1px solid gray;
				padding:10px;
				color:black;
			}

		</style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	
		<style>
			$(function(){
				$('#closeBtn').click(function(){
					$('#popup').hide();
					var chkVal = $("input:checkbox[id=inactiveToday]:checked").val();
					
					$.ajax({
						url : './PopupCookie.jsp',
						type : 'get',
						data : {inactiveToday : chkVal},
						dataType : "text",
						success : function(resData) {
							if (resData != '') location.reload();
						}
					});
				});
			});		
		</style>
	</head>
	<body>
		<h2>팝업 메인 페이지</h2>
		<%
			for(int i = 1; i <= 10; i++){
				out.print("현재 팝업창은 " + popupMode + " 상태입니다.<br/>");
			}
			if (popupMode.equals("on")){
		%>
		<div id= "popup">
			<h2 align="center">공지사항 팝업입니다.</h2>
			<div align="right"><form name="popFrm">
				<input type="button" value="닫기" id="closeBtn"/>
			</form></div>
		</div>
		<%
			}
		%>
	</body>
</html>