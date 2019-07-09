package com.henuonline.service;

import org.springframework.stereotype.Component;

import com.henuonline.domain.News;
import com.henuonline.domain.PageBean;

@Component
public interface NewsService {

	PageBean<News> findPageBean(int currentPage, int currentCount, int type);

	News getContent(int id);

	boolean updateNews(News news);

	boolean deleteNews(int id);
	
}
