package com.HarinderKaur.SauceLabsPractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccounLogoutPage extends TestBase {

	public AccounLogoutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement accountLogOutSuccessTxt;
	
	
	@FindBy(css = "div.buttons a")
	WebElement continueBtn;

	public String getSuccessLogOutText() {
		return accountLogOutSuccessTxt.getText();
	}
	
	public HomePage clickcontinueBtn() {
		continueBtn.click();
		return new HomePage();
		
	}
}
