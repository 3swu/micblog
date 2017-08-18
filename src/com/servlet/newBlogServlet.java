package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.addItemDAO;
import com.bean.Item;
import com.bean.User;

public class newBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public newBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Item item = new Item();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		item.setItem_userid(user.getUser_id());
		String str = new String(request.getParameter("str").getBytes("ISO-8859-1"),"utf-8");
		//item.setItem_str(request.getParameter("str"));
		item.setItem_str(str);
		addItemDAO newItem = new addItemDAO();
		if(newItem.addItem(item)) {
			response.sendRedirect("getSelfItemServlet");
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<a href=\"newBlog.jsp\"> ß∞‹£¨«Î÷ÿ ‘</a>");
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
