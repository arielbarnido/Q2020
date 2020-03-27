package com.delivery.app.webservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.delivery.app.model.Dog;

@Service
public class DogClient {

	protected static final String GET_RANDOM_DOG_URL = "https://dog.ceo/api/breeds/image/random";
	@Autowired RestTemplate restTemplate;
	
	public Dog getRandomeDog(){
		return restTemplate.getForObject(GET_RANDOM_DOG_URL, Dog.class);
	}
}
