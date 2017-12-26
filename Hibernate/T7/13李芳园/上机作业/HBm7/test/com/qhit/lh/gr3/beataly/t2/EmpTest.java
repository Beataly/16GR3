/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.gr3.beataly.t2.bean.Dept;
import com.qhit.lh.gr3.beataly.t2.bean.Emp;
import com.qhit.lh.gr3.beataly.t2.bean.User;
import com.qhit.lh.gr3.beataly.t2.service.BaseService;
import com.qhit.lh.gr3.beataly.t2.service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.beataly.t2.utils.HibernateSessionFactory;


/**
 * @author 李芳园
 *TODO
 * 2017年12月25日上午9:37:15
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
		emp.setEmpName("张三");
		emp.setEmpSex("M");
		emp.setBirthday("2017-12-25");

		//分配一个账户
		User user = new User();
		user.setUserName("zs");
		user.setPassword("123456");
		//建立一对一关系
		emp.setUser(user);
		user.setEmp(emp);
		//分配所属的部门
		Dept dept = new Dept();
		dept = (Dept) baseService.getObjectById(Dept.class, 2);
		//建立多对一关联
		emp.setDept(dept);
		//级联操作
		baseService.add(emp);

	}
	@Test
	public void delete() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(Emp.class, 5);
		baseService.delete(emp);
	}
	@Test
	public void update() {
		//声明员工对象
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp.getClass(), 7);
		emp.setEmpName("张三a");
		//分配一个账户
		User user = emp.getUser();
		user.setUserName("zhangsan");
		//建立一对一关系
		emp.setUser(user);//指定当前员工的账户
		user.setEmp(emp);//指定当前账户所属的员工
		//修改所属的部门，并不是修改部门本身的信息
		Dept dept = new Dept();
		dept = (Dept) baseService.getObjectById(dept.getClass(), 3);
		//建立多对一关联
		emp.setDept(dept);
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
	@Test
	public void getEmpByName(){
		List<Emp> list = baseService.getEmpByName("%李%");

		for (Emp emp : list) {
			System.out.println(emp.getEid()+":"+emp.getEmpName()+":"+emp.getEmpSex()+":"+emp.getBirthday());
		}
	}
	
}
