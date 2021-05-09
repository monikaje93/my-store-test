package page.objects.registration;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.BasePage;
import waits.WaitForElement;

public class RegistrationFormFirstStepPage extends BasePage {

    @FindBy(id = "email_create")
    private WebElement createAccountEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(css = "#create_account_error li")
    private WebElement alert;


    public RegistrationFormFirstStepPage typeIntoEmailInputForAccountCreation(String email) {
        createAccountEmail.sendKeys(email);
        log().info("Typed into email field in Create Account form: {}", email);
        return this;
    }

    public RegistrationFormSecondStepPage clickCreateAnAccountButton() {
        createAccountButton.click();
        log().info("Clicked on Create an account button");
        return new RegistrationFormSecondStepPage();
    }

    public boolean isAlertWithProperAlertMessageDisplayed(String alertMessage) {
        WaitForElement.waitUntilElementIsVisible(alert);
        String actualAlertMessage = alert.getText();
        log().info("Returned warning message: {}", actualAlertMessage);
        return actualAlertMessage.equals(alertMessage);
    }

}
