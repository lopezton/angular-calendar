package com.xpanxion.trugrade.controllers.testgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xpanxion.trugrade.controllers.ControllerConstants;
import com.xpanxion.trugrade.objects.TestGroup;
import com.xpanxion.trugrade.services.ProjectService;

@Controller
@RequestMapping(value = "/{projectName}/testgroups/{testGroupName}")
public class TestGroupController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getTestGroup(Model model, @PathVariable String projectName, @PathVariable String testGroupName) {
		final TestGroup testGroup = this.projectService.getTestGroup(projectName, testGroupName);
		
		if (null == testGroup) {
			model.addAttribute("errorHeader", "Oops!");
			model.addAttribute("errorMessage", "Test Group '" + testGroupName + "' was not found.");
			return ControllerConstants.VIEW_GENERIC_ERROR;
		}
		
		model.addAttribute("testGroup", testGroup);
		return ControllerConstants.VIEW_TEST_GROUP;
	}

	/**
	 * @return the projectService
	 */
	public ProjectService getProjectService() {
		return projectService;
	}

	/**
	 * @param projectService the projectService to set
	 */
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
