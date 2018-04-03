package com.qhit.lh.gr3.beataly.exam.common.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.beataly.exam.common.bean.User;
import com.qhit.lh.gr3.beataly.exam.common.service.UserService;
import com.qhit.lh.gr3.beataly.exam.common.service.UserServiceImpl;


/**
 * @author 李芳园
 *TODO
 * 2018年1月7日下午7:05:12
 */
public class UserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	
	private User user;
	
	/**
	 *登录
	 */
	public String login(){
		user = userService.login(user);
		if(user != null){
			//登录成功
			System.out.println(user.toString());
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}else{
			super.addActionError("登录失败！用户名密码错误!");
			return "loginFail";
		}
	}
	/**
	 *退出
	 */
	public String logout(){
		//获取session对象，并销毁
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
}

