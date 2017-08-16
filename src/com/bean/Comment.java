package com.bean;

public class Comment {
	private int comment_id;
	private int comment_itemid;
	private int comment_userid;
	private String comment_time;
	private String comment_str;
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getComment_itemid() {
		return comment_itemid;
	}
	public void setComment_itemid(int comment_itemid) {
		this.comment_itemid = comment_itemid;
	}
	public int getComment_userid() {
		return comment_userid;
	}
	public void setComment_userid(int comment_userid) {
		this.comment_userid = comment_userid;
	}
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	public String getComment_str() {
		return comment_str;
	}
	public void setComment_str(String comment_str) {
		this.comment_str = comment_str;
	}
	
}
