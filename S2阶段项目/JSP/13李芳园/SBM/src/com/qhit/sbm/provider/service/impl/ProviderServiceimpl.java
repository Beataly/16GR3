package com.qhit.sbm.provider.service.impl;

import java.util.List;

import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.dao.impl.ProviderDaoimpl;
import com.qhit.sbm.provider.service.ProviderService;

public class ProviderServiceimpl implements ProviderService {

	@Override
	public List<Provider> getAllProvider() {
		// TODO Auto-generated method stub
		return new ProviderDaoimpl().getAllProvider();
	}

}
