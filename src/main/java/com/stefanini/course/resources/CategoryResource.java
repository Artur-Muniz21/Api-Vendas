package com.stefanini.course.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.course.dto.GetCategory;
import com.stefanini.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public List<GetCategory> findAll(){
		
		List<GetCategory> list = service.findAll().stream()
				.map(GetCategory::new) //
				.collect(Collectors.toList());
		
		return list;
	}
	
	@GetMapping(value = "{id}")
	public GetCategory findById(@PathVariable Long id) {
		 GetCategory obj = new GetCategory(service.findById(id));
		 return obj;
	}
	
}
