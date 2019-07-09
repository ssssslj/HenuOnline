package com.henuonline.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.henuonline.domain.Study;

@Component
public interface StudyDao<Study> extends BaseDao<Study>{
	boolean save(Study study);
	boolean update(Study study);
	Study get(int id);
	List<Study> find();
	List<Study> find(String hql , Object... params);
	boolean delete(Serializable id);
	long findCount();
	int getTotalCount(int type);
	List<Study> findArticleListForPageBean(int index, int currentCount, int type);
}
