package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Item;
import com.vo.User;

public class UserDao extends Dao<User, String> {

	@Override
	public void insert(User o, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(Sql.insertUser);
			pst.setString(1, o.getId());
			pst.setString(2, o.getPwd());
			pst.setString(3, o.getName());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pst);
		}

	}

	@Override
	public void update(User o, Connection conn) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String i, Connection conn) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public User select(String i, Connection conn) throws Exception {
		PreparedStatement pst = null;
		User user = null;
		ResultSet rst = null;
		try {
			pst = conn.prepareStatement(Sql.selectUser);
			pst.setString(1, i);
			rst = pst.executeQuery();
			rst.next();
			String id = rst.getString("ID");
			String pwd = rst.getString("PWD");
			String name = rst.getString("NAME");
			user = new User(id, pwd, name);
		} catch (Exception e) {
			throw e;
		} finally {
			close(pst);
		}
		return user;
	}

	@Override
	public ArrayList<User> selectAll(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	///////////////////////////////////////////////////////////////////////////
	// 조인조인인조인조인조조인?
	// specialization //User에 Item을 넣기 위해 Item list에서 Item의 정보를 가져온다.
	public void insertItem(User o, Connection conn) throws Exception {
		ArrayList<Item> items = o.getItems();
		String id = o.getId();
		PreparedStatement pst = null;
		try {
			for (Item item : items) {
				pst = conn.prepareStatement(Sql.insertUserItem);
				pst.setString(1, id);
				pst.setInt(2, item.getId());
				pst.executeUpdate();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(pst);
		}
	}

	public ArrayList<Item> getItem(String i, Connection conn) throws Exception {
		ArrayList<Item> items = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			pst = conn.prepareStatement(Sql.selectUserItem2);
			pst.setString(1, i);
			rst = pst.executeQuery();
			while(rst.next()){
				Item item = null;
				int id = rst.getInt("ID");
				String name = rst.getString("NAME");
				int price = rst.getInt("PRICE");
				item = new Item(id, name, price);
				items.add(item);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(rst);
			close(pst);
		}
		return items;
	}

}
