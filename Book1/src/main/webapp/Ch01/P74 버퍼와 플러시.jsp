<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
 buffer="1kb" autoFlush="false"%>  	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>page 지시어 - buffer, autoFlush 속성</title>
		<!-- 
			날짜 : 2022/10/13
			이름 : 라성준
			내용 : 버퍼와 플러시 실습하기
		 -->
	</head>
	<body>
		<%
			for(int i = 1; i <= 100; i++) { 	//버퍼 채우기
				out.println("abcde12345");
			}
		%>
	</body>
</html>