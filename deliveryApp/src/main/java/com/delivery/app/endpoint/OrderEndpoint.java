package com.delivery.app.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.delivery.app.dto.Order;
import com.delivery.app.dto.PlaceOrderDto;

@Component
@Path("order")
public class OrderEndpoint {

	@GET
	@Produces("application/json")
	@Path("/list")
	public Response listOrders(final @PathParam("page") Integer page, final @PathParam("limit") Integer limit) {
		List<Order> orderList = new ArrayList<>();
		
		Order order1 = new Order();
		order1.setId(1);
		order1.setDistance(100);
		order1.setStatus("UNASSIGNED");
		
		Order order2 = new Order();
		order2.setId(2);
		order2.setDistance(300);
		order2.setStatus("TAKEN");
		orderList.add(order1 );
		orderList.add(order2);
		return Response.ok(orderList).build();
		//return Response.ok(new ArrayList<Order>()).build();
	}

	@POST
	@Produces("applicatio/json")
	@Path("/orders")
	public Response placeOrder(final PlaceOrderDto placeOrderDto) {
		return Response.ok(new ArrayList<Order>()).build();
	}

}