<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel = "stylesheet" type = "text/css" href="${pageContext.request.contextPath}/css/login.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(document).ready(function() {
		$.get("${pageContext.request.contextPath}/LoginForm", 
			{
			}, function(data) {
			$('#login_form').html(data);
		});
	});

	
	function validateEmail($email) {
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		return emailReg.test($email);
	}
	
	function Submit() {
		var email_id = $("#email_id").val();
		if (validateEmail(email_id)) {
			document.login.action="${pageContext.request.contextPath}/auth/login";
			
		}
		else{
			alert("Worng Email form");
			document.login.action="${pageContext.request.contextPath}/auth/login"
		}
		login.submit();
		//return true;
		
	}
	
</script>

<title>로그인</title>
</head>
<body>
<div class = "wrap">
	<div class = "header">
		<p>Advanced Web Programming</p>
	</div>
	<div class = "contents">
	<marquee>고급 웹프로그래밍 4조 홈페이지</marquee>
		<div class="main_img">
    		<img src="http://cphoto.asiae.co.kr/listimglink/6/2014102910452844272_2.jpg" width="800px" /></div>
		<div id = 'login_form'></div>
	</div>
</div>
</body>
</html>