package com.Playwright_APIAutomation.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;

public class APIDisposeTest {
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
	public void disposeResposeTest() {
		// Request-1:
		APIResponse apiResponse = requestContext.get("https://gorest.co.in/public/v2/users");
		int statusCode = apiResponse.status();
		System.out.println("Response status code: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(apiResponse.ok(), true);
		String statusResText = apiResponse.statusText();
		System.out.println("Status Text: " + statusResText);

		System.out.println("----print api response with plain text-----");
		System.out.println(apiResponse.text());

		apiResponse.dispose();// will dispose only response body but status code,url,status text will remain same

		
		System.out.println("----print api response after dispose with plain text-----");
		try {
			System.out.println(apiResponse.text());
		} catch (PlaywrightException e) {
			System.out.println("Api response body is disposed");
		}
		int statusCode1 = apiResponse.status();
		System.out.println("Response status code after dispose: " + statusCode1);
		
		String statusResText1 = apiResponse.statusText();
		System.out.println(statusResText1);
		
		System.out.println("response Url:"+ apiResponse.url());
		
		//Request-2:			
		APIResponse apiResponse1 = requestContext.get("https://reqres.co.in/api/users/2");
		System.out.println("Get a response body for 2nd request:");
		System.out.println("Status code:"+ apiResponse1.status());
		System.out.println("Response body:"+ apiResponse1.text());

		//request context dispose
		//dispose can be used on the specific response or on the complete request
		requestContext.dispose();
		System.out.println("Response1 body: "+ apiResponse.text());
		System.out.println("Response2 body: "+ apiResponse1.text());

	}

	@AfterTest
	public void tearDown() {
		playwright.close();
	}
}
