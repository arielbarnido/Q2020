package com.delivery.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.app.dto.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
}
