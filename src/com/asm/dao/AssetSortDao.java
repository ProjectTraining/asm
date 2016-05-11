package com.asm.dao;

import java.util.List;

import com.asm.domain.AssetSort;

public interface AssetSortDao {
	public abstract boolean addSort(AssetSort tasset);
	public abstract boolean delSort(AssetSort tasset);
	public abstract List<AssetSort> findList();
	
}
