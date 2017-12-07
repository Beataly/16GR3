package com.qhit.sbm.account.service.impl;

import java.util.List;

import com.qhit.sbm.account.dao.impl.AccountDaoImpl;
import com.qhit.sbm.account.service.AccountService;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;

public class AccountServiceImpl implements AccountService {

	@Override
	public PageBean getPageBean(PageBean pageBean) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().getPageBean(pageBean);
	}

	@Override
	public int addAccount(Goods goods, int businessNum, int providerId, int isPayed) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().addAccount(goods, businessNum, providerId, isPayed);
	}

	@Override
	public PageBean getPageBeanByParam(List<String> wheres, List<String> values) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().getPageBeanByParam(wheres, values);
	}

	@Override
	public int deleteAccountById(int accountId) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().deleteAccountById(accountId);
	}

	@Override
	public int upDateAccountById(int accountId, int providerId, int isPayed) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().upDateAccountById(accountId, providerId, isPayed);

}
	}
