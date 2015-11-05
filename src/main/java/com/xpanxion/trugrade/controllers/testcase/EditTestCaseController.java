package com.xpanxion.trugrade.controllers.testcase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xpanxion.trugrade.controllers.ControllerConstants;

@Controller
@RequestMapping(value = "/{projectName}/testcases/{testCaseId}/edit")
public class EditTestCaseController extends BaseTestCaseController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getEditTestCase(@PathVariable Long testCaseId, Model model) {
		model.addAttribute("testcase", this.projectService.getTestCase(testCaseId));
		return ControllerConstants.VIEW_EDIT_TEST_CASE;
	}
}
