package User.test;

import org.junit.jupiter.api.Test;

import com.vo.User;

import User.UserBiz;

class UserGetBizTest {

	@Test
	void testGetString() {
		UserBiz biz = new UserBiz();
		User user =null;
		try {
			user = biz.get("id2");
			System.out.println(user);
			System.out.println(user.getItem());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
