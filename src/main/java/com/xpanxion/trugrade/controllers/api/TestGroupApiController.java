package com.xpanxion.trugrade.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xpanxion.trugrade.objects.TestGroup;
import com.xpanxion.trugrade.services.ProjectService;

@RestController
public class TestGroupApiController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/api/{projectName}/testgroups", method = RequestMethod.GET)
	public Iterable<TestGroup> getTestGroups(@PathVariable String projectName) {
		return this.projectService.getTestGroupsByProject(projectName);
	}
	
	@RequestMapping(value = "/api/{projectName}/testgroups/{testGroupName}", method = RequestMethod.GET)
	public TestGroup getTestGroup(@PathVariable String projectName, @PathVariable String testGroupName) {
		return this.projectService.getTestGroup(projectName, testGroupName);
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
