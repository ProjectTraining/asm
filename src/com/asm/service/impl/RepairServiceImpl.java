package com.asm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.AssetSortDao;
import com.asm.dao.RepairDao;
import com.asm.domain.AssetSort;
import com.asm.domain.Repair;
import com.asm.service.RepairService;



@Transactional(readOnly = true)
@Service("repairService")
public class RepairServiceImpl implements RepairService {
	@Autowired
	private RepairDao repairDao;
	
	@Autowired
	private AssetSortDao assetSortDao;
	
	@Override
	public List<Repair> listRepair(String assettName,String purchaseId) {
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
		List<Repair> list = repairDao
				.findCollectionByConditionNopage(hqlWhere, params, null);
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveRepair(Repair repair) {
		// TODO Auto-generated method stub
		repairDao.save(repair);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean remove(String repairId) {
		try {
			repairDao.deleteObjectByIds(repairId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Repair findRepair(String repairId) {
		// TODO Auto-generated method stub
		return repairDao.findObjectByID(repairId);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean updateRepair(Repair repair) {
		try {
		// TODO Auto-generated method stub
			repairDao.update(repair);
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
