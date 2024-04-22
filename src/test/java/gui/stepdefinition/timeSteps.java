package gui.stepdefinition;


import io.cucumber.java.en.When;
import pageobjects.timePage;

public class timeSteps {
    private timePage TimePage;

    public timeSteps(timePage TimePage)
    {
        this.TimePage =	  TimePage;

    }
    @When("User goto time")
    public void userGotoTime() {
        TimePage.clickTime();
        //TimePage.enterText();
    }
}
