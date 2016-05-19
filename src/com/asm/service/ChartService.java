package com.asm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;


public interface ChartService {

	public abstract List<Object[]> findNameAndNumByAssetSortLv1();
	public abstract List<Object[]> findNameAndNumByAssetSortLv2(String assetSortId);
	
	public abstract HibernateTemplate getHibernateTemplate();

	@Resource
	public abstract void setHibernateTemplate(
			HibernateTemplate hibernateTemplate);
	
	

}