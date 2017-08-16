package com.util;

import java.sql.*;

public class DbConnect {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	//连接数据库
	public void getConnection() {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://192.168.1.2/micblog";
		final String USER = "root";
		final String PASS = "wulei123";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//执行查询语句，传入SQL语句
	public ResultSet executeQuery(String sql) {
		getConnection();//获取数据库连接
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			return rs;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	//专门用于执行增删改操作
	public void executeOther(String sql) {
		getConnection();//获取数据库连接
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		if(stmt != null) {
			try {
				stmt.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
