package com.qhit.sbm.account.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.sbm.account.bean.AccountDetail;
import com.qhit.sbm.account.dao.AccountDao;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.utils.DBManager;


public class AccountDaoImpl implements AccountDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	public PageBean getPageBean(PageBean pageBean){
		AccountDetail accountDetail = null;
		con = DBManager.getConnection();
		String sql = "select top "
				+ pageBean.getPagesize()
				+ " a.accountId,g.goodsName,g.goodsNum,a.businessNum,a.totalPrice,"
				+ " a.isPayed,p.providerName,g.goodsIntro,a.accountDate "
				+ " from tb_account a left join tb_goods g on a.goodsId = g.goodsId "
				+ " left join tb_provider p on p.providerId = a.providerId  "
				+ " where a.accountId not in (select top "
				+ pageBean.getPagesize()*(pageBean.getP() - 1)
				+ " a.accountId from tb_account a left join tb_goods g on "
				+ " a.goodsId = g.goodsId left join tb_provider p on p.providerId = a.providerId );";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				accountDetail = new AccountDetail(
						rs.getInt("accountId"), 
						rs.getString("goodsName"), 
						rs.getInt("goodsNum"), 
						rs.getInt("businessNum"), 
						rs.getFloat("totalPrice"), 
						rs.getInt("isPayed"), 
						rs.getString("providerName"), 
						rs.getString("goodsIntro"),
						rs.getDate("accountDate"));
				pageBean.addData(accountDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		
		
		return pageBean;
		
	}


	public int addAccount(Goods goods, int businessNum, int providerId, int isPayed) {
		con = DBManager.getConnection();
		String sql = "insert into tb_account values(?,?,?,getDate(),?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, providerId);
			ps.setFloat(2, businessNum*goods.getGoodsPrice());
			ps.setInt(3, isPayed);
			ps.setInt(4, goods.getGoodsId());
			ps.setInt(5, businessNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public PageBean getPageBeanByParam(List<String> wheres, List<String> values) {
		PageBean pageBean = new PageBean();
		List<AccountDetail> list = new ArrayList<>();
		AccountDetail accountDetail = null;
		con = DBManager.getConnection();
		String sql = "select a.accountId,g.goodsName,g.goodsNum,"
				+ "a.businessNum,a.totalPrice, a.isPayed,"
				+ "p.providerName,g.goodsIntro,a.accountDate "
				+ "from tb_account a left join tb_goods g on a.goodsId = g.goodsId "
				+ " left join tb_provider p on p.providerId = a.providerId ";
		if (wheres.size() > 0 && values.size() > 0) {
			sql += " where ";
			for(int i=0;i<wheres.size();i++){
				sql += wheres.get(i) + " = " + values.get(i) + " and ";
			}
			sql += " 1=1 ";
		}
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				accountDetail = new AccountDetail(
						rs.getInt("accountId"), 
						rs.getString("goodsName"), 
						rs.getInt("goodsNum"), 
						rs.getInt("businessNum"), 
						rs.getFloat("totalPrice"), 
						rs.getInt("isPayed"), 
						rs.getString("providerName"), 
						rs.getString("goodsIntro"),
						rs.getDate("accountDate"));
				list.add(accountDetail);
			}
			pageBean.setPagesize(list.size());
			pageBean.setCount(list.size());
			pageBean.setP(1);
			pageBean.setData(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageBean;
	}

	public int deleteAccountById(int accountId) {
		con = DBManager.getConnection();
		String sql = "delete from tb_account where accountId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, accountId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int upDateAccountById(int accountId, int providerId, int isPayed) {
		con = DBManager.getConnection();
		String sql = "update tb_account set providerId = ?, isPayed = ? where accountId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, providerId);
			ps.setInt(2, isPayed);
			ps.setInt(3, accountId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
