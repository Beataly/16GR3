package com.qhit.sbm.goods.dao;

import com.qhit.sbm.goods.bean.Goods;

public interface GoodsDao {
	//更新库存
		int updateStore(int num, int goodsId);
	//根据商品名称去查询商品信息
		Goods getGoodsInfoByName(String goodsName);

}
