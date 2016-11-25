<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.regex.Pattern"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" type = "text/css" href="./css/main.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		// Newly Added By STKIM for checking email validation when Enter Key is pressed. 
		$("#email_id").keydown(function(event) {

			if (event.keyCode == 13) {
				var emailId = $("#email_id").val();
				alert("entered!:" + emailId);

				if (!validateEmail(emailId)) {
					alert("email is not valid");
					// TODO: Move Cursor into "email_id"
				}
			}
		})
	});

	// Newly Added By STKIM
	function validateEmail($email) {
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		return emailReg.test($email);
	}
	
	function processLogin() {
		alert("processLogin");
		$.post('auth/login', 
			{
				email_id : $("#email_id").val(),
				password : $("#password_id").val()
			}, 
			function(data,status) 
			{	
				if(status=="success"){
					alert("processLogin");
				}
				$("#msg").html(data);
			});
	}
</script>



<title>로그인</title>
</head>
<body>
	<!--  Old Code -->
	<!-- <form action="login" method="post">
		이메일: <input type="text" name="email" id="email_id"><br>
		암호: <input type="password" name="password"><br> 
		     <input type="submit" value="로그인">
		</form>
	-->

	<!--  New Code -->
	
	<!--<form action="javascript:processLogin();" method="post" id="login_form">
		이메일: <input type="text" name="email" id="email_id"><br>
		암호: <input type="password" name="password" id="password_id"><br>
		<input type="submit" value="로그인">
	</form>
	<div id="msg"></div>  -->
<div class = "wrap">
	<div class = "header">
		<p>Advanced Web Programming</p>
	</div>
	<div class = "contents">
		<div class ="main_img">
			<img src="http://cphoto.asiae.co.kr/listimglink/6/2014102910452844272_2.jpg" width="800px" />
		</div>
		<div class = "login_menu">
			<form action="javascript:processLogin();" method="post" id="login_form">
			<br/>
			이메일: <input type="text" name="email" id="email_id" size="10"><br><br/>
			&nbsp&nbsp&nbsp암호: <input type="password" name="password" size="11"><br><br/>
		    <input type="submit" value="로그인">
		    <input type="submit" value="회원가입">
			</form>
		</div>
	</div>
</div>
</body>
</html>