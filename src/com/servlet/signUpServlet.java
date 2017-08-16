package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.DAO.signUpDAO;

public class signUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public signUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		User user = new User();
		user.setUser_username(request.getParameter("username"));
		user.setUser_nickname(request.getParameter("nickname"));
		user.setUser_password(request.getParameter("password"));
		
		signUpDAO signup = new signUpDAO();
		PrintWriter out = response.getWriter();
		if(signup.checkNickname(user)) {
			if(signup.insertUser(user)) {
				out.println("<a href=\"login.jsp\">◊¢≤·≥…π¶£¨∑µªÿµ«¬º£°</a>");
			}
			else {
				out.println("<a href=\"signup.jsp\">◊¢≤· ß∞‹£¨«Î÷ÿ ‘£°</a>");
			}
		}
		else {
			out.println("<a href=\"signup.jsp\">Í«≥∆“—¥Ê‘⁄£¨«Î÷ÿ ‘£°</a>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
