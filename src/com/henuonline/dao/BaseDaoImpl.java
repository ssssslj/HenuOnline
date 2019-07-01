package com.henuonline.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Component
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean save(T t) {
		// TODO Auto-generated method stub
		try {
			this.sessionFactory.getCurrentSession().save(t);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}	
		return true;
	}

	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		try {
			this.sessionFactory.getCurrentSession().update(t);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}	
		return true;
	}
	

}
