/**
 * 
 */
package com.qhit.lh.gr3.beataly.t1.service;

import java.util.List;

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

}
