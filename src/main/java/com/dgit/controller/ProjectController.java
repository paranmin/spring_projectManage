package com.dgit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGet(Model model) {
		logger.info("project register Get...");

		model.addAttribute("title", "Register");
	}

	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String projectList(Model model) {
		logger.info("project list Get...");

		return "projectList";
	}
}
