package framework;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverHelper
{
    private  static WebDriver driver=null;
    private static final Logger LOG = LoggerFactory.getLogger(DriverHelper.class);
    private static String browserName,path;
    private static URL basePath;

    static {
        try {
            Props.loadProperties("/environment.properties");
            browserName = Props.getProp("browser");
            basePath = new URL(Props.getProp("testurl"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("in Driver Properties loaded");
        try {
            if (browserName.equals("chrome"))
                driver = WebDriverManager.chromedriver().create();
            else if (browserName.equals("firefox"))
                driver = WebDriverManager.firefoxdriver().create();
            else if (browserName.equals("edge"))
                driver = WebDriverManager.edgedriver().create();
            // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (IllegalStateException e) {
            LOG.error(" Browser parameter type not supported");
        }
    }

    public static WebDriver callDriver()
    {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
         return driver;
    }

    public static void Quit()
    {
        driver.quit();
    }
    public static void close()
    {
        driver.close();
    }
    public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;

    }
    public static void startAtHomePage()
    {
       callDriver().navigate().to(basePath);
     }

}

