package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SmartActions;
import config.ConfigReader;

public class SKShoppingLogin {
	
	private WebDriver driver;
	private SmartActions actions;
	
	public SKShoppingLogin(WebDriver driver) {
		this.driver=driver;
		this.actions=new SmartActions(driver);
	}
	
	public void login() {
		driver.get(ConfigReader.get("SK_URL"));
	}
	
	public void enterEmail(String email) {
		actions.safeFill(By.name("email"), email, "email");
	}
	
	public void enterPassword(String password) {
		actions.safeFill(By.name("password"),password, "password");
	}
	
	public void clickLogin() {
		actions.safeClick(By.xpath("//button[@type='submit']"), "submit");
	}
	
	

}
