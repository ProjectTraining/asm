package com.asm.dao;

import java.util.List;

import com.asm.domain.AssetSort;

public interface AssetSortDao extends CommonDao<AssetSort>{
	public abstract boolean addSort(AssetSort assetSort);
	public abstract boolean delSort(AssetSort assetSort);
	public abstract List<AssetSort> findList();
	public abstract AssetSort findSort(String assetSortId);
	public abstract boolean updateSort(AssetSort assetSort);
	public abstract List<AssetSort> queryForPage(final String hql, final int offset, final int length);
	public abstract int getAllRowCount(String hql);
	public abstract List<AssetSort> findSortByName(String assetSortName);
}
