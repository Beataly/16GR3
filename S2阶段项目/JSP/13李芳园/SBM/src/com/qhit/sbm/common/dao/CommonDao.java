package com.qhit.sbm.common.dao;

import java.util.List;

public interface CommonDao {
	//总记录数的业务
		public int getCount(String tableName,List<String> wheres,List<String> values);
	
}
