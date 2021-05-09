package tests;

import driver.BrowserType;
import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    WebDriver driver;
    DriverManager driverManager;

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(@Optional("CHROME") BrowserType browserType) {
        driverManager = new DriverManager(browserType);
        driver = driverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.disposeDriver();
    }
}
