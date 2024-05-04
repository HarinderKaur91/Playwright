package com.HarinderKaur.learningSeleniuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GetTextExample {

	WebDriver wd; // declare wd at class level bcoz it is used in setUp and tearDown both methods

	@BeforeMethod
	public void setUp() { // starting or launching a browser

		// basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver",
				"D:\\ChromeDriver120\\chromedriver-win64\\chromedriver.exe");

		// launch a browser
		wd = new ChromeDriver(); // An instance of chrome browser is created means a blank chrome page will be
									// opened on browser

		// launch a page
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test
	public void validatingTest() { // test something
		WebElement textElement = wd.findElement(By.cssSelector("#content div.row>div:last-of-type strong"));

		// getText ifrom dom
		String text = textElement.getText();
		//Assert.assertEquals(text, "Hello message", "Text doesn't match");
		Assert.assertEquals(text, "I am a returning customer", "Text doesn't match");
	


	}

	@AfterMethod
	public void tearDown() { // closing the browser
		wd.close(); // to close the browser after testing

}
}
