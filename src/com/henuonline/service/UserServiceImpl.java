package com.henuonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.henuonline.dao.UserDao;
import com.henuonline.domain.User;
@Component
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		try {
			return userDao.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean login(int phonenumber, String password) {
		// TODO Auto-generated method stub
		return userDao.login(phonenumber, password);
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	@Override
	public boolean updatePhone(int id, int newphone) {
		// TODO Auto-generated method stub
		return userDao.updatePhone(id, newphone);
	}

	@Override
	public User showUser(int id) {
		// TODO Auto-generated method stub
		return userDao.showUser(id);
	}
	
}
