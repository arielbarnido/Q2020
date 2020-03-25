package com.delivery.app.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.delivery.app.dto.Order;
import com.delivery.app.dto.PlaceOrderDto;

@Service
public class OrderService {

	public List<Order> getOrders(Integer page, Integer limit) {
		List<Order> orderList = new ArrayList<>();

		Order order1 = new Order();
		order1.setId(1);
		order1.setDistance(100);
		order1.setStatus("UNASSIGNED");

		Order order2 = new Order();
		order2.setId(2);
		order2.setDistance(300);
		order2.setStatus("TAKEN");
		orderList.add(order1);
		orderList.add(order2);
		return orderList;
	}

	public Order placeOrder(PlaceOrderDto placeOrderRequest) {
		System.out.println("ORIGIN1:" + placeOrderRequest.getOrigin()[0].toString());
		System.out.println("ORIGIN2:" + placeOrderRequest.getOrigin()[1].toString());
		System.out.println("DESTINATION1:" + placeOrderRequest.getDestination()[0].toString());
		System.out.println("DESTINATION2:" + placeOrderRequest.getDestination()[1].toString());
		Order order = new Order();
		order.setDistance(100);
		order.setId(1);
		order.setStatus("UNASSIGNED");
		return order;
	}

}
