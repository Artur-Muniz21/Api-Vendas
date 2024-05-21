package com.stefanini.course.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.course.dto.GetProduct;
import com.stefanini.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<GetProduct> findAll(){

		List<GetProduct> list = service.findAll().stream()
				.map(GetProduct::new) //
				.collect(Collectors.toList());
		
		return list;
	}
	
	@GetMapping(value = "{id}")
	public GetProduct findById(@PathVariable Long id) {
		 GetProduct obj = new GetProduct(service.findById(id));
		 return obj;
	}
	
}
