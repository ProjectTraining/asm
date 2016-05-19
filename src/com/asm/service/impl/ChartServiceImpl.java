package com.asm.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asm.service.ChartService;



@Transactional(readOnly = true)
@Service("chartService")
public class ChartServiceImpl implements ChartService {
	private HibernateTemplate hibernateTemplate;
	@Override
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {	
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	@Override
	public List<Object[]> findNameAndNumByAssetSortLv1() {
		// TODO Auto-generated method stub
		final String sql = "SELECT assetsort.assetSortName as assetName,sum(asset.price) as price " +
			     "FROM  t_asset as asset,t_assetSort as assetsort " + 
                "WHERE asset.assetParentId = assetsort.assetSortId  group by assetsort.assetSortId";
	List<Object[]> list = (List<Object[]>)this.getHibernateTemplate().execute(new HibernateCallback(){

		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session.createSQLQuery(sql);
			return query.list();
		}
	});
	return list;
	}
	
	@Override
	public List<Object[]> findNameAndNumByAssetSortLv2(String assetSortId) {
		// TODO Auto-generated method stub
		final String sql = "SELECT assetsort.assetSortName as assetName,sum(asset.price) as price " +
			     "FROM  t_asset as asset,t_assetSort as assetsort " + 
                "WHERE asset.assetSortId = assetsort.assetSortId and assetsort.parentId='"+assetSortId+"' group by assetsort.assetSortId";
	List<Object[]> list = (List<Object[]>)this.getHibernateTemplate().execute(new HibernateCallback(){

		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session.createSQLQuery(sql);
			return query.list();
		}
	});
	return list;
	}
	


}
