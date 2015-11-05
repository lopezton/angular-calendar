package com.xpanxion.trugrade.controllers.testcase;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xpanxion.trugrade.controllers.ControllerConstants;
import com.xpanxion.trugrade.objects.TestCase;

@Controller
@RequestMapping(value = "/{projectName}/testcases/{testCaseId}")
public class TestCaseController extends BaseTestCaseController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String addTestCase(@PathVariable String projectName, @PathVariable Long testCaseId, TestCase testCase) {
		TestCase existingTestCase = null;
		
		// If id is null, user is adding a new test case.
		if (null != testCaseId) {
			existingTestCase = this.projectService.getTestCase(testCaseId);
		}
		
		// Check to see if we are adding a new test case or updating an existing one.
		if (null != existingTestCase) {
			existingTestCase.setName(testCase.getName());
			existingTestCase.setDescription(testCase.getDescription());
			testCase = existingTestCase;
		} else {
			testCase.setProject(this.projectService.getProjectByName(projectName));
		}
		
		this.addTestCase(testCase);
		return "redirect:/" + projectName + "/testcases/" + testCaseId;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public String updateTestCase(@PathVariable String projectName, @PathVariable Long testCaseId, TestCase testCase) {
		testCase.setId(testCaseId);
		this.projectService.updateTestCase(testCase);
		return "redirect:/" + projectName + "/testCase/" + testCaseId;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteTestCase(HttpServletRequest request, @PathVariable Long testCaseId) {
		this.projectService.removeTestCase(testCaseId);
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getTestCase(@PathVariable Long testCaseId, Model model) {
		model.addAttribute("testcase", this.projectService.getTestCase(testCaseId));
		return ControllerConstants.VIEW_INDIVIDUAL_TEST_CASE;
	}
}
