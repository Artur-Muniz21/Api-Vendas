package com.stefanini.course.dto;

import java.time.Instant;
import java.util.Set;

import com.stefanini.course.entities.Order;
import com.stefanini.course.entities.OrderItem;
import com.stefanini.course.entities.User;
import com.stefanini.course.entities.enums.OrderStatus;

public class PostOrder {
	
	private Long id;
    private Instant moment;
    private OrderStatus orderStatus;
    private User client;
    private Set<OrderItem> items;

    public PostOrder() {
    	
    }
    
    public PostOrder(Order order) {
    	this.id = order.getId();
    	this.moment = order.getMoment();
    	setOrderStatus(order.getOrderStatus());
    	this.client = order.getClient();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
    
	public Order toOrder() {
		return new Order(null, this.moment, this.orderStatus, this.client, this.items);
	}
    
	
	
}
