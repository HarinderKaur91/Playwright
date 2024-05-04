package com.HarinderKaur.learningSeleniuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumScript {
	WebDriver wd; // declare wd at class level bcoz it is used in setUp and tearDown both methods

	@BeforeMethod
	public void setUp() { // starting or launching a browser

		// basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver120\\chromedriver-win64\\chromedriver.exe");

		// launch a browser
		// WebDriver wd = new ChromeDriver();
		wd = new ChromeDriver(); // An instance of chrome browser is created means a blank chrome page will be
									// opened on browser
		// ChromeDriver cd = new ChromeDriver(); we can use direct ChromeDriver class to
		// instantiate as well but instance cd will not
		// help to use other drivers like edge and firefox but instance of interface
		// WebDriver can be used with other drivers also
		// So try to make reference variable of parent class always. Here WebDriver is
		// an interface which is implemented by ChromeDriver class.
		// wd = new EdgeDriver();
		// wd = new FirefoxDriver();

		// launch a page
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test
	public void verifyLoginTest() { // test something
		WebElement emailInputField = wd.findElement(By.cssSelector("form div.form-group:first-of-type input"));
		WebElement passwordInputField = wd.findElement(By.cssSelector("form div.form-group:last-of-type input"));
		WebElement loginBtn = wd.findElement(By.cssSelector("input[type='submit']"));

		// Send a text into an input field
		emailInputField.sendKeys("harinderkaur21@gmail.com");
		passwordInputField.sendKeys("Password1");
		loginBtn.click();
		// System.out.println(wd.getTitle());//it will print "My Account" if login is
		// successful otherwise it will print "Account Login"
		String titleofpage = wd.getTitle();
	
		Assert.assertEquals(titleofpage, "My Account", "User is not signed in");
		String urlOfPage = wd.getCurrentUrl();
		System.out.println(urlOfPage);
	}

	@AfterMethod
	public void tearDown() { // closing the browser
		wd.close(); // to close the browser after testing

	}

}
