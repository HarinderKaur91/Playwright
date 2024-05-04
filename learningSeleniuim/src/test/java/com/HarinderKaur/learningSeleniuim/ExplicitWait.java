package com.HarinderKaur.learningSeleniuim;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {
	WebDriver wd; // declare wd at class level bcoz it is used in setUp and tearDown both methods
	WebDriverWait wdwait;

	@BeforeMethod
	public void setUp() { // starting or launching a browser

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kaurh\\OneDrive\\Documents\\Drivers\\chromedriver.exe");

		wd = new ChromeDriver();

		wdwait = new WebDriverWait(wd, Duration.ofSeconds(10));// explicit wait

		wd.get("https://demoqa.com/alerts");
	}

	@Test
	public void verifyExplicitWaitForAlert() { // test something
		WebElement alertBtuttonAfterWait = wd.findElement(By.cssSelector("#timerAlertButton"));

		wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#timerAlertButton")));

		alertBtuttonAfterWait.click();

		wdwait.until(ExpectedConditions.alertIsPresent());

		wd.switchTo().alert().accept();

	}

	@AfterMethod
	public void tearDown() { // closing the browser
		// wd.close(); // to close the browser after testing
	}

}
