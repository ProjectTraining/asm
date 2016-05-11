package com.asm.service;

import java.util.List;

import com.asm.domain.Dept;


public interface DeptService {
	public void regDept(Dept dept);

	public List<Dept> findAllUsers();

	public void delete(Dept dept);

	public void update(Dept dept);

	public Dept findUserById(int id);
}
