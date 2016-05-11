package com.asm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asm.dao.AssetSortDao;
import com.asm.dao.CommonDao;
import com.asm.domain.AssetSort;
@Repository("assetSortDao")
public class AssetSortDaoImpl extends CommonDaoImpl<AssetSort> implements AssetSortDao {

	@Override
	public boolean addSort(AssetSort asset) {
		// TODO Auto-generated method stub
		save(asset);
		return true;
	}

	@Override
	public boolean delSort(AssetSort asset) {
		// TODO Auto-generated method stub
		this.deleteObjectByIds(asset.getAssetId());
		return true;
	}

	@Override
	public List<AssetSort> findList() {
		// TODO Auto-generated method stub
		String hql = "from AssetSort t ";
		List<AssetSort> list=(List<AssetSort>)find(hql, null);
		return list;
	}

}
