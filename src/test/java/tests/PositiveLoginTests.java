package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.login.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase{

    @Test
    public void asUserLoginUsingValidEmailAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        boolean isMyAccountPageAfterLoginDisplayed = loginPage
                .typeIntoEmailInput("email1188@email.com")
                .typeIntoPasswordInput("12345")
                .clickLoginButton()
                .isMyAccountPageAfterLoginDisplayed();

        assertTrue(isMyAccountPageAfterLoginDisplayed);
    }
}
