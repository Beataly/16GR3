package com.qhit.lh.gr3.beataly.exam.common.dao;

import org.hibernate.Session;

import com.qhit.lh.gr3.beataly.exam.common.utils.HibernateSessionFactory;


/**
 * @author 李芳园
 *TODO
 * 2018年1月7日下午7:07:26
 */
public class BaseDao {
    public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}
