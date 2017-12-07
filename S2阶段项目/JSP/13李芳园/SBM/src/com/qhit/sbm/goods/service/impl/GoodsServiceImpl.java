package com.qhit.sbm.goods.service.impl;

import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.dao.impl.GoodsDaoImpl;
import com.qhit.sbm.goods.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {

	@Override
	public int updateStore(int num, int goodsId) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().updateStore(num,goodsId);
	}

	@Override
	public Goods getGoodsInfoByName(String goodsName) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().getGoodsInfoByName(goodsName);
	}

}
