package com.dgit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.dao.ProjectDao;
import com.dgit.dto.Criteria;
import com.dgit.dto.ProjectVO;

@Service
public class ProjectSerivceImpl implements ProjectService {

	@Autowired
	private ProjectDao dao;

	@Override
	public List<ProjectVO> selectAll() {
		List<ProjectVO> list = null;
		try {
			list =  dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProjectVO> selectListByPage(Criteria criteria) {
		List<ProjectVO> list = null;
		try {
			list =  dao.selectListByPage(criteria);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProjectVO selectByNo(int no) {
		ProjectVO vo = null;
		try {
			vo = dao.selectByNo(no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int getTotalCnt() {
		int res = 0;
		try {
			res = dao.getTotalCnt();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insertProject(ProjectVO project) {
		int res = 0;
		try {
			res = dao.insertProject(project);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int modifyProject(ProjectVO project) {
		int res = 0;
		try {
			res = dao.modifyProject(project);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int removeProject(int no) {
		int res = 0;
		try {
			res = dao.removeProject(no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
