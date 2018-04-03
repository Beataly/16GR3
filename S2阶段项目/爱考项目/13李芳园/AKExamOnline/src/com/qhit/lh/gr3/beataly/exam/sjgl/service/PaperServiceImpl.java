package com.qhit.lh.gr3.beataly.exam.sjgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.beataly.exam.common.bean.PageBean;
import com.qhit.lh.gr3.beataly.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.beataly.exam.sjgl.dao.PaperDao;
import com.qhit.lh.gr3.beataly.exam.sjgl.dao.PaperDaoImpl;


public class PaperServiceImpl implements PaperService {
	private PaperDao paperDao = new PaperDaoImpl();

	@Override
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex) {
		return paperDao.getPaperList(pageBean, parameter, pageIndex);
	}

}
