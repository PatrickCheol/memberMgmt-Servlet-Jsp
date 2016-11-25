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
	alert("글을 등록했습니다.");
}
</script>

<title>로그인</title>
</head>
<body>
		<h3><span class="label label-default">타임라인</span></h3>
		<div class="container">
		   <div class="form-group" >
		     <form class="form-horizontal" action="${pageContext.request.contextPath}/BoardWrite"  method="post">
		     <label for="comment">Comment:</label><br>
		     <div class="col-lg-8">
		     <textarea class="form-control" rows="4" id="comment" name ="text" cols="10"></textarea>
		     <input type="hidden" name="name" value="<%=member.getName()%>">
		     <div class="form-group">
		       <div class="col-sm-offset-5 col-sm-4">
		         <button type="submit" class="btn btn-default" onclick="message()" >POST</button>
		        </div>
		      </div>
		      </div>
		    </form>
		  </div>
		</div>
</body>
</html>