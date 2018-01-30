package com.user;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;
import com.vo.Item;
import com.vo.User;

public class UserBiz extends Biz<User, String> {

	UserDao dao;

	public UserBiz() {
		dao = new UserDao();
	}

	@Override
	public void register(User o) throws Exception {
		Connection conn = getConnection();
		try {
			// User ������ �Է�
			dao.insert(o, conn);
			// User �� ���� �ϰ� �ִ� Item ���� �Է�
			dao.insertItem(o, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}

	}

	@Override
	public void modify(User o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String i) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public User get(String i) throws Exception {
		Connection conn = getConnection();
		User user = null;
		ArrayList<Item> ilist=null;
		try {
			user = dao.select(i, conn);
			ilist = dao.getItem(i, conn);
			user.setItems(ilist);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		return user;
	}

	@Override
	public ArrayList<User> getAll() throws Exception {
		// ��� user ������ ��ȸ
		// �� ������ id�� ���� ������ ������ ������������ ��ȸ
		// �� �������� ������ ������ ����
		// ���� �� ����Ʈ�� ����!
		Connection conn = getConnection();
		ArrayList<User> users = null;
		ArrayList<Item> items = null;
		try {
			users = dao.selectAll(conn);
			for(User user : users) {
				items =dao.getItem(user.getId(), conn);
				user.setItems(items);
			}
		} catch(Exception e) {
			
		} finally {
			close(conn);
		}
		return users;
	}

}
