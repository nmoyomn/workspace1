package User.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.vo.User;

import User.UserBiz;

class UserGetAllDaoTest {

	@Test
	void testSetItemAll() {
		UserBiz biz = new UserBiz();
		ArrayList<User> list = new ArrayList<>();
		try {
			list = biz.getAll2();
			for(User u : list) {
				System.out.println(u);
				System.out.println(u.getItem());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
