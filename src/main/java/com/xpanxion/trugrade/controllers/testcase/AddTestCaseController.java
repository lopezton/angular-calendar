package com.xpanxion.trugrade.controllers.testcase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xpanxion.trugrade.controllers.ControllerConstants;
import com.xpanxion.trugrade.objects.TestCase;

@Controller
@RequestMapping(value = "/{projectName}/testcases/add")
public class AddTestCaseController extends BaseTestCaseController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAddTestCase(Model model, @PathVariable String projectName) {
		model.addAttribute("project", this.projectService.getProjectByName(projectName));
		return ControllerConstants.VIEW_ADD_TEST_CASE;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getAddTestCase(@PathVariable String projectName, TestCase testCase) {
		final TestCase addedTestCase = this.addTestCase(testCase);
		return "redirect:/" + projectName + "/testcase/" + addedTestCase.getId();
	}
}
