/**
 * 
 */
package com.qhit.lh.gr3.beataly.t1;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.beataly.t1.bean.User;
import com.qhit.lh.gr3.beataly.t1.service.BaseService;
import com.qhit.lh.gr3.beataly.t1.service.impl.BaseServiceImpl;

/**
 * @author 李芳园
 *TODO
 * 2017年12月11日上午10:48:15
 */
public class UserTest {
	private BaseService baseService = new BaseServiceImpl();
	@Test
	public void addUser() {
		User user = new User();
		user.setUname("aa");
		user.setUpwd("123456");
		user.setBrithday("2012-12-11");
		user.setSex("m");
		user.setEnbale(1);
		//数据操作
		baseService.add(user);	
	}
	@Test
	public void deteleUser() {
		User user = new User();
		user.setId(10);
		//数据操作
		baseService.delete(user);	
	}
	@Test
	public void update() {
		User user = new User();
		user.setId(9);
		user.setUname("jack");
		user.setUpwd("123");
		user.setBrithday("2012-12-12");
		user.setSex("F");
		user.setEnbale(1);
		//数据操作
		baseService.update(user);	
	}
	@Test
	public void getAll() {
		List<Object> list = baseService.getAll("from User");
		for(Object o : list){
			User user = new User();
			System.out.println(o);
		}
		
	}
}
