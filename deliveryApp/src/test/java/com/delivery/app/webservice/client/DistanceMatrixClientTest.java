package com.delivery.app.webservice.client;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistanceMatrixClientTest {

	
	
	@Autowired
	DistanceMatrixClient client;
	@Test
	public void testBuildParamsWithValues(){
		
		String[] input = {"a","b","c"};
		String result = client.buildParams(Arrays.asList(input));
		assertEquals("a|b|c", result);
		print(result, "RESULT");
		
	}
	
	@Test
	public void testBuildParamsEmptyStrings(){
		
		String[] input = {"","",""};
		String result = client.buildParams(Arrays.asList(input));
		assertEquals("", result);
		print(result, "RESULT");
		
		
	}
	
	@Test
	public void testBuildParamsBrokenSet(){
		
		String[] input = {"a","","b"};
		String result = client.buildParams(Arrays.asList(input));
		assertEquals("a|b", result);
		print(result, "RESULT");
	}
	
	@Test
	public void testBuildParamsBrokenSetOfNullValue(){
		
		String[] input = {"a",null,"d"};
		String result = client.buildParams(Arrays.asList(input));
		assertEquals("a|d", result);
		print(result, "RESULT");
	}
	private void print(String... items) {
		if(items.length > 1){
			System.out.print(items[1] + "-->");
		}
		System.out.println(" [" + items[0] + "]");
		
	}
	
	@Test
	public void testBuildFullUri() throws UnsupportedEncodingException{
		String[] start = {"a","b","c"};
		String[] end = {"x","y","z"};
		String expected = client.BASE_URL + "?" + URLEncoder.encode("origins=a|b|c&destinations=x|y|z&key=" + client.API_KEY, "UTF-8");
		print(expected, "EXPECTED URI");
		String fullUri = client.buildFullUri(start, end);
		print(fullUri,"ACTUAL   URI");
		assertEquals(expected, fullUri);
		
		
		
		
	}
}
