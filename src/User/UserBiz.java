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
	// 다른 biz에서 사용하지 않고 여기에서만 두개 쓰기 때문에 한다 ㅅㅂ
	public UserBiz() {
		dao = new UserDao();
		itemDao = new ItemDao();
		userDao = new UserDao();
	}

	@Override
	public void register(User o) throws Exception {
		Connection conn = getConnection();
		try {
			// 1. 사용자 정보를 조회한다.
			int grade = o.getGrade();
			// 2. 아이템 정보를 조회한다.
			Item item = itemDao.selectGrade(grade, conn);
			// 3. 사용자 정보를 입력한다.
			dao.insert(o, conn);
			// 4. 사용자 아이템을 입력한다.
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
			// - 사용자 정보 ID 입력받는다.
			// - 사용자 아이템 삭제
			userDao.deleteUserItem(i, conn);
			// - 사용자 삭제
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
			// - 사용자의 ID를 입력 받는다.
			// - 사용자 정보 조회
			user = userDao.select(i, conn);
			// - 사용자 ID로 아이템 User(ID와 count)를 조회한다.
			// - 사용자의 count를 setting 한다.
			user = userDao.setItem(user, conn);
			// - 사용자 아이템을 아이템 테이블에서 조회
			Item item = itemDao.select(user.getItem().getId(), conn);
			// - 사용자에 아이템 세팅
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
