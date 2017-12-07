package com.qhit.sbm.user.dao;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.user.bean.User;

public interface UserDao {
//登录访问的数据
	public User doLogin(String userName,String userPassword);
//	添加用户
	public int addUser(User user);
	//分页的业务
		PageBean getPageBean(PageBean pageBeanU);
}
