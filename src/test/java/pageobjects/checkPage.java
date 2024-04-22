package pageobjects;

import framework.PageObject;
import framework.Props;
import org.openqa.selenium.By;


public class checkPage extends PageObject {
    private By username = By.cssSelector("input[data-qa='login-email']");
    private By password = By.cssSelector("input[placeholder='Password']");
    private By loginBtn = By.cssSelector("button[data-qa='login-button']");
    private By logoutLink = By.cssSelector("a[href='/logout']");
    private By signInBtn=By.cssSelector("a[href='/login']");
    public void enterUsername() {
        waitForExpectedElement(username).sendKeys(Props.getProp("username"));
    }

    public void enterPassword() {
        waitForExpectedElement(password).sendKeys(Props.getProp("password"));
    }



    public void signIn() {
        waitForExpectedElement(signInBtn).click();
    }
    public void loginBtn()
    {
        waitForExpectedElement(loginBtn).click();
    }

    public void checkLogout() {
        isElementPresent(logoutLink);
        getCurrentUrl().contains("account");
    }

}
