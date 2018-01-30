package User.test;

import org.junit.jupiter.api.Test;

import com.vo.User;

import User.UserBiz;

class UserRegister2DaoTest {

	@Test
	void testInsertUserItem() {
		UserBiz biz = new UserBiz();
		User user = new User("id68", "pwd01", "name02", 2);
		
		try {
			biz.register(user);
			System.out.println("ÀÔ·Â¤¡¤¡¤¡¤¡¤¡¤¡¤¡");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
