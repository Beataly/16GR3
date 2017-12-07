package com.qhit.sbm.account.dao;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;

public interface AccountDao {
//分页的数据访问
	public PageBean getPageBean(PageBean pageBean);
	//添加账单
	public int addAccount(Goods goods, int businessNum, int providerId, int isPayed);
	//根据参数查询
		public PageBean getPageBeanByParam(List<String> wheres,List<String> values);
		// 删除
		public int deleteAccountById(int accountId);
//		更新
		public int upDateAccountById(int accountId, int providerId, int isPayed);
}
