package com.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.asm.dao.ParameterDao;
import com.asm.domain.Parameter;
import com.asm.service.ParameterService;


@Transactional(readOnly = false)
@Service("parameterService")
public class ParameterServiceImpl implements ParameterService {
	@Autowired
	private ParameterDao parameterDao;

	@Override
	public Parameter checkparameterExist(String parameterName) {
		return parameterDao.getParameter(parameterName);
	}

	@Override
	public void updateParamter(Parameter parameter) {
		parameterDao.save(parameter);
	}
	
	@Override
	public List<Parameter> scanTable(){
		return parameterDao.scan();
	}
	
	@Override
	public boolean delParameter(Parameter parameter){
		return parameterDao.delParameter(parameter);
	}
}
