package com.HarinderKaur.SauceLabsPractice;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SauceLabsExample {

	WebDriver driver;

	public static final String USERNAME = "oauth-kaur.harinder91-9901c";
	public static final String ACCESS_KEY = "027dcde7-b7df-4e0d-a59c-942a6c324ef6";
	public static final String URL = "https://oauth-kaur.harinder91-9901c:027dcde7-b7df-4e0d-a59c-942a6c324ef6@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	// public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY +
	// "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

	@Parameters({ "browser", "version", "platform" })
	@BeforeClass
	public void setUp(String br, String vr, String pf) throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browser", br);
		capabilities.setCapability("version", vr);
		capabilities.setCapability("platform", pf);
		driver = new RemoteWebDriver(new URL(URL), capabilities);
	}

	@Test
	public void verifyLogin() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");

		// login
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		Assert.assertEquals(driver.getTitle(), "OrangeHRM");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
