package User.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.vo.User;

import User.UserBiz;

class UserModifyDeleteDaoTest {

	@Test
	void testUpdateUserItem() {
		UserBiz biz = new UserBiz();
		User user = new User("id68", "pwd100", "수정과", 1);
		
		try {
			biz.modify(user);
			System.out.println("수정ㄱㄱㄱㄱㄱㄱㄱ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	void testDeleteUserItem() {
		UserBiz biz = new UserBiz();
		String i = new String("id2");
		
		try {
			biz.remove(i);
			System.out.println("삭제ㄱㄱㄱㄱㄱㄱㄱ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
