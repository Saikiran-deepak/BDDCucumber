package stepdefinitions;

import Core.DriverManager;
import io.cucumber.java.en.*;
import pages.LoginPage;


public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Given("user is on login page")
    public void openLoginPage() {
        loginPage.open();
    }

    @When("user enters username and password")
    public void enterCredentials() {
        loginPage.enterUsername("afssdg");
        loginPage.enterPassword("dsfgdfhdah");
    }

    @Then("user should see dashboard")
    public void validateLogin() {
      
    }
}