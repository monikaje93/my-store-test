package page.objects;


import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class RegistrationFormFirstStep {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(id = "email_create")
    private WebElement createAccountEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(css = "#create_account_error li")
    private WebElement alert;

    public RegistrationFormFirstStep() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public RegistrationFormFirstStep typeIntoEmailInputForAccountCreation(String email) {
        createAccountEmail.sendKeys(email);
        logger.info("Typed into email field in Create Account form: {}", email);
        return this;
    }

    public RegistrationFormSecondStep clickCreateAnAccountButton() {
        createAccountButton.click();
        logger.info("Clicked on Create an account button");
        return new RegistrationFormSecondStep();
    }

    public boolean isAlertWithProperAlertMessageDisplayed(String alertMessage) {
        WaitForElement.waitUntilElementIsVisible(alert);
        String actualAlertMessage = alert.getText();
        logger.info("Returned warning message: {}", actualAlertMessage);
        return actualAlertMessage.equals(alertMessage);
    }

}
