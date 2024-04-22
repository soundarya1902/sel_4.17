package gui.stepdefinition;

import framework.DriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.checkPage;

public class checkSteps {
    private checkPage checkpage;

    public checkSteps(checkPage checkpage) {
        this.checkpage = checkpage; // This is where pico-containers starts working

    }

    @Given("user is on landingpage")
    public void user_is_on_landingpage() {
        DriverHelper.startAtHomePage();
    }

    @Then("User should be able to login succesfully")
    public void user_should_be_able_to_login_succesfully() {
        checkpage.checkLogout();
    }

    @When("user login with valid credentails")
    public void user_login_with_valid_credentails() {
        checkpage.signIn();
        checkpage.enterUsername();
        checkpage.enterPassword();
        checkpage.loginBtn();

    }
}
