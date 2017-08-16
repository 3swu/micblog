<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
</head>
<body>
<div align="center">
<h1>用户注册</h1>
<a href="login.jsp">已有账号？登录</a>
</div>
<hr/>
<div align="center">
<form action="signUpServlet" method="post">
<table>
<tr>
<td>用户名：</td>
<td><input type="text" name ="username"/></td>
</tr>
<tr>
<td>昵称：</td>
<td><input type="text" name="nickname"/></td>
</tr>
<tr>
<td>密码：</td>
<td><input type="password" name ="password"/></td>
</tr>
<tr>
<td colspan="2" align ="center"><input type="submit" value="注册"/></td>
</tr>
</table>
</form>
</div>
</body>
</html>