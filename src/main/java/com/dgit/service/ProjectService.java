package com.dgit.service;

import java.util.List;
import java.util.Map;

import com.dgit.dto.ProjectVO;

public interface ProjectService {
	public List<ProjectVO> selectAll();

	public List<ProjectVO> selectListByPage(Map<String, Integer> map);

	public ProjectVO selectByNo(int no);

	public int getTotalCnt();

	public int insertProject(ProjectVO project);

	public int modifyProject(ProjectVO project);

	public int removeProject(int no);
}
