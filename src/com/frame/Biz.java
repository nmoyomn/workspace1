package com.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Biz<O,I> {
	protected Dao<O,I> dao;
	
	public Biz() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle Driver Not Found...");
		}
	}
	
	public Connection getConnection() {
		// Connection�� ��������� �Ҽ� ����.
		// Connection�� ��������� �Ұ�� �������� Connection�� �۾��� �Ҽ� �ִ� ��Ȳ�� �Ǿ�
		// ���������� �����ؼ� �������� �Ѵ�.

		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr";
		String password = "hr";
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}
	}
	
	public abstract void register(O o) throws Exception;
	public abstract void remove(I i) throws Exception;
	public abstract void modify(O o) throws Exception;
	public abstract O get(I i) throws Exception;
	public abstract ArrayList<O> getAll() throws Exception;
	
}
