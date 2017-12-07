package com.qhit.sbm.user.service;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.user.bean.User;

public interface UserService {
//登录的业务
	User doLogin(String userName, String userPassword);
//添加用户
	int addUser(User user);
	//分页的业务
	PageBean getPageBean(PageBean pageBeanU);

}
