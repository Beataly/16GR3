/**
 * 
 */
package com.qhit.lh.gr3.beataly.t1;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.gr3.beataly.t1.bean.Dept;
import com.qhit.lh.gr3.beataly.t1.service.BaseService;
import com.qhit.lh.gr3.beataly.t1.service.impl.BaseServiceImpl;

/**
 * @author 李芳园
 *TODO
 * 2017年12月11日上午11:06:37
 */
public class DeptTest {
	private BaseService baseService = new BaseServiceImpl();
	@Test
	public void addDept() {
		//1.声明并实例化
		Dept dept = new Dept();
		dept.setName("信息部");
		//2.操作对象
		baseService.add(dept);
	}

}
