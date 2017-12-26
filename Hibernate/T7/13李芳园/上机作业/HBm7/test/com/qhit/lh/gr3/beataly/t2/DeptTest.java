/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import com.qhit.lh.gr3.beataly.t2.bean.Dept;
import com.qhit.lh.gr3.beataly.t2.bean.Emp;
import com.qhit.lh.gr3.beataly.t2.bean.User;
import com.qhit.lh.gr3.beataly.t2.service.BaseService;
import com.qhit.lh.gr3.beataly.t2.service.impl.BaseServiceImpl;


/**
 * @author 李芳园
 *TODO
 * 2017年12月19日下午7:11:27
 */
public class DeptTest {
	private BaseService baseService = new BaseServiceImpl();
	@Test
	public void add() {
		//创建部门
		Dept dept = new Dept();
		dept.setDeptName("测试部");
		dept.setAddress("北京");
		//没有员工
		
		//有员工
		Emp emp = new Emp();
		emp.setEmpName("嗨嗨a");
		emp.setEmpSex("M");
		emp.setBirthday("2012-12-19");
		
		User user = new User();
		user.setUserName("lyl");
		user.setPassword("1234560");
		//一对一
		emp.setUser(user);
		user.setEmp(emp);
		//一对多
		dept.getEmps().add(emp);
		// inverse解决方式二：映射文件不改变 而代码需要修改
		emp.setDept(dept);
		//级联操作
		baseService.add(dept);
	}
	@Test
	public void delete() {
		
		Dept dept = (Dept) baseService.getObjectById(Dept.class,9);
		
		//级联操作
		baseService.delete(dept);
	}
	@Test
	public void update() {
		Dept dept = (Dept) baseService.getObjectById(Dept.class,5);
		dept.setDeptName("编程部");
		//级联操作
		baseService.update(dept);
	}
	@Test
	public void query() {
		Dept dept = (Dept) baseService.getObjectById(Dept.class,5);
		for (Emp emp : dept.getEmps()) {
			System.out.println(dept.getDeptName()+":"+emp.getEmpName());
		}
	}
}
