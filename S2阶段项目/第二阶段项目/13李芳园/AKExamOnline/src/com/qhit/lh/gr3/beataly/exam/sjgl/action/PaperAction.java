package com.qhit.lh.gr3.beataly.exam.sjgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.beataly.exam.common.bean.PageBean;
import com.qhit.lh.gr3.beataly.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.beataly.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.beataly.exam.sjgl.service.PaperService;
import com.qhit.lh.gr3.beataly.exam.sjgl.service.PaperServiceImpl;

public class PaperAction extends ActionSupport {
	private PaperService paperService = new PaperServiceImpl();
	private List<Course> listCourses = new ArrayList<>();
	private List<Paper> listPapers = new ArrayList<>();
	//试题列表分页数据
	private PageBean<Paper> pageBean = new PageBean<>();
	private int pageIndex = 1;//指定页,初始化为1
	//条件参数
	private Course course;
	private Paper paper;
	
	/**
	 * @return
	 * 获取试卷列表
	 */
	public String getPaperList(){
		//设置参数
		Map<String, Object> parameter = new HashMap<>();
		if(course != null){
			parameter.put("csId", course.getCsId());
		}
		if(paper != null){
			parameter.put("pType", paper.getPtype());
			parameter.put("pState", paper.getPstate());
		}
		//查询题库列表数据
		pageBean = paperService.getPaperList(pageBean, parameter, getPageIndex());
		System.out.println(pageBean.getItems().size());
		return "listPaper";
	}
	
	/**
	 * @return
	 * 随机组卷
	 */
	public String createByRandom(){
		
		return null;
	}

	public List<Course> getListCourses() {
		return listCourses;
	}

	public List<Paper> getListPapers() {
		return listPapers;
	}

	public PageBean<Paper> getPageBean() {
		return pageBean;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}

	public void setListPapers(List<Paper> listPapers) {
		this.listPapers = listPapers;
	}

	public void setPageBean(PageBean<Paper> pageBean) {
		this.pageBean = pageBean;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	
}
