package com.asm.service;

import com.asm.domain.User;

public interface UserService {

	public abstract User checkUserExist(String userName, String passWord);

}