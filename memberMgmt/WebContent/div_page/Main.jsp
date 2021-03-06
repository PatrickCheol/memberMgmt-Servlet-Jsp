<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel = "stylesheet" type = "text/css" href="${pageContext.request.contextPath}/css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$(document).ready(function() {
	$.get("${pageContext.request.contextPath}/Memberinfo", 
		{
		}, function(data) {
		$('#member_info').html(data);
	});
	$.get("${pageContext.request.contextPath}/Myinfo", 
			{
			}, function(data) {
			$('#Myinfo').html(data);
		});
	$.get("${pageContext.request.contextPath}/PointRank", 
			{
			}, function(data) {
			$('#Point_rank').html(data);
		});
	$.get("${pageContext.request.contextPath}/BoardWrite", 
			{
			}, function(data) {
			$('#Board_Write').html(data);
		});
	$.get("${pageContext.request.contextPath}/Boardlist", 
			{
			}, function(data) {
			$('#Board_List').html(data);
		});
})
</script>

<title>Welcome</title>
</head>
<body>
<div class = "wrap">
	<div class="header">
	<div class="container">
		<h1><span class="label label-success">Advanced Web Programming</span><small><span class="label label-info">4조</span></small></h1>
	</div>
	</div>
	
	<div class = "sector">
		<div id = 'Myinfo'></div>
		<div id = 'Point_rank'></div>
		<div id = 'member_info'>맴버리스트</div>
	</div>
	<div class = "contents">
		<div id = 'Board_Write'></div>
		<div id = 'Board_List'></div>
	</div>
</div>
</body>
</html>