package stepdefinitions;

import Core.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonLoginPages;

public class AmazonLoginSteps {
	
	// by default this will read the driver from website based on you browser version
	AmazonLoginPages alp=new AmazonLoginPages(DriverManager.getDriver());
	
	@Given("user is on Amazon login page")
	public void openAmazonLoginPage() {
		alp.loginToAmazon();
		alp.clickSignin();
		
	}
	@When("enter the username and click continue")
	public void enterUsername(){
		alp.enterEmail_Mobile();
		alp.clickContinue();
		
	}
	@Then("enter the password")
	public void enterPassword(){
		alp.enterPassword();
		
	}
	@Then("click submit button")
	public void clickSubmitButton(){
		alp.clickSubmit();
	}
	@Then("click menu bar")
	public void clickMenuBar() {
		alp.clickMenu();
	}
	@Then("click logout button")
	public void clickSignoutButton() {
		alp.signout();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
