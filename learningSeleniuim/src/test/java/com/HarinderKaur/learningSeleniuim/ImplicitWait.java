package com.HarinderKaur.learningSeleniuim;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWait {
	WebDriver wd; // declare wd at class level bcoz it is used in setUp and tearDown both methods

	@BeforeMethod
	public void setUp() { // starting or launching a browser

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kaurh\\OneDrive\\Documents\\Drivers\\chromedriver.exe");

		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		wd.get("https://www.webroot.com/us/en/home");
		wd.findElement(By.id("onetrust-accept-btn-handler")).click();// css selector for cookies
	}

	@Test
	public void verifySelect() { // test something

		wd.findElement(By.cssSelector("div.TableBlock div>div>div:nth-of-type(2) a:first-of-type")).click();

		selectElementByIndex(wd.findElement(By.cssSelector("select[name='billing.country']")), 3);

		selectElementByValue(wd.findElement(By.cssSelector("select[name='billing.country']")), "US");

		selectElementbyVisibleText(wd.findElement(By.cssSelector("select[name='billing.country']")), "Australia");

		selectElementByIndex(wd.findElement(By.cssSelector("select[name='billing.state']")), 2);

	}

	@AfterMethod
	public void tearDown() { // closing the browser
		wd.close(); // to close the browser after testing
	}

	public void selectElementByIndex(WebElement element, int index) {
		Select sc = new Select(element);
		sc.selectByIndex(index);
	}

	public void selectElementByValue(WebElement element, String value) {
		Select sc = new Select(element);
		sc.selectByValue(value);
	}

	public void selectElementbyVisibleText(WebElement element, String text) {
		Select sc = new Select(element);
		sc.selectByVisibleText(text);
	}

	public void deselectAll(WebElement element) {
		Select sc = new Select(element);
		sc.deselectAll();

	}
}
