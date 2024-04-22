package gui.stepdefinition;

import framework.DriverHelper;
import pageobjects.LoginProcessPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    private LoginProcessPage loginProcessPage;

    public LoginSteps(LoginProcessPage loginProcessPage)
    {
        this.loginProcessPage =	  loginProcessPage; // This is where pico-containers starts working

    }

    @Given("User is on HRMLogin page")
    public void user_is_on_hrm_login_page() {
        DriverHelper.startAtHomePage();
         }

    @When("User enters cred")
    public void user_enters_cred() {
        loginProcessPage.enterUsername();
        loginProcessPage.enterPassword();
        loginProcessPage.ClcikLogin();
    }
    @When("User enters cred invalid cred {string} and {string}")
    public void user_enters_cred_invalid_cred_and(String un, String pass) {
        loginProcessPage.enter_Username(un);
        loginProcessPage.enter_Password(pass);
        loginProcessPage.ClcikLogin();
    }
    @Then("User should be able to login")
    public void user_should_be_able_to_login() {
        loginProcessPage.checkLogout();
    }

    @Then("User should be able to see error message")
    public void verifyErrorMessage() {
        loginProcessPage.checkError();
    }
}