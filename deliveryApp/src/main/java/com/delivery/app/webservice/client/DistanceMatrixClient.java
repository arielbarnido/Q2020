package com.delivery.app.webservice.client;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
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

	@Value("${distance.matrix.base.uri}")
	protected String BASE_URL;
	//= "https://maps.googleapis.com/maps/api/distancematrix/json";

	public String getDistanceBetweenTwoPoints(String[] start, String[] end)
			throws URISyntaxException, UnsupportedEncodingException {
		URI uri = new URI(buildFullUri(start, end));
		DistanceMatrix distanceMatrix = restTemplate.getForObject(uri, DistanceMatrix.class);
		System.out.println(distanceMatrix.getStatus());
		System.out.println(String.format("%s:%d","rows size:",distanceMatrix.getRows().size()));
		return "1 735 km";
	}

	public String buildFullUri(String[] start, String[] end) throws UnsupportedEncodingException {
		String encodedUrl = URLEncoder.encode("origins=" + buildParams(Arrays.asList(start)) + "&" + "destinations="
				+ buildParams(Arrays.asList(end)) + "&key=" + API_KEY, "UTF-8");
		System.out.println("URL: " + encodedUrl);
		return BASE_URL + "?" + encodedUrl;
	}

	public String buildParams(List<String> coordinates) {
		List<String> filtered = Optional.ofNullable(coordinates).orElse(Collections.emptyList()).stream()
				.filter(item -> null != item && !item.isEmpty()).collect(Collectors.toList());
		return String.join("|", filtered);
	}
}
