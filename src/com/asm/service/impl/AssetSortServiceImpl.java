package com.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.AssetSortDao;
import com.asm.domain.AssetSort;
import com.asm.service.AssetSortService;
//@Transactional(readOnly=true)
@Service("assetSortService")
public class AssetSortServiceImpl implements AssetSortService{
	@Autowired
	private AssetSortDao assetdao;
	@Override
	public List<AssetSort> findList() {
		// TODO Auto-generated method stub
		return this.assetdao.findList();
	}

	@Override
	public boolean addSort(AssetSort tasset) {
		// TODO Auto-generated method stub
		return assetdao.addSort(tasset);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean delSort(AssetSort assetSort) {
		// TODO Auto-generated method stub
		return this.assetdao.delSort(assetSort);
	}

	@Override
	public boolean updateSort(AssetSort assetSort) {
		// TODO Auto-generated method stub
		return this.assetdao.updateSort(assetSort);
	}

	@Override
	public AssetSort findSort(String assetSortId) {
		// TODO Auto-generated method stub
		return this.assetdao.findSort(assetSortId);
	}

}
