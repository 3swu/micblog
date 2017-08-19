package com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.User;
import com.util.*;
import com.DAO.loginDAO;

public class followDAO {
	//检查是否已经关注
	public boolean checkIsFollowed(User user,User followUser) {
		if(user.getUser_id() == followUser.getUser_id())
			return true;
		
		DbConnect dbconn = new DbConnect();
		String sql = "select * from follow where follow_userid='" + user.getUser_id()
						+ "' and follow_followuserid='" + followUser.getUser_id() + "'";
		
		ResultSet rs = dbconn.executeQuery(sql);
		try {
			if(rs.next()) {
				//已经关注,返回true
				return true;
			}else {
				return false;
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
			return true;
		}finally {
			dbconn.closeConnection();
		}
	}
	
	public boolean follow(User user,User followUser) {
		DbConnect dbconn = new DbConnect();
		String sql = "insert into follow (follow_userid,follow_followuserid) values ("+
					user.getUser_id() + "," + followUser.getUser_id() +")";
		
		dbconn.executeOther(sql);
		dbconn.closeConnection();
		//检查是否添加成功
		if(checkIsFollowed(user,followUser))
			return true;//关注成功
		return false;//关注不成功
				
	}
	
	public ArrayList<User> getFollows(User user) {
//		User[] users = null;
//		DbConnect dbconn = new DbConnect();
//		String sql = "select * from follow where follow_userid=" + user.getUser_id();
//		ResultSet rs = dbconn.executeQuery(sql);
//		try {
//			int rawNum = rs.getMetaData().getColumnCount();//获取该用户关注的用户数
//			users = new User[rawNum];
//			int i=0;
//			while(rs.next()) {//封装被关注的用户数组
//				users[i].setUser_id(rs.getInt("follow_followuserid"));
//				users[i].setUser_nickname(new loginDAO().getNickname(user));
//				i++;
//			}
//			return users;
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//			return null;
//		}
		ArrayList<User> users = new ArrayList<User>();
		DbConnect dbconn = new DbConnect();
		String sql = "select * from follow where follow_userid=" + user.getUser_id();
		ResultSet rs = dbconn.executeQuery(sql);
		try {
			if(rs.getMetaData().getColumnCount() == 0)
				return null;
			while(rs.next()) {
				User u = new User();
				u.setUser_id(rs.getInt("follow_followuserid"));
				u.setUser_nickname(new loginDAO().getNickname(u));
				users.add(u);
			}
			return users;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}finally {
			dbconn.closeConnection();
		}
	}
	
	public ArrayList<User> getFans(User user){
		ArrayList<User> users = new ArrayList<User>();
		DbConnect dbconn = new DbConnect();
		String sql = "select * from follow where follow_followuserid=" + user.getUser_id();
		ResultSet rs = dbconn.executeQuery(sql);
		try {
			if(rs.getMetaData().getColumnCount() == 0)
				return null;
			while(rs.next()) {
				User u = new User();
				u.setUser_id(rs.getInt("follow_userid"));
				u.setUser_nickname(new loginDAO().getNickname(u));
				users.add(u);
			}
			return users;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}finally {
			dbconn.closeConnection();
		}
	}
}
