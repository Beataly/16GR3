package com.qhit.lh.gr3.beataly.exam.sjgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.beataly.exam.common.bean.PageBean;
import com.qhit.lh.gr3.beataly.exam.sjgl.bean.Paper;

public interface PaperDao {

	/**
	 * @param parameter
	 * @return
	 * 查询试卷列表
	 */
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex);
}
