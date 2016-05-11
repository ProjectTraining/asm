package com.asm.service;

import java.util.List;

import com.asm.domain.AssetSort;

public interface AssetSortService {
	public abstract List<AssetSort> findList();  
	public abstract boolean addSort(AssetSort asset);
	public abstract boolean delSort(AssetSort asset);
}
