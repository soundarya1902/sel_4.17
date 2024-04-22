package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public abstract class PageObject {
    private static final long DRIVER_WAIT = 20;
    private static final Logger LOG = LoggerFactory.getLogger(PageObject.class);

    protected WebDriverWait wait;

    protected WebDriver webDriver;

    protected PageObject() {
        this.webDriver = DriverHelper.callDriver();
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(DRIVER_WAIT));
    }

    protected WebElement waitForExpectedElement(final By by) {
        return wait.until(visibilityOfElementLocated(by));
    }

    private ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) throws NoSuchElementException {
        return driver -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                LOG.error(e.getMessage());
            }
            WebElement element = webDriver.findElement(by);
            return element.isDisplayed() ? element : null;
        };
    }

    public boolean isElementPresent(final By by) {
        try {
            new WebDriverWait(webDriver, Duration.ofSeconds(DRIVER_WAIT)).until(presenceOfElementLocated(by));

        } catch (TimeoutException exception) {
            LOG.info(exception.getMessage());
            return false;
        }
        return true;
    }
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
