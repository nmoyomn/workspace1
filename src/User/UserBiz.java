package User;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;
import com.vo.Item;
import com.vo.User;

import Item.ItemDao;

public class UserBiz extends Biz<User, String> {

	UserDao userDao;
	ItemDao itemDao;

	// special generalization
	// �ٸ� biz���� ������� �ʰ� ���⿡���� �ΰ� ���� ������ �Ѵ� ����
	public UserBiz() {
		dao = new UserDao();
		itemDao = new ItemDao();
		userDao = new UserDao();
	}

	@Override
	public void register(User o) throws Exception {
		Connection conn = getConnection();
		try {
			// 1. ����� ������ ��ȸ�Ѵ�.
			int grade = o.getGrade();
			// 2. ������ ������ ��ȸ�Ѵ�.
			Item item = itemDao.selectGrade(grade, conn);
			// 3. ����� ������ �Է��Ѵ�.
			dao.insert(o, conn);
			// 4. ����� �������� �Է��Ѵ�.
			o.setItem(item);
			o.setItemcount(1);
			userDao.insertUserItem(o, conn);
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
		Connection conn = getConnection();
		try {
			dao.update(o, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}


	@Override
	public ArrayList<User> getAll() throws Exception {
		ArrayList<User> list = null;
		Connection conn = getConnection();
		try {
			list = dao.selectAll(conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		return list;
	}
	
	@Override
	public void remove(String i) throws Exception {
		Connection conn = getConnection();
		try {
			// - ����� ���� ID �Է¹޴´�.
			// - ����� ������ ����
			userDao.deleteUserItem(i, conn);
			// - ����� ����
			userDao.delete(i, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}

	}


	@Override
	public User get(String i) throws Exception {
		Connection conn = getConnection();
		User user = null;
		try {
			// - ������� ID�� �Է� �޴´�.
			// - ����� ���� ��ȸ
			user = userDao.select(i, conn);
			// - ����� ID�� ������ User(ID�� count)�� ��ȸ�Ѵ�.
			// - ������� count�� setting �Ѵ�.
			user = userDao.setItem(user, conn);
			// - ����� �������� ������ ���̺��� ��ȸ
			Item item = itemDao.select(user.getItem().getId(), conn);
			// - ����ڿ� ������ ����
			user.setItem(item);

		} catch (Exception e) {
			throw e;
		} finally {
			close(conn);
		}
		return user;
	}

public ArrayList<User> getAll2() throws Exception{
	Connection conn = getConnection();
	ArrayList<User> list = new ArrayList<>();
	try {
		list = userDao.selectAll(conn);
		for(User u : list) {
			u = userDao.setItem(u, conn);
			Item item = itemDao.select(u.getItem().getId(), conn);
			u.setItem(item);
		}
	}catch(Exception e){
		throw e;
	}finally {
		close(conn);
	}
	return list;
}

}
