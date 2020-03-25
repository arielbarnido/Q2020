package com.delivery.app.service;


import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.delivery.app.dao.OrderRepository;
import com.delivery.app.dto.Order;
import com.delivery.app.dto.PlaceOrderDto;
import com.delivery.app.webservice.client.DistanceMatrixClient;

@Service
public class OrderService {
	
	private static final String INITAL_STATUS = "UNASSIGNED";
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private DistanceMatrixClient distanceMatrixClient;

	public List<Order> getOrders(Integer page, Integer limit) {
		Pageable pagedOrders = PageRequest.of(page, limit);
		return orderRepository.findAll(pagedOrders).toList();
	}

	public Order placeOrder(PlaceOrderDto placeOrderRequest) throws URISyntaxException {
		Order newOrder = createOrder(placeOrderRequest);
		Order savedOrder = orderRepository.save(newOrder);
		return savedOrder;
	}

	private Order createOrder(PlaceOrderDto placeOrderRequest) throws URISyntaxException {
		Order newOrder = new Order();
		newOrder.setDistance(getDistance(placeOrderRequest.getOrigin(), placeOrderRequest.getDestination()));
		newOrder.setStatus(INITAL_STATUS);
		return newOrder;
	}

	private String getDistance(String[] origin, String[] destination) throws URISyntaxException {
		return distanceMatrixClient.getDistanceBetweenTwoPoints(origin,
				destination);
	}

}
