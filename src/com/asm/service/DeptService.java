package com.asm.service;

import java.util.List;

import com.asm.domain.Dept;
import com.asm.util.PageBean;

/**
 * @description 部门
 * @Author: 赵楠（作者）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-4-12 （创建日期）
 */
public interface DeptService {
	public void regDept(Dept dept);

	public List<Dept> findAllUsers();

	public boolean delete(Dept dept);

	public void update(Dept dept);

	public Dept findDeptById(String id);
	public abstract boolean checkDeptExistByName(String userName);
	public abstract boolean checkDeptExist(String deptName);
	/**   
	 * 分页查询     
	 * @param pageSize  每页显示多少记录   
	 * @param currentPage 当前页   
	 * @return 封装了分页信息的bean   
	 */    
	public PageBean queryForPage(String hql,int pageSize,int page); 
}
