/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 李芳园
 *TODO
 * 2017年12月20日上午9:27:49
 */
public class Role {
	private int roleId;
	private String roleName;
	private String memo;
	
	private Set<User> users = new HashSet<User>();

	public Role(int roleId, String roleName, String memo, Set<User> users) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.memo = memo;
		this.users = users;
	}

	public Role(int roleId, String roleName, String memo) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.memo = memo;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", memo=" + memo + "]";
	}

	
	
}
