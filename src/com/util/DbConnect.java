package com.util;

import java.sql.*;

public class DbConnect {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	//�������ݿ�
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
	
	//ִ�в�ѯ��䣬����SQL���
	public ResultSet executeQuery(String sql) {
		getConnection();//��ȡ���ݿ�����
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			return rs;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	//ר������ִ����ɾ�Ĳ���
	public void executeOther(String sql) {
		getConnection();//��ȡ���ݿ�����
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
