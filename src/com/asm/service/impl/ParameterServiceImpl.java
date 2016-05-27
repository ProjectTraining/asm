package com.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.asm.dao.ParameterDao;
import com.asm.domain.Parameter;
import com.asm.service.ParameterService;
import com.asm.util.ParameterPageBean;


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
	public void saveParamter(Parameter parameter) {
		parameterDao.save(parameter);
	}
	
	@Override
	public void updateParamter(Parameter parameter) {
		parameterDao.update(parameter);
	}
	
	@Override
	public List<Parameter> scanTable(){
		return parameterDao.scan();
	}
	
	@Override
	public boolean delParameter(Parameter parameter){
		System.err.println("111parameter~~~~" + parameter.getParameterId());
		return parameterDao.delParameter(parameter);
	}

	@Override
	public Parameter getParameterById(String parameterId) {
		return parameterDao.getParameterById(parameterId);
	}
	
	public ParameterPageBean queryForPage(int pageSize, int page) {
		final String hql = "from Parameter p order by p.parameterName asc"; // 查询语句
		int allRow = parameterDao.getAllRowCount(hql); // 总记录数
		int totalPage = ParameterPageBean.countTatalPage(pageSize, allRow); // 总页数
		System.out.println("总共记录数："+totalPage);
		final int offset = ParameterPageBean.countOffset(pageSize, page); // 当前页开始记录
		final int currentPage = ParameterPageBean.countCurrentPage(page); // 当前页
		int length = 0; // 每页记录数
		if(currentPage==totalPage){
			length=allRow-(currentPage-1)*pageSize;
		}else {
			length=pageSize;
		}
		List<Parameter> list = parameterDao.queryForPage(hql, offset, length); //得到在分页内的数据
		// 把分页信息保存到Bean当中
		ParameterPageBean parameterPageBean = new ParameterPageBean();
		parameterPageBean.setPageSize(pageSize);
		parameterPageBean.setCurrentPage(currentPage);
		parameterPageBean.setAllRow(allRow);
		parameterPageBean.setTotalPage(totalPage);
		parameterPageBean.setList(list);
		return parameterPageBean;
	}
}
