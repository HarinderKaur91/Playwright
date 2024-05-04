package com.HarinderKaur.learningSeleniuim;

import java.awt.Window;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimeComparisonOfLocators {

	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kaurh\\OneDrive\\Documents\\Drivers\\chromedriver.exe");

		// Initialize webdriver instance
		wd = new ChromeDriver();

		// Launch a page
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// maximize the browser window
		wd.manage().window().maximize();
	}

	@Test(invocationCount = 50)
	public void timeTakenByCss() {
		WebElement emailInputField = wd.findElement(By.cssSelector("input[name='email']"));
	}
		

	@Test(invocationCount = 50)
	public void timeTakenById() {
		//double startTime = getMilliSecTime();
		WebElement emailInputField = wd.findElement(By.id("input-email"));
//		double endTime = getMilliSecTime();
//		System.out.println(endTime);
//		System.out.println(startTime);
//		System.out.println("Diff "+ (endTime-startTime));

	}

	@Test(invocationCount = 50)
	public void timeTakenByXpath() {
		
		WebElement emailInputField = wd.findElement(By.xpath("//input[@name='email']"));
	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.quit();
	}

	private double getMilliSecTime() {
		Date date = new Date();

		return date.getTime();
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
