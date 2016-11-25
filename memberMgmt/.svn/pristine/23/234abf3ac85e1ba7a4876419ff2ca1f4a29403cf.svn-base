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

</head>
<body>
<div class="container">
   <div class="form-group">
     <label for="comment">   방명록:</label><br>
     <c:forEach begin="0" end="5" var="board" items="${boards}">
	<div class="col-lg-8">
<textarea class="form-control" rows="5" id="comment" name ="content" readonly>
글쓴이  : ${board.name}      작성날짜 : ${board.createdDate}

${board.text}
</textarea>
	<div class="form-group">
        <div class="col-sm-offset-0 col-sm-0">
			<form action="${pageContext.request.contextPath}/DeleteList" method="get">
			<input type="hidden" name="name" value="${board.name}">
			<input type="hidden" name="no" value="${board.no}">
			<input type="hidden" name="mem_name" value=<%= member.getName() %>>
			  <button type="submit" class="btn btn-default">글 삭제</button>
 			</form>
  		</div>
    </div>
</div>
	</c:forEach>
    </div>
<br>

</div>

</body>
</html>

