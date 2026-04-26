package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Locators.LoginLocators;
import config.ConfigReader;
import utils.SmartActions;

public class LoginPage {

    private WebDriver driver;
    private SmartActions actions;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new SmartActions(driver); // ✅ FIX
    }

    public LoginPage open() {
        driver.get(ConfigReader.get("baseUrl"));
        return this;
    }

    public LoginPage enterUsername(String username) {
        actions.safeFill(LoginLocators.username, username, "Username");
        return this;
    }

    public LoginPage enterPassword(String password) {
        actions.safeFill(LoginLocators.password, password, "Password");
        return this;
    }

    public void clickLogin() {
        actions.safeClick(By.id("submit-lo"), "Login");
    }

    // ✅ Clean single method (like Playwright style)
    public void login(String username, String password) {
        enterUsername(username)
            .enterPassword(password);
        clickLogin();
    }
    
    public String loginVerification() {

        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        return element.getText();
    }
}