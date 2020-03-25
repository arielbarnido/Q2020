package com.delivery.app.endpoint;


import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.delivery.app.AbstractRestTest;

public class OrderEndpointIntegrationTest extends AbstractRestTest {

	@Test
	public void getOrderList() throws Exception {
		String uri = "/api/orders?page=1&limit=2";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print()).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
		//assertTrue(status == 200);
	}
}
