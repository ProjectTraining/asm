package com.asm.dao;

import java.util.List;
import com.asm.domain.Dept;
import com.asm.domain.User;


public interface deptDao extends CommonDao<Dept>{
	public abstract void saveDept(Dept dept);
    public abstract List<Dept> findAllUsers();
    public abstract void removeUser(Dept user);  
    public abstract void updateUser(Dept user);  
    public abstract Dept findUserById(int id);
	public abstract Dept getDept(String deptName);
	public abstract boolean checkDeptExistByName(String userName);
}
