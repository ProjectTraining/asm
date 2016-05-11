package com.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.deptDao;
import com.asm.domain.Dept;
import com.asm.service.DeptService;


@Transactional(readOnly=false)
@Service("deptService")
public class DeptServiceImpl implements DeptService {
	@Autowired
	private deptDao deptdao;
	@Override
	public void regDept(Dept dept) {
		System.out.println("到这里了————"+dept.getDeptId());
		deptdao.saveDept(dept);
	}
	@Override
	public void delete(Dept dept) {
		System.out.println("---" + dept.getDeptId()+ "---" + dept.getDeptName());
		this.deptdao.removeUser(dept);
	}
	@Override
    public List<Dept> findAllUsers() {  
        return this.deptdao.findAllUsers();  
    }  
	@Override
	public void update(Dept dept) {
		this.deptdao.updateUser(dept);
	}
	@Override
	public Dept findUserById(int id) {
		return this.deptdao.findUserById(id);
	}
}
