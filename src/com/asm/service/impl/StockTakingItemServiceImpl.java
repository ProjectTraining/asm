package com.asm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.AssetSortDao;
import com.asm.dao.StockTakingItemDao;
import com.asm.domain.AssetSort;
import com.asm.domain.StockTakingItem;
import com.asm.service.StockTakingItemService;



@Transactional(readOnly = true)
@Service("stockTakingItemService")
public class StockTakingItemServiceImpl implements StockTakingItemService {
	@Autowired
	private StockTakingItemDao stockTakingItemDao;
	
	@Autowired
	private AssetSortDao assetSortDao;
	
	@Override
	public List<StockTakingItem> listStockTakingItem(String assettName,String stockTakingId) {
		// TODO Auto-generated method stub
		// 组织查询条件
		String hqlWhere = "";
		List<Object> paramsList = new ArrayList<Object>();

		if (null != assettName && !"".equals(assettName)) {
			hqlWhere += " and o.asset.assetName like ?";
			paramsList.add("%"+assettName+"%");
		}
		if (null != stockTakingId && !"".equals(stockTakingId)) {
			hqlWhere += " and o.stockTaking.stockTakingId =?";
			paramsList.add(stockTakingId);
		}
		
		Object[] params = paramsList.toArray();
		System.out.println("hqlWhere"+hqlWhere);
		List<StockTakingItem> list = stockTakingItemDao
				.findCollectionByConditionNopage(hqlWhere, params, null);
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveStockTakingItem(StockTakingItem stockTakingItem) {
		// TODO Auto-generated method stub
		stockTakingItemDao.save(stockTakingItem);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean remove(String stockTakingItemId) {
		try {
			stockTakingItemDao.deleteObjectByIds(stockTakingItemId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public StockTakingItem findStockTakingItem(String stockTakingItemId) {
		// TODO Auto-generated method stub
		return stockTakingItemDao.findObjectByID(stockTakingItemId);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean updateStockTakingItem(StockTakingItem stockTakingItem) {
		try {
		// TODO Auto-generated method stub
			stockTakingItemDao.update(stockTakingItem);
		return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<AssetSort> findAssertSortList() {
		// TODO Auto-generated method stub
		String hql = "select distinct c " +
					"from AssetSort c " +
					"join fetch c.listAssetSort " +
					"where c.parentId=?";
		Object[] params = {"0"};
		List<AssetSort> list = (List<AssetSort>)assetSortDao.find(hql,params);
		return list;
		
	}

}
