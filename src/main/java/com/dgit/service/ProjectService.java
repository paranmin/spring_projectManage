package com.dgit.service;

import java.util.List;
import java.util.Map;

import com.dgit.dto.ProjectVO;

public interface ProjectService {
	public List<ProjectVO> selectAll() throws Exception;

	public List<ProjectVO> selectListByPage(Map<String, Integer> map) throws Exception;

	public ProjectVO selectByNo(int no) throws Exception;

	public int getTotalCnt() throws Exception;

	public int insertProject(ProjectVO project) throws Exception;

	public int modifyProject(ProjectVO project)  throws Exception;

	public int removeProject(int no)  throws Exception;
}
