package com.asm.service;

import java.util.List;

import com.asm.domain.AssetSort;

public interface AssetSortService {
	public abstract List<AssetSort> findList();  
	public abstract boolean addSort(AssetSort assetSort);
	public abstract boolean delSort(AssetSort assetSort);
	public abstract boolean updateSort(AssetSort assetSort); 
	public abstract AssetSort findSort(String assetSortId);
}
