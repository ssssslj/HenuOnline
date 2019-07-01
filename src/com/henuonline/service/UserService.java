package com.henuonline.service;

import org.springframework.stereotype.Component;

import com.henuonline.domain.User;
@Component
public interface UserService {
	//注册
	public boolean register(User user);
	//登陆
	public boolean login(int phonenumber,String password);
	//修改信息
	public boolean update(User user);
	//更换手机号
	public boolean updatePhone(int id,int newphone);
	//获取用户信息
	public User showUser(int id);
	
}
