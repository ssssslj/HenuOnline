package com.henuonline.action;

import java.io.InputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.henuonline.service.NewsService;
import com.henuonline.service.NewsServiceImpl;
import com.henuonline.service.UserService;
import com.opensymphony.xwork2.ActionContext;

@Component
public class BaseAction {
	protected Map<String,Object> session;
	protected Map<String, Object> application;
	protected InputStream hint;//返回提示
	
	protected NewsService newsHotsService;
	@Autowired
	protected UserService userService;
	
    public Map<String, Object> getSession() {
		
		return ActionContext.getContext().getSession();
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getApplication() {
		return ActionContext.getContext().getApplication();
	}
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	
	public NewsService getNewsHotsService() {
		return newsHotsService;
	}
	public void setNewsHotsService(NewsService newsHotsService) {
		this.newsHotsService = newsHotsService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public InputStream getHint() {
		return hint;
	}
	public void setHint(InputStream hint) {
		this.hint = hint;
	}
	
    
}
