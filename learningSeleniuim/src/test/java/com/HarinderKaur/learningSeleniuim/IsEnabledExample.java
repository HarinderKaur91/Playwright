package com.HarinderKaur.learningSeleniuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsEnabledExample {
	
	WebDriver wd; 

	@BeforeMethod
	public void setUp() { // starting or launching a browser

		// basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver120\\chromedriver-win64\\chromedriver.exe");

		// launch a browser
		wd = new ChromeDriver(); 

		// launch a page
		wd.get("https://ca.hotels.com/login?");
	}

	@Test
	public void verifyIsBtnEnabled() { // test something
		
		WebElement btn = wd.findElement(By.cssSelector("button#loginFormSubmitButton"));//we can also write only #loginFormSubmitButton"

		// isEnabled
		boolean isBtnEnabled = btn.isEnabled();
		Assert.assertTrue(isBtnEnabled);
	}

	@AfterMethod
	public void tearDown() { 
		wd.close(); // to close the browser after testing

	}

}
