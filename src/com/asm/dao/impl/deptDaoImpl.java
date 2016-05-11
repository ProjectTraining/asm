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


@Repository("deptDao")
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

	
}
