package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;

    @FindBy(css = ".alert li")
    private WebElement alert;


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public LoginPage typeIntoEmailInput(String email) {
        emailInput.sendKeys(email);
        logger.info("Typed into email field: {}", email);
        return this;
    }

    public LoginPage typeIntoPasswordInput(String password) {
        passwordInput.sendKeys(password);
        logger.info("Typed into password field: {}", password);
        return this;
    }

    public MyAccountPage clickLoginButton() {
        submitLoginButton.click();
        logger.info("Clicked on login button");
        return new MyAccountPage();
    }

    public boolean isAlertWithProperAlertMessageDisplayed(String alertMessage) {
        WaitForElement.waitUntilElementIsVisible(alert);
        String actualAlertMessage = alert.getText();
        logger.info("Returned warning message: {}", actualAlertMessage);
        return actualAlertMessage.equals(alertMessage);
    }

}
