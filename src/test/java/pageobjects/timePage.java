package pageobjects;

import framework.PageObject;
import org.openqa.selenium.By;

public class timePage extends PageObject {
    private By time = By.cssSelector(".oxd-userdropdown-name");
    private By inputText=By.cssSelector("input[placeholder='Type for hints...']");


    public void clickTime()  {
       assert (waitForExpectedElement(time).getText().contains("John"));
    }
    public void enterText()
    {
        waitForExpectedElement(inputText).sendKeys("admin");
    }
}
