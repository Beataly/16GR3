/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import com.qhit.lh.gr3.beataly.t2.bean.Role;
import com.qhit.lh.gr3.beataly.t2.bean.User;
import com.qhit.lh.gr3.beataly.t2.service.BaseService;
import com.qhit.lh.gr3.beataly.t2.service.impl.BaseServiceImpl;

/**
 * @author 李芳园
 *TODO
 * 2017年12月20日上午10:10:49
 */
public class RoleTest {
	private BaseService baseService = new BaseServiceImpl();
	@Test
	public void add() {
		//新建一个角色
		Role role = new Role();
		role.setRoleName("经理");
		role.setMemo("管理员工");
		
		//获取账户
		User user = (User) baseService.getObjectById(User.class, 1014);
		
		//建立角色和账户之间的关系
		role.getUsers().add(user);
		
		//级联操作
		baseService.add(role);
	}
	@Test
	public void delete(){
		Role role = (Role) baseService.getObjectById(Role.class, 3);
		//级联操作
		baseService.delete(role);;
	}
	@Test
	public void update(){
		Role role = (Role) baseService.getObjectById(Role.class, 2);
		role.setMemo("管理人");
		//账户
		User user = (User) baseService.getObjectById(User.class, 1);
		//建立角色和账户之间的关系
		role.getUsers().add(user);
		
		//级联操作
		baseService.update(role);
	}
	@Test
	public void query(){
		Role role = (Role) baseService.getObjectById(Role.class, 2);
		System.out.println(role);
		System.out.println("分配的账户");
		for (User user : role.getUsers()) {
			System.out.println(user);
		}
	}
}
