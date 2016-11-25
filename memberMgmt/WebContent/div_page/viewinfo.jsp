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
function message()
{
	alert("쪽지를 보냈습니다.");
	
}
</script>

<title>회원정보</title>
</head>
<body>
	<p>
		<h1>회원정보</h1>
		이름: ${member.name}<br>
		이메일: ${member.email}<br>
		전화번호 : ${member.pnum}<br>
		성별 : ${member.sex}<br>
		취미 : ${member.hobby}<br>
		나이 : ${member.age}<br>
		가입일: ${member.createdDate}<br>
		<h3>쪽지 보내기</h3>
		<form action="${pageContext.request.contextPath}/message"  method="post">
		제목 : <input type="text" name="title"><br>
		내용<br>
		<textarea cols="60" rows="13" name="content"></textarea>
		<input type="hidden" name="no" value="${member.no}">
		<input type="hidden" name="name" value="<%=member.getName()%>">
		<input type ="submit" value ="쪽지 전송" onclick="message()" >
		</form>
</body>
</html>

