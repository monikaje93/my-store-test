package page.objects.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.BasePage;
import waits.WaitForElement;

public class OrderConfirmationPage extends BasePage {

    @FindBy(className = "alert-success")
    private WebElement alert;


    public boolean isSuccessAlertWithProperAlertMessageDisplayed(String alertMessage) {
        WaitForElement.waitUntilElementIsVisible(alert);
        String actualAlertMessage = alert.getText();
        log().info("Returned warning message: {}", actualAlertMessage);
        return actualAlertMessage.equals(alertMessage);
    }
}
