package com.HarinderKaur.learningSeleniuim;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandlerExample {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver120\\chromedriver-win64\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();

		// Launch a page
		wd.get("https://demoqa.com/browser-windows");

		// maximise the browser window
		wd.manage().window().maximize();
	}

	@Test
	public void tabExample() {
		String parentWindowHandle = wd.getWindowHandle();
		System.out.println(parentWindowHandle);

		wd.findElement(By.cssSelector("#tabButton")).click();
		Set<String> allWindowHandlesList1 = wd.getWindowHandles();

		// List<String> names = new ArrayList<>(List.of("MANVIR", "Swaroop", "Sahib",
		// "Jattan"));

		// System.out.println(names.get(1));

		for (String handle : allWindowHandlesList1) {
			if (!handle.equals(parentWindowHandle)) {
				wd.switchTo().window(handle);
				System.out.println("Child handle is " + handle);
				System.out
						.println("Text from child tab : " + wd.findElement(By.cssSelector("#sampleHeading")).getText());
			}
		}
		wd.switchTo().window(parentWindowHandle);

	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		// wd.quit();
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
