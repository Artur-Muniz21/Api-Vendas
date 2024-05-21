package com.stefanini.course.dto;

import java.time.Instant;
import java.util.Set;

import com.stefanini.course.entities.Order;
import com.stefanini.course.entities.OrderItem;
import com.stefanini.course.entities.enums.OrderStatus;

public class GetOrder {
	private Long id;
    private Instant moment;
    private OrderStatus orderStatus;
    private GetUser client;
    private Set<OrderItem> items;
    private Double total;
    
    public GetOrder() {
    	
    }
    
	public GetOrder(Order order) {
		this.id = order.getId();
		this.moment = order.getMoment();
		this.orderStatus = order.getOrderStatus();
		this.client = new GetUser(order.getClient());
		this.items = order.getItems();
		this.total = order.getTotal();
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

	public GetUser getClient() {
		return client;
	}

	public void setClient(GetUser client) {
		this.client = client;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	
}
