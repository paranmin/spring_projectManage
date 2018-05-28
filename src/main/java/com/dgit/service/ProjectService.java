package com.dgit.service;

import java.util.List;

import com.dgit.dto.Criteria;
import com.dgit.dto.ProjectVO;

public interface ProjectService {
	public List<ProjectVO> selectAll();

	public List<ProjectVO> selectListByPage(Criteria criteria);

	public ProjectVO read(int no);

	public int getTotalCnt();

	public int insertProject(ProjectVO project);

	public int modifyProject(ProjectVO project);

	public int removeProject(int no);

}
