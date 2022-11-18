<%@page import="common.Person"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
		<!-- 
			날짜 : 2022/11/09
			이름 : 라성준
			내용 : PageContextMain.jsp에 포함시킬 JSP 문서 ,P121
		 -->
<h4>Include 페이지</h4>
<%
	int pInteger2 = (Integer)(pageContext.getAttribute("pageInteger"));
	// String pString2 = pageContext.getAttributd("pageString").toString();
	Person pPerson2 = (Person)(pageContext.getAttribute("pagePerson"));
%>
<ul>
	<li>Integer 객체 : <%= pInteger2 %></li>
	<li>String 객체 : <%= pageContext.getAttribute("pageString") %></li>
	<li>Person 객체 : <%= pPerson2.getName() %>,<%= pPerson2.getAge() %></li>
</ul>








	