package com.henuonline.action;

import java.io.StringBufferInputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.henuonline.domain.User;
import com.henuonline.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class UserAction extends BaseAction{
	private String username;
	private String password;

	@Autowired
	private User user;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Action(value="user_register",results={@Result(name="success",type="stream",params={"inputName","hint"}),
										   @Result(name="error",type="stream",params={"inputName","hint"})})
	public String register() {
		
		if(userService.register(user)) {
			hint = new StringBufferInputStream(((Boolean)true).toString());
			return ActionSupport.SUCCESS;
		}else {
			hint = new StringBufferInputStream(((Boolean)false).toString());
			return ActionSupport.ERROR;
		}
	}
}
