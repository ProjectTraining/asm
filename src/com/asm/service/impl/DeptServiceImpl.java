package com.asm.service.impl;

import java.util.List;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.deptDao;
import com.asm.domain.Dept;
import com.asm.domain.User;
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
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean delete(Dept dept) {
		try{
		System.out.println("---" + dept.getDeptId()+ "---" + dept.getDeptName());
		//this.deptdao.removeUser(dept);
		deptdao.deleteObjectByIds(dept.getDeptId());
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
    public List<Dept> findAllUsers() {  
        return this.deptdao.findAllUsers();  
    }  
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void update(Dept dept) {
		this.deptdao.updateUser(dept);
	}
	@Override
	public Dept findDeptById(String id) {
		return this.deptdao.findObjectByID(id);
	}
/*	@Override
	public Dept checkDeptExist(String deptName) {
		// TODO Auto-generated method stub
		return deptdao.getDept(deptName);
	}*/
	@Override
	public boolean checkDeptExistByName(String deptName) {
		return deptdao.checkDeptExistByName(deptName);
	}
	@Override
	public boolean checkDeptExist(String deptName) {
		// TODO Auto-generated method stub
		return false;
	}
}
