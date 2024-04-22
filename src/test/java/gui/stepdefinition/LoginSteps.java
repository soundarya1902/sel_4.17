package gui.stepdefinition;

import framework.DriverHelper;
import pageobjects.LoginProcessPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.checkPage;

public class LoginSteps {

    private LoginProcessPage loginProcessPage;
    private checkPage checkpage;

    public LoginSteps(LoginProcessPage loginProcessPage, checkPage checkpage)
    {
        this.loginProcessPage =	  loginProcessPage; // This is where pico-containers starts working
        this.checkpage = checkpage;

    }
    @When("User enters cred")
    public void user_enters_cred() {
        checkpage.signIn();
        checkpage.enterUsername();
        checkpage.enterPassword();
        checkpage.loginBtn();
    }
    @When("User enters cred invalid cred {string} and {string}")
    public void user_enters_cred_invalid_cred_and(String un, String pass) {
        loginProcessPage.signIn();
        loginProcessPage.enter_Username(un);
        loginProcessPage.enter_Password(pass);
        loginProcessPage.loginBtn();
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