package com.henuonline.action;

import java.io.StringBufferInputStream;
import java.util.HashMap;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.henuonline.domain.PageBean;
import com.henuonline.domain.Study;
import com.opensymphony.xwork2.ActionSupport;

@Component
@ParentPackage("json-default")
public class StudyAction extends BaseAction{
	private int id;
	@Autowired
	private Study study;
	int currentPage = 1;
	int currentCount = 10;
	int type = 0;
	private PageBean<Study> pageBean = null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Study getStudy() {
		return study;
	}
	public void setStudy(Study study) {
		this.study = study;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public PageBean<Study> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<Study> pageBean) {
		this.pageBean = pageBean;
	}
	//获取新闻列表
	@Action(value="study_showStudy",results={@Result(name="success",type="json",params={"root","dataMap"}),
			   @Result(name="error",type="json",params={"root","false"})})
	public String showStudy() {
		pageBean = studyService.findPageBean(currentPage, currentCount, type);
		if(pageBean == null) {
			return ActionSupport.ERROR;
		}
		this.dataMap = new HashMap<String, Object>();
		this.dataMap.put("study", pageBean);
		return ActionSupport.SUCCESS;
	}
	//获取新闻内容
	@Action(value="study_showContent",results={@Result(name="success",type="json",params={"root","dataMap"}),
			   @Result(name="error",type="json",params={"root","false"})})
	public String showContent() {
		if(study == null) {
			return ActionSupport.ERROR;
		}
		study = studyService.getContent(id);
		this.dataMap = new HashMap<String, Object>();
		this.dataMap.put("study", study);
		return ActionSupport.SUCCESS;
	}
	//修改文章
	@Action(value="study_updateStudy",results={@Result(name="success",type="stream",params={"inputName","hint"}),
			   @Result(name="error",type="stream",params={"inputName","hint"})})
	public String updateStudy() {
		if(studyService.updateStudy(study)) {
			hint = new StringBufferInputStream(((Boolean)true).toString());
			return ActionSupport.SUCCESS;
		}else {
			hint = new StringBufferInputStream(((Boolean)false).toString());
			return ActionSupport.ERROR;
		}
	}
	//删除文章
	@Action(value="study_deleteStudy",results={@Result(name="success",type="stream",params={"inputName","hint"}),
			   @Result(name="error",type="stream",params={"inputName","hint"})})
	public String deleteStudy() {
		if(studyService.deleteStudy(id)) {
			hint = new StringBufferInputStream(((Boolean)true).toString());
			return ActionSupport.SUCCESS;
		}else {
			return ActionSupport.ERROR;
		}
	}
}
