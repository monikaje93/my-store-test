package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.registration.RegistrationFormFirstStepPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class FailedRegistrationTests extends TestBase{

    @Test
    public void asUserProvideIncorrectAlreadyRegisteredEmailForRegistrationFirstStep() {
        DriverUtils.navigateToPage(LOGIN_URL);

        RegistrationFormFirstStepPage registrationFormFirstStepPage = new RegistrationFormFirstStepPage();
        registrationFormFirstStepPage
                .typeIntoEmailInputForAccountCreation("email1188@email.com")
                .clickCreateAnAccountButton();

        assertTrue(registrationFormFirstStepPage.isAlertWithProperAlertMessageDisplayed(
                "An account using this email address has already been registered. Please enter a valid password or request a new one."));
    }

}
