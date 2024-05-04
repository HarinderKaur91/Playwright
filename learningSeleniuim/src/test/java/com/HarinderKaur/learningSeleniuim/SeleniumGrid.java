package com.HarinderKaur.learningSeleniuim;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumGrid {

	ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@BeforeMethod()
	public void setUp() {

		// System.out.println("Chrome Browser Initiated");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.WINDOWS);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("start-maximized");
		
		options.merge(capabilities);
		
		WebDriverManager.chromedriver().setup();


		try {
			driver.set(new RemoteWebDriver(new URL(" http://192.168.1.78:4444"), capabilities));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testCase1() {
		driver.get().get("https://www.selenium.dev/documentation/grid/getting_started/");
		System.out.println(driver.get().getTitle());
	}
	@Test
	public void testCase2() {
		driver.get().get("https://www.guru99.com/introduction-to-selenium-grid.html");
		System.out.println(driver.get().getTitle());
	}
	@Test
	public void testCase3() {
		driver.get().get("https://www.lambdatest.com/blog/selenium-grid-setup-tutorial/");
		System.out.println(driver.get().getTitle());
	}
	@Test
	public void testCase4() {
		driver.get().get("https://www.javatpoint.com/selenium-grid");
		System.out.println(driver.get().getTitle());
	}
	@Test
	public void testCase5() {
		driver.get().get("https://www.browserstack.com/guide/parallel-testing-with-selenium");
		System.out.println(driver.get().getTitle());
	}
	@Test
	public void testCase6() {
		driver.get().get("https://github.com/SeleniumHQ/docker-selenium");
		System.out.println(driver.get().getTitle());
	}
	@Test
	public void testCase7() {
		driver.get().get("https://www.tutorialspoint.com/selenium/selenium_grids.htm");
		System.out.println(driver.get().getTitle());
	}
	@Test
	public void testCase8() {
		driver.get().get("https://www.toolsqa.com/selenium-webdriver/selenium-grid/");
		System.out.println(driver.get().getTitle());
	}
	@Test
	public void testCase9() {
		driver.get().get("https://www.geeksforgeeks.org/selenium-basics-components-features-uses-and-limitations/");
		System.out.println(driver.get().getTitle());
	}
	@Test
	public void testCase10() {
		driver.get().get("https://www.javacodegeeks.com/selenium-tutorials");
		System.out.println(driver.get().getTitle());
	}
	@AfterMethod
	public void tearDown() {
		driver.get().quit();
	}
}