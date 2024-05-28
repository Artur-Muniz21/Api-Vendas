package com.stefanini.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.course.entities.OrderItem;
import com.stefanini.course.resources.openApi.OrderItemResourceOpenApi;
import com.stefanini.course.services.OrderItemService;

@RestController
@RequestMapping(value = "/orderItens")
public class OrderItemResource implements OrderItemResourceOpenApi{
	
	@Autowired
	private OrderItemService service;
	
	@GetMapping
	public List<OrderItem> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public OrderItem insert(OrderItem obj) {
		return service.insert(obj);
	}
}
