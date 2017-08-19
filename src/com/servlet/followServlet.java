package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.followDAO;
import com.bean.User;

public class followServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public followServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		User goalUser = (User)session.getAttribute("goalUser");
		followDAO followdao = new followDAO();
		if(followdao.checkIsFollowed(user, goalUser)) {
			out.println("<a href=\"getSelfItemServlet\">你已经关注该用户！</a>");
		}
		else {
			if(followdao.follow(user, goalUser)) {
				out.println("<a href=\"getSelfItemServlet\">关注成功！</a>");//TODO
			}
			else {
				out.println("<a href=\"getSelfItemServlet\">关注失败！</a>");//TODO
			}
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
