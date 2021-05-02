package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.RegistrationFormFirstStep;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class FailedRegistrationTests extends TestBase{

    @Test
    public void asUserProvideIncorrectAlreadyRegisteredEmailForRegistrationFirstStep() {

        DriverUtils.navigateToPage(LOGIN_URL);

        RegistrationFormFirstStep registrationFormFirstStep = new RegistrationFormFirstStep();
        registrationFormFirstStep
                .typeIntoEmailInputForAccountCreation("hendryka1993@gmail.com")
                .clickCreateAnAccountButton();

        assertTrue(registrationFormFirstStep.isAlertWithProperAlertMessageDisplayed(
                "An account using this email address has already been registered. Please enter a valid password or request a new one."));
    }

}
