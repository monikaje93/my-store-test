package driver.manager;

import driver.BrowserFactory;
import driver.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;
    private static BrowserType browserType;


    public DriverManager(BrowserType browserType) {
        this.browserType = browserType;
    }

    public static WebDriver getWebDriver() {

        if (driver==null) {
            driver = BrowserFactory.getBrowser(browserType);
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if(!browserType.equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }


}