package com.asm.dao;

import java.util.List;
import com.asm.domain.Dept;

/**
 * @description 部门action
 * @Author: 赵楠（作者）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-4-12 （创建日期）
 */
public interface deptDao extends CommonDao<Dept>{
	public abstract void saveDept(Dept dept);
    public abstract List<Dept> findAll();
    public abstract void removeUser(Dept user);  
    public abstract void updateUser(Dept user);  
    public abstract Dept findUserById(int id);
	public abstract Dept getDept(String deptName);
	public abstract boolean checkDeptExistByName(String userName);
	
	/**   
	 * 分页查询   
	 * @param hql  查询条件   
	 * @param offset  开始记录   
	 * @param length  一次查询几条记录   
	 * @return 查询的记录集合   
	 */    
	public List<Dept> queryForPage(final String hql,final int offset,final int length);
	
	/**   
	 * 查询所有的记录数   
	 * @param hql 查询条件   
	 * @return 总记录数   
	 */    
	public int getAllRowCount(String hql);    
}
