package com.dgit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.dto.Criteria;
import com.dgit.dto.PageMaker;
import com.dgit.dto.ProjectVO;
import com.dgit.service.ProjectService;

@Controller
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	private ProjectService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGet(Model model) {
		logger.info("project register Get...");

		model.addAttribute("title", "Register");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(ProjectVO vo) {
		logger.info("project register Post..." + vo.toString());

		service.insertProject(vo);

		return "redirect:/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String projectList(Model model, Criteria criteria) {
		logger.info("project list Get...");

		List<ProjectVO> list = service.selectListByPage(criteria);

		model.addAttribute("list", list);

		PageMaker pageMaker = PageMaker.getInstance();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(service.getTotalCnt());
		logger.info("pagemaker : " + pageMaker);
		model.addAttribute("pageMaker", pageMaker);

		return "projectList";
	}
}
