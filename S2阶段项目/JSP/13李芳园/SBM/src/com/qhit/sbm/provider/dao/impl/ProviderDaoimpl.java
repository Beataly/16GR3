package com.qhit.sbm.provider.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.dao.ProviderDao;
import com.qhit.sbm.utils.DBManager;

public class ProviderDaoimpl implements ProviderDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	@Override
	public List<Provider> getAllProvider() {
		List<Provider> list = new ArrayList<>();
		Provider provider = null;
		con = DBManager.getConnection();
		String sql = "select * from tb_provider";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				provider = new Provider(
						rs.getInt("providerId"), 
						rs.getString("providerName"), 
						rs.getString("providerDetail"), 
						rs.getString("contact"), 
						rs.getString("telephone"), 
						rs.getString("facsimile"), 
						rs.getString("address"));
				list.add(provider);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
