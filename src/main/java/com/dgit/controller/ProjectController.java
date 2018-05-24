package com.dgit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.dto.ProjectVO;
import com.dgit.service.ProjectService;
import com.dgit.util.PagingUtil;

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
	public String projectList(Model model, String page) {
		logger.info("project list Get...");

		int iPage = 0;
		if (page == null || page.equals("")) {
			iPage = 1;
		}
		int width = 5;
		int row = 10;
		int start = (iPage - 1) * row;
		Map<String, Integer> map = new HashMap<>();
		map.put("width", row);
		map.put("start", start);

		List<ProjectVO> list = service.selectListByPage(map);

		int total = service.getTotalCnt();

		int cnt = (int) Math.ceil((double) total / row);

		String paging = PagingUtil.getInstance().makePaging(cnt, iPage, width, row, "/list");

		model.addAttribute("list", list);
		model.addAttribute("total", total);
		model.addAttribute("paging", paging);
		return "projectList";
	}
}
