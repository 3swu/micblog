package com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.*;
import com.util.DbConnect;

public class loginDAO {

	//登录验证
	public int checkUser(User user) {
		String sql = "select * from user where user_username='"
				+ user.getUser_username() +"' and user_password='"
				+ user.getUser_password() +"'";
		//System.out.println("SQL: " + sql);//输出SQL语句，调试使用
		DbConnect dbconn = new DbConnect();
		ResultSet rs = dbconn.executeQuery(sql);
		
//		try {
//			rs.next();
//			//登录成功，返回用户ID
//			return rs.getInt("user_id");
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//			//System.out.println("login error");
//			return -1;
//		}finally {
//			dbconn.closeConnection();
//		}
//		
		try {
			if(rs.next())
				return rs.getInt("user_id");
			return -1;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return -1;
		}finally {
			dbconn.closeConnection();
		}
	}
	
	public String getNickname(User user) {
		String sql = "select * from user where user_id='" + user.getUser_id() + "'";
		//System.out.println("SQL: " + sql);
		DbConnect dbconn = new DbConnect();
		ResultSet rs = dbconn.executeQuery(sql);
		
		try {
			rs.next();
			return rs.getString("user_nickname");
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}finally {
			dbconn.closeConnection();
		}
	}
}
