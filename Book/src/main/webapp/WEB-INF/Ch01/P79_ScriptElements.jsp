<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%! 
	public int add(int num1, int num2) {
	return num1 + num2;
}
	int result = add(10 ,20);

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>스크립트 요소</title>
		<!-- 
			날짜 : 2022/10/13
			이름 : 라성준
			내용 : 스크립트 요소
		 -->
	</head>
	<body>
		덧셈 결과 1 : <%= result %><br/>   
		덧셈 결과 2 : <%= add(30, 40) %> 
		
	</body>
</html>