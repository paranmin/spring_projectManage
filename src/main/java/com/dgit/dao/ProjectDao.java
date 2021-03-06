package com.dgit.dao;

import java.sql.SQLException;
import java.util.List;

import com.dgit.dto.Criteria;
import com.dgit.dto.ProjectVO;

public interface ProjectDao {
	List<ProjectVO> selectAll() throws SQLException;
	List<ProjectVO> selectListByPage(Criteria criteria) throws SQLException;
	ProjectVO selectByNo(int no) throws SQLException;
	int insertProject(ProjectVO project) throws SQLException;
	int modifyProject(ProjectVO project) throws SQLException;
	int removeProject(int no) throws SQLException;
	
	int getTotalCnt() throws SQLException;
}
