package com.xpanxion.trugrade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpanxion.trugrade.dao.ProjectDao;
import com.xpanxion.trugrade.dao.TestCaseDao;
import com.xpanxion.trugrade.dao.TestGroupDao;
import com.xpanxion.trugrade.objects.Project;
import com.xpanxion.trugrade.objects.TestCase;
import com.xpanxion.trugrade.objects.TestGroup;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private TestGroupDao testGroupDao;
	
	@Autowired
	private TestCaseDao testCaseDao;
	
	public TestCaseDao getTestCaseDao() {
		return testCaseDao;
	}

	public void setTestCaseDao(TestCaseDao testCaseDao) {
		this.testCaseDao = testCaseDao;
	}

	@Override
	public TestCase getTestCase(Long testCaseId) {
		return this.testCaseDao.findOne(testCaseId);
	}

	@Override
	public Iterable<TestCase> getTestCasesByProjectName(Long projectName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<TestGroup> getTestGroupsByProject(String projectName) {
		return this.testGroupDao.findByProjectName(projectName);
	}

	@Override
	public TestGroup getTestGroup(String projectName, String testGroupName) {
		return this.testGroupDao.findOneByProjectNameAndName(projectName, testGroupName);
	}

	@Override
	public Project getProjectByName(String projectName) {
		return this.projectDao.findOneByName(projectName);
	}

	@Override
	public Iterable<Project> getProjects() {
		return this.projectDao.findAll();
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public TestGroupDao getTestGroupDao() {
		return testGroupDao;
	}

	public void setTestGroupDao(TestGroupDao testGroupDao) {
		this.testGroupDao = testGroupDao;
	}

	@Override
	public TestCase addTestCase(TestCase testCase) {
		return this.testCaseDao.save(testCase);
	}

	@Override
	public void updateTestCase(TestCase testCase) {
		this.testCaseDao.save(testCase);
	}

	@Override
	public void removeTestCase(Long testCaseId) {
		this.testCaseDao.delete(testCaseId);
	}

	@Override
	public Iterable<TestCase> getAllTestCases() {
		return this.testCaseDao.findAll();
	}

	@Override
	public Iterable<TestCase> addAllTestCases(List<TestCase> testCases) {
		return this.testCaseDao.save(testCases);
	}

	@Override
	public Project addProject(Project project) {
		return this.projectDao.save(project);
	}
	
	
}
