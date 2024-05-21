package com.stefanini.course.dto;

import java.util.Set;

import com.stefanini.course.entities.Category;
import com.stefanini.course.entities.Product;

public class GetProduct {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private Set<Category> categories;
	
	public GetProduct() {
		
	}
	
	public GetProduct(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.categories = product.getCategories();
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	
}
