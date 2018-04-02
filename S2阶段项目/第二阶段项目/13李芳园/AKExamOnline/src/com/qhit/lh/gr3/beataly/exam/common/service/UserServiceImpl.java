package com.qhit.lh.gr3.beataly.exam.common.service;

import com.qhit.lh.gr3.beataly.exam.common.bean.User;
import com.qhit.lh.gr3.beataly.exam.common.dao.UserDao;
import com.qhit.lh.gr3.beataly.exam.common.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return  userDao.login(user);
	}

}
