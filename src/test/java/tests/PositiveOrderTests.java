package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.HeaderPage;
import page.objects.login.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveOrderTests extends TestBase{

    @Test
    public void asLoggedInUserMakeSuccessfulOrder() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoEmailInput("email1111@email.com")
                .typeIntoPasswordInput("12345")
                .clickLoginButton();

        HeaderPage headerPage = new HeaderPage();
        boolean isSuccessAlertWithProperAlertMessageDisplayed = headerPage
                .clickTshirtCategoryMenuLink()
                .clickFirstProduct()
                .clickAddToCartButton()
                .clickProceedToCheckoutButton()
                .clickProceedToCheckoutButton()
                .clickProceedToCheckoutButton()
                .selectTermsOfServiceCheckbox()
                .clickProceedToCheckoutButton()
                .selectCheckPayment()
                .clickConfirmOrderButton()
                .isSuccessAlertWithProperAlertMessageDisplayed("Your order on My Store is complete.");

        assertTrue(isSuccessAlertWithProperAlertMessageDisplayed);
    }
}
