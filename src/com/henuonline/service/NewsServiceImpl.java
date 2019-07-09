package com.henuonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.henuonline.dao.NewsDao;
import com.henuonline.domain.News;
import com.henuonline.domain.News_School;
import com.henuonline.domain.PageBean;

@Component
public class NewsServiceImpl implements NewsService{
	@Autowired
	private PageBean pageBean;
	@Autowired
	private NewsDao<News> newsDao;
	
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public NewsDao<News> getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao<News> newsDao) {
		this.newsDao = newsDao;
	}

	@Override
	public PageBean<News> findPageBean(int currentPage, int currentCount, int type) {
		// TODO Auto-generated method stub
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		int totalCount = newsDao.getTotalCount(type);
		
		pageBean.setTotalCount(totalCount);
		
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		int index = (currentPage - 1) * currentCount;
		List<News> articleList = newsDao.findArticleListForPageBean(index,currentCount,type);
		if(articleList == null) {
			return null;
		}
		pageBean.setArticleList(articleList);
		
		return pageBean;
	}

	@Override
	public News getContent(int id) {
		// TODO Auto-generated method stub
		return newsDao.get(id);
	}

	@Override
	public boolean updateNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.update(news);
	}

	@Override
	public boolean deleteNews(int id) {
		// TODO Auto-generated method stub
		return newsDao.delete(id);
	}
}
