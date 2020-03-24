package com.delivery.app.deliveryApp;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.delivery.app.endpoint.OrderEndpoint;

@Configuration
@ApplicationPath("api")
public class RestConfig extends ResourceConfig {
	public RestConfig() {
		
		register(OrderEndpoint.class);
	}

//	@PostConstruct
//	public void setup() {
//		register(OrderEndpoint.class);
//	}
}
