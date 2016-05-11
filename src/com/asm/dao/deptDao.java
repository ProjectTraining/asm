package com.asm.dao;

import java.util.List;

import com.asm.domain.Dept;


public interface deptDao {
	public abstract void saveDept(Dept dept);
    public abstract List<Dept> findAllUsers();
    public abstract void removeUser(Dept user);  
    public abstract void updateUser(Dept user);  
    public abstract Dept findUserById(int id);
}
