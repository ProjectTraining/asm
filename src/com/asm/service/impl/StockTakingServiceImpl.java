package com.asm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.StockTakingDao;
import com.asm.dao.UserDao;
import com.asm.domain.StockTaking;
import com.asm.domain.User;
import com.asm.service.StockTakingService;
import com.asm.service.UserService;
import com.asm.util.StringHelper;


@Transactional(readOnly = true)
@Service("stockTakingService")
public class StockTakingServiceImpl implements StockTakingService {
	@Autowired
	private StockTakingDao stockTakingDao;

	@Override
	public List<StockTaking> listStockTaking(String deptId,
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
		List<StockTaking> list = stockTakingDao
				.findCollectionByConditionNopage(hqlWhere, params, null);
		System.out.println("servicebegin3");
		System.out.println("size"+list.size());
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveStockTaking(StockTaking stockTaking) {
		// TODO Auto-generated method stub
		stockTakingDao.save(stockTaking);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean remove(String stockTakingId) {
		try {
			System.out.println("purchaseorderid"+stockTakingId);
			stockTakingDao.deleteObjectByIds(stockTakingId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public StockTaking findStockTaking(String stockTakingId) {
		// TODO Auto-generated method stub
		return stockTakingDao.findObjectByID(stockTakingId);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean updateStockTaking(StockTaking stockTaking) {
		try {
			stockTakingDao.update(stockTaking);
		return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
