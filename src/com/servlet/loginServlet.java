package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.*;
import com.DAO.loginDAO;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		User user = new User();
		user.setUser_username(request.getParameter("username"));
		user.setUser_password(request.getParameter("password"));
		
		loginDAO logindao = new loginDAO();
		int loginFlag = logindao.checkUser(user);
		
		if(loginFlag != -1) {
			user.setUser_id(loginFlag);
			user.setUser_nickname(logindao.getNickname(user));
			//ต๗สิ
			//System.out.println("nickname:" + user.getUser_nickname());
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			//request.getRequestDispatcher("loginSuccessTest.jsp").forward(request, response);
			response.sendRedirect("getFollowItemServlet");
		}
		else {
			request.getRequestDispatcher("loginErrorTest.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
