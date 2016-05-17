package com.asm.service;

import java.util.List;

import com.asm.domain.Dept;
import com.asm.util.PageBean;


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
	public PageBean queryForPage(int pageSize,int page); 
}
