<%@ page language="java" import="com.bean.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录成功</title>
</head>
<body>
<h1 align="center">登陆成功</h1>
<%
User user = new User();
user = (User)session.getAttribute("user");
%>
欢迎: <%=user.getUser_nickname() %><br/>
</body>
</html>