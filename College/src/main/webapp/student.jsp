<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="bean.StudentBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="config.DBCP"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	List<StudentBean> students = new ArrayList<>();
	try{
		Connection conn =  DBCP.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from `student`");
		
		while(rs.next()){
			StudentBean sb = new StudentBean();
			sb.setStdNo(rs.getString(1));
			sb.setStdName(rs.getString(2));
			sb.setStdHp(rs.getString(3));
			sb.setStdYear(rs.getInt(4));
			sb.setStdAddress(rs.getString(5));
			
			students.add(sb);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script>
			
			$(function)(){
				
				$('btnOrder').click(function(){
					$('section').show();
					alert('클릭!');
				});
				
				$('.btnClose').click(function() {
					$('section').hide();
				});
				
				$('input[type=submit]').click(function(){
					
					let StdNo = $('input[name=StdNo]').val();
					let StdName = $('input[name=StdName]').val();
					let StdHp = $('input[name=StdHp]').val();
					let StdYear = $('input[name=StdYear]').val();
					let StdAddress = $('input[name=StdNAddress]').val();
					
					let jsonData ={
							"StdNo":StdNo,
							"StdName":StdName,
							"stdHp":StdHp,
							"StdYear":StdYear,
							"StdAddress":StdAddress
					};
					
					//콘솔 로그
					console.log(jsonData);
					
					$.post('./studentProc.jsp', jsonData, function(data){
						
						if(data.result > 0){
							alert('등록완료!');
							
							let tr "<tr>";
								tr += "<td>"+data.StdNo+"</td>";
								tr += "<td>"+data.StdName+"</td>";
								tr += "<td>"+data.StdHp+"</td>";
								tr += "<td>"+data.StdYear+"</td>";
								tr += "<td>"+data.StdAddress+"</td>";
								tr += "</tr>";
								
								$('#stdList').append(tr);
								
						}else{
							alert('등록실패!');
						}
					});
				});
			});
		
		
		</script>
	
	</head>
	<body>
		<h3>학생목록</h3>
		<a href="#">강좌관리</a>
		<a href="#">수강관리</a>
		<a href="#">학생관리</a>
		
		<h4>::</h4>
		<button class="btnOrder">등록</button>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>강좌명</th>
				<th>학점</th>
				<th>시간</th>
				<th>강의장</th>
			</tr>
			<% for(StudentBean sb : students){%>
			<tr>
				<td><%= sb.getStdNo() %></td>
				<td><%= sb.getStdName() %></td>
				<td><%= sb.getStdHp() %></td>
				<td><%= sb.getStdYear() %></td>
				<td><%= sb.getStdAddress() %></td>
			</tr>
			<% } %>
		</table>
		
		<section style="display:none;">
			<h4>강좌등록</h4>			
			<table border="1">
				<tr>
					<td>번호</td>
					<td><input type="text" name="stdNo"/></td>
				</tr>
				<tr>
					<td>강좌명</td>
					<td><input type="text" name="stdName"/></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="text" name="stdHp"/></td>
				</tr>
				<tr>
					<td>날짜</td>
					<td><input type="text" name="stdYear"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="stdAddress"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="추가"/></td>
				</tr>
			</table>
			<button class="btnClose">닫기</button>
		</section>
	</body>
</html>