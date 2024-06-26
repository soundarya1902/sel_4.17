package pageobjects;

import framework.PageObject;
import framework.Props;
import org.openqa.selenium.By;

public class LoginProcessPage  extends PageObject {
    private By username = By.cssSelector("input[data-qa='login-email']");
    private By password = By.cssSelector("input[placeholder='Password']");
    private By loginBtn = By.cssSelector("button[data-qa='login-button']");
    private By logoutLink = By.cssSelector("a[href='/logout']");
    private By signInBtn=By.cssSelector("a[href='/login']");
    private By errorLogin=By.xpath("//p[normalize-space()='Your email or password is incorrect!']");
    public void enterUsername() {
        waitForExpectedElement(username).sendKeys(Props.getProp("username"));
    }

    public void enter_Username(String un) {
        waitForExpectedElement(username).sendKeys(un);
    }

    public void enterPassword() {
        waitForExpectedElement(password).sendKeys(Props.getProp("password"));
    }

    public void enter_Password(String pass) {
        waitForExpectedElement(password).sendKeys(pass);
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

    public void clickLogout() {
        waitForExpectedElement(logoutLink).click();
    }

    public void checkError() {
        waitForExpectedElement(errorLogin).isDisplayed();
    }
}
