package com.Playwright_APIAutomation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class CreateUserPostCallTest {
	
	Playwright playwright;
	APIRequest request;
	APIRequestContext requestContext;

	@BeforeTest
	public void setup() {
		playwright = Playwright.create();
		request = playwright.request();
		requestContext = request.newContext();
	}
	
	@Test
	public void createUserTest() throws IOException {
		
		Map<String,Object> data= new HashMap<String,Object>();
		data.put("name", "Harinder");
		data.put("email", "harinder123@gmail.com");
		data.put("gender", "female");
		data.put("status", "active");
		
		//POST Call: create a user		
		APIResponse apiPostResponse= requestContext.post("https://gorest.co.in/public/v2/users",
				RequestOptions.create()
				.setHeader("Content-Type", "application/json")
				.setHeader("Authorization", "Bearer 9a578adb8387d1c4a62300f8dfe721e3904457b6cb6a1ff6f1d39d91364f5ec4")
				.setData(data));		
		System.out.println(apiPostResponse.status());
		Assert.assertEquals(apiPostResponse.status(),201);
		Assert.assertEquals(apiPostResponse.statusText(),"Created");
		
		System.out.println(apiPostResponse.text());
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode postJsonNode = objectMapper.readTree(apiPostResponse.body());
		System.out.println(postJsonNode.toPrettyString());

	}
	//comment added
	
	@AfterTest
	public void tearDown() {
		playwright.close();
	}

}
