package driver.manager;

import driver.BrowserFactory;
import driver.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;
    private static final BrowserType BROWSER_TYPE = BrowserType.CHROME;

    //Singleton pattern, private constructor allows to create only one instance of WebDriver
    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver==null) {
            driver = BrowserFactory.getBrowser(BROWSER_TYPE);
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if(!BROWSER_TYPE.equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }

}
