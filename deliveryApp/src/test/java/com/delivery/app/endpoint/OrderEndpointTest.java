package com.delivery.app.endpoint;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

@RunWith(SpringRunner.class)
public class OrderEndpointTest {

	private static final Integer PORT = 8082;
	private static final String HOST_PORT = "http://localhost:8082";
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(PORT);

	@Test
	public void tesOrderEndpointSuccess() throws ClientProtocolException, IOException {
		wireMockRule.stubFor(get(urlEqualTo("/api/orders?page=1&limit=2"))
				.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json")));

		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(HOST_PORT + "/api/orders?page=1&limit=2");
		HttpResponse httpResponse = client.execute(get);
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());

	}

	@Test
	public void tesOrderEndpoint404Fail() throws ClientProtocolException, IOException {
		wireMockRule.stubFor(get(urlEqualTo("/api/orde?page=1&limit=2"))
				.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json")));

		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(HOST_PORT + "/api/orders?page=1&limit=2");
		HttpResponse httpResponse = client.execute(get);
		assertEquals(404, httpResponse.getStatusLine().getStatusCode());

	}

	@Test
	public void tesOrderEndpoint400Fail() throws ClientProtocolException, IOException {
		wireMockRule.stubFor(get(urlEqualTo("/api/orders?page=0&limit=2"))
				.willReturn(aResponse().withStatus(400).withHeader("Content-Type", "application/json")));

		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(HOST_PORT + "/api/orders?page=0&limit=2");
		HttpResponse httpResponse = client.execute(get);
		assertEquals(400, httpResponse.getStatusLine().getStatusCode());

	}

	private String convertHttpResponseToString(HttpResponse httpResponse) throws IOException {
		InputStream inputStream = httpResponse.getEntity().getContent();
		return convertInputStreamToString(inputStream);
	}

	private String convertInputStreamToString(InputStream inputStream) {
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		String string = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return string;
	}

}
