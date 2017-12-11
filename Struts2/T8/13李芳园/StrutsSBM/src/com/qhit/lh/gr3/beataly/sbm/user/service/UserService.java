package com.qhit.lh.gr3.beataly.sbm.user.service;

import java.util.List;

import com.qhit.lh.gr3.beataly.sbm.user.bean.User;

public interface UserService {

	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 * 登录的业务
	 */
	User doLogin(String userName, String userPassword);

	/**
	 * @param user
	 * @return
	 * 添加用户
	 */
	int addUser(User user);
	
	/**
	 * @return
	 * 查询所有的用户
	 * @throws Exception 
	 */
	List<User> getAll() throws Exception;
	
	
}
