package com.asm.service;

import java.util.List;

import com.asm.domain.AssetSort;
import com.asm.domain.StockTakingItem;

public interface StockTakingItemService {

	public abstract List<StockTakingItem> listStockTakingItem(String assettName,String purchaseId);

	public abstract void saveStockTakingItem(StockTakingItem stockTakingItem);

	public abstract boolean remove(String stockTakingItemId);

	public abstract StockTakingItem findStockTakingItem(String stockTakingItemId);

	public abstract boolean updateStockTakingItem(StockTakingItem stockTakingItem);
	
	public abstract List<AssetSort> findAssertSortList();

}