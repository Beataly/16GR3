/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 李芳园
 *TODO
 * 2017年12月13日上午10:08:46
 */
public class User {
	private int UserId;
	private String userName;
	private String password;
	//一对一关系映射
	private Emp emp;
	//多对多
	private Set<Role> roles = new HashSet<Role>();
	
	public User(int userId, String userName, String password, Emp emp, Set<Role> roles) {
		super();
		UserId = userId;
		this.userName = userName;
		this.password = password;
		this.emp = emp;
		this.roles = roles;
	}
	public User(int userId, String userName, String password, Emp emp) {
		super();
		UserId = userId;
		this.userName = userName;
		this.password = password;
		this.emp = emp;
	}
	public User(int userId, String userName, String password) {
		super();
		UserId = userId;
		this.userName = userName;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
