package com.asm.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;


import com.asm.dao.CommonDao;
import com.asm.dao.impl.CommonDaoImpl;
import com.asm.util.GenericSuperClass;


public class CommonDaoImpl<T> implements CommonDao<T> {
	private HibernateTemplate hibernateTemplate;
	@SuppressWarnings("rawtypes")
	private Class entityClass = (Class)GenericSuperClass.getClass(this.getClass());
	/* (non-Javadoc)
	 * @see com.asm.dao.CommonDao#getHibernateTemplate()
	 */
	@Override
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	/* (non-Javadoc)
	 * @see com.asm.dao.CommonDao#setHibernateTemplate(org.springframework.orm.hibernate3.HibernateTemplate)
	 */
	@Override
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {	
		this.hibernateTemplate = hibernateTemplate;
	}
	/* (non-Javadoc)
	 * @see com.asm.dao.CommonDao#save(T)
	 */
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(entity);

	}

	/* (non-Javadoc)
	 * @see com.asm.dao.CommonDao#update(T)
	 */
	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(entity);
	}

	/* (non-Javadoc)
	 * @see com.asm.dao.CommonDao#findObjectByID(java.io.Serializable)
	 */
	@Override
	public T findObjectByID(Serializable id) {
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see com.asm.dao.CommonDao#deleteObjectByIds(java.io.Serializable)
	 */
	@Override
	public void deleteObjectByIds(Serializable... ids) {
		// TODO Auto-generated method stub
		for (int i = 0; ids != null && i < ids.length; i++) {
			Serializable id = ids[i];
			Object object = (Object) this.getHibernateTemplate().get(entityClass, id);
			this.getHibernateTemplate().delete(object);
		}
	}

	/* (non-Javadoc)
	 * @see com.asm.dao.CommonDao#deleteObjectByCollection(java.util.Collection)
	 */
	@Override
	public void deleteObjectByCollection(Collection<T> entities) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().deleteAll(entities);
	}


	/* (non-Javadoc)
	 * @see com.asm.dao.CommonDao#findCollectionByConditionNopage(java.lang.String, java.lang.Object[], java.util.LinkedHashMap)
	 */
	@Override
	public List<T> findCollectionByConditionNopage(String hqlWhere,
			final Object[] params, LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		String hql = "from " + entityClass.getSimpleName() + " o where 1=1 ";
		String hqlOrderBy = this.orderByCondition(orderby);
		hql = hql + hqlWhere + hqlOrderBy;
		final String finalHql = hql;
		List<T> list = (List<T>)this.getHibernateTemplate()
				.execute(new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query = session.createQuery(finalHql);
						setParams(query, params);	
						return query.list();
					}
				});
		return list;
	}
	/* (non-Javadoc)
	 * @see com.asm.dao.CommonDao#find(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<T> find(String queryString, Object[] values){
		return this.getHibernateTemplate().find(queryString,values);
		
	}
	private void setParams(Query query, Object[] params) {
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
	}

	private String orderByCondition(LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		StringBuffer sbuffer = new StringBuffer("");
		if (orderby != null) {
			sbuffer.append(" order by ");
			for (Map.Entry<String, String> entry : orderby.entrySet()) {
				sbuffer.append(" " + entry.getKey() + " " + entry.getValue()
						+ ",");
			}
			sbuffer.deleteCharAt(sbuffer.length() - 1);
		}
		return sbuffer.toString();
	}

}
