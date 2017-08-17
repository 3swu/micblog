package com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bean.Item;
import com.util.*;

public class addItemDAO {

	 //发微博
	public boolean addItem(Item item) {
		String sql = "insert into item (item_userid,item_time,item_str) values ('"
				+ item.getItem_userid()
				+ "','" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
				+ "','" + item.getItem_str()
				+ "')";
		
		DbConnect dbconn = new DbConnect();
		dbconn.executeOther(sql);
		sql = "select * from item where item_str='" + item.getItem_str() + "'";
		ResultSet rs = dbconn.executeQuery(sql);
		try {
			if(rs.next())
				return true;//写入成功，返回true
			return false;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}finally {
			dbconn.closeConnection();
		}
	}
}
