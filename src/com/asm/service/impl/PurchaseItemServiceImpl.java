package com.asm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.AssetSortDao;
import com.asm.dao.PurchaseItemDao;
import com.asm.domain.AssetSort;
import com.asm.domain.PurchaseItem;
import com.asm.service.PurchaseItemService;



@Transactional(readOnly = true)
@Service("purchaseItemService")
public class PurchaseItemServiceImpl implements PurchaseItemService {
	@Autowired
	private PurchaseItemDao purchaseItemDao;
	
	@Autowired
	private AssetSortDao assetSortDao;
	
	@Override
	public List<PurchaseItem> listPurchaseItem(String assettName,String purchaseId) {
		// TODO Auto-generated method stub
		// 组织查询条件
		String hqlWhere = "";
		List<Object> paramsList = new ArrayList<Object>();

		if (null != assettName && !"".equals(assettName)) {
			hqlWhere += " and o.assettName like ?";
			paramsList.add("%"+assettName+"%");
		}
		if (null != purchaseId && !"".equals(purchaseId)) {
			hqlWhere += " and o.purchaseOrderId =?";
			paramsList.add(purchaseId);
		}
		
		Object[] params = paramsList.toArray();
		List<PurchaseItem> list = purchaseItemDao
				.findCollectionByConditionNopage(hqlWhere, params, null);
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void savePurchaseItem(PurchaseItem purchaseItem) {
		// TODO Auto-generated method stub
		purchaseItemDao.save(purchaseItem);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean remove(String purchaseItemId) {
		try {
			purchaseItemDao.deleteObjectByIds(purchaseItemId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PurchaseItem findPurchaseItem(String purchaseItemId) {
		// TODO Auto-generated method stub
		return purchaseItemDao.findObjectByID(purchaseItemId);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean updatePurchaseItem(PurchaseItem purchaseItem) {
		try {
		// TODO Auto-generated method stub
			purchaseItemDao.update(purchaseItem);
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
