package com.asm.dao;

import java.util.List;

import com.asm.domain.Parameter;

public interface ParameterDao {
	public abstract Parameter getParameter(String parameterName);
	public abstract void save(Parameter parameter);
	public abstract List<Parameter> scan();
}
