package com.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bean.User;
import com.util.*;
import com.DAO.loginDAO;

public class signUpDAO {
	
	//����ǳ��Ƿ��Ѿ�����
	public boolean checkNickname(User user) {
		String sql = "select * from user where user_nickname='" + user.getUser_nickname() + "'";

		DbConnect dbconn = new DbConnect();
		ResultSet rs = dbconn.executeQuery(sql);
//		try {
//			System.out.println(rs.getString("user_nickname"));
//			rs.next();
//			//System.out.println("nickname existed");
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//			return true;
//		}finally {
//			dbconn.closeConnection();
//		}
//		return false;//�ǳƴ��ڣ�����false
		try {
			if(!rs.next())
				return true;
			return false;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}finally {
			dbconn.closeConnection();
		}
	}
	
	public boolean insertUser(User user) {
		String sql = "insert into user (user_username,user_nickname,user_password,user_regtime)"
				+ "values ('" + user.getUser_username() + "','"
				+ user.getUser_nickname() + "','"
				+ user.getUser_password() + "','"
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
				+ "')";
		
		DbConnect dbconn = new DbConnect();
		dbconn.executeOther(sql);
		dbconn.closeConnection();
		
		//��loginDAO���еķ���������û��Ƿ���ӳɹ�
		loginDAO logindao = new loginDAO();
		int checkUserFlag = logindao.checkUser(user);
		if(checkUserFlag != -1) {
			user.setUser_id(checkUserFlag);
			return true;
		}
		else {
			return false;
		}
	}
}
