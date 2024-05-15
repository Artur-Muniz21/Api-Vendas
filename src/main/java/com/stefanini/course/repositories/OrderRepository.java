package com.stefanini.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.course.entities.Order;
import com.stefanini.course.entities.User;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
