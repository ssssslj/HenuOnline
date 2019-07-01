package com.henuonline.dao;

import org.springframework.stereotype.Component;

import com.henuonline.domain.User;
@Component
public interface UserDao extends BaseDao<User>{
	boolean save(User user);
	boolean update(User user);
	boolean login(int phonenumber,String password);
	boolean updatePhone(int id,int newp);
	User showUser(int id);
}
