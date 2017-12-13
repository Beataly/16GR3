/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2.service;

import java.util.List;

import com.qhit.lh.gr3.beataly.t2.bean.Emp;

/**
 * @author 李芳园
 *TODO
 * 2017年12月11日上午10:23:36
 */
public interface BaseService {
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
	 * 根据id去查
	 */
	public Object getObjectById(Object obj, int id);
}
