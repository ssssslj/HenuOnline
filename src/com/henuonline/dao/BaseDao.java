package com.henuonline.dao;

public interface BaseDao<T> {
	boolean save(T t);
	boolean update(T t);
}
