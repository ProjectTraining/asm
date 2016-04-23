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
	
	public List<User> listUser() {
		String hqlWhere = " ";
		List<User> list = userDao.findCollectionByConditionNopage(
				hqlWhere, null, null);
		return list;
	}
	
	public boolean checkUserExistByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.checkUserExistByName(userName);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try {
		// TODO Auto-generated method stub
			userDao.getHibernateTemplate().saveOrUpdate(user);
		return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean remove(String userId) {
		try {
			userDao.deleteObjectByIds(userId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User findUser(String userId) {
		// TODO Auto-generated method stub
		return userDao.findObjectByID(userId);
	}
	
	
}
