package com.qhit.lh.gr3.beataly.sbm.user.dao;

import java.util.List;

import com.qhit.lh.gr3.beataly.sbm.user.bean.User;

public interface UserDao {

	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 * 登录访问的数据
	 */
	public User doLogin(String userName,String userPassword);

	/**
	 * @param user
	 * @return
	 * 添加用户
	 */
	public int addUser(User user);
	/**
	 * @return
	 * 查询所有的用户
	 * @throws Exception 
	 */
	public List<User> getAll() throws Exception;
	}
	
