/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
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
	@Test
	public void getEmpLikeName(){
		//获取session对象
		Session session = HibernateSessionFactory.getSession();
		//通过session对象创建criteria条件查询器
		//基于员工类的反射类通过session.createCriteria()创建Criteria实例
		Criteria criteria = session.createCriteria(Emp.class)
		//add()将筛选条件动态添加到Criteria实例中该方法返回的是当前Criteria实例，支持方法链操作
				//Restrictions.like()创建模糊匹配条件表达式
				.add(Restrictions.like("empName", "%张%"));
		//通过criteria条件查询器查询
		List<Emp> list = criteria.list();
		//遍历查询调用Criteria实例的list()方法才会去检索数据库，返回List集合
		for(Object object : criteria.list()){
			System.out.println(object);
		}
	}
	@Test
	public void getEmpgetLikeAll(){
		//获取session对象
		Session session = HibernateSessionFactory.getSession();
		//通过session对象创建criteria条件查询器
		Criteria criteria = session.createCriteria(Emp.class)
				.add(Restrictions.like("empName", "%李%"));
		//Projections.projectionList()获取投影属性列表
		ProjectionList projectionList = Projections.projectionList()
				//投影属性列表对象的add()添加投影的属性每个投影属性通过Projections.property()来获取相应的封装
				.add(Projections.property("empName"))
				.add(Projections.property("empSex"))
				.add(Projections.property("birthday"));
		//通过criteria.setProjection()将投影属性列表添加到Criteria实例中进行投影查询
		criteria.setProjection(projectionList);
		//遍历查询
		for(Object[] o : (List<Object[]>)criteria.list()){
			System.out.println(o[0]+","+o[1]+","+o[2]);
		}

	}
	/**
	 * 查询市场部的员工
	 */
	@Test
	public void getEmpInfo(){
		//获取session对象
		Session session = HibernateSessionFactory.getSession();
		//通过session对象创建criteria条件查询器
		Criteria criteria = session.createCriteria(Emp.class)
				.setFetchMode("dept", FetchMode.JOIN)
				.createAlias("dept", "d")
				.add(Restrictions.eq("d.deptName", "国防部"));
		for(Object object : criteria.list()){
			System.out.println(object);
		}

	}
}
