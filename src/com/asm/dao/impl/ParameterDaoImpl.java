package com.asm.dao.impl;

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
		if (list.size() > 0)
			return list;
		else
			return null;
	}

}
