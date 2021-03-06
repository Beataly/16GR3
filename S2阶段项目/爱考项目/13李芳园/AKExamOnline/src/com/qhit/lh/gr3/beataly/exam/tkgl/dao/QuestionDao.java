package com.qhit.lh.gr3.beataly.exam.tkgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.beataly.exam.common.bean.PageBean;
import com.qhit.lh.gr3.beataly.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.beataly.exam.tkgl.bean.WrittenQuestion;


/**
 * @author 李芳园
 *TODO
 * 2018年1月7日下午7:11:36
 */
public interface QuestionDao {

	/**
	 * 题库管理
	 * @param parameter
	 * @return
	 * 题库列表
	 */
	public List<Course> getCourseInfo(Map parameter);
	/**
	 * @param pageBean
	 * @return
	 * 笔试题列表分页数据
	 */
	public PageBean<WrittenQuestion> getWrittenList(
			PageBean<WrittenQuestion> pageBean, 
			Course course,
			int pageIndex);

	/**
	 * @param writtenQuestion
	 * 添加笔试题
	 */
	public void addWrittenQuestion(WrittenQuestion writtenQuestion);

	/**
	 * @param writtenTest
	 * @return
	 * 根据id查询试题
	 */
	public WrittenQuestion getWrittenQuestionById(WrittenQuestion writtenQuestion);

	/**
	 * @param writtenTest
	 * 更新数据
	 */
	public void updateWrittenQuestion(WrittenQuestion writtenQuestion);
	/**
	 * @param listWTests
	 * 批量导入笔试题
	 */
	public void inportWrittenQuestions(List<WrittenQuestion> listWQuestions);
	/**
	 * @param csId
	 * @param qtype
	 * @param degree
	 * @return
	 * 获取题目数
	 */
	public int getQuestionsMax(int csId, String qtype, String degree);
}
