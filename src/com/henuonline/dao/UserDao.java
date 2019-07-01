package com.henuonline.dao;

import com.henuonline.domain.User;

public interface UserDao extends BaseDao<User>{
	boolean save(User user);
	boolean update(User user);
}
