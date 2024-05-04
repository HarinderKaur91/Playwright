package com.Playwright_APIAutomation.Tests;

import java.io.IOException;
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

public class GetAPICall {
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
	public void getSpecificUserApiTest() throws IOException {
		APIResponse apiResponse = requestContext.get("https://gorest.co.in/public/v2/users",
				RequestOptions.create().setQueryParam("gender", "male").setQueryParam("status", "active"));
		System.out.println(apiResponse.text());
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonResponse = objectMapper.readTree(apiResponse.body());
		String jsonPrettyResponse = jsonResponse.toPrettyString();
		System.out.println(jsonPrettyResponse);
	}

	@Test
	public void getUsersApiTest() throws IOException {
		APIResponse apiResponse = requestContext.get("https://gorest.co.in/public/v2/users");
		int statusCode = apiResponse.status();
		System.out.println("Response status code: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(apiResponse.ok(), true);

		String statusResText = apiResponse.statusText();
		System.out.println("Status Text: " + statusResText);
		System.out.println("----print api text with plain text-----");
		System.out.println(apiResponse.text());

		System.out.println(apiResponse.body());// body returns byte array

		// convert json body using jackson api for json parsing
		System.out.println("---print api json response----");
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonResponse = objectMapper.readTree(apiResponse.body());
		String jsonPrettyResponse = jsonResponse.toPrettyString();
		System.out.println(jsonPrettyResponse);

		System.out.println("---print api url----");
		System.out.println(apiResponse.url());

		System.out.println("---print response headers----");
		Map<String, String> headersMap = apiResponse.headers();
		System.out.println(headersMap);
		Assert.assertEquals(headersMap.get("content-type"), "application/json; charset=utf-8");

	}

	@AfterTest
	public void tearDown() {
		playwright.close();
	}
}
