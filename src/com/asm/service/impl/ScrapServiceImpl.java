package com.asm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.AssetSortDao;
import com.asm.dao.ScrapDao;
import com.asm.domain.AssetSort;
import com.asm.domain.Scrap;
import com.asm.service.ScrapService;



@Transactional(readOnly = true)
@Service("scrapService")
public class ScrapServiceImpl implements ScrapService {
	@Autowired
	private ScrapDao scrapDao;
	
	@Override
	public List<Scrap> listScrap(String assettName,String purchaseId) {
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
		List<Scrap> list = scrapDao
				.findCollectionByConditionNopage(hqlWhere, params, null);
		System.out.println("scrapDao size:"+list.size());
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveScrap(Scrap scrap) {
		// TODO Auto-generated method stub
		scrapDao.save(scrap);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean remove(String scrapId) {
		try {
			scrapDao.deleteObjectByIds(scrapId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Scrap findScrap(String scrapId) {
		// TODO Auto-generated method stub
		return scrapDao.findObjectByID(scrapId);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean updateScrap(Scrap scrap) {
		try {
		// TODO Auto-generated method stub
			scrapDao.update(scrap);
		return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
