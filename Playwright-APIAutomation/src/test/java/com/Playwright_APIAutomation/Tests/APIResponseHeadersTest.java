package com.Playwright_APIAutomation.Tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.HttpHeader;

public class APIResponseHeadersTest {
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
	public void getHeadersTest() {
		APIResponse apiResponse = requestContext.get("https://gorest.co.in/public/v2/users");
		int statusCode = apiResponse.status();
		System.out.println("Response status code: " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// using map:assertion is easy because key value pair is there
		Map<String, String> headersMap = apiResponse.headers();
		headersMap.forEach((k, v) -> System.out.println(k + ":" + v));
		System.out.println("total response headers: " + headersMap.size());
		Assert.assertEquals(headersMap.get("server"), "cloudflare");
		Assert.assertEquals(headersMap.get("cf-cache-status"), "DYNAMIC");
		
		System.out.println("==================================");
		
		// using list:
		List<HttpHeader> headersList = apiResponse.headersArray();
		for (HttpHeader e : headersList) {
			System.out.println(e.name + ":" + e.value);
		}		
	}

	@AfterTest
	public void tearDown() {
		playwright.close();
	}
}
