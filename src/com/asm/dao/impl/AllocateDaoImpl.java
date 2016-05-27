package com.asm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asm.dao.AllocateDao;
import com.asm.domain.Allocate;
@Repository("allocateDao")
public class AllocateDaoImpl extends CommonDaoImpl<Allocate>implements AllocateDao {

	@Override
	public List<Allocate> findList() {
		// TODO Auto-generated method stub
		String hql = "from Allocate t ";
		List<Allocate> list = (List<Allocate>) find(hql, null);
		return list;
	}

	@Override
	public void add(Allocate allocate) {
		// TODO Auto-generated method stub
		this.save(allocate);
	}
	
}
