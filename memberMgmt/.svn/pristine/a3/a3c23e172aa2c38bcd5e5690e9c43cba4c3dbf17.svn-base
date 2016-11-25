<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="member" scope="session" class="spms.vo.Member" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<title>회원 목록</title>
<script>
////////////////////////////////////////////////////
	$(document).ready(function() {
		$.get("${pageContext.request.contextPath}/Memberinfo", 
			{
			}, function(data) {
			$('#member_info').html(data);
		});
	})
/////////////////////////////////////////////////////전체 회원 이름 불러오기


///////////////////////////////////////////////////////////////////////	
	function message()
	{
		var nameValue = $('#name').val();
		alert(nameValue);
		$.get("${pageContext.request.contextPath}/Message", 
			{
				name : nameValue
			}, function(data) {
			$('#testDivId').html(data);
		});
	}
/////////////////////////////////////////////////////////////////////////메시지 서블릿 불러오기
</script>
</head>
<body>
	<jsp:include page="/Header.jsp" />

	<h1>회원목록2</h1>
	<p>
		<a href='add'>신규 회원</a>
	</p>
	<c:forEach var="member" items="${members}">  ${member.no}, 
		<a href='update?no=${member.no}'>${member.name}</a>,
		${member.email}, ${member.createdDate}, ${member.sex}, ${member.pnum}, ${member.hobby}, ${member.age}
		<a href='delete?no=${member.no}'>[삭제]</a>
		<br>
	</c:forEach>
	<form action="${pageContext.request.contextPath}/member/list" method="get">
		<input type="submit" value="쪽지함 보기" onclick="window.open('Viewmessage?no=<%=member.getNo()%>','name','resizeable=no scrollbars=es width=500 height=600')">
	</form>
	
	<div id = 'member_info'></div>
	<jsp:include page="/Tail.jsp" />
	
	
</body>
</html>