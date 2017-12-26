/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
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
	
	/**
	 * 查询每个部门的员工人数，显示出部门信息和人数
	 */
	@Test
	public void getDeptLikeName(){
		//获取session对象
		Session session = HibernateSessionFactory.getSession();
		//通过session对象创建criteria条件查询器
		Criteria criteria = session.createCriteria(Dept.class)
				.setFetchMode("emps", FetchMode.JOIN)
				.createAlias("emps", "e");
		//设置分组条件和查询结果
		ProjectionList projectionList = Projections.projectionList()
				.add(Projections.property("deptId"))
				.add(Projections.property("deptName"))
				.add(Projections.property("address"))
				.add(Projections.property("e.deptId"));
		//关联查询器和结果
		criteria.setProjection(projectionList);
		//通过criteria条件查询器查询
		List<Object[]> list = criteria.list();
		//遍历输出
		for(Object[] object : list){
			System.out.println(object[0]+","+object[1]+","+object[2]+","+object[3]);
		}
	}
	/**
	 * 查询所有部门同时加载其部门下员工
	 */
	@Test
	public void getDeptInfo(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Dept.class);
		detachedCriteria.setFetchMode("emps", FetchMode.JOIN);
		
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = detachedCriteria.getExecutableCriteria(session);
		
		for(Object object : criteria.list()){
			System.out.println(object);
		}
	}
}
