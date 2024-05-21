package com.stefanini.course.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.course.dto.GetOrder;
import com.stefanini.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public List<GetOrder> findAll(){
		
		List<GetOrder> list = service.findAll().stream()
				.map(GetOrder::new) //
				.collect(Collectors.toList());
		
		return list;
	}
	
	@GetMapping(value = "{id}")
	public GetOrder findById(@PathVariable Long id) {
		 GetOrder obj = new GetOrder(service.findById(id));
		 return obj;
	}
	
}
