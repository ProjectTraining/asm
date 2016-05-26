package com.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.dao.AllocateDao;
import com.asm.domain.Allocate;
import com.asm.service.AllocateService;
@Service("allocateService")
public class AllocateServiceImpl implements AllocateService {
	@Autowired
	private AllocateDao allocateDao;

	@Override
	public List<Allocate> findList() {
		// TODO Auto-generated method stub
		return this.allocateDao.findList();
	}
	
}
