package com.xpanxion.trugrade.dao;

import org.springframework.data.repository.CrudRepository;

import com.xpanxion.trugrade.objects.Project;

public interface ProjectDao extends CrudRepository<Project, Long> {

	/**
	 * 
	 * @param name
	 * @return
	 */
	Project findOneByName(String name);
}
