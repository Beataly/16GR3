/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2.dao;

import java.util.List;

import com.qhit.lh.gr3.beataly.t2.bean.Emp;

/**
 * @author 李芳园
 *TODO
 * 2017年12月11日上午10:22:50
 */
public interface BaseDao {
	/**
	 * @param obj
	 * 增
	 */
	public void add(Object obj);
	/**
	 * @param obj
	 * 删
	 */
	public void delete(Object obj);
	/**
	 * @param obj
	 * 改
	 */
	public void update(Object obj);
	/**
	 * 查
	 * 
	 */
	public List<Object> getAll(String fromObject);
	/**
	 * @param obj
	 * @param id
	 * @return
	 */
	public Object getObjectById(Class clazz, int id);
	/**
	 * @param name
	 * @return
	 *按员工的姓名进行模糊查询
	 */
	public List<Emp> getEmpByName(String name);

}
