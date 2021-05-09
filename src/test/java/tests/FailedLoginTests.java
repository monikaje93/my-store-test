package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.login.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class FailedLoginTests extends TestBase{

    @BeforeMethod
    public void beforeLoginTests() {
        DriverUtils.navigateToPage(LOGIN_URL);
    }

    @Test
    public void asUserTryToLoginWithInvalidEmailAndPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage
            .typeIntoEmailInput("NotExistingEmail@email.com")
            .typeIntoPasswordInput("NotExistingPassword")
            .clickLoginButton();

        assertTrue(loginPage.isAlertWithProperAlertMessageDisplayed("Authentication failed."));
    }

    @Test
    public void asUserTryToLoginWithCorrectEmailAndInvalidPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage
            .typeIntoEmailInput("hendryka1993@gmail.com")
            .typeIntoPasswordInput("NotValidPassword")
            .clickLoginButton();

        assertTrue(loginPage.isAlertWithProperAlertMessageDisplayed("Authentication failed."));
    }

    @Test
    public void asUserTryToLoginWithNoEmail() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginButton();

        assertTrue(loginPage.isAlertWithProperAlertMessageDisplayed("An email address required."));
    }
}
