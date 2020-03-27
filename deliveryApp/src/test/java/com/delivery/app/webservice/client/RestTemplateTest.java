package com.delivery.app.webservice.client;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.delivery.app.model.Dog;

import static org.junit.Assert.*;

import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateTest {

	@Autowired
	RestTemplate restTemplate;
	
	
	/**
	 * This is just to test the RestTemplate library as well as it's object mapping
	 */
	
	@Test
	public void testRestTemplateObjectMapping(){
		
		Dog dog = restTemplate.getForObject(DogClient.GET_RANDOM_DOG_URL, Dog.class);
		System.out.println(dog.getMessage());
		System.out.println(dog.getStatus());
		assertNotNull(dog);
		assertTrue(dog.getStatus() != null);
		assertTrue(dog.getMessage() != null);
		
	}
}
