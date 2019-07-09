package com.henuonline.service;

import org.springframework.stereotype.Component;

import com.henuonline.domain.PageBean;
import com.henuonline.domain.Study;

@Component
public interface StudyService {
	PageBean<Study> findPageBean(int currentPage, int currentCount, int type);

	Study getContent(int id);

	boolean updateStudy(Study study);

	boolean deleteStudy(int id);
}
