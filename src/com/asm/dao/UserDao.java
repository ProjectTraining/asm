package com.asm.dao;

import com.asm.domain.User;

public interface UserDao extends CommonDao<User> {

	public abstract User getUser(String loginName, String loginPwd);

	public abstract boolean checkUserExistByName(String userName);

}