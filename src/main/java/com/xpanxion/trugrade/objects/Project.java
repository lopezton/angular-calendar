package com.xpanxion.trugrade.objects;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@NotEmpty
	private String name;
	
	@Column
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private List<TestGroup> testGroups;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private List<TestCase> testCases;
	
	public List<TestCase> getTestCases() {
		return testCases;
	}

	public void setTestCases(List<TestCase> testCases) {
		this.testCases = testCases;
	}

	public List<TestGroup> getTestGroups() {
		return testGroups;
	}

	public void setTestGroups(List<TestGroup> testGroups) {
		this.testGroups = testGroups;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
