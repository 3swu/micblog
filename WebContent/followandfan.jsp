<%@ page language="java" import="com.bean.*,java.util.ArrayList" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <jsp:include page="head.jsp" />
    <jsp:include page="head2.jsp" />
<% 
ArrayList<User> follows = (ArrayList<User>)session.getAttribute("follows");
ArrayList<User> fans = (ArrayList<User>)session.getAttribute("fans");
out.println("<h2>关注的人</h2></br>");
for(User followUser : follows){
	String nickname = followUser.getUser_nickname();
	out.println("<a href=\"getUserItemServlet?nickname="+nickname +"\">"+nickname + "</a>&nbsp;&nbsp;&nbsp;&nbsp;");
}
out.println("<hr/>");
out.println("<h2>粉丝</h2></br>");
for(User fanUser : fans){
	String nickname = fanUser.getUser_nickname();
	out.println("<a href=\"getUserItemServlet?nickname="+nickname +"\">"+nickname + "</a>&nbsp;&nbsp;&nbsp;&nbsp;");
}
%>