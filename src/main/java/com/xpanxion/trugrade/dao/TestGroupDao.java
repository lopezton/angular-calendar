package com.xpanxion.trugrade.dao;

import org.springframework.data.repository.CrudRepository;

import com.xpanxion.trugrade.objects.TestGroup;

public interface TestGroupDao extends CrudRepository<TestGroup, Long> {

	/**
	 * 
	 * @param name 
	 * @param project 
	 * @return
	 */
	TestGroup findOneByProjectNameAndName(String projectName, String name);

	/**
	 * 
	 * @param project
	 * @return
	 */
	Iterable<TestGroup> findByProjectName(String projectName);

}
