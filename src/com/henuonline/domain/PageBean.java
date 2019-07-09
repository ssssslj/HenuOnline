package com.henuonline.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PageBean<T> {
	
	//当前页
	private int currentPage;
	//当前页显示的条数
	private int currentCount;
	//总条数
	private int totalCount;
	//总页数
	private int totalPage; 
	//每页显示的数据
	private List<T> articleList = new ArrayList<T>();
	
	
	public PageBean() {
		super();
	}
	public PageBean(int currentPage, int currentCount, int totalCount, int totalPage, List<T> articleList) {
		super();
		this.currentPage = currentPage;
		this.currentCount = currentCount;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.articleList = articleList;
	}
	public List<T> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<T> articleList) {
		this.articleList = articleList;
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
