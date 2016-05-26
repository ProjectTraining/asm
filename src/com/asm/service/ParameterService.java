package com.asm.service;

import java.util.List;

import com.asm.domain.Parameter;
import com.asm.util.PageBean;

public interface ParameterService {
	public abstract Parameter checkparameterExist(String parameterName);
	public abstract Parameter getParameterById(String parameterId);
	public abstract void saveParamter(Parameter parameter);
	public abstract void updateParamter(Parameter parameter);
	public abstract List<Parameter> scanTable();
	public abstract boolean delParameter(Parameter parameter);
	public PageBean queryForPage(int pageSize,int page);
}
