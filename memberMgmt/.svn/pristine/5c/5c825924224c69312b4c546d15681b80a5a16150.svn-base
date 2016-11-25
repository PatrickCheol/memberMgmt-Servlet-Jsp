<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

<div id = "view_member_info">
	<p>가입한 맴버 현황</p>
	<c:forEach var="member" items="${members}">
	
	<a href="#" onclick="window.open('${pageContext.request.contextPath}/Viewinfo?no=${member.no}','name','resizeable=no scrollbars=es width=500 height=600')">${member.getName()}</a>
	<br>
</c:forEach>
</div>