package com.HarinderKaur.learningSeleniuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectExample {
	WebDriver wd; // declare wd at class level bcoz it is used in setUp and tearDown both methods

	@BeforeMethod
	public void setUp() { // starting or launching a browser

		// basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver",
				"D:\\ChromeDriver120\\chromedriver-win64\\chromedriver.exe");

		// launch a browser
		wd = new ChromeDriver();

		// launch a page
		wd.get("https://www.webroot.com/us/en/home");
		sleep();
		wd.findElement(By.id("onetrust-accept-btn-handler")).click();// css selector for cookies
		sleep();
	}


	
	@Test
	public void verifySelect() { // test something
		// WebElement buyNowButton = wd.findElement(By.cssSelector("div.TableBlock
		// div>div>div:nth-of-type(2) a:first-of-type"));
		// buyNowButton.click();
		// or click is a method which is called upon web element and findElement returns
		// us a web element, we can directly use click on it
wd.findElement(By.cssSelector("div.TableBlock div>div>div:nth-of-type(2) a:first-of-type")).click();
	sleep();
//
		// WebElement selectElement =
		 //wd.findElement(By.cssSelector("select[name='billing.country']"));
		// Select sc = new Select(selectElement);
		// or
		// Select sc = new
		// Select(wd.findElement(By.cssSelector("select[name='billing.country']")));
		
		
		selectElementByIndex(wd.findElement(By.cssSelector("select[name='billing.country']")), 3);
		sleep();
		selectElementByValue(wd.findElement(By.cssSelector("select[name='billing.country']")), "US");
		sleep();
		selectElementbyVisibleText(wd.findElement(By.cssSelector("select[name='billing.country']")), "Australia");
		sleep();
		selectElementByIndex(wd.findElement(By.cssSelector("select[name='billing.state']")), 2);
		sleep();
		deselectAll(wd.findElement(By.cssSelector("select[name='billing.country']")));//will give error bcoz deselect
		//is used only for multi select options and country is not multi select.
		sleep();

		/* Select a country */
		/*
		 * // Select by index sc.selectByIndex(4);
		 * 
		 * // Select by value sc.selectByValue("CA");
		 * 
		 * // Select by visible text sc.selectByVisibleText("Australia");
		 * 
		 * // return the text of first selected option
		 * System.out.println(sc.getFirstSelectedOption().getText());
		 */

		/* Select a state */
		// Select sc2 = new
		// Select(wd.findElement(By.cssSelector("select[name='billing.state']")));

		// Select sc2 = new
		// Select(wd.findElement(By.cssSelector("div.dropdown-field")));

	}

	@AfterMethod
	public void tearDown() { // closing the browser
		wd.close(); // to close the browser after testing
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		Select sc= new Select(element);
		sc.deselectAll();

	}
}
