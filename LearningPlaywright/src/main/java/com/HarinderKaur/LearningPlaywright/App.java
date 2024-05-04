package com.HarinderKaur.LearningPlaywright;

import com.microsoft.playwright.*;

/*
 * public class App { public static void main(String[] args) { try (Playwright
 * playwright = Playwright.create()) { Browser browser =
 * playwright.chromium().launch(); Page page = browser.newPage();
 * page.navigate("http://playwright.dev"); System.out.println(page.title()); } }
 * }
 */

import java.nio.file.Paths;

public class App {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {

			Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			page.navigate("https://playwright.dev/");
			System.out.println(page.title());
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
			//browser.close();
			//playwright.close();
		}
	}
}