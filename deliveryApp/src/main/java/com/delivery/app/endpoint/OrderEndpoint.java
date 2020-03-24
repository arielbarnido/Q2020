package com.delivery.app.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.delivery.app.dto.Order;
import com.delivery.app.service.OrderService;

@Component
@Path("order")
public class OrderEndpoint {

	@Autowired
	private OrderService orderService;

	@GET
	@Produces("application/json")
	@Path("/list")
	public Response listOrders(final @PathParam("page") Integer page, final @PathParam("limit") Integer limit) {
		return Response.ok(orderService.getOrders(page, limit)).build();
	}

	@POST
	@Produces("application/json")
	@Path("/orders")
	public Response placeOrder(
			final @FormParam("origin") @Size(min = 2, max = 2, message = "Origin coordinates must be two points") List<String> origin,
			final @FormParam("destination") @Size(min = 2, max = 2, message = "Destination coordinates must be two points") List<String> destination) {
		
		return Response.ok(new ArrayList<Order>()).build();
	}

}