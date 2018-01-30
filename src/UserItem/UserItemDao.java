package UserItem;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.User;
import Item.ItemDao;

public class UserItemDao extends Dao<User, String> {

	ItemDao itemDao;
	
	@Override
	public void insert(User o, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(Sql.insertUI);
			pst.setString(1, o.getId());
			pst.setInt(2, o.getItem().getId());
			pst.setInt(3, o.getItemcount());
			
			pst.executeUpdate();
		}catch(Exception e) {
			e.getMessage();
			throw e;
		}finally {
			close(pst);
		}
		
	}

	@Override
	public void delete(String i, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User o, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(Sql.insertUI);
			pst.setString(1, o.getId());
			pst.setInt(2, o.getItem().getId());
			pst.setInt(3, o.getItemcount());
			
			pst.executeUpdate();
		}catch(Exception e) {
			e.getMessage();
			throw e;
		}finally {
			close(pst);
		}
		
	}

	@Override
	public User select(String i, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> selectAll(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
