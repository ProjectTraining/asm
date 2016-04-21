package com.asm.dao;

import com.asm.domain.User;

public interface UserDao {

	public abstract User getUser(String loginName, String loginPwd);

}