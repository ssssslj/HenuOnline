package com.henuonline.action;

import java.io.StringBufferInputStream;
import java.util.HashMap;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.henuonline.domain.News;
import com.henuonline.domain.PageBean;
import com.henuonline.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

@Component
@ParentPackage("json-default")
public class NewsAction extends BaseAction{
	private int id;
	@Autowired
	private News news;
	int currentPage = 1;
	int currentCount = 10;
	int type = 0;
	private PageBean<News> pageBean = null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public PageBean<News> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<News> pageBean) {
		this.pageBean = pageBean;
	}
	//获取新闻列表
	@Action(value="news_showNews",results={@Result(name="success",type="json",params={"root","dataMap"}),
			   @Result(name="error",type="json",params={"root","false"})})
	public String showNews() {
		pageBean = newsService.findPageBean(currentPage, currentCount, type);
		if(pageBean == null) {
			return ActionSupport.ERROR;
		}
		this.dataMap = new HashMap<String, Object>();
		this.dataMap.put("news", pageBean);
		return ActionSupport.SUCCESS;
	}
	//获取新闻内容
	@Action(value="news_showContent",results={@Result(name="success",type="json",params={"root","dataMap"}),
			   @Result(name="error",type="json",params={"root","false"})})
	public String showContent() {
		if(news == null) {
			return ActionSupport.ERROR;
		}
		news = newsService.getContent(id);
		this.dataMap = new HashMap<String, Object>();
		this.dataMap.put("news", news);
		return ActionSupport.SUCCESS;
	}
	//修改文章
	@Action(value="news_updateNews",results={@Result(name="success",type="stream",params={"inputName","hint"}),
			   @Result(name="error",type="stream",params={"inputName","hint"})})
	public String updateNews() {
		if(newsService.updateNews(news)) {
			hint = new StringBufferInputStream(((Boolean)true).toString());
			return ActionSupport.SUCCESS;
		}else {
			hint = new StringBufferInputStream(((Boolean)false).toString());
			return ActionSupport.ERROR;
		}
	}
	//删除文章
	@Action(value="news_deleteNews",results={@Result(name="success",type="stream",params={"inputName","hint"}),
			   @Result(name="error",type="stream",params={"inputName","hint"})})
	public String deleteNews() {
		if(newsService.deleteNews(id)) {
			hint = new StringBufferInputStream(((Boolean)true).toString());
			return ActionSupport.SUCCESS;
		}else {
			return ActionSupport.ERROR;
		}
	}
	
}
