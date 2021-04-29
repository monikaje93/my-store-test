package tests;

import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.MyAccountPage;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase{

    @Test
    public void asUserLoginUsingValidEmailAndPassword() {

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoEmailInput("hendryka1993@gmail.com");
        loginPage.typeIntoPasswordInput("SKVet12#");
        loginPage.clickLoginButton();

        MyAccountPage myAccountPage = new MyAccountPage();
        assertTrue(myAccountPage.isMyAccountPageAfterLoginDisplayed());
    }
}
