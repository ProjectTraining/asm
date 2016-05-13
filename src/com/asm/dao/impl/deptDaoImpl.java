package com.asm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.asm.dao.deptDao;
import com.asm.domain.Dept;
import com.asm.domain.User;


@Repository("deptDao")  // @Repository对应数据访问层Bean,注解是告诉Spring，让Spring创建一个名字叫“deptDao”的DeptDaoImpl实例
public class deptDaoImpl extends CommonDaoImpl<Dept> implements deptDao{

	@Override
	public void saveDept(Dept dept) {
		System.out.println("heihie--"+dept.getDeptId());
		this.getHibernateTemplate().save(dept);
	}

	@SuppressWarnings("unchecked")
	public List<Dept> findAllUsers() {
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
	
}
