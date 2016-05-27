package com.asm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.asm.dao.ParameterDao;
import com.asm.domain.Parameter;

@Repository("parameterDao")
public class ParameterDaoImpl extends CommonDaoImpl<Parameter> implements
		ParameterDao {

	@Override
	public Parameter getParameter(String parameterName) {
		String hql = "from Parameter p where p.parameterName=?";
		List<Parameter> list = (List<Parameter>) find(hql,
				new String[] { parameterName });
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public List<Parameter> scan() {
		String hql = "from Parameter p";
		List<Parameter> list = (List<Parameter>) find(hql, null);
		System.out.println("+++++" + list.size());
		return list;
	}
	
	@Override
	public boolean delParameter(Parameter parameter){
		this.deleteObjectByIds(parameter.getParameterId());
		return true;
	}

	@Override
	public Parameter getParameterById(String parameterId) {
		return this.findObjectByID(parameterId);
	}
	
	public List<Parameter> findAll() {
		String hql = "from Parameter p order by p.parameterName asc";
		@SuppressWarnings("unchecked")
		List<Parameter> list = (List<Parameter>) this.getHibernateTemplate().find(hql);
		return list;
	}
	
	public List<Parameter> queryForPage(final String hql, final int offset, final int length) {
		List<Parameter> list = findAll();
		if(list.size() <= 0){
			return null;
		}
		List<Parameter> list1=new ArrayList<Parameter>();
		for(int i=0;i<offset+length;i++){
			if(i>=offset){
				list1.add(list.get(i));
			}
		}
		System.out.println("这一页的记录是："+list1.size());
		return list1;
	}
	
	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find(hql).size();
	}
}
