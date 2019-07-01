package com.henuonline.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	//保存实例
	boolean save(T t);
	//更新实例
	boolean update(T t);
	//获取实例
	T get(Class<T> entityClazz,int id);
	boolean delete(Class<T> entityClazz , Serializable id);
	List<T> find(Class<T> entityClazz);
	List<T> find(String hql , Object... params);
	long findCount(Class<T> entityClazz);
}
