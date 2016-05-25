package com.asm.service;

import java.util.List;

import com.asm.domain.AssetSort;
import com.asm.domain.Dept;
import com.asm.util.PageBean;

public interface AssetSortService {
	public abstract List<AssetSort> findList();  
	public abstract boolean addSort(AssetSort assetSort);
	public abstract boolean delSort(AssetSort assetSort);
	public abstract boolean updateSort(AssetSort assetSort); 
	public abstract AssetSort findSort(String assetSortId);
	public PageBean SplitPage(int pageSize, int page);
	public abstract List<AssetSort> findSortByName(String assetSortName);
}
