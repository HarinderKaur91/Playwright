package com.HarinderKaur.learningSeleniuim;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class GetAndToCommands {
		WebDriver wd;

		@BeforeMethod
		public void setUp() {

			// Basic Setup to begin with Selenium
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaurh\\OneDrive\\Documents\\Drivers\\chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", "‪C:\\Users\\kaurh\\OneDrive\\Documents\\Drivers\\geckodriver.exe");

			// intialise webdriver instance
			wd = new FirefoxDriver();

			// Launch a page
			wd.get("https://www.carbonite.com/");
			wd.manage().window().maximize();
			sleep();
			
			wd.findElement(By.cssSelector("button[id='onetrust-accept-btn-handler']")).click();

		}

		@Test
		public void verifyGetAndToDifference() {
					
			sleep();
			
			wd.navigate().to("https://stackoverflow.com/questions/5664808/");
			sleep();
			
			wd.findElement(By.xpath("//button[contains(text(),'Accept all cookies')]")).click();
			sleep();
			//wd.get("https://www.carbonite.com/");
			
			//wd.get("https://stackoverflow.com/questions/5664808/");
			
			wd.navigate().back();
			sleep();
			
			
//			wd.findElement(By.cssSelector("button[id ='onetrust-accept-btn-handler']")).click();
//			wd.get("https://www.carbonite.com/");
//			sleep();
//			wd.get("https://www.webroot.com/us/en");
//			sleep();
			
		}

		@AfterMethod
		public void tearDown() {
			// closing the browser
			wd.close();
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
