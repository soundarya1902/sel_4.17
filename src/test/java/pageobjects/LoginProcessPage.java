package pageobjects;

import framework.PageObject;
import framework.Props;
import org.openqa.selenium.By;

public class LoginProcessPage extends PageObject {
    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//button[normalize-space()='Login']");
    private By logoutLink = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    private By errorLogin = By.cssSelector(".oxd-alert--error");


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

    public void ClcikLogin() {
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
