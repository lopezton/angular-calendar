package com.xpanxion.trugrade.dao;

import org.springframework.data.repository.CrudRepository;

import com.xpanxion.trugrade.objects.TestCase;

public interface TestCaseDao extends CrudRepository<TestCase, Long> {

}
