package com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DbConnect;

public class showBlogDAO {
	public int getIdByNickname(String nickname) {
		String sql = "select * from user where user_nickname='" + nickname + "'";
		DbConnect dbconn = new DbConnect();
		ResultSet rs = dbconn.executeQuery(sql);
		
		try {
			if(rs.next()) {
				return rs.getInt("user_id");
			}
			return -1;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return -1;
		}finally{
			dbconn.closeConnection();
		}
	}
}
