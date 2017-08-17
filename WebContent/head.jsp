<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
<!-- header开始-->
<table id="header" align="center" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="30%" align="left"><h2>micblog</h2></td>
    <td width="55%" align="right">
      <table border="0" align="right" cellpadding="0" cellspacing="0" id="daohang">
        <tr>
          <td width="30%"><a href="home.jsp?No=">关注</a></td>
          <td width="30%"><a href="friend.jsp">我的首页</a></td>

        </tr>
      </table>
    </td>
    <td width="30%" align="right">
      <table id="welcome" border="0" cellspacing="0" cellpadding="0">
        <tr>          
          <td>欢迎您，${u_nickname}</td>
        </tr>
        <tr>
          <td><a href="servlet/LogoutServlet">退出 </a></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<hr/>
<!-- header结束-->
</body>
</html>