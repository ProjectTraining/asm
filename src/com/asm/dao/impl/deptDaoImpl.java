package com.asm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.asm.dao.deptDao;
import com.asm.domain.Dept;
import com.asm.domain.User;

/**
 * @description 部门
 * @Author: 赵楠（作者）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-4-12 （创建日期）
 */
@Repository("deptDao")  // @Repository对应数据访问层Bean,注解是告诉Spring，让Spring创建一个名字叫“deptDao”的DeptDaoImpl实例
public class deptDaoImpl extends CommonDaoImpl<Dept> implements deptDao{

	@Override
	public void saveDept(Dept dept) {
		System.out.println("heihie--"+dept.getDeptId());
		this.getHibernateTemplate().save(dept);
	}

	@SuppressWarnings("unchecked")
	public List<Dept> findAll() {
		String hql = "from Dept d order by d.deptId asc";
		List<Dept> list = (List<Dept>) this.getHibernateTemplate().find(hql);
		return list;
	}

	public void removeUser(Dept dept) {
		System.out.println("fjgdfjkghdjkfghkdf");
		this.getHibernateTemplate().delete(dept);
	}
	
	public void updateUser(Dept dept) {
		this.getHibernateTemplate().update(dept);
	}

	public Dept findUserById(int id) {
		Dept dept = null;
		dept = (Dept) this.getHibernateTemplate().get(Dept.class, id);
		return dept;
	}
	@Override
	public Dept getDept(String deptName) {
		// TODO Auto-generated method stub
		String hql = "from Dept d where d.deptName=?";
		List<Dept> list=(List<Dept>)find(hql, new String[]{deptName});
		if(list.size()>0)
			return list.get(0);
		else 
			return null;
	}
	@Override
	public boolean checkDeptExistByName(String username) {
		String hql = "from Dept d where d.deptName=?";
		List<Dept> list=(List<Dept>)find(hql, new String[]{username});
		if(list.size()>0)
			return true;
		else 
			return false;
	}
	/**   
	 * 分页查询   
	 * @param hql  查询条件   
	 * @param offset  开始记录   
	 * @param length  一次查询几条记录   
	 * @return 查询的记录集合   
	 */    
	@SuppressWarnings("unchecked")
	public List<Dept> queryForPage(final String hql, final int offset, final int length) {
		List<Dept> list = findAll();
		List<Dept> list1=new ArrayList<Dept>();
		if(list.size()==0){
			return list;
		}
		for(int i=0;i<offset+length&&i<=list.size();i++){
			if(i>=offset){
				list1.add(list.get(i));
			}
		}
		System.out.println("这一页的记录是："+list1.size());
		return list1;
	}

	/**
	 * 查询所有的记录数
	 * 
	 * @param hql
	 *            查询条件
	 * @return 总记录数
	 */
	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find(hql).size();
	}

}
