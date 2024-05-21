package com.stefanini.course.dto;

import com.stefanini.course.entities.Category;

public class GetCategory {

	private Long id;
	private String name;
	
	public GetCategory() {
		
	}
	
	public GetCategory(Category category) {
		this.id = category.getId();
		this.name = category.getName();
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
	
	
}
