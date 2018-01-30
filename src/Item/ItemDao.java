package Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Item;

public class ItemDao extends Dao<Item, Integer> {

	public Item selectGrade(Integer i, Connection conn) throws SQLException{
		PreparedStatement pst = null;
		ResultSet rst = null;
		Item item = null;
		try {
			pst = conn.prepareStatement(Sql.selectGrade);
			pst.setInt(1, i);
			rst = pst.executeQuery();
			rst.next();
			int id = rst.getInt("ID");
			String name = rst.getString("NAME");
			int grade = rst.getInt("GRADE");
			int price = rst.getInt("PRICE");
			item = new Item(id, name, grade, price);
		} catch (Exception e) {
			throw e;
		} finally {
			close(rst);
			close(pst);
		}
		return item;
	}
	
	@Override
	public void insert(Item o, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(Sql.insertItem);
			pst.setInt(1, o.getId());
			pst.setString(2, o.getName());
			pst.setInt(3, o.getGrade());
			pst.setInt(4, o.getPrice());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pst);
		}

	}

	@Override
	public void delete(Integer i, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(Sql.deleteItem);
			pst.setInt(1, i);
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pst);
		}

	}

	@Override
	public void update(Item o, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(Sql.updateItem);
			pst.setInt(4, o.getId());
			pst.setString(1, o.getName());
			pst.setInt(2, o.getGrade());
			pst.setInt(3, o.getPrice());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pst);
		}
	}

	@Override
	public Item select(Integer i, Connection conn) throws Exception {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Item item = null;
		try {
			pst = conn.prepareStatement(Sql.selectItem);
			pst.setInt(1, i);
			rst = pst.executeQuery();
			rst.next();
			int id = rst.getInt("ID");
			String name = rst.getString("NAME");
			int grade = rst.getInt("GRADE");
			int price = rst.getInt("PRICE");
			item = new Item(id, name, grade, price);
		} catch (Exception e) {
			throw e;
		} finally {
			close(rst);
			close(pst);
		}
		return item;
	}

	@Override
	public ArrayList<Item> selectAll(Connection conn) throws Exception {
		PreparedStatement pst = null;
		ResultSet rst = null;
		ArrayList<Item> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(Sql.selectAllItem);
			rst = pst.executeQuery();
			while (rst.next()) {
				Item item = null;
				int id = rst.getInt("ID");
				String name = rst.getString("NAME");
				int grade = rst.getInt("GRADE");
				int price = rst.getInt("PRICE");
				item = new Item(id, name, grade, price);
				list.add(item);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(rst);
			close(pst);
		}
		return list;
	}
}
