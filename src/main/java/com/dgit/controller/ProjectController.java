package com.dgit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String projectList(Model model, @ModelAttribute("criteria") Criteria criteria) {
		logger.info("project list Get..." + criteria);

		List<ProjectVO> list = service.selectListByPage(criteria);

		PageMaker pageMaker = PageMaker.getInstance();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(service.getTotalCnt());
		logger.info("pagemaker : " + pageMaker);

		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);

		return "projectList";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String readPage(Model model, int no, @ModelAttribute("criteria") Criteria criteria) throws Exception {
		logger.info("board readPage Get...");
		logger.info("no : " + no);
		logger.info("criteria : " + criteria);

		ProjectVO vo = service.read(no);
		model.addAttribute("project", vo);
		model.addAttribute("title", "Read");

		return "readProject";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String removePage(Model model, int no, Criteria criteria) throws Exception {
		logger.info("board remove Get...");
		logger.info("no : " + no);
		logger.info("criteria : " + criteria);

		service.removeProject(no);
		model.addAttribute("page", criteria.getPage());
		return "redirect:/list";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyPageGet(Model model, int no, @ModelAttribute("criteria") Criteria criteria) throws Exception {
		logger.info("board modifyPageGet Get...");
		logger.info("no : " + no);
		logger.info("criteria : " + criteria);

		ProjectVO vo = service.read(no);
		model.addAttribute("project", vo);
		model.addAttribute("title", "Modify");
		
		return "modifyProject";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPagePost(Model model, ProjectVO vo, Criteria criteria) throws Exception {
		logger.info("board modifyPagePost Post...");
		logger.info("ProjectVO : " + vo);
		logger.info("criteria : " + criteria);

		service.modifyProject(vo);
		model.addAttribute("no", vo.getNo());
		model.addAttribute("page", criteria.getPage());
		return "redirect:/read";
	}
}
