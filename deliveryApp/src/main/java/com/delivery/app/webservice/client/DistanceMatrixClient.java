package com.delivery.app.webservice.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.delivery.app.model.DistanceMatrix;

@Service
public class DistanceMatrixClient {

	@Value("${distance.matrix.api.key}")
	protected String API_KEY;

	@Autowired
	RestTemplate restTemplate;

	protected final String BASE_URL = "https://maps.googleapis.com/maps/api/distancematrix/json";

	public String getDistanceBetweenTwoPoints(String[] start, String[] end) throws URISyntaxException {
		URI uri = new URI(buildFullUri(start,end));
		DistanceMatrix distanceMatrix = restTemplate.getForObject(uri, DistanceMatrix.class);
		System.out.println(distanceMatrix.getStatus());
		
		return "1 735 km";
	}
	
	//BASE_URL + "?" + "origins=" + buildParams(Arrays.asList(start)) + "&" + "destination=" + buildParams(Arrays.asList(end)) + "&key=" + API_KEY
	

	public String buildFullUri(String[] start, String[] end) {
		return BASE_URL + "?" + "origins=" + buildParams(Arrays.asList(start)) + "&" + "destinations=" + buildParams(Arrays.asList(end)) + "&key=" + API_KEY;
	}

	public String buildParams(List<String> coordinates) {
		List<String> filtered = Optional.ofNullable(coordinates).orElse(Collections.emptyList()).stream()
				.filter(item -> null != item && !item.isEmpty()).collect(Collectors.toList());
		return String.join("|", filtered);
	}
}
