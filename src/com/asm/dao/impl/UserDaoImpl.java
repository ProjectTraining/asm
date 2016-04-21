package com.asm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asm.dao.UserDao;
import com.asm.dao.impl.UserDaoImpl;
import com.asm.domain.User;




@Repository("userDao")
public class UserDaoImpl extends CommonDaoImpl<User> implements UserDao {


	/* (non-Javadoc)
	 * @see com.asm.dao.UserDao#getEmployee(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUser(String loginName, String loginPwd) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.userName=? and u.password=? ";
		List<User> list=(List<User>)find(hql, new String[]{loginName,loginPwd});
		if(list.size()>0)
			return list.get(0);
		else 
			return null;
	}
}
