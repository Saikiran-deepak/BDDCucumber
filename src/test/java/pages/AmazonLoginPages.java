package pages;

import org.openqa.selenium.WebDriver;

import Locators.Loginpagelocators;
import config.ConfigReader;
import utils.SmartActions;

public class AmazonLoginPages {
	
	private WebDriver driver;
	private SmartActions actions;
	
	public  AmazonLoginPages(WebDriver driver) {
		this.driver =driver;
		this.actions= new SmartActions(driver);
	}
	Loginpagelocators log=new Loginpagelocators();
	
	public void loginToAmazon() {
		driver.get(ConfigReader.get("Amazon"));
	}
	
	public void clickSignin() {
		actions.safeClick(log.signin, "Hello, sign in");
	}
	
	public void enterEmail_Mobile() {
		actions.safeFill(log.email_mobile, ConfigReader.get("email"), "email");
		
	}
	public void clickContinue() {
		actions.safeClick(log.continueBtn,"Continue");
	}
	public void enterPassword() {
		actions.safeFill(log.password, ConfigReader.get("password"), "password");
	}
	public void clickSubmit() {
		actions.safeClick(log.submitBtn, "Sign in");
	}
	public void clickMenu() {
		actions.safeClick(log.menu, "All");
	}
	public void signout() {
		actions.safeClick(log.signout, "Sign Out");
	}

}
