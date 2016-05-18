package com.asm.service;

import java.util.List;

import com.asm.domain.Parameter;

public interface ParameterService {
	public abstract Parameter checkparameterExist(String parameterName);
	public abstract void updateParamter(Parameter parameter);
	public abstract List<Parameter> scanTable();
	public abstract boolean delParameter(Parameter parameter);
}
