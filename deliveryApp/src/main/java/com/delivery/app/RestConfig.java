
package com.delivery.app;

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

	//@PostConstruct
	//public void setup() {
		//register(OrderService.class);
		//register(OrderEndpoint.class);
		
	//}
	
	
    


}
