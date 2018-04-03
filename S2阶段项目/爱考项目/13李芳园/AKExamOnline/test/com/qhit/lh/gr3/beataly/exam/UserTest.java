package com.qhit.lh.gr3.beataly.exam;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.gr3.beataly.exam.common.action.UserAction;
import com.qhit.lh.gr3.beataly.exam.common.bean.User;


/**
 * @author 李芳园
 *TODO
 * 2018年1月7日下午8:43:10
 */
public class UserTest {

	@Test
	public void login() {
       UserAction userAction = new UserAction();
		
		User user = new User();
		user.setName("admin");
		user.setPwd("123456");
		user.setRole(4);
		
		userAction.setUser(user);
		
		System.out.println(userAction.login());;
		
	}
}

