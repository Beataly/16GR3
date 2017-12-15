/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import com.qhit.lh.gr3.beataly.t2.bean.Dept;
import com.qhit.lh.gr3.beataly.t2.bean.Emp;
import com.qhit.lh.gr3.beataly.t2.service.BaseService;
import com.qhit.lh.gr3.beataly.t2.service.impl.BaseServiceImpl;

/**
 * @author 李芳园
 *TODO
 * 2017年12月14日下午4:48:40
 */
public class DeptTest {
	private BaseService baseService = new BaseServiceImpl();
	@Test
	public void add() {
		//创建部门
		Dept dept = new Dept();
		dept.setDeptName("财务部");
		dept.setAddress("上海");
		//没有员工
		
		//有员工
		Emp lala = new Emp();
		lala.setEmpName("啦啦");
		lala.setEmpSex("M");
		lala.setBirthday("2012-12-12");
		
		Emp kaka = new Emp();
		kaka.setEmpName("卡卡");
		kaka.setEmpSex("F");
		kaka.setBirthday("2017-12-14");
		
		dept.getEmps().add(lala);
		dept.getEmps().add(kaka);
		//级联操作
		baseService.add(dept);
	}
	@Test
	public void delete() {
		
		Dept dept = (Dept) baseService.getObjectById(Dept.class,6);
		
		//级联操作
		baseService.delete(dept);
	}
	@Test
	public void update() {
		Dept dept = (Dept) baseService.getObjectById(Dept.class,5);
		dept.setDeptName("嘻哈部");
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
