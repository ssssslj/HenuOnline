package com.henuonline.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.regexp.internal.recompile;
@Transactional
@Component
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	protected SessionFactory sessionFactory;

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

	
	@Override
	public T get(Class<T> entityClazz, int id) {
		// TODO Auto-generated method stub
		System.out.println(id+"1");
		System.out.println(entityClazz.getSimpleName());
		try {
			return (T)this.sessionFactory.getCurrentSession().get(entityClazz, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean delete(Class<T> entityClazz, Serializable id) {
		// TODO Auto-generated method stub
		try {
			getSessionFactory().getCurrentSession()
			.createQuery("delete " + entityClazz.getSimpleName()
				+ " en where en.id = ?0")
			.setParameter("0" , id)
			.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public List<T> find(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery("from"+entityClazz.getSimpleName());
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<T> find(String hql, Object... params) {
		// TODO Auto-generated method stub
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			for(int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public long findCount(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		List<?> l = find("select count(*) from "
				+ entityClazz.getSimpleName());
			// 返回查询得到的实体总数
		if (l != null && l.size() == 1 ){
			return (Long)l.get(0);
		}
		return 0;
	}
	

}
