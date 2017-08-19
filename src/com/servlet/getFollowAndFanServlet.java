package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.followDAO;
import com.bean.User;

public class getFollowAndFanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public getFollowAndFanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		ArrayList<User> follows = new followDAO().getFollows((User)session.getAttribute("goalUser"));
		ArrayList<User> fans = new followDAO().getFans((User)session.getAttribute("goalUser"));
		session.setAttribute("follows", follows);
		session.setAttribute("fans", fans);
		response.sendRedirect("followandfan.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
