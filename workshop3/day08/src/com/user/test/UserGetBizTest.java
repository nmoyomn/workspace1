package com.user.test;

import org.junit.jupiter.api.Test;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.User;

class UserGetBizTest {

	@Test
	void testGetString() {
		Biz<User, String> biz = new UserBiz();
		String i = "id04";
		try {
			System.out.println(biz.get(i));
			System.out.println(biz.get(i).getItems());
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
