package com.henuonline.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.henuonline.domain.Study;

@Component
public class StudyDaoImpl extends BaseDaoImpl<Study> implements StudyDao<Study>{

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub
		return super.delete(Study.class, id);
	}

	@Override
	public long findCount() {
		// TODO Auto-generated method stub
		return super.findCount(Study.class);
	}

	@Override
	public boolean save(Study study) {
		// TODO Auto-generated method stub
		return super.save(study);
	}

	@Override
	public boolean update(Study study) {
		// TODO Auto-generated method stub
		return super.update(study);
	}
	
	@Override
	public Study get(int id) {
		// TODO Auto-generated method stub
		Study study = super.get(Study.class, id);
		int views = study.getView();
		study.setView(++views);
		super.update(study);//浏览量+1
		return study;
	}

	@Override
	public List<Study> find() {
		// TODO Auto-generated method stub
		return super.find(Study.class);
	}

	@Override
	public List<Study> find(String hql, Object... params) {
		// TODO Auto-generated method stub
		return super.find(hql,params);
	}

	@Override
	public int getTotalCount(int type) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		String hqlcount= null;
	    hqlcount="select count(*) from Study where type ="+type;
	
		String sumstring =  (String) session.createQuery(hqlcount).uniqueResult().toString();
		int sum=Integer.parseInt(sumstring);
		System.out.println(sum+"???");
		return sum;
	}

	@Override
	public List<Study> findArticleListForPageBean(int index, int currentCount, int type) {
		// TODO Auto-generated method stub
		Query query = null;
		Session session = this.sessionFactory.getCurrentSession();
		query =session.createQuery("select id,title,imgUrl,view,isStick from Study where type ="+type+" order by id desc");
		query.setFirstResult(index);
		query.setMaxResults(currentCount-index);
		List<Study> studyList =query.list();
		return studyList;
	}
	
}
