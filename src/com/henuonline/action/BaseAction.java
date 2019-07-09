package com.henuonline.action;

import java.io.InputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.henuonline.service.NewsService;
import com.henuonline.service.NewsServiceImpl;
import com.henuonline.service.StudyService;
import com.henuonline.service.UserService;
import com.opensymphony.xwork2.ActionContext;

@Component
public class BaseAction {
	protected Map<String,Object> session;
	protected Map<String, Object> application;
	protected InputStream hint;//返回提示
	protected Map<String,Object> dataMap;
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	@Autowired
	protected NewsService newsService;
	@Autowired
	protected UserService userService;
	@Autowired
	protected StudyService studyService;
	
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
	public NewsService getNewsService() {
		return newsService;
	}
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
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
	public StudyService getStudyService() {
		return studyService;
	}
	public void setStudyService(StudyService studyService) {
		this.studyService = studyService;
	}
	 
	
}
