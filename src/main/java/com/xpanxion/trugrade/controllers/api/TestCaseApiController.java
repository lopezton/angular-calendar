package com.xpanxion.trugrade.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xpanxion.trugrade.objects.TestCase;
import com.xpanxion.trugrade.services.ProjectService;

@RestController
public class TestCaseApiController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/api/{projectName}/testcases/{testCaseId}", method = RequestMethod.GET)
	public TestCase getTestCase(@PathVariable Long testCaseId) {
		return this.projectService.getTestCase(testCaseId);
	}
	
	@RequestMapping(value = "/api/{projectName}/testcases", method = RequestMethod.GET)
	public Iterable<TestCase> getTestCasesByProject(@PathVariable Long projectName) {
		return this.projectService.getTestCasesByProjectName(projectName);
	}
	
	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
