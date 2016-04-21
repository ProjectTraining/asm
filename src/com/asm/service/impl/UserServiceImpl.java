package com.asm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.UserDao;
import com.asm.domain.User;
import com.asm.service.UserService;



@Transactional(readOnly=true)
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	/* (non-Javadoc)
	 * @see com.asm.service.UserService1#checkEmployeeExist(java.lang.String, java.lang.String)
	 */
	@Override
	public User checkUserExist(String userName, String passWord) {
		// TODO Auto-generated method stub
		return userDao.getUser(userName, passWord);
	}
}
