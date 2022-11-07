<%@page import="bean.RegisterBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="config.DBCP"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	List<RegisterBean> registers = new ArrayList<>();

	try{
		Connection conn = DBCP.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from `register`");
		
		while(rs.next()){
			RegisterBean rb = new RegisterBean();
			rb.setRegStdNo(rs.getString(1));
			rb.setRegLecNo(rs.getNString(2));
			rb.setRegMidScore(rs.getInt(3));
			rb.setRegFinalScore(rs.getInt(4));
			rb.setRegTotalScore(rs.getInt(5));
			rb.setRegGrade(rs.getString(6));
			
			registers.add(rb);
			
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
		$(function(){
			
			$('.btnOrder').click(function(){					
				$('section').show();
				//alert('aedfsad');
			});
			
			$('.btnClose').click(function(){
				$('section').hide();
			});
			
			$('input[type=submit]').click(function(){

				let regStdNo     = $('input[name=regStdNo]').val();
				let regLecNo   = $('input[name=regLecNo]').val();
				let regMidScore = $('input[name=regMidScore]').val();
				let regFinalScore   = $('input[name=regFinalScore]').val();
				let regTotalScore  = $('input[name=regTotalScore]').val();
				let regGrade  = $('input[name=regGrade]').val();
				
				let jsonData = {
					"regStdNo":regStdNo,
					"regLecNo":regLecNo,
					"regMidScore":regMidScore,
					"regFinalScore":regFinalScore,
					"regTotalScore":regTotalScore,
					"regGrade":regGrade,
				};
				
				//콘솔 로그 
				console.log(jsonData);
				
				$.post('./lectureProc.jsp', jsonData, function(data){
					
					if(data.result > 0){
						alert('등록완료!');
						
						let tr = "<tr>";
							tr += "<td>"+data.regStdNo+"</td>";
							tr += "<td>"+data.regLecNo+"</td>";
							tr += "<td>"+data.regMidScore+"</td>";
							tr += "<td>"+data.regFinalScore+"</td>";
							tr += "<td>"+data.regTotalScore+"</td>";
							tr += "<td>"+data.regGrade+"</td>";
							tr += "</tr>";
						
						$('#lecList').append(tr);
						
						
						
					}else{
						alert('등록실패!');
					}
					
				});
			});
		});
		
		</script>
	</head>
	<body>
		<h3>수강관리</h3>
		<a href="#">강좌관리</a>
		<a href="#">수강관리</a>
		<a href="#">학생관리</a>
		
		<h4>수강신청</h4>
		<table border="1">
				<td><button class="btnOrder" value="">수강신청</button></td>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>강좌명</th>
				<th>강좌코드</th>
				<th>중간시험</th>
				<th>기말시험</th>
				<th>총점</th>
				<th>등급</th>
			
			</tr>
			<% for(RegisterBean rb : registers){ %>
			<tr>
				<td><%= rb.getRegStdNo() %></td>
				<td><%= rb.getRegLecNo()%></td>
				<td><%= rb.getRegMidScore()%></td>
				<td><%= rb.getRegFinalScore()%></td>
				<td><%= rb.getRegTotalScore()%></td>
				<td><%= rb.getRegGrade()%></td>
				<td><%= %></td>		
			</tr>
			<% } %>
			
		</table>
		
		<section style="display:none;">
			<h4>강좌등록</h4>			
			<table border="1">
				<tr>
					<td>학번</td>
					<td><input type="text" name="regStdNo"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="regLecNo"/></td>
				</tr>
				<tr>
					<td>강좌명</td>
					<td><input type="text" name="regMidScore"/></td>
				</tr>
				<tr>
					<td>시간</td>
					<td><input type="text" name="regFinalScore"/></td>
				</tr>
				<tr>
					<td>강의장</td>
					<td><input type="text" name="regTotalScore"/></td>
				</tr>
				<tr>
					<td>강의장</td>
					<td><input type="text" name="regGrade"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="추가"/></td>
				</tr>
			</table>
			<button class="btnClose">닫기</button>
		</section>
	</body>
</html>