package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;

    @FindBy(css = ".alert li")
    private WebElement alert;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void typeIntoEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    public void typeIntoPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        submitLogin.click();
    }

    public boolean isAlertWithProperAlertMessageDisplayed(String alertMessage) {
        WaitForElement.waitUntilElementIsVisible(alert);
        return alert.getText().contains(alertMessage);
    }
}
