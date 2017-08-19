<%@ page language="java" import="com.bean.User" contentType="text/html; charset=utf-8"
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
    <td width="30%" align="left"><h2><%=((User)session.getAttribute("goalUser")).getUser_nickname() %>的主页</h2></td>
    <td width="45%" align="right">
      <table border="0" align="right" cellpadding="0" cellspacing="0" id="daohang">
        <tr>
          <td width="130"><a href="followServlet">关注Ta</a></td>
          <td width="200"><a href="getFollowAndFanServlet">Ta关注的人/Ta的粉丝</a></td>
        </tr>
      </table>
    </td>
    <td width="30%" align="right">
    </td>
  </tr>
</table>
<hr/>
<!-- header结束-->
</body>
</html>