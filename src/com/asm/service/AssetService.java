package com.asm.service;

import java.util.List;

import com.asm.domain.Asset;

public interface AssetService {

	public abstract List<Asset> listAsset(String assettName,String purchaseId);

	public abstract void saveAsset(Asset asset);

	public abstract boolean remove(String assetId);

	public abstract Asset findAsset(String assetId);

	public abstract boolean updateAsset(Asset asset);
	

}