package com.asm.service;

import java.util.List;

import com.asm.domain.User;

public interface UserService {

	public abstract User checkUserExist(String userName, String passWord);

	public abstract List<User> listUser();

	public abstract boolean checkUserExistByName(String userName);

	public abstract void saveUser(User user1);

	public abstract boolean remove(String userID);

	public abstract User findUser(String userId);

	public abstract boolean updateUser(User user);

}