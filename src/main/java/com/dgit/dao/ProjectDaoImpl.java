package com.dgit.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.dto.Criteria;
import com.dgit.dto.ProjectVO;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	private final String namespace = "com.dgit.mapper.ProjectMapper.";

	@Autowired
	private SqlSession session;

	@Override
	public List<ProjectVO> selectAll() throws SQLException {
		return session.selectList(namespace + "selectAll");
	}

	@Override
	public List<ProjectVO> selectListByPage(Criteria criteria) throws SQLException {
		return session.selectList(namespace + "selectListByPage", criteria);
	}

	@Override
	public ProjectVO selectByNo(int no) throws SQLException {
		return session.selectOne(namespace + "selectByNo", no);
	}

	@Override
	public int insertProject(ProjectVO project) throws SQLException {
		return session.insert(namespace + "insertProject", project);
	}

	@Override
	public int modifyProject(ProjectVO project) throws SQLException {
		return session.update(namespace + "modifyProject", project);
	}

	@Override
	public int removeProject(int no) throws SQLException {
		return session.delete(namespace + "removeProject", no);
	}

	@Override
	public int getTotalCnt() throws SQLException {
		return session.selectOne(namespace + "getTotalCnt");
	}

}
