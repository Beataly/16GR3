package com.qhit.sbm.goods.service;

import com.qhit.sbm.goods.bean.Goods;

public interface GoodsService {
//更新库存
	int updateStore(int num, int goodsId);
//根据商品名称去查询商品信息
	Goods getGoodsInfoByName(String goodsName);

}
