package com.henuonline.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.henuonline.domain.News;

@Component
public interface NewsDao<News> extends BaseDao<News>{
	boolean save(News news);
	boolean update(News news);
	News get(int id);
	List<News> find();
	List<News> find(String hql , Object... params);
	boolean delete(Serializable id);
	long findCount();
	int getTotalCount(int type);
	List<News> findArticleListForPageBean(int index, int currentCount, int type);
}