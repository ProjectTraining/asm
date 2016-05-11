package com.asm.service;

import java.util.List;

import com.asm.domain.Dept;


public interface DeptService {
	public void regDept(Dept dept);

	public List<Dept> findAllUsers();

	public boolean delete(Dept dept);

	public void update(Dept dept);

	public Dept findDeptById(String id);
	public abstract boolean checkDeptExistByName(String userName);
	public abstract boolean checkDeptExist(String deptName);
}
