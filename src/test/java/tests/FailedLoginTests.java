package tests;

import org.testng.annotations.Test;
import page.objects.LoginPage;

import static org.testng.Assert.assertTrue;

public class FailedLoginTests extends TestBase{

    @Test
    public void asUserTryToLoginWithInvalidEmailAndPassword() {

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoEmailInput("NotExistingEmail@email.com");
        loginPage.typeIntoPasswordInput("NotExistingPassword");
        loginPage.clickLoginButton();

        assertTrue(loginPage.isAlertWithProperAlertMessageDisplayed("Authentication failed"));
    }

    @Test
    public void asUserTryToLoginWithCorrectEmailAndInvalidPassword() {

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoEmailInput("hendryka1993@gmail.com");
        loginPage.typeIntoPasswordInput("NotValidPassword");
        loginPage.clickLoginButton();

        assertTrue(loginPage.isAlertWithProperAlertMessageDisplayed("Authentication failed"));
    }

    @Test
    public void asUserTryToLoginWithNoEmail() {

        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginButton();

        assertTrue(loginPage.isAlertWithProperAlertMessageDisplayed("An email address required"));
    }
}
