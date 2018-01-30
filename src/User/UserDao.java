package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Item;
import com.vo.User;

public class UserDao extends Dao<User, String> {

	//// special generalization

	public void insertUserItem(User o, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(Sql.insertUI);
			pst.setString(1, o.getId());
			pst.setInt(2, o.getItem().getId());
			pst.setInt(3, o.getItemcount());

			pst.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
			throw e;
		} finally {
			close(pst);
		}
	}

	public void updateUserItem(User o, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(Sql.updateUI);
			pst.setString(1, o.getId());
			pst.setInt(2, o.getItem().getId());
			pst.setInt(3, o.getItemcount());

			pst.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
			throw e;
		} finally {
			close(pst);
		}
	}

	public void deleteUserItem(String id, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(Sql.deleteUI);
			pst.setString(1, id);

			pst.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
			throw e;
		} finally {
			close(pst);
		}
	}

	public User setItem(User o, Connection conn) throws Exception {
		PreparedStatement pst = null;
		// o에서 id를 빼낸다.
		// UserItem에서 해당 아이디의 ItemId, Count를 조회한다.
		// ItemId와 Count를 o 객체에 넣어준다.
		ResultSet rst = null;
		Item item = new Item();

		try {
			pst = conn.prepareStatement(Sql.selectUI);
			pst.setString(1, o.getId());
			rst = pst.executeQuery();
			rst.next();

			int itemid = rst.getInt("ITEMID");
			item.setId(itemid);
			o.setItem(item);

			int count = rst.getInt("COUNT");
			o.setItemcount(count);

		} catch (Exception e) {
			e.getMessage();
			throw e;
		} finally {
			close(rst);
			close(pst);
		}
		return o;
	}

	@SuppressWarnings("null")
	public ArrayList<User> setItemAll(Connection conn) throws Exception {
		ArrayList<User> list = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		Item item = new Item();

		try {
			pst = conn.prepareStatement(Sql.selectAllUI);
			rst = pst.executeQuery();
			while (rst.next()) {
				User o = null;
				int itemid = rst.getInt("ITEMID");
				item.setId(itemid);
				o.setItem(item);

				int count = rst.getInt("COUNT");
				o.setItemcount(count);
				list.add(o);
			}
		} catch (Exception e) {
			e.getMessage();
			throw e;
		} finally {
			close(rst);
			close(pst);
		}
		return list;

	}

	/////////////////////////////////////////////////////////////////////////////
	/////////////////// USER 조회하기////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	@Override
	public void insert(User o, Connection conn) throws Exception {

		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(Sql.insertUser);
			pst.setString(1, o.getId());
			pst.setString(2, o.getPwd());
			pst.setString(3, o.getName());
			pst.setInt(4, o.getGrade());
			pst.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
			throw e;
		} finally {
			close(pst);
		}

	}

	@Override
	public void delete(String i, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(Sql.deleteUser);
			pst.setString(1, i);
			pst.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
			throw e;
		} finally {
			close(pst);
		}

	}

	@Override
	public void update(User o, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(Sql.updateUser);
			pst.setString(4, o.getId());
			pst.setString(1, o.getPwd());
			pst.setString(2, o.getName());
			pst.setInt(3, o.getGrade());
		} catch (Exception e) {
			e.getMessage();
			throw e;
		} finally {
			close(pst);
		}

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
			int grade = rst.getInt("GRADE");
			user = new User(id, pwd, name, grade);
		} catch (Exception e) {
			e.getMessage();
			throw e;
		} finally {
			close(rst);
			close(pst);
		}
		return user;
	}

	@Override
	public ArrayList<User> selectAll(Connection conn) throws Exception {
		PreparedStatement pst = null;
		ArrayList<User> list = new ArrayList<>();
		ResultSet rst = null;
		try {
			pst = conn.prepareStatement(Sql.selectAllUser);
			rst = pst.executeQuery();
			while (rst.next()) {
				User user = null;
				String id = rst.getString("ID");
				String pwd = rst.getString("PWD");
				String name = rst.getString("NAME");
				int grade = rst.getInt("GRADE");
				user = new User(id, pwd, name, grade);
				list.add(user);
			}
		} catch (Exception e) {
			e.getMessage();
			throw e;
		} finally {
			close(rst);
			close(pst);
		}
		return list;
	}

}
