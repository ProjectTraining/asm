package com.asm.dao;

import java.util.List;

import com.asm.domain.AssetSort;

public interface AssetSortDao extends CommonDao<AssetSort>{
	public abstract boolean addSort(AssetSort assetSort);
	public abstract boolean delSort(AssetSort assetSort);
	public abstract List<AssetSort> findList();
	public abstract AssetSort findSort(String assetSortId);
	public abstract boolean updateSort(AssetSort assetSort);
	
}
