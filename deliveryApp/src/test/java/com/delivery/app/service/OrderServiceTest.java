package com.delivery.app.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class OrderServiceTest {

	OrderService orderService;

	@BeforeEach
	public void setup() {
		orderService = new OrderService();
	}

	@Test
	public void testAutowires() {
		orderService = new OrderService();
		assertTrue(orderService != null);
	}

}
