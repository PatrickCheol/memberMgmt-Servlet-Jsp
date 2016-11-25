<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="session" class="spms.vo.Member" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

</head>
<body>
	<div class="container">
	<h3><span class="label label-default"><%=member.getName() %>님 안녕하세요</span></h3>
	<c:forEach var="member" items="${members}">
		
	</c:forEach>
	<h3><span class="label label-info">포인트 : <%= request.getAttribute("point")%></span></h3>
	     <div class="form-group">
	       <div class="col-sm-offset-0 col-sm-0">
	       <form class="form-horizontal" action="${pageContext.request.contextPath}/div_page/Main.jsp"  method="get">
	<button type="submit" class="btn btn-default" onclick="window.open('${pageContext.request.contextPath}/Viewmessage?no=<%=member.getNo()%>','name','resizeable=no scrollbars=es width=500 height=600')">쪽지보기</button>
	</form>
	<form class="form-horizontal" action="${pageContext.request.contextPath}/auth/logout"  method="get">
	    <button type="submit" class="btn btn-default">로그아웃</button>
	    </form>
	    </div>
	    </div>
	    </div>
</body>
</html>

