/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.beataly.t2.dao.BaseDao;
import com.qhit.lh.gr3.beataly.t2.utils.HibernateSessionFactory;

/**
 * @author 李芳园
 *TODO
 * 2017年12月11日上午10:23:20
 */
public class BaseDaoImpl implements BaseDao {

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.beataly.t1.dao.BaseDao#add(java.lang.Object)
	 */
	@Override
	public void add(Object obj) {
		//1、获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2、开启事务
		Transaction ts = session.beginTransaction();
		//3.执行
		session.save(obj);
		//4.提交事务
		ts.commit();
		//5.释放资源
		HibernateSessionFactory.closeSession();
		
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.beataly.t1.dao.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object obj) {
		//1、获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2、开启事务
		Transaction ts = session.beginTransaction();
		//3.执行
		session.delete(obj);
		//4.提交事务
		ts.commit();
		//5.释放资源
		HibernateSessionFactory.closeSession();
				
		
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.beataly.t1.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(Object obj) {
		//1、获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2、开启事务
		Transaction ts = session.beginTransaction();
		//3.执行
		session.update(obj);
		//4.提交事务
		ts.commit();
		//5.释放资源
		HibernateSessionFactory.closeSession();
				
		
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.beataly.t1.dao.BaseDao#getAll()
	 */
	@Override
	public List<Object> getAll(String fromObject) {
		//1、获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2、开启事务
		Transaction ts = session.beginTransaction();
		//3.获取查询器
		Query query = session.createQuery(fromObject);
		List<Object> list = query.list();
		//4.提交事务
		ts.commit();
		//5.释放资源
		HibernateSessionFactory.closeSession();
		return list;		
		
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.beataly.t2.dao.BaseDao#getObjectById(java.lang.Object, int)
	 */
	@Override
	public Object getObjectById(Class clazz, int id) {
		//1,获取session对象
				Session session = HibernateSessionFactory.getSession();
				//2，开启事务
				Transaction ts = session.beginTransaction();
				//3，获取查询器对象
				Object obj = session.get(clazz, id);
				//4,提交事务
				ts.commit();
				//5，释放资源
				HibernateSessionFactory.closeSession();
				return obj;
	}

}
