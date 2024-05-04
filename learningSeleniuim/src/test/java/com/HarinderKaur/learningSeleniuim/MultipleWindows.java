package com.HarinderKaur.learningSeleniuim;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\ChromeDriver120\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Load the website
		driver.get("https://demoqa.com/browser-windows");
		
		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();
	
		driver.findElement(By.cssSelector("#tabButton")).click();
		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window));
				System.out.println(child_window);
				// switch to the parent window
				driver.switchTo().window(parent);
				driver.quit();
			}
		}
	}
}
