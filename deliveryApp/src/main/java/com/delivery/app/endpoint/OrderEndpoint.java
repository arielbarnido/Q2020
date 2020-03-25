package com.delivery.app.endpoint;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.delivery.app.constraint.ValidPageNumber;
import com.delivery.app.dto.PlaceOrderDto;
import com.delivery.app.service.OrderService;

@Component
@Path("orders")
// @Validated
public class OrderEndpoint {

	@Autowired
	private OrderService orderService;

	@GET

	@Produces("application/json")
	public Response listOrders(@QueryParam("page") @ValidPageNumber Integer page, @QueryParam("limit") Integer limit) {

		return Response.ok(orderService.getOrders(page, limit)).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response placeOrder(final @Valid PlaceOrderDto placeOrderRequest) {
		return Response.ok(orderService.placeOrder(placeOrderRequest)).build();
	}

}