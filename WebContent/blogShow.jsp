<%@ page language="java" import="com.bean.Item,java.util.ArrayList,com.DAO.*,com.bean.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    
    ArrayList<Item> items = (ArrayList<Item>)session.getAttribute("items");
    for( Item item:items){
    	User user = new User();
    	user.setUser_id(item.getItem_userid());
    	loginDAO logindao = new loginDAO();
    	out.println("<div align=\"center\">");
    	out.println("<table>");
    	out.println("<tr>");
    	out.println("<td width=\"300\" height=\"40\">" + logindao.getNickname(user) + "</td>");
    	out.println("<td width=\"300\">"+ item.getItem_time() +"</td>");
    	out.println("<tr/>");
    	out.println("<tr>");
    	out.println("<td height=\"200\" colspan=\"2\">"+ item.getItem_str() +"</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td height=\"40\">赞:"+ item.getItem_star() +"</td>");
    	out.println("<td>查看评论</td>");
    	out.println("</tr>");
    	out.println("</table>");
    	out.println("</div>");
    }
    
    %>
