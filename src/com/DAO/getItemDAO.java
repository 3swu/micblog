package com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Item;
import com.bean.User;
import com.util.DbConnect;

public class getItemDAO {
	//取得对应用户发过的所有微博
	public ArrayList<Item> getItemByUser(User user){
		String sql = "Select * from item where item_userid=" + user.getUser_id();
		DbConnect dbconn = new DbConnect();
		ResultSet rs = dbconn.executeQuery(sql);
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			int rawNum = rs.getMetaData().getColumnCount();
			if(rawNum == 0)
				return null;
			
			while(rs.next()) {//组装item
				Item item = new Item();
				item.setItem_userid(rs.getInt("item_userid"));
				item.setItem_time(rs.getString("item_time"));
				item.setItem_str(rs.getString("item_str"));
				item.setItem_star(rs.getInt("item_star"));
				items.add(item);
			}
			return items;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}finally {
			dbconn.closeConnection();
		}
	}

}
