package com.xpanxion.trugrade.objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TestCase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Project project;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private TestGroup testGroup;
	
	@Column
	@NotEmpty
	private String name;
	
	@Column
	private String description;

	public TestGroup getTestGroup() {
		return testGroup;
	}

	public void setTestGroup(TestGroup testGroup) {
		this.testGroup = testGroup;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
