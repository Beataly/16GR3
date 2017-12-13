/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.beataly.t2.bean.Emp;
import com.qhit.lh.gr3.beataly.t2.bean.User;
import com.qhit.lh.gr3.beataly.t2.service.BaseService;
import com.qhit.lh.gr3.beataly.t2.service.impl.BaseServiceImpl;

/**
 * @author 李芳园
 *TODO
 * 2017年12月13日上午10:25:19
 */
public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();
	/**
	 * 添加员工并分配一个账户
	 */
	@Test
	public void add() {
		//声明员工对象
		Emp emp = new Emp();
		emp.setEmpName("aaa");
		emp.setEmpSex("M");
		emp.setBirthday("2017-12-13");
		emp.setDeptId(1);
		//分配一个账户
		User user = new User();
		user.setUserName("aaa");
		user.setPassword("123456");
		//建立一对一关系
		emp.setUser(user);
		user.setEmp(emp);

		//级联操作
		baseService.add(emp);

	}
	@Test
	public void delete() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp, 1005);
		baseService.delete(emp);
	}
	@Test
	public void update() {
		//声明员工对象
				Emp emp = new Emp();
				emp.setEid(1001);
				emp.setEmpName("haha");
				emp.setEmpSex("F");
				emp.setBirthday("2017-12-13");
				emp.setDeptId(1);
				//分配一个账户
				User user = new User();
				user.setUserId(1);
				user.setUserName("haha");
				user.setPassword("122");
				//建立一对一关系
				emp.setUser(user);//指定当前员工的账户
				user.setEmp(emp);//指定当前账户所属的员工

				//级联操作
				baseService.update(emp);
	}
	@Test
	public void query() {
		List<Object> list = baseService.getAll("from Emp");
		
		for (Object object : list) {
			Emp emp = (Emp) object;
			System.out.println(emp.toString());
		}
	}
}
