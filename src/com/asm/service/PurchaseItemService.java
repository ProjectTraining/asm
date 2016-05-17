package com.asm.service;

import java.util.Date;
import java.util.List;

import com.asm.domain.AssetSort;
import com.asm.domain.PurchaseItem;
import com.asm.domain.User;

public interface PurchaseItemService {

	public abstract List<PurchaseItem> listPurchaseItem(String assettName,String purchaseId);

	public abstract void savePurchaseItem(PurchaseItem purchaseItem);

	public abstract boolean remove(String purchaseItemId);

	public abstract PurchaseItem findPurchaseItem(String purchaseItemId);

	public abstract boolean updatePurchaseItem(PurchaseItem purchaseItem);
	
	public abstract List<AssetSort> findAssertSortList();

}