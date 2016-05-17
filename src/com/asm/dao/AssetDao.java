package com.asm.dao;

import java.util.List;

import com.asm.domain.Asset;

public interface AssetDao extends CommonDao<Asset>{
	public abstract boolean addAsset(Asset asset);
	public abstract boolean delAsset(Asset asset);
	public abstract List<Asset> findList();
	public abstract Asset findAsset(String assetId);
	public abstract boolean updateAsset(Asset asset);
	
}
