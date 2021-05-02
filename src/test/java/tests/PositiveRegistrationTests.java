package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.RegistrationFormFirstStep;
import page.objects.Title;

import java.util.Calendar;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveRegistrationTests extends TestBase{

    @Test
    public void asUserProvideCorrectNonRegisteredEmailForRegistrationFirstStep() {

        DriverUtils.navigateToPage(LOGIN_URL);

        RegistrationFormFirstStep registrationFormFirstStep = new RegistrationFormFirstStep();
        boolean isCreateAnAccountFormDisplayed = registrationFormFirstStep
                .typeIntoEmailInputForAccountCreation("email111@email.com")
                .clickCreateAnAccountButton()
                .isCreateAnAccountFormDisplayed();

        assertTrue(isCreateAnAccountFormDisplayed);
    }

    @Test
    public void asUserCompletePersonalData() {

        DriverUtils.navigateToPage(LOGIN_URL);

        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1980, 10, 11);

        RegistrationFormFirstStep registrationFormFirstStep = new RegistrationFormFirstStep();
        registrationFormFirstStep
                .typeIntoEmailInputForAccountCreation("email111@email.com")
                .clickCreateAnAccountButton()
                .waitUntilPageIsLoaded()
                .fillInPersonalInformation(Title.MR, "Anna", "Nowak", "", dateOfBirth, false, false);

    }
}
