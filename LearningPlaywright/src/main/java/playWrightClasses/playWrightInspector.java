package playWrightClasses;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class playWrightInspector {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://academy.naveenautomationlabs.com/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
      page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("Harinder");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").press("Tab");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("harinder12345@gmail.com");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").press("Tab");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("Password1");
      page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").fill("+1 (780) 258-681");
      page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Get Started")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Profile")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Subscriptions")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("My Wallet")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Purchase History")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Notifications")).click();
    }
  }
}
