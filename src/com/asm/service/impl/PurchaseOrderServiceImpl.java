package com.asm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.PurchaseOrderDao;
import com.asm.dao.UserDao;
import com.asm.domain.PurchaseOrder;
import com.asm.domain.User;
import com.asm.service.PurchaseOrderService;
import com.asm.service.UserService;
import com.asm.util.StringHelper;


@Transactional(readOnly = true)
@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	@Autowired
	private PurchaseOrderDao purchaseOrderDao;

	@Override
	public List<PurchaseOrder> listPurchaseOrder(String deptId,
			Date dateBegin, Date dateEnd) {
		// TODO Auto-generated method stub
		// 组织查询条件
		System.out.println("servicebegin");
		String hqlWhere = "";
		List<Object> paramsList = new ArrayList<Object>();

		if (null != deptId && !"".equals(deptId)) {
			hqlWhere += " and o.purchaseDeptId = ? ";
			paramsList.add(deptId);
		}
		if (null != dateBegin && null != dateEnd) {
			hqlWhere += " and o.purchaseDate >=? and o.purchaseDate<= ?";
			paramsList.add(dateBegin);
			paramsList.add(dateEnd);
		}
		System.out.println("servicebegin2");
		Object[] params = paramsList.toArray();
		List<PurchaseOrder> list = purchaseOrderDao
				.findCollectionByConditionNopage(hqlWhere, params, null);
		System.out.println("servicebegin3");
		System.out.println("size"+list.size());
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void savePurchaseOrder(PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub
		purchaseOrderDao.save(purchaseOrder);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean remove(String purchaseOrderId) {
		try {
			System.out.println("purchaseorderid"+purchaseOrderId);
			purchaseOrderDao.deleteObjectByIds(purchaseOrderId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PurchaseOrder findPurchaseOrder(String purchaseOrderId) {
		// TODO Auto-generated method stub
		return purchaseOrderDao.findObjectByID(purchaseOrderId);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		try {
		// TODO Auto-generated method stub
			System.out.println("state"+purchaseOrder.getPurchaseDate());
			purchaseOrderDao.update(purchaseOrder);
		return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
