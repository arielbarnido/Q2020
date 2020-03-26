package com.delivery.app.endpoint;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.delivery.app.constraint.ValidPageNumber;
import com.delivery.app.dto.PlaceOrderDto;
import com.delivery.app.service.OrderService;

@Component
@Path("orders")
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
	public Response placeOrder(final @Valid PlaceOrderDto placeOrderRequest) throws URISyntaxException, UnsupportedEncodingException {
		return Response.ok(orderService.placeOrder(placeOrderRequest)).build();
	}
	
	
	@GET
	@Produces("application/json")
	//@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public Response takeOrder(final @PathParam("id") Integer oderId) {
		Map<String, String> response = getResponse(orderService.takeOrder(oderId));
		return Response.ok(response).build();
	}

	private Map<String, String> getResponse(boolean orderTaken) {
		Map<String, String> res = new HashMap<>();
		if(orderTaken){
			res.put("status", "SUCCESS");
		}else{
			res.put("error", "Fail to take rder");
		}
		return res;
	}

}