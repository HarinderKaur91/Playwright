package com.HarinderKaur.learningSeleniuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
	//	WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver120\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/upload-download");
		
	}
	
	
	@org.testng.annotations.Test
	public void verifyuploadFunctionality() {
		WebElement uploadButton = driver.findElement(By.cssSelector("#uploadFile"));
		uploadFile("C:\\Users\\kaurh\\Downloads\\sampleFile.jpeg", uploadButton);
	}
	
	public void uploadFile(String filePath, WebElement uploadButton) {
		uploadButton.sendKeys(filePath);
	}

}