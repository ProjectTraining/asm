package com.asm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.dao.AllocateDao;
import com.asm.service.AllocateService;
@Service("allocateService")
public class AllocateServiceImpl implements AllocateService {
	@Autowired
	private AllocateDao allocateDao;
	
}
