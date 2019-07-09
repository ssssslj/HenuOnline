package com.henuonline.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import com.henuonline.domain.News;

@Component
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao<News>{

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub
		return super.delete(News.class, id);
	}

	@Override
	public long findCount() {
		// TODO Auto-generated method stub
		return super.findCount(News.class);
	}

	@Override
	public boolean save(News news) {
		// TODO Auto-generated method stub
		return super.save(news);
	}

	@Override
	public boolean update(News news) {
		// TODO Auto-generated method stub
		return super.update(news);
	}

	@Override
	public News get(int id) {
		// TODO Auto-generated method stub
		News news = super.get(News.class, id);
		int views = news.getView();
		news.setView(++views);
		super.update(news);//浏览量+1
		return news;
	}

	@Override
	public List<News> find() {
		// TODO Auto-generated method stub
		return super.find(News.class);
	}

	@Override
	public List<News> find(String hql, Object... params) {
		// TODO Auto-generated method stub
		return super.find(hql,params);
	}

	@Override
	public int getTotalCount(int type) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		String hqlcount= null;
	    hqlcount="select count(*) from News where type ="+type;
		
		String sumstring =  (String) session.createQuery(hqlcount).uniqueResult().toString();
		int sum=Integer.parseInt(sumstring);
		System.out.println(sum+"???");
		return sum;
	}

	@Override
	public List<News> findArticleListForPageBean(int index, int currentCount, int type) {
		// TODO Auto-generated method stub
		Query query = null;
		Session session = this.sessionFactory.getCurrentSession();
		query =session.createQuery("select id,title,imgUrl,view,isStick from News where type ="+type+" order by id desc");
		query.setFirstResult(index);
		query.setMaxResults(currentCount-index);
		List<News> newsList =query.list();
		return newsList;
	}
	

}
