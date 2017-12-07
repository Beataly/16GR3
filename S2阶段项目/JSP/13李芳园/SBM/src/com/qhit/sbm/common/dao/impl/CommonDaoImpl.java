package com.qhit.sbm.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qhit.sbm.common.dao.CommonDao;
import com.qhit.sbm.utils.DBManager;


public class CommonDaoImpl implements CommonDao {
private Connection con = null;
private PreparedStatement ps = null; 
	@Override
	public int getCount(String tableName, List<String> wheres, List<String> values) {
		con = DBManager.getConnection();
		String sql = "select count(*) as count from " + tableName + " ";
		if (wheres != null && wheres.size()>0) {
			sql += " where ";
			for (int i = 0; i < wheres.size(); i++) {
				sql += wheres.get(i)+" = "+values.get(i)+" and ";
			}
			sql += "1 = 1";
		}
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return 0;
	}

}
