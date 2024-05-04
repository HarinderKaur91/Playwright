package com.HarinderKaur.assignment2Selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import junit.framework.Assert;

public class ValidatePurchase {

	public class FirstSeleniumScript {
		WebDriver wd;

		@BeforeMethod
		public void setUp() {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\kaurh\\OneDrive\\Documents\\Drivers\\chromedriver.exe");
			wd = new ChromeDriver();
			wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		}

		@Test
		public void verifyLoginTest() { // test something
			WebElement emailInputField = wd.findElement(By.cssSelector("form div.form-group:first-of-type input"));
			WebElement passwordInputField = wd.findElement(By.cssSelector("form div.form-group:last-of-type input"));
			WebElement loginBtn = wd.findElement(By.cssSelector("input[type='submit']"));

			emailInputField.sendKeys("iron.man@gmail.com");
			passwordInputField.sendKeys("avengers.com");
			loginBtn.click();
			System.out.println(wd.getTitle());//it will print "My Account" if login is
			// successful otherwise it will print "Account Login"
			String titleofpage = wd.getTitle();
			// Assert.assertEquals(titleofpage, "My Account", "User is not signed in");
			String urlOfPage = wd.getCurrentUrl();
			System.out.println(urlOfPage);
		}

		@AfterMethod
		public void tearDown() { // closing the browser
			wd.close(); // to close the browser after testing

		}
	}
}
