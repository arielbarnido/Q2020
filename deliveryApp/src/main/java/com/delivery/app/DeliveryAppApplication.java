package com.delivery.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DeliveryAppApplication  extends SpringBootServletInitializer{

	//main method
	public static void main(String[] args) {
		// new JerseydemoApplication().configure(new
		//SpringApplicationBuilder(JerseydemoApplication.class)).run(args);
		//new DeliveryAppApplication().configure(new SpringApplicationBuilder(DeliveryAppApplication.class)).run(args);
		SpringApplication.run(DeliveryAppApplication.class, args);
	}

}
