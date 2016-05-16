package com.asm.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.AssetDao;
import com.asm.domain.Asset;
import com.asm.service.AssetService;



@Transactional(readOnly = true)
@Service("assetService")
public class AssetServiceImpl implements AssetService {
	@Autowired
	private AssetDao assetDao;
	
	@Override
	public List<Asset> listAsset(String assettName,String assetId) {
		// TODO Auto-generated method stub
		// 组织查询条件
		String hqlWhere = "";
		List<Object> paramsList = new ArrayList<Object>();

		if (null != assettName && !"".equals(assettName)) {
			hqlWhere += " and o.assettName like ?";
			paramsList.add("%"+assettName+"%");
		}
		if (null != assetId && !"".equals(assetId)) {
			hqlWhere += " and o.purchaseOrderId =?";
			paramsList.add(assetId);
		}
		
		Object[] params = paramsList.toArray();
		List<Asset> list = assetDao
				.findCollectionByConditionNopage(hqlWhere, params, null);
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveAsset(Asset asset) {
		// TODO Auto-generated method stub
		assetDao.save(asset);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean remove(String assetId) {
		try {
			assetDao.deleteObjectByIds(assetId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Asset findAsset(String assetId) {
		// TODO Auto-generated method stub
		return assetDao.findObjectByID(assetId);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean updateAsset(Asset asset) {
		try {
		// TODO Auto-generated method stub
			assetDao.update(asset);
		return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


}
