package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.disposeDriver();
    }
}
