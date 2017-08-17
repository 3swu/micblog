package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.followDAO;
import com.DAO.getItemDAO;
import com.DAO.itemSortDAO;
import com.bean.Item;
import com.bean.User;

public class getFollowItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public getFollowItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		ArrayList<User> followUsers = new followDAO().getFollows(user);
		ArrayList<Item> items = new ArrayList<Item>();
		
		for(User followUser : followUsers) {
			ArrayList<Item> everyFollowItems = new getItemDAO().getItemByUser(followUser);
			for(Item everyFollowItem : everyFollowItems) {
				items.add(everyFollowItem);
			}
		}
		//≈≈–Ú
		itemSortDAO sortDAO = new itemSortDAO();
		Collections.sort(items, sortDAO);
		session.setAttribute("items", items);
		request.getRequestDispatcher("followBlog.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
