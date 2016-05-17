package com.asm.service.impl;

import java.util.ArrayList;
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
	
	public List<User> listUser(String userName,String deptId,String roleId,String state) {
		//组织查询条件
		String hqlWhere = "";
		List<Object> paramsList = new ArrayList<Object>();
		if(null!=userName && !"".equals(userName)){
				hqlWhere += " and o.userName = ? ";
				paramsList.add(userName);
		}
		if(null!=deptId && !"".equals(deptId)){
			hqlWhere += " and o.deptId = ? ";
			paramsList.add(deptId);
		}
		if(null!=roleId && !"".equals(roleId)){
			hqlWhere += " and o.roleId = ? ";
			paramsList.add(roleId);
		}
		if(null!=state && !"".equals(state)){
			hqlWhere += " and o.state =?";

			System.out.println("ffff"+state);
			paramsList.add(Integer.parseInt(state));
		}
		Object [] params = paramsList.toArray();
		List<User> list = userDao.findCollectionByConditionNopage(
				hqlWhere, params, null);
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
