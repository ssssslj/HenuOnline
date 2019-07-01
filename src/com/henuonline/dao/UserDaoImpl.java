package com.henuonline.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.henuonline.domain.User;
@Component
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return super.update(user);
	}

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		return super.save(user);
	}

	//登陆
	@Override
	public boolean login(int phonenumber, String password) {
		// TODO Auto-generated method stub
		try {
			List<User> list = super.find("from User where phonenumber = ? and password = ? order by phonenumber desc",phonenumber, password);
			if(list.size() > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updatePhone(int id, int newp) {
		// TODO Auto-generated method stub
		User user = super.get(User.class, id);
		if(user != null) {
			user.setPhonenumber(newp);
			return super.update(user);
		}
		return false;
		
		
		
	}

	@Override
	public User showUser(int id) {
		// TODO Auto-generated method stub
		System.out.println("执行了吗");
		return super.get(User.class, id);
	}
	
}
