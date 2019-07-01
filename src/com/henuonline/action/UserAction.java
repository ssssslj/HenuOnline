package com.henuonline.action;

import java.io.StringBufferInputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.henuonline.domain.User;
import com.henuonline.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

@Component
@ParentPackage("json-default")
public class UserAction extends BaseAction{
	private int phonenumber;
	private String password;
	private int newphone;
	private int id;
	@Autowired
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNewphone() {
		return newphone;
	}
	public void setNewphone(int newphone) {
		this.newphone = newphone;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
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
	//注册
	public String register() {
		
		if(userService.register(user)) {
			hint = new StringBufferInputStream(((Boolean)true).toString());
			return ActionSupport.SUCCESS;
		}else {
			hint = new StringBufferInputStream(((Boolean)false).toString());
			return ActionSupport.ERROR;
		}
	}
	@Action(value="user_login",results={@Result(name="success",type="stream",params={"inputName","hint"}),
			   @Result(name="error",type="stream",params={"inputName","hint"})})
	//登陆
	public String login() {
		if(userService.login(phonenumber, password)) {
			hint = new StringBufferInputStream(((Boolean)true).toString());
			return ActionSupport.SUCCESS;
		}else {
			hint = new StringBufferInputStream(((Boolean)false).toString());
			return ActionSupport.ERROR;
		}
	}
	@Action(value="user_update",results={@Result(name="success",type="stream",params={"inputName","hint"}),
			   @Result(name="error",type="stream",params={"inputName","hint"})})
	//信息认证
	public String update() {
		if(userService.update(user)) {
			hint = new StringBufferInputStream(((Boolean)true).toString());
			return ActionSupport.SUCCESS;
		}else {
			hint = new StringBufferInputStream(((Boolean)false).toString());
			return ActionSupport.ERROR;
		}
	}
	@Action(value="user_updatephone",results={@Result(name="success",type="stream",params={"inputName","hint"}),
			   @Result(name="error",type="stream",params={"inputName","hint"})})
	//更换手机号
	public String updatePhone() {
		if(userService.updatePhone(id,newphone)) {
			hint = new StringBufferInputStream(((Boolean)true).toString());
			return ActionSupport.SUCCESS;
		}else {
			hint = new StringBufferInputStream(((Boolean)false).toString());
			return ActionSupport.ERROR;
		}
	}
	//获取用户信息
	@Action(value="user_showUser",results={@Result(name="success",type="json",params={"root","userJson"}),
			   @Result(name="error",type="json",params={"root","userJson"})})
	public String showUser() {
		User user1 = userService.showUser(id);
		if(user1 != null) {
			JSONObject userJson = JSONObject.fromObject(user1);
			return ActionSupport.SUCCESS;
		}else {
			return ActionSupport.ERROR;
		}
	}
}
