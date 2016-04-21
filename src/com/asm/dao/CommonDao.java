package com.asm.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

public interface CommonDao<T> {

	public abstract HibernateTemplate getHibernateTemplate();

	@Resource
	public abstract void setHibernateTemplate(
			HibernateTemplate hibernateTemplate);

	public abstract void save(T entity);

	public abstract void update(T entity);

	public abstract T findObjectByID(Serializable id);

	public abstract void deleteObjectByIds(Serializable... ids);

	public abstract void deleteObjectByCollection(Collection<T> entities);

	public abstract List<T> findCollectionByConditionNopage(String hqlWhere,
			final Object[] params, LinkedHashMap<String, String> orderby);

	public abstract List<T> find(String queryString, Object[] values);

}