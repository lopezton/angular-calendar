package com.xpanxion.trugrade.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xpanxion.trugrade.objects.Project;
import com.xpanxion.trugrade.services.ProjectService;

@RestController
public class ProjectApiController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/api/{projectName}", method = RequestMethod.GET)
	public Project getProjects(@PathVariable String projectName) {
		return this.projectService.getProjectByName(projectName);
	}
	
	@RequestMapping(value = "/api/projects", method = RequestMethod.GET)
	public Iterable<Project> getProjects() {
		return this.projectService.getProjects();
	}
	
	@RequestMapping(value = "/api/projects/add", method = RequestMethod.POST)
	public Project addProject(@RequestBody Project project) {
		return this.projectService.addProject(project);
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
