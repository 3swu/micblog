package com.DAO;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.bean.*;

public class itemSortDAO implements Comparator<Object>{
	//将微博按发布时间倒序排序
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Item item1 = (Item)o1;
		Item item2 = (Item)o2;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1,d2;
		try {
			d1 = format.parse(item1.getItem_time());
			d2 = format.parse(item2.getItem_time());
		}catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
		if(d1.before(d2))
			return 1;
		else
			return -1;
	}

}
