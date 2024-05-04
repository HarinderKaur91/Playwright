package com.HarinderKaur.learningSeleniuim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationCommandExample {

	WebDriver wd;

	@BeforeMethod
	public void setUp() { // starting or launching a browser

		// basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver",
				"D:\\ChromeDriver120\\chromedriver-win64\\chromedriver.exe");

		// launch a browser
		wd = new ChromeDriver();

		// launch a page
		wd.get("https://www.webroot.com/us/en/home");
	}

	@Test
	public void validatingNavigation() { // test something
		// to command
		sleep();
		
		//wd.get("https://www.carbonite.com/");
		wd.navigate().to("https://www.carbonite.com/");
		sleep();

		// Refresh a page
		wd.navigate().refresh();
		wd.navigate().refresh();
		sleep();

		// Go back
		wd.navigate().back();
		sleep();

		// Go forward
		wd.navigate().forward();
		sleep();

	}

	@AfterMethod
	public void tearDown() {
		//wd.close(); // to close the browser after testing

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
