<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="session" class="spms.vo.Member" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" type = "text/css" href="${pageContext.request.contextPath}/css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>

</script>

<title>메세지함</title>
</head>
<body>
<jsp:include page="/Header.jsp" />
	<h3>Message Box</h3>
	<c:forEach var="message" items="${messages}">
		----------------------------------------------<br>
		<a href='update?no=${message.no}'>
		보낸사람 : ${message.name}</a><br>
		제목 : ${message.title}<br>
		내용<br>${message.content}<br>
		보낸날자 : ${message.createdDate}<br>
		<form action="${pageContext.request.contextPath}/DeleteMessage" method="get">
			<input type="hidden" name="name" value="${message.name}">
			<input type="hidden" name="delno" value="${message.delno}">
			<input type="hidden" name="no" value="<%= member.getNo() %>">
		<input type="submit" value="메시지 삭제">
	</form>
		----------------------------------------------
		<br>
	</c:forEach>
</body>
</html>

