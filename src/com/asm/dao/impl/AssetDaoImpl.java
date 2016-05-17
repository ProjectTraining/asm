package com.asm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asm.dao.AssetDao;

import com.asm.domain.Asset;

@Repository("assetDao")
public class AssetDaoImpl extends CommonDaoImpl<Asset> implements
		AssetDao {

	@Override
	public boolean addAsset(Asset asset) {
		// TODO Auto-generated method stub
		save(asset);
		return true;
	}

	@Override
	public boolean delAsset(Asset asset) {
		// TODO Auto-generated method stub
		this.deleteObjectByIds(asset.getAssetId());
		return true;

	}
	@Override
	public Asset findAsset(String assetId){
		return findObjectByID(assetId);
	}

	@Override
	public List<Asset> findList() {
		// TODO Auto-generated method stub
		String hql = "from Asset t ";
		List<Asset> list = (List<Asset>) find(hql, null);
		return list;
	}

	@Override
	public boolean updateAsset(Asset asset) {
		// TODO Auto-generated method stub
		this.update(asset);
		return true;
	}

}
