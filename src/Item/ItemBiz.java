package Item;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;
import com.vo.Item;

public class ItemBiz extends Biz<Item, Integer> {

	public ItemBiz() {
		dao = new ItemDao();
	}
	


	@Override
	public void register(Item o) throws Exception {
		Connection conn = getConnection();
		try {
			dao.insert(o, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}

	}

	@Override
	public void remove(Integer i) throws Exception {
		Connection conn = getConnection();
		try {
			dao.delete(i, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}

	}

	@Override
	public void modify(Item o) throws Exception {
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
	public Item get(Integer i) throws Exception {
		Connection conn = getConnection();
		Item item = null;
		try {
			item = dao.select(i, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		return item;
	}

	@Override
	public ArrayList<Item> getAll() throws Exception {
		Connection conn = getConnection();
		ArrayList<Item> list = null;
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

}
