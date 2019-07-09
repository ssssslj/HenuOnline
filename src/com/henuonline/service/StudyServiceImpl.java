package com.henuonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.henuonline.dao.StudyDao;
import com.henuonline.domain.PageBean;
import com.henuonline.domain.Study;

@Component
public class StudyServiceImpl implements StudyService{
	@Autowired
	private PageBean pageBean;
	@Autowired
	private StudyDao<Study> studyDao;
	
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public StudyDao<Study> getStudyDao() {
		return studyDao;
	}

	public void setStudyDao(StudyDao<Study> studyDao) {
		this.studyDao = studyDao;
	}

	@Override
	public PageBean<Study> findPageBean(int currentPage, int currentCount, int type) {
		// TODO Auto-generated method stub
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		int totalCount = studyDao.getTotalCount(type);
		
		pageBean.setTotalCount(totalCount);
		
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		int index = (currentPage - 1) * currentCount;
		List<Study> articleList = studyDao.findArticleListForPageBean(index,currentCount,type);
		if(articleList == null) {
			return null;
		}
		pageBean.setArticleList(articleList);
		
		return pageBean;
	}

	@Override
	public Study getContent(int id) {
		// TODO Auto-generated method stub
		return studyDao.get(id);
	}

	@Override
	public boolean updateStudy(Study study) {
		// TODO Auto-generated method stub
		return studyDao.update(study);
	}

	@Override
	public boolean deleteStudy(int id) {
		// TODO Auto-generated method stub
		return studyDao.delete(id);
	}
}
