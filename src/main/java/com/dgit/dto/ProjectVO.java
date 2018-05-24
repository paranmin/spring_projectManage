package com.dgit.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProjectVO {
	private int no;
	private String name;
	private String content;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	private String state;

	public ProjectVO() {
	}

	public ProjectVO(int no, String name, String content, Date startDate, Date endDate, String state) {
		this.no = no;
		this.name = name;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return String.format("Project [no=%s, name=%s, content=%s, startDate=%s, endDate=%s, state=%s]", no, name,
				content, startDate, endDate, state);
	}

}
