package com.xpanxion.trugrade.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xpanxion.trugrade.services.ProjectService;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHome(HttpServletRequest request, Model model) {
		model.addAttribute("projects", this.projectService.getProjects());
		return ControllerConstants.VIEW_HOME;
	}
}
