<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <jsp:include page="head.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

<div align="center">
	<form action="newBlogServlet" method="post">
		<textarea rows="10" cols="80" name="str"></textarea>
		<br/>
		<input type="submit" value="提交"/>
	</form>
</div>

</body>
</html>