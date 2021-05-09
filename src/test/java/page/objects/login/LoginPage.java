package page.objects.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.BasePage;
import waits.WaitForElement;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;

    @FindBy(css = ".alert li")
    private WebElement alert;


    public LoginPage typeIntoEmailInput(String email) {
        emailInput.sendKeys(email);
        log().info("Typed into email field: {}", email);
        return this;
    }

    public LoginPage typeIntoPasswordInput(String password) {
        passwordInput.sendKeys(password);
        log().info("Typed into password field: {}", password);
        return this;
    }

    public MyAccountPage clickLoginButton() {
        submitLoginButton.click();
        log().info("Clicked on login button");
        return new MyAccountPage();
    }

    public boolean isAlertWithProperAlertMessageDisplayed(String alertMessage) {
        WaitForElement.waitUntilElementIsVisible(alert);
        String actualAlertMessage = alert.getText();
        log().info("Returned warning message: {}", actualAlertMessage);
        return actualAlertMessage.equals(alertMessage);
    }

}
