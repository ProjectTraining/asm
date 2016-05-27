package com.asm.dao;

import java.util.List;

import com.asm.domain.Parameter;

public interface ParameterDao {
	public abstract Parameter getParameter(String parameterName);
	public abstract Parameter getParameterById(String parameterId);
	public abstract void save(Parameter parameter);
	public abstract void update(Parameter parameter);
	public abstract List<Parameter> scan();
	public abstract boolean delParameter(Parameter parameter);
	public List<Parameter> queryForPage(final String hql,final int offset,final int length);
	public int getAllRowCount(String hql);
}
