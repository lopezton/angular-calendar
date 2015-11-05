package com.xpanxion.trugrade.controllers.testcase;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.xpanxion.trugrade.objects.TestCase;
import com.xpanxion.trugrade.services.ProjectService;

public class BaseTestCaseController {

	@Autowired
	protected ProjectService projectService;
	
	protected TestCase addTestCase(TestCase testCase) {
		System.out.println("Test Case: " + ToStringBuilder.reflectionToString(testCase));
		return this.projectService.addTestCase(testCase);
	}
}
